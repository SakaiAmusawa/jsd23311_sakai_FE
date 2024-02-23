package cn.tedu.baking.exception;

import lombok.Getter;
import cn.tedu.baking.response.StatusCode;


//1.自定义业务异常类
public class ServiceException extends RuntimeException {
    @Getter
    private StatusCode statusCode;

    public ServiceException(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

}
