package com.qcq.Hello_SpringDataJpa.repository;


import com.qcq.Hello_SpringDataJpa.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;


/**
 * 带有分页和排序功能的接口
 */
@Component
public interface ComplexUserRepository extends PagingAndSortingRepository<User,Integer> {

}
