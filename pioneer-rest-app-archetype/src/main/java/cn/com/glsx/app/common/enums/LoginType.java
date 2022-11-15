package cn.com.glsx.app.common.enums;

import lombok.Getter;

@Getter
public enum LoginType {

    NATIVE("native"), WECHAT("wechat"), QQ("qq"), APPLE("apple");

    private String type;

    LoginType(String type) {
        this.type = type;
    }

}
