package cn.com.glsx.app.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_user_local_account")
public class UserLocalAccount extends BaseEntity {

    /**
     * 用户id 为了方便，这里冗余用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 认证id
     */
    @Column(name = "auth_id")
    private Long authId;

    /**
     * 用户名/昵称
     */
    private String username;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 平台id
     */
    @Column(name = "union_id")
    private String unionId;

}