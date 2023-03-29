package com.bookstore.service;

import com.bookstore.domain.User;

public interface UserService {
    void register(User user);
    User selByName(String username);
    User selById(Integer id);
    void modify(User user);
}
