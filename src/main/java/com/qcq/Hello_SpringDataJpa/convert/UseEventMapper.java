package com.qcq.Hello_SpringDataJpa.convert;

import com.qcq.Hello_SpringDataJpa.domain.User;
import com.qcq.Hello_SpringDataJpa.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


/**
 * 如果同时使用了Mapstruct和Lombok，那么需要保证Lombok先于Mapstruct加载，
 * 因为Maostruct依赖Lombok生成的get/set方法，否则无法生成映射接口的实现类。
 */
@Mapper(componentModel = "spring")
public interface UseEventMapper {

    /**
     * 在@Mapping注解中，source与expression属性只能指定一个
     * source：源对象，target：目标对象，将source转化为target
     * @param user
     * @return
     */
    @Mappings({
            @Mapping(source = "userId",target = "id"),
            @Mapping(source = "userName",target = "userName"),
            @Mapping(source = "nickName",target = "nickName"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "phoneNumber",target = "phoneNumber"),
            @Mapping(target = "createTime",expression = "java(convertToCreateTime(user))")
    })
   UserDTO convert(User user);

    default Date convertToCreateTime(User user) {
        LocalDateTime createTime = user.getCreateTime();
        return Date.from(createTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
