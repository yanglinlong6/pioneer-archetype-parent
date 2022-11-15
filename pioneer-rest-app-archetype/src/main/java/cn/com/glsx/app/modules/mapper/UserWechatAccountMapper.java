package cn.com.glsx.app.modules.mapper;

import cn.com.glsx.app.modules.entity.UserWechatAccount;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserWechatAccountMapper extends CommonBaseMapper<UserWechatAccount> {

    UserWechatAccount selectByAuthId(Long authId);

}