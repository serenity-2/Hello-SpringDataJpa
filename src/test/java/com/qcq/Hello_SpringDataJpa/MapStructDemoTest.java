package com.qcq.Hello_SpringDataJpa;

import com.qcq.Hello_SpringDataJpa.convert.UseEventMapper;
import com.qcq.Hello_SpringDataJpa.domain.User;
import com.qcq.Hello_SpringDataJpa.dto.UserDTO;
import com.qcq.Hello_SpringDataJpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MapStructDemoTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UseEventMapper useEventMapper;

    @Test
    public void test1() {
        Optional<User> userOptional = userRepository.findById(1);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO userDTO = useEventMapper.convert(user);
            System.out.println(userDTO);
        }
    }
}
