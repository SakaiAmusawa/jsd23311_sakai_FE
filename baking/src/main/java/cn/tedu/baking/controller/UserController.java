package cn.tedu.baking.controller;

import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    public JsonResult regUser() {
        return JsonResult.ok();
    }
}
