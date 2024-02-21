package top.sakai.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakai.web.mapper.UserMapper;
import top.sakai.web.pojo.dto.UserRegDTO;
import top.sakai.web.pojo.entity.User;
import top.sakai.web.pojo.vo.UserVO;
import top.sakai.web.response.JsonResult;
import top.sakai.web.response.StatusCode;

import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/reg")
    public JsonResult reg(@RequestBody UserRegDTO userRegDTO) {
        System.out.println("userRegDTO = " + userRegDTO);
        //根据用户名查询用户
        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        //如果不为空说明该用户已存在
        if (userVO != null) {
            return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        //如果为空，则可以注册新用户
        User user = new User();
        BeanUtils.copyProperties(userRegDTO, user);
        user.setCreated(new Date());
        userMapper.insert(user);

        return JsonResult.ok();
    }
}
