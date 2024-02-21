package top.sakai.weibo.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserRegDTO {
    //                   参数说明           是否必须        示例
        /*
        1.NotNull注解:不允许为空值null,message参数为自定义提示消息
                     [ex.getFieldError().getDefaultMessage()];
        2.NotEmpty注解:不允许为空字符串,不允许为null值;
        3.NotBlank注解:不允许为空白串,空字符串,null值;
        4.Size注解:限制字符串类型的长度;
        5.Pattern注解：正则表达式校验，适用于相对复杂的数据合法性需求
     */
    //@NotNull(message = "用户名不能为null")
    //@NotEmpty(message = "用户名不能为空,同时不能为null")
    //@NotBlank(message = "用户名不能为空白,不能为空,不能为null")
    @Size(min = 6, max = 12, message = "用户名必须在6-12位之间")
    @ApiModelProperty(value = "用户名", required = true, example = "Tony")
    private String username;
    @ApiModelProperty(value = "用户密码", required = true, example = "123456")
    private String password;
    @ApiModelProperty(value = "用户昵称", required = true, example = "tony")
    private String nickname;
}
