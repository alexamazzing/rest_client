package org.example;

import org.example.config.MyConfig;
import org.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        List<User> users = communication.getAllUsers();
        String cookie = communication.cookie.get(0);

        User user = new User();
        user.setId(3L);
        user.setName("James");
        user.setLastName("Brown");
        user.setAge((byte) 30);

        String code1 = communication.saveUser(user, cookie);
        System.out.print(code1);

        user.setName("Thomas");
        user.setLastName("Shelby");

        String code2 = communication.editUser(user, cookie);
        System.out.print(code2);

        String code3 = communication.deleteUserById(3L, cookie);
        System.out.print(code3);
    }
}
