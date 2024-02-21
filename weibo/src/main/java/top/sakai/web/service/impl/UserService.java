package top.sakai.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.sakai.web.mapper.UserMapper;
import top.sakai.web.pojo.dto.UserLoginDTO;
import top.sakai.web.pojo.dto.UserRegDTO;
import top.sakai.web.service.IUserService;

public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void reg(UserRegDTO userRegDTO) {

    }

    @Override
    public void login(UserLoginDTO userLoginDTO) {

    }
}
