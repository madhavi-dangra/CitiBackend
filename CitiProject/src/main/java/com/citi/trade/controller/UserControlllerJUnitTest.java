package com.citi.trade.controller;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.citi.trade.model.User;
import com.citi.trade.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class UserControlllerJUnitTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private UserService userservice;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
    public void testPostExample() throws Exception {
		User user = new User();
        user.setUserName("Madhavi");
        user.setPassword("password");
        Mockito.when(userservice.checkLogin(ArgumentMatchers.any())).thenReturn(true);
        String json = mapper.writeValueAsString(user);
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.password", Matchers.equalTo("password")))
                .andExpect(jsonPath("$.userName", Matchers.equalTo("Madhavi")));
    }
}
