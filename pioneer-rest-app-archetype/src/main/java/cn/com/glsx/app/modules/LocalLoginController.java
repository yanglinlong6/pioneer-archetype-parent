package cn.com.glsx.app.modules;

import cn.com.glsx.app.modules.model.AppUser;
import cn.com.glsx.app.modules.model.LoginByAccountBO;
import cn.com.glsx.app.modules.service.LoginService;
import cn.com.glsx.app.modules.service.UserService;
import com.glsx.plat.core.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyf
 */
@Slf4j
@RestController
public class LocalLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/")
    public String index() {
        return "success";
    }

    /**
     * 本地登录
     */
    @PostMapping(value = "/login")
    public R login(@RequestBody @Valid LoginByAccountBO loginBO) {

        AppUser user = loginService.localAuth(loginBO);

        String token = userService.createToken(user);

        Map<String, Object> rtnMap = new HashMap<>();
        rtnMap.put("token", token);
        rtnMap.put("user", user);
        return R.ok().data(rtnMap);
    }

    @GetMapping(value = "/logout")
    public R logout() {
        //todo 拉黑token
        return R.ok();
    }

}
