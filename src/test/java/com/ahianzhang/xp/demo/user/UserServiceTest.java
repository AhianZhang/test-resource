package com.ahianzhang.xp.demo.user;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;

/**
 * @author ahianzhang
 */
@ExtendWith(MockitoExtension.class)
@Feature("业务逻辑层")
class UserServiceTest {


    @Mock
    private IUserMapper userMapper;

    @InjectMocks
    private UserService userService;


    @Test
    void should_affect_1_row_when_save_a_user() {
        // Given
        Integer expectedAffectRows = 1;

        User user = User.builder()
                .name("tom")
                .gender(1)
                .address("SF")
                .createTime(Instant.now().toString())
                .build();

        doReturn(expectedAffectRows).when(userMapper).createUser(user);


        // When
        Integer actualAffectRows = userService.createUser(user);

        // Then
        assertThat(actualAffectRows,is(expectedAffectRows));
    }

    @Test
    void should_return_user_list_when_get_all_user() {
        // Given
        User user = User.builder()
                .name("tom")
                .gender(1)
                .address("SF")
                .createTime(Instant.now().toString())
                .build();
        List<User> expectedUserList = Collections.singletonList(user);
        doReturn(expectedUserList).when(userMapper).getUsers();


        // When
        List<User> actualUserList = userService.getUsers();

        // Then
        assertThat(actualUserList,is(expectedUserList));

    }
}