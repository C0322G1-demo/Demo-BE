package com.example.service.impl;

import com.example.common.MyConstants;
import com.example.module.AppUser;
import com.example.repository.IAppUserRepository;
import com.example.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Create by SangNH
     * Date: 08/09/2022
     * find list by name
     * @param name
     * @return appUserRepository.findAppUserByName(name)
     */
    @Override
    public AppUser findByName(String name) {
        return appUserRepository.findAppUserByName(name);
    }

    @Override
    public String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException {
        String user = appUserRepository.existsByUserName(username);
        AppUser appUser = appUserRepository.findAppUserByName(username);
        if (user != null) {
            sendVerificationEmailForResetPassWord(username, appUser.getEmail());
        }
        return user;
    }

    @Override
    public void saveNewPassword(String password, String name) {
        appUserRepository.saveNewPassword(password, name);
    }


    public void sendVerificationEmailForResetPassWord(String userName, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verify-reset-password/" + userName;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("sangnguyenjp97@gmail.com","CODE GYM");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
                "<p>CODE GYM</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }
}
