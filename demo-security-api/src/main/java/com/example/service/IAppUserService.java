package com.example.service;

import com.example.module.AppUser;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IAppUserService {

    AppUser findByName(String name);

    String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String password, String name);
}
