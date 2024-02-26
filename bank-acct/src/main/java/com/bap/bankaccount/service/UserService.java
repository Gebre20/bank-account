package com.bap.bankaccount.service;

import com.bap.bankaccount.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
}
