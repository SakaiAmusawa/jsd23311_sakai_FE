package top.sakai.weibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakai.weibo.pojo.dto.UserLoginDTO;
import top.sakai.weibo.pojo.dto.UserRegDTO;
import top.sakai.weibo.response.JsonResult;
import top.sakai.weibo.service.IUserService;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    //不再注入UserMapper,而是注入业务接口
    @Autowired
    IUserService userService;//注入的是接口

    @PostMapping("/reg")
    public JsonResult reg(UserRegDTO userRegDTO) {
        //调用业务层代码，具体是什么业务 不关心
        userService.reg(userRegDTO);
        return JsonResult.ok();
    }

    @PostMapping("/login")
    public JsonResult login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);
        return JsonResult.ok();
    }
}
