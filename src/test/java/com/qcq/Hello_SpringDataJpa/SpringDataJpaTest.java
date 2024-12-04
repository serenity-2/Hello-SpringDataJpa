package com.qcq.Hello_SpringDataJpa;

import com.qcq.Hello_SpringDataJpa.domain.User;
import com.qcq.Hello_SpringDataJpa.repository.ComplexUserRepository;
import com.qcq.Hello_SpringDataJpa.repository.UserOrderRelationRepository;
import com.qcq.Hello_SpringDataJpa.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class SpringDataJpaTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComplexUserRepository complexUserRepository;
    @Autowired
    private UserOrderRelationRepository userOrderRelationRepository;


    @Test
    @DisplayName(value = "findById(ID id)")
    public void test1() {
        User user = userRepository.findById(100).orElseThrow(() -> new RuntimeException("用户不存在"));
        System.out.println(user);
    }

    @Test
    @DisplayName(value = "findAllById(Iterable<ID> ids")
    public void test2() {
        Iterable<User> userIterable = userRepository.findAllById(List.of(1, 2, 3));
        userIterable.forEach(System.out::println);
    }

    @Test
    @DisplayName(value = "existsById(ID id)")
    public void test3() {
        boolean isExist = userRepository.existsById(5);
        if (!isExist) {
            System.out.println("用户不存在");
        }
    }

    /**
     * save()方法在不指定主键的情况下，即实体对象的主键为null时，执行的是insert操作，
     * 而在指定主键的情况下，执行的操作为update操作，是将指定主键对应的那条记录的所有字段，更新为实体对象的每个对应属性的值，包括null值
     * 这种更新方法，会将有默认值且未给定值的字段给默认值null来插入库中，导致sql报错
     * 解决方法一是先通过findById()方法查询出该条记录，然后再更新
     * 第二种方法是通过@Query注解来指定sql语句
     * 方法三是在实体类里面给有默认值的字段直接赋值
     */
    @Test
    @DisplayName(value = "save(S entity)")
    public void test4() {
        User sanrio = new User();
        sanrio.setUserName("Sanrio Characters");
        sanrio.setNickName("三丽鸥");
        sanrio.setEmail("sanrio@gmail.com");
        sanrio.setSex("F");
        sanrio.setPhoneNumber("15800000000");
        //数据库里面没有，执行新增操作
        User user = userRepository.save(sanrio);
        Optional<User> userOptional = userRepository.findById(user.getUserId());
        if (userOptional.isPresent()) {
            //数据库里面有，执行更新操作,根据主键id进行更新
            user = userOptional.get();
            user.setUserName("Sanrio Character");
            userRepository.save(user);
        }
    }


    /**
     * deleteById()方法是根据主键id进行删除操作
     */
    @Test
    @DisplayName(value = "deleteById()")
    public void test5() {
        userRepository.deleteById(25);
    }

    /**
     * delete()方法是根据实体对象进行删除操作
     */
    @Test
    @DisplayName(value = "delete()")
    public void test6() {
        userRepository.findById(24).ifPresent(user -> userRepository.delete(user));
    }

    /**
     * 根据方法名自定义sql
     */
    @Test
    @DisplayName(value = "findByUserNameAndPhoneNumber()")
    public void test7() {
        User kuromi = userRepository.findByUserNameAndPhoneNumber("Kuromi", "15400000000");
        System.out.println(kuromi);
    }

    /**
     * JPA会根据方法名自动生成的sql
     */
    @Test
    @DisplayName(value = "findByUserNameLike()")
    public void test8() {
        User user = userRepository.findByUserNameLike("kur%");
        System.out.println(user);
    }

    /**
     * 使用JPQL自定义sql
     */
    @Test
    @DisplayName(value = "findByCreateTimeAndUpdateTime()")
    public void test9() {
        LocalDateTime createTime = LocalDateTime.now().minusDays(30);
        LocalDateTime updateTime = LocalDateTime.now();
        List<User> userList = userRepository.findByCreateTimeAndUpdateTime(createTime, updateTime);
        userList.forEach(System.out::println);
    }

    /**
     * 分页查询
     */
    @Test
    @DisplayName(value = "findByCreateTimeAndUpdateTime()")
    public void test10() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("createTime").reverse());
        Page<User> userPage = complexUserRepository.findAll(pageable);
        long total = userPage.getTotalElements();
        int totalPages = userPage.getTotalPages();
        int pageNumber = userPage.getNumber();
        List<User> userList = userPage.get().toList();
        userList.forEach(System.out::println);
    }

    /**
     *    select
     *         u1_0.id,
     *         u1_0.create_by,
     *         u1_0.create_time,
     *         u1_0.email,
     *         u1_0.nick_name,
     *         u1_0.phone_number,
     *         u1_0.sex,
     *         u1_0.status,
     *         u1_0.update_by,
     *         u1_0.update_time,
     *         u1_0.user_id,
     *         u1_0.user_name,
     *         uorl1_0.user_id,
     *         uorl1_0.id,
     *         uorl1_0.order_id
     *     from
     *         user u1_0
     *     left join
     *         user_order_relation uorl1_0
     *             on u1_0.user_id=uorl1_0.user_id
     *     where
     *         u1_0.id=?
     */
    @Test
    public void test11() {
        Optional<User> userOptional = userRepository.findById(1);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println(user);
        }
    }

    /**
     * SELECT * FROM user_order_relation uor
     * WHERE uor.user_id = 1 AND uor.order_id = 1
     * JOIN user u ON uor.user_id = u.user_id
     * and u.status = 1;
     */
    @Test
    public void test12() {
        boolean exist = userOrderRelationRepository.existsByUserIdAndOrderIdAndUserStatus(1,1,"1");
        Assertions.assertTrue(exist);
    }
}
