package top.sakai.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakai.web.pojo.dto.UserRegDTO;
import top.sakai.web.response.JsonResult;
import top.sakai.web.service.IUserService;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    @Autowired
    IUserService userService;//注入的是接口

    @PostMapping("/reg")
    public JsonResult reg(@RequestBody UserRegDTO userRegDTO) {
        userService.reg(userRegDTO);
        return JsonResult.ok();
    }
}
