package com.qcq.Hello_SpringDataJpa;

import com.qcq.Hello_SpringDataJpa.domain.User;
import com.qcq.Hello_SpringDataJpa.repository.UserRepository;
import com.qcq.Hello_SpringDataJpa.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceMockTest {
    @Mock
    private UserService userService;

    /**
     * 有返回值的方法主要用when()方法结合thenReturn()、thenThrow()等方法来模拟
     */
    @Test
    public void assertUserExist() {
        //expectation
        when(userService.existUserById(1)).thenReturn(true);
        when(userService.existUserById(20)).thenReturn(false);
        //unit test & assert
        Assertions.assertTrue(userService.existUserById(1));
        Assertions.assertFalse(userService.existUserById(20));
        // verification
        verify(userService).existUserById(11); // 验证方法是否被调用,且参数为指定的参数
    }

    @Test
    public void assertFindUser() {
        User user = new User();
        User moko = user.setUserId(2).setUserName("moko");
        when(userService.findUserById(2)).thenReturn(moko).thenThrow(new RuntimeException("用户不存在"));
        Assertions.assertNotNull(userService.findUserById(20));
    }

    /**
     * 无返回值的方法用doThrow()、doAnswer()、doNothing()、doReturn()等方法来模拟
     */
    @Test
    public void assertSaveUser() {
        User user = new User();
        user.setUserId(1).setUserName("Sophie").setNickName("苏菲").setSex("M").setPhoneNumber("1370000000");
        doThrow(new RuntimeException("保存失败")).when(userService).saveUser(user);
        Assertions.assertThrows(RuntimeException.class, () -> userService.saveUser(user));
    }

}
