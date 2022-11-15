package cn.com.glsx.app.modules;

import cn.com.glsx.app.modules.entity.UserAuthRel;
import cn.com.glsx.app.modules.model.AppUser;
import cn.com.glsx.app.modules.model.QQLoginBO;
import cn.com.glsx.app.modules.model.WechatLoginBO;
import cn.com.glsx.app.modules.service.LoginService;
import cn.com.glsx.app.modules.service.UserService;
import cn.hutool.json.JSONUtil;
import com.glsx.plat.common.annotation.NoLogin;
import com.glsx.plat.core.web.R;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author liuyf
 * @Title UserController.java
 * @Package com.hflw.vasp.controller
 * @Description 微信登录
 * @date 2019年10月24日 下午2:02:54
 */
@Slf4j
@RestController
public class ThirdLoginController {

    private final WxMpService wxMpService;

    @Resource
    private UserService userService;

    @Autowired
    private LoginService loginService;

    public ThirdLoginController(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @NoLogin
    @RequestMapping(value = "/wechatAuth")
    public R wechatAuth(@RequestParam String code) throws WxErrorException {
        WxOAuth2AccessToken accessToken = wxMpService.getOAuth2Service().getAccessToken(code);
        log.info("微信code[{}]获取的Token信息为{}", code, JSONUtil.toJsonStr(accessToken));
        UserAuthRel authRel = loginService.wechatAuth(accessToken);

        Map<String, Object> rtnMap = thirdLogin(authRel);

        return R.ok().data(rtnMap);
    }

    @NoLogin
    @PostMapping(value = "/wechatLogin")
    public R wechatLogin(@RequestBody WechatLoginBO loginBO) {
        log.info("微信授权参数 {}", loginBO.toString());
        UserAuthRel wxAuthRel = loginService.wechatLogin(loginBO);

        Map<String, Object> rtnMap = thirdLogin(wxAuthRel);

        return R.ok().data(rtnMap);
    }

    @NoLogin
    @RequestMapping(value = "/qqAuth")
    public R qqAuth(@RequestParam String code) {
        return R.ok();
    }

    @NoLogin
    @RequestMapping(value = "/qqLogin")
    public R qqLogin(@RequestBody QQLoginBO loginBO) {
        log.info("QQ授权参数 {}", loginBO.toString());
        UserAuthRel qqAuthRel = loginService.qqLogin(loginBO);

        Map<String, Object> rtnMap = thirdLogin(qqAuthRel);

        return R.ok().data(rtnMap);
    }

    private Map<String, Object> thirdLogin(UserAuthRel authRel) {
        Map<String, Object> rtnMap = new HashMap<>();

        Optional<Long> optUserId = Optional.ofNullable(authRel.getUserId());
        if (optUserId.isPresent()) {
            //如果用户id存在，理论上User不为空
            AppUser user = userService.getAppUserByUserId(optUserId.get());
            String token = userService.createToken(user);
            rtnMap.put("token", token);
//            rtnMap.put("user", UserConverter.INSTANCE.do2dto(user));
        } else {
            //没有绑定用户
            rtnMap.put("authRelId", authRel.getId());
        }
        return rtnMap;
    }

}
