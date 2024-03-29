package cn.tedu.baking.pojo.vo;

import lombok.Data;

@Data
public class UserVO {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Integer isAdmin;
    private String imgUrl;
}
