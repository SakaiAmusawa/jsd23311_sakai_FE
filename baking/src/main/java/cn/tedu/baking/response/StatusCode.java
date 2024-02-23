package cn.tedu.baking.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusCode {
    //枚举中所有的实例都放在最上面
    NOT_LOGIN(1000, "未登入"), LOGIN_SUCCESS(1001, "登入成功"), PASSWORD_ERROR(1002, "密码错误"), USERNAME_ERROR(1003, "用户名错误"), USERNAME_ALREADY_EXISTS(1004, "用户名被占用"), OPERATION_SUCCESS(2001, "操作成功"), OPERATION_FAILED(2002, "操作失败"), THROWABLE_ERROR(3000, "THROWABLE异常出现"),
    VALIDATED_ERROR(4000, "参数校验失败");
    //状态码code，提示消息msg
    private Integer code;
    private String msg;

}
