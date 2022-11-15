package cn.com.glsx.app.modules.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QQLoginBO {

    @NotBlank
    private String openId;

}
