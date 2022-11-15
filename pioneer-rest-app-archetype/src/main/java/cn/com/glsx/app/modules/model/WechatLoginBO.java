package cn.com.glsx.app.modules.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WechatLoginBO {

    @NotBlank
    private String openId;
    @NotBlank
    private String unionId;

}
