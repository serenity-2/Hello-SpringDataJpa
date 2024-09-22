package com.qcq.Hello_SpringDataJpa.repository;

import com.qcq.Hello_SpringDataJpa.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface UserRepository extends CrudRepository<User,Integer> {


    User findByUserNameAndPhoneNumber(String userName, String phoneNumber);

    User findByUserNameLike(String userName);

    @Query(value = "select t from User t where t.createTime >= :createTime and t.updateTime <= :updateTime")
    List<User> findByCreateTimeAndUpdateTime(LocalDateTime createTime, LocalDateTime updateTime);

}
