package top.sakai.web.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginDTO {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "用户密码", required = true)
    private String password;


}
