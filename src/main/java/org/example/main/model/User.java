package org.example.main.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

// TODO: 27.06.2023 ID, NAME, LAST_NAME, EMAIL, AGE, ADDRESS, FRIEND_ID;
@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int id;
    String name;
    String last_name;
    String email;
    int age;
    String address;
    int friend_id;

    public User(String name, String last_name, String email, int age, String address, int friend_id) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.friend_id = friend_id;
    }
}
