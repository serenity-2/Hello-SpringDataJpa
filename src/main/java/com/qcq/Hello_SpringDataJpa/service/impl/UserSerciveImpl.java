package com.qcq.Hello_SpringDataJpa.service.impl;

import com.qcq.Hello_SpringDataJpa.domain.User;
import com.qcq.Hello_SpringDataJpa.dto.UserDTO;
import com.qcq.Hello_SpringDataJpa.repository.UserRepository;
import com.qcq.Hello_SpringDataJpa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSerciveImpl implements UserService {
     private UserRepository userRepository;

    public UserSerciveImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
     public User findUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user;
        }else {
            System.out.println("用户不存在");
            return null;
        }
    }

    @Override
    public boolean existUserById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
