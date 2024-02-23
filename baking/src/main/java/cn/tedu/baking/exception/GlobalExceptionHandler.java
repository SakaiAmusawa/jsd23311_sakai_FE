package cn.tedu.baking.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.sakai.weibo.response.JsonResult;
import top.sakai.weibo.response.StatusCode;

import javax.validation.ConstraintViolationException;

/**
 * Spring MVC  全局异常处理器
 * <p>
 * ControllerAdvice注解:
 * <p>
 * 1.表示此类为SpringMVC全局异常处理器的类
 * <p>
 * 2.一旦控制器抛出异常，框架会检查是否定义了全局异常处理器；
 */

@Slf4j
/*@ControllerAdvice
@ResponseBody*/

@RestControllerAdvice//组合注解，如上


public class GlobalExceptionHandler {
    @ExceptionHandler//标记为异常处理方法
    //                                                 将需要处理的异常传递进来
    public JsonResult doHandleIllegalArgumentException(IllegalArgumentException ex) {
        String message = ex.getMessage();
        log.error("IllegalArgumentException" + message);
        return new JsonResult(StatusCode.OPERATION_FAILED, message);//切记返回JAVA类型的数据时要用@ResponseBody（此处已经在类上使用了组合注解）
    }


    /*
    如何出现了异常那么将会先去寻找该异常对应的异常处理方法，如果未寻找到对应的异常处理方法那么就会找到其父类的异常处理方法，
    如果父类也没有找到那么就会使用throwable，如果还是没有那么使用springMVC内置的异常处理机制
     */
    @ExceptionHandler
    public JsonResult doHandleRuntimeException(RuntimeException ex) {
        String message = ex.getMessage();
        log.error(message);
        return new JsonResult(StatusCode.OPERATION_FAILED, message);
    }

    /*
    Throwable:处理控制器抛出的所有异常，一般在工程的最后时期加
     */
/*    @ExceptionHandler
    public JsonResult doHandle(Throwable ex) {
        String message = ex.getMessage();
        log.error(message);
        return new JsonResult(StatusCode.THROWABLE_ERROR, message);
    }*/
    /*
   第三个异常处理方法：验证DTO类方式接受数据异常
     */
    @ExceptionHandler
    public JsonResult doHandleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String message = exception.getFieldError().getDefaultMessage();
        log.error(message);
        return new JsonResult(StatusCode.VALIDATED_ERROR, message);
    }

    @ExceptionHandler
    public JsonResult doHandleConstraintViolationException(ConstraintViolationException exception) {
        String message = exception.getMessage().split(":")[1].trim();
        log.error(message);
        return new JsonResult(StatusCode.VALIDATED_ERROR, message);
    }

    @ExceptionHandler
    public JsonResult doHandleServiceException(ServiceException exception) {
        //1.在后端控制台打印错误日志
        log.error("RuntimeException:" + exception.getStatusCode().getMsg());
        //2.返回错误状态码
        return new JsonResult(exception.getStatusCode());
    }

}
