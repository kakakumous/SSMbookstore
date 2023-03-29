package com.bookstore.service.impl;

import com.bookstore.domain.User;
import com.bookstore.mapper.UsersMapper;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UsersMapper userDAO;
    public void register(User user){
        userDAO.register(user);
    }
    public User selByName(String username){
        return userDAO.selByName(username);
    }

    @Override
    public User selById(Integer id) { return userDAO.selById(id); }

    @Override

    public void modify(User user) { userDAO.update(user);}
}
