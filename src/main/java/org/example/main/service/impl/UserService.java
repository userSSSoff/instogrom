package org.example.main.service.impl;

import org.example.main.model.Friend;
import org.example.main.model.Post;
import org.example.main.model.User;
import org.example.main.service.Service;

import java.util.List;

// TODO: 27.06.2023
//  Здесь ты должен реализовать весь CRUD
//  (create -save,
//  read - findById || getAll,
//  update - update,
//  delete - delete) и дополнительные методы!!!
public class UserService implements Service<User> {

    public User followYou(int friendId) {
        return null;
    }

    public List<Friend> getAllFriends() {
        return null;
    }

    public Post sendLike(int postId) {
        return null;
    }

    public List<Post> getNewPosts() {
        return null;
    }

    public Post getPopularPost() {
        return null;
    }
    
}
