package cn.com.glsx.app.modules.mapper;

import cn.com.glsx.app.modules.entity.UserLocalAccount;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLocalAccountMapper extends CommonBaseMapper<UserLocalAccount> {

    UserLocalAccount selectByAuthId(@Param("authId") Long authId);

    UserLocalAccount selectByUserId(@Param("userId") Long userId);

    UserLocalAccount selectByUnionId(@Param("unionId") String unionId);

    int logicDeleteById(@Param("id") Long id);

}