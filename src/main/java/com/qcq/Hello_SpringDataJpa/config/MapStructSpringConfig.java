package com.qcq.Hello_SpringDataJpa.config;

import org.mapstruct.MapperConfig;

/**
 *componentModel = "spring":指定生成的实现类遵循Spring框架的组建类型，这意味着生产的类可以被Spring容器管理和注入。
 * unmappedTargetPolicy: 指定源对象与目标对象之间没有映射的方法时的处理策略，IGNORE表示不生成警告和错误，直接忽略。
 */
@MapperConfig(componentModel = "spring",unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public class MapStructSpringConfig {
}
