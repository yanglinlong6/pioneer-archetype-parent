package cn.com.glsx.app.modules.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class QQOAuth2AccessToken implements Serializable {

    private String accessToken;

    private int expiresIn = -1;

    private String refreshToken;

    private String openId;

    private String unionId;

}
