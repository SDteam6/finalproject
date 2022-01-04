package com.mycompany;

import com.mycompany.user.User;
import com.mycompany.user.UserController;
import com.mycompany.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class UserRepositoryTests {
    @Autowired private UserRepository repo;
    @Test
    public void testAddNew() {
        User user = new User("qiu","email123@email.com","123456","s");

        User savedUser = repo.save(user);
        System.out.println(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
/*
    @Test
    public void testAddNew1() {
        User user = new User(1,"qiu","email123@email.com","123456","s");
        String respond =uc.saveUser(user,ra);
        User savedUser = repo.save(user);
        System.out.println(user);
        assertEquals("redirect:/home",respond);
        assertTrue ((repo.findById(1)!=NULL));
    }

    @Test
    public void testAddNew2() {
        User user = new User(1,"qiu","email123@email.com","123456","s");
        String respond =uc.saveUser(user,ra);
        User savedUser = repo.save(user);
        System.out.println(user);
        assertEquals("redirect:/home",respond);
        assertTrue ((repo.findById(1)!=NULL));
    }

    @Test
    public void testAddNew3() {
        User user = new User(1,"qiu","email123@email.com","123456","s");
        String respond =uc.saveUser(user,ra);
        User savedUser = repo.save(user);
        System.out.println(user);
        assertEquals("redirect:/home",respond);
        assertTrue ((repo.findById(1)!=NULL));
    }
*/
}
