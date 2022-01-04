package com.mycompany.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    UserController uc=new UserController();
    RedirectAttributes ra;
    @Test
    void saveUser() {
        User user = new User("qiu","email123@email.com","123456","s");
        String respond=uc.saveUser(user);
        assertEquals("redirect:/home",respond);
    }
    @Test
    void saveUser1() {
        User user = new User("qiu","email123email.com","123456","s");
        String respond=uc.saveUser(user);
        assertEquals("grammatical",respond);
    }
    @Test
    void saveUser2() {
        User user = new User("","email123@email.com","123456","s");
        String respond=uc.saveUser(user);
        assertEquals("empty",respond);
    }
}