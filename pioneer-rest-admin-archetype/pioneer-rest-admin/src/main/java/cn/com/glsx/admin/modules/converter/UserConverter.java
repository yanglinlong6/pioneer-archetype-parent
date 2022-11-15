package cn.com.glsx.admin.modules.converter;

import cn.com.glsx.admin.modules.entity.User;
import cn.com.glsx.admin.services.userservice.model.UserBO;
import cn.com.glsx.admin.services.userservice.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 解耦dao与api的实体映射
 * 字段名不一样，用@Mapping来处理
 * https://github.com/mapstruct/mapstruct-examples
 *
 * @author payu
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDTO do2dto(User user);

    User dto2do(UserDTO userDTO);

    @Mappings(@Mapping(source = "realname", target = "realName"))
    UserBO do2bo(User user);

    @Mappings(@Mapping(source = "realName", target = "realname"))
    User bo2do(UserBO userBO);

}
