package cn.com.glsx.app.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "t_user_local_auth")
public class UserLocalAuth extends BaseEntity {

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

}