package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.UserLoginDTO;
import cn.tedu.baking.pojo.dto.UserRegDTO;
import cn.tedu.baking.pojo.dto.UserUpdateDTO;
import cn.tedu.baking.pojo.vo.UserVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/")
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("reg")
    public JsonResult regUser(UserRegDTO userRegDTO) {
        userService.reg(userRegDTO);
        return JsonResult.ok();
    }

    @PostMapping("login")
    public JsonResult login(UserLoginDTO userLoginDTO) {
        UserVO userVO = userService.login(userLoginDTO);
        return JsonResult.ok(userVO);
    }

    @PostMapping("update")
    public JsonResult update(UserUpdateDTO userUpdateDTO) {
        userService.update(userUpdateDTO);
        return JsonResult.ok();
    }
}
