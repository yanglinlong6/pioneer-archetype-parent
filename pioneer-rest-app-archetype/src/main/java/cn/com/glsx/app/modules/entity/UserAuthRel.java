package cn.com.glsx.app.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_user_auth_rel")
public class UserAuthRel extends BaseEntity {

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 认证id
     */
    @Column(name = "auth_id")
    private Long authId;

    /**
     * 验证类型:local,third
     */
    @Column(name = "auth_type")
    private String authType;

}