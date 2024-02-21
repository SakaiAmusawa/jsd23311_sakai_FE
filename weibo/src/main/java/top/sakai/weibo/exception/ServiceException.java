package top.sakai.weibo.exception;

import lombok.Getter;
import top.sakai.weibo.response.StatusCode;


//1.自定义业务异常类
public class ServiceException extends RuntimeException {
    @Getter
    private StatusCode statusCode;

    public ServiceException(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

}
