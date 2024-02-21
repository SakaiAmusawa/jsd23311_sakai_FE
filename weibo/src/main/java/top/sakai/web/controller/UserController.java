package top.sakai.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakai.web.pojo.dto.UserRegDTO;
import top.sakai.web.response.JsonResult;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    @PostMapping("/reg")
    public JsonResult reg(@RequestBody UserRegDTO userRegDTO) {
        System.out.println("userRegDTO = " + userRegDTO);
        return JsonResult.ok();
    }
}
