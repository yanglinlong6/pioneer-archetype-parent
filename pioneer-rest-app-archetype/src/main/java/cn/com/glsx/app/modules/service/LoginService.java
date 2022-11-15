package cn.com.glsx.app.modules.service;

import cn.com.glsx.app.common.enums.AuthType;
import cn.com.glsx.app.common.enums.LoginType;
import cn.com.glsx.app.common.exception.AppServerException;
import cn.com.glsx.app.modules.entity.*;
import cn.com.glsx.app.modules.mapper.*;
import cn.com.glsx.app.modules.model.*;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserAuthRelMapper authRelMapper;

    @Resource
    private UserLocalAuthMapper localAuthMapper;

    @Resource
    private UserThirdAuthMapper thirdAuthMapper;

    @Resource
    private UserLocalAccountMapper localAccountMapper;

    @Resource
    private UserWechatAccountMapper wechatAccountMapper;

    @Resource
    private UserQQAccountMapper qqAccountMapper;

    @Transactional(rollbackFor = Exception.class)
    public AppUser localAuth(LoginByAccountBO loginBO) {

        // TODO: 2022/3/24 内部登录转成appUser返回前端
        AppUser appUser = new AppUser();

        UserAuthRel userAuthRel = authRelMapper.selectLocalAuthRelByUserId(appUser.getId());
        if (loginBO.getLoginType() == 1) {
            //密码登录
            UserLocalAuth localAuth = localAuthMapper.selectById(userAuthRel.getAuthId());
            if (localAuth == null) {
                throw new AppServerException("请先开通登录权限");
            }
        } else if (loginBO.getLoginType() == 2) {
            //验证码校验
            //smsService.verifyCode(loginBO.getAccount(), loginBO.getCode());
        }
        return appUser;
    }

    @Transactional(rollbackFor = Exception.class)
    public UserAuthRel qqAuth(QQOAuth2AccessToken accessToken) {
        UserThirdAuth thirdAuth = thirdAuthMapper.selectByOpenid(accessToken.getOpenId());
        if (thirdAuth == null) {
            thirdAuth = new UserThirdAuth();
            thirdAuth.setOpenid(accessToken.getOpenId());
            thirdAuth.setAccessToken(accessToken.getAccessToken());
            thirdAuth.setLoginType(LoginType.QQ.getType());
            thirdAuthMapper.insertUseGeneratedKeys(thirdAuth);
        }

        UserQQAccount qqAccount = qqAccountMapper.selectByAuthId(thirdAuth.getId());
        if (qqAccount == null) {
            qqAccount = new UserQQAccount();
            qqAccount.setAuthId(thirdAuth.getId());
            qqAccount.setUnionId(accessToken.getUnionId());
            qqAccountMapper.insertUseGeneratedKeys(qqAccount);
        }

        UserAuthRel authRel = authRelMapper.selectByAuthTypeAndAuthId(AuthType.THIRD.getType(), thirdAuth.getId());
        if (authRel == null) {
            authRel = new UserAuthRel();
            authRel.setAuthId(thirdAuth.getId());
            authRel.setAuthType(AuthType.THIRD.getType());
            authRelMapper.insertUseGeneratedKeys(authRel);
        }
        return authRel;
    }

    @Transactional(rollbackFor = Exception.class)
    public UserAuthRel qqLogin(QQLoginBO loginBO) {
        UserThirdAuth thirdAuth = thirdAuthMapper.selectByOpenid(loginBO.getOpenId());
        if (thirdAuth == null) {
            thirdAuth = new UserThirdAuth();
            thirdAuth.setOpenid(loginBO.getOpenId());
            thirdAuth.setLoginType(LoginType.QQ.getType());
            thirdAuthMapper.insertUseGeneratedKeys(thirdAuth);
        }

        UserQQAccount qqAccount = qqAccountMapper.selectByAuthId(thirdAuth.getId());
        if (qqAccount == null) {
            qqAccount = new UserQQAccount();
            qqAccount.setAuthId(thirdAuth.getId());
            qqAccountMapper.insertUseGeneratedKeys(qqAccount);
        }

        UserAuthRel authRel = authRelMapper.selectByAuthTypeAndAuthId(AuthType.THIRD.getType(), thirdAuth.getId());
        if (authRel == null) {
            authRel = new UserAuthRel();
            authRel.setAuthId(thirdAuth.getId());
            authRel.setAuthType(AuthType.THIRD.getType());
            authRelMapper.insertUseGeneratedKeys(authRel);
        }
        return authRel;
    }

    @Transactional(rollbackFor = Exception.class)
    public UserAuthRel wechatAuth(WxOAuth2AccessToken accessToken) {
        UserThirdAuth thirdAuth = thirdAuthMapper.selectByOpenid(accessToken.getOpenId());
        if (thirdAuth == null) {
            thirdAuth = new UserThirdAuth();
            thirdAuth.setOpenid(accessToken.getOpenId());
            thirdAuth.setAccessToken(accessToken.getAccessToken());
            thirdAuth.setLoginType(LoginType.WECHAT.getType());
            thirdAuthMapper.insertUseGeneratedKeys(thirdAuth);
        }

        UserWechatAccount wechatAccount = wechatAccountMapper.selectByAuthId(thirdAuth.getId());
        if (wechatAccount == null) {
            wechatAccount = new UserWechatAccount();
            wechatAccount.setAuthId(thirdAuth.getId());
            wechatAccount.setUnionId(accessToken.getUnionId());
            wechatAccountMapper.insertUseGeneratedKeys(wechatAccount);
        }

        UserAuthRel authRel = authRelMapper.selectByAuthTypeAndAuthId(AuthType.THIRD.getType(), thirdAuth.getId());
        if (authRel == null) {
            authRel = new UserAuthRel();
            authRel.setAuthId(thirdAuth.getId());
            authRel.setAuthType(AuthType.THIRD.getType());
            authRelMapper.insertUseGeneratedKeys(authRel);
        }
        return authRel;
    }

    @Transactional(rollbackFor = Exception.class)
    public UserAuthRel wechatLogin(WechatLoginBO loginBO) {
        UserThirdAuth thirdAuth = thirdAuthMapper.selectByOpenid(loginBO.getOpenId());
        if (thirdAuth == null) {
            thirdAuth = new UserThirdAuth();
            thirdAuth.setOpenid(loginBO.getOpenId());
            thirdAuth.setLoginType(LoginType.WECHAT.getType());
            thirdAuthMapper.insertUseGeneratedKeys(thirdAuth);
        }

        UserWechatAccount wechatAccount = wechatAccountMapper.selectByAuthId(thirdAuth.getId());
        if (wechatAccount == null) {
            wechatAccount = new UserWechatAccount();
            wechatAccount.setAuthId(thirdAuth.getId());
            wechatAccount.setUnionId(loginBO.getUnionId());
            wechatAccountMapper.insertUseGeneratedKeys(wechatAccount);
        }

        UserAuthRel authRel = authRelMapper.selectByAuthTypeAndAuthId(AuthType.THIRD.getType(), thirdAuth.getId());
        if (authRel == null) {
            authRel = new UserAuthRel();
            authRel.setAuthId(thirdAuth.getId());
            authRel.setAuthType(AuthType.THIRD.getType());
            authRelMapper.insertUseGeneratedKeys(authRel);
        }
        return authRel;
    }

}
