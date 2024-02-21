package top.sakai.web.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakai.web.mapper.UserMapper;
import top.sakai.web.pojo.dto.UserLoginDTO;
import top.sakai.web.pojo.dto.UserRegDTO;
import top.sakai.web.pojo.entity.User;
import top.sakai.web.pojo.vo.UserVO;
import top.sakai.web.response.StatusCode;
import top.sakai.web.service.IUserService;

import java.util.Date;

@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void reg(UserRegDTO userRegDTO) {
        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        if (userVO != null) {
            throw new ServiceException(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegDTO, user);
        user.setCreated(new Date());
        userMapper.insert(user);
    }

    @Override
    public void login(UserLoginDTO userLoginDTO) {

    }
}
