package top.sakai.weibo.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserVO {
    @ApiModelProperty(value = "用户的ID")
    private Integer id;
    @ApiModelProperty(value = "用户的密码")
    private String password;
    @ApiModelProperty(value = "用户的昵称")
    private String nickname;

}
