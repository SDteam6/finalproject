package com.mycompany.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void checkEmail() {
        User user=new User();
        user.setuserid("name@mail.com");
        assertTrue(user.checkEmail());
        user.setuserid("d12345678@mail.com");
        assertTrue(user.checkEmail());
        user.setuserid("name@mail.com.org.tw");
        assertFalse(user.checkEmail());
        user.setuserid("namemail.com.org.tw");
        assertFalse(user.checkEmail());

    }
}