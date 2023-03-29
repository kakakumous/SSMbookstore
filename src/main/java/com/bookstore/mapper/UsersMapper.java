package com.bookstore.mapper;

import com.bookstore.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {
    void register(User user);
    User selByName(String username);
    User selById(Integer id);
    void update(User user);


}
