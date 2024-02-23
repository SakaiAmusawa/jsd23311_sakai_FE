package cn.tedu.baking.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 统一响应结果的Java类型
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    private Integer code;
    private String msg;
    private Object data;

    public JsonResult(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    public JsonResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public static JsonResult ok(Object object) {
        return new JsonResult(StatusCode.OPERATION_SUCCESS, object);
    }

    public static JsonResult ok() {
        return new JsonResult(StatusCode.OPERATION_SUCCESS);
    }
}
