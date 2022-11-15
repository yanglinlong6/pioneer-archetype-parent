package cn.com.glsx.app.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_user_wechat_account")
public class UserWechatAccount extends BaseEntity {

    /**
     * 认证id
     */
    @Column(name = "auth_id")
    private Long authId;

    /**
     * 平台id
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 微信头像
     */
    @Column(name = "wechat_avatar")
    private String avatar;

    /**
     * 微信名
     */
    @Column(name = "wechat_name")
    private String wechatName;

}