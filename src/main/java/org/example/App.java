package org.example;

import org.example.main.model.User;
import org.example.main.service.impl.UserService;

/**
 * Hello world!
 */
public class App {
    /**
     *
     * Я В ТЕБЕ ВЕРЮ, У ТЕБЯ ВСЕ ПОЛУЧИТСЯ!!!
     */
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.createTable();
//        userService.save(new User("Adilet","Akbaraliev",
//                "akbaraliev@gmail.com",17,
//                "Russia",1616));
//        User user = userService.findById(2)
        userService.update(1,new User("Aijan",
                "Chyngyzova","aijan@gmail.com",11,"Kyrgyzstan",1111));
//userService.deleteById(1);
        System.out.println(userService.getAll());
    }
}
