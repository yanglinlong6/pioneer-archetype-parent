package cn.com.glsx.app.modules.service;

import cn.com.glsx.app.modules.model.AppUser;
import cn.hutool.core.lang.UUID;
import com.glsx.plat.common.utils.ObjectUtils;
import com.glsx.plat.jwt.base.ComJwtUser;
import com.glsx.plat.jwt.util.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private JwtUtils<ComJwtUser> jwtUtils;

    /**
     * 生成带用户信息的token
     *
     * @param user
     * @return
     */
    public String createToken(AppUser user) {
        Assert.notNull(user, "获取当前用户信息失败");
        String uuid = UUID.randomUUID().toString(); //JWT 随机ID,做为验证的key
        String jwtId = jwtUtils.getApplication() + ":" + uuid + "_" + jwtUtils.JWT_SESSION_PREFIX + user.getId();
        ComJwtUser jwtUser = new ComJwtUser();
        jwtUser.setApplication(jwtUtils.getApplication());
        jwtUser.setJwtId(jwtId);
        jwtUser.setUserId(String.valueOf(user.getId()));
        jwtUser.setAccount(user.getAccount());
        Map<String, Object> userMap = (Map<String, Object>) ObjectUtils.objectToMap(jwtUser);
        return jwtUtils.createToken(userMap);
    }

    public AppUser getAppUserByUserId(Long aLong) {
        return null;
    }

}
