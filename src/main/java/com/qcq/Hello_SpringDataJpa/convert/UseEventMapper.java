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
     * /参数类型相同，直接指定source和target即可
     * @param user
     * @return
     */
    @Mappings({
            @Mapping(target = "userName"), //当source未指定时，映射将基于属性名称和类型自动匹配
            @Mapping(source = "nickName",target = "nickName"),
            @Mapping(source = "email",target = "email",defaultValue = "eamail@163.com"), // 当源对象的email为null时，使用默认值
            @Mapping(source = "phoneNumber",target = "phoneNumber"),
            @Mapping(target = "createTime",expression = "java(convertToCreateTime(user))") //参数类型不同，使用expression
    })
   UserDTO convert(User user);

    default Date convertToCreateTime(User user) {
        LocalDateTime createTime = user.getCreateTime();
        return Date.from(createTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
