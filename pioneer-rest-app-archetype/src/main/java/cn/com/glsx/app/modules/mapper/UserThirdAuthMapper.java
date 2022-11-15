package cn.com.glsx.app.modules.mapper;

import cn.com.glsx.app.modules.entity.UserThirdAuth;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserThirdAuthMapper extends CommonBaseMapper<UserThirdAuth> {

    UserThirdAuth selectByOpenid(@Param("openid") String openid);

    UserThirdAuth selectByLoginTypeAndUserId(@Param("loginType") String loginType, @Param("userId") Long userId);

    int logicDeleteById(@Param("id") Long id);

}