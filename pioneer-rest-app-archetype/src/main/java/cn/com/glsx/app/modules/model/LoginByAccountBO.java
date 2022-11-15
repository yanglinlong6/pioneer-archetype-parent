package cn.com.glsx.app.modules.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginByAccountBO {

    /**
     * 登录类型：1密码，2短信验证码
     */
    @NotNull
    private Integer loginType;

    @NotBlank(message = "账号不能为空")
    private String account;

    @NotBlank(message = "验证码/密码不能为空")
    private String code;

    //@NotNull(message = "APP客户端ID不能为空")
    private String clientId;

}
