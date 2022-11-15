package cn.com.glsx.app.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_user_qq_account")
public class UserQQAccount extends BaseEntity {

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
     * QQ头像
     */
    @Column(name = "qq_avatar")
    private String avatar;

    /**
     * QQ名
     */
    @Column(name = "qq_name")
    private String qqName;

}