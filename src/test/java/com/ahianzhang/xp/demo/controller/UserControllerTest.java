package com.ahianzhang.xp.demo.controller;

import com.ahianzhang.xp.demo.entity.User;
import com.ahianzhang.xp.demo.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@AutoConfigureMybatis
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IUserService userService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void should_return_affect_rows_when_post_users() throws Exception {
        // Given
        Integer affectRows = 1;
        doReturn(affectRows).when(userService).createUser(any(User.class));
        User user = User.builder()
                .name("tom")
                .gender(1)
                .address("SF")
                .createTime(Instant.now().toString())
                .build();
        String json = objectMapper.writeValueAsString(user);
        // When + Then
        this.mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print());



    }

    @Test
    void should_get_user_list_when_get_all_user() throws Exception {
        // Given
        List<User> userList = new ArrayList<>(1);
        User user = User.builder()
                .name("tom")
                .gender(1)
                .address("SF")
                .createTime(Instant.now().toString())
                .build();
        userList.add(user);
        doReturn(userList).when(userService).getUsers();
        // When + Then
        this.mockMvc.perform(get("/user").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].name",is("tom")));
    }
}