package com.qcq.Hello_SpringDataJpa.service;

import com.qcq.Hello_SpringDataJpa.domain.User;

public interface UserService {

    User findUserById(Integer id);

    boolean existUserById(Integer id);

    void saveUser(User user);
}
