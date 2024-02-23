package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.UserLoginDTO;
import cn.tedu.baking.pojo.dto.UserRegDTO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("reg")
    public JsonResult regUser(UserRegDTO userRegDTO) {
        //System.out.println("userRegDTO = " + userRegDTO);
        userService.reg(userRegDTO);
        return JsonResult.ok();
    }

    @PostMapping("login")
    public JsonResult login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);
        return JsonResult.ok();
    }
}
