package cn.com.glsx.app.modules.model;

import lombok.Data;

@Data
public class AppUser {

    private Long id;
    private String account;
    private String username;
    private String avatar;
    private Integer gender;
    private Integer blacklist;

}
