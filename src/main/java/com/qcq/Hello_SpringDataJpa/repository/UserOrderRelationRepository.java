package com.qcq.Hello_SpringDataJpa.repository;

import com.qcq.Hello_SpringDataJpa.domain.User;
import com.qcq.Hello_SpringDataJpa.domain.UserOrderRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRelationRepository extends CrudRepository<UserOrderRelation,Integer> {

    boolean existsByUserIdAndOrderIdAndUserStatus(Integer userId, Integer orderId, String user_status);
}
