package cn.com.glsx.app.modules.mapper;

import cn.com.glsx.app.modules.entity.UserQQAccount;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserQQAccountMapper extends CommonBaseMapper<UserQQAccount> {

    UserQQAccount selectByAuthId(Long authId);

}