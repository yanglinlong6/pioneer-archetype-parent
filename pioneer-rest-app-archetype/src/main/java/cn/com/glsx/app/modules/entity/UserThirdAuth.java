package cn.com.glsx.app.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_user_third_auth")
public class UserThirdAuth extends BaseEntity {

    /**
     * 第三方用户唯一标识
     */
    private String openid;

    /**
     * 第三方平台标识(qq、wechat...)
     */
    @Column(name = "login_type")
    private String loginType;

    /**
     * 第三方获取的access_token,校验使用
     */
    @Column(name = "access_token")
    private String accessToken;

}