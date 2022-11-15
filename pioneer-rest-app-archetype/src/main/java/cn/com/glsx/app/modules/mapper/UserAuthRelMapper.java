package cn.com.glsx.app.modules.mapper;

import cn.com.glsx.app.modules.entity.UserAuthRel;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAuthRelMapper extends CommonBaseMapper<UserAuthRel> {

    UserAuthRel selectById(@Param("id") Long id);

    UserAuthRel selectLocalAuthRelByUserId(@Param("userId") Long userId);

    UserAuthRel selectByAuthTypeAndAuthId(@Param("authType") String authType, @Param("authId") Long authId);

    List<UserAuthRel> selectByAuthTypeAndUserId(@Param("authType") String authType, @Param("userId") Long userId);

    List<UserAuthRel> selectByUserId(@Param("userId") Long userId);

    int logicDeleteByUserId(@Param("userId") Long userId);

}