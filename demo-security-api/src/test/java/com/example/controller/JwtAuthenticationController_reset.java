package com.example.controller;

import com.example.module.JwtRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthenticationController_reset {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test the validation of field name more specific is null
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_13() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername(null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field name more specific is empty
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_14() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername("");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to verify the field name to be that is not to be used to the special character.
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_15() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername("admin@#");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to verify that all are valid
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_18() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername("admin");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
