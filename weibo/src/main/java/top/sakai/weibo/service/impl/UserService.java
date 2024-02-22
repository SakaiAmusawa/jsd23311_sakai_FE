package top.sakai.weibo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakai.weibo.exception.ServiceException;
import top.sakai.weibo.mapper.UserMapper;
import top.sakai.weibo.pojo.dto.UserLoginDTO;
import top.sakai.weibo.pojo.dto.UserRegDTO;
import top.sakai.weibo.pojo.entity.User;
import top.sakai.weibo.pojo.vo.UserVO;
import top.sakai.weibo.response.StatusCode;
import top.sakai.weibo.service.IUserService;

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
    public UserVO login(UserLoginDTO userLoginDTO) {
        UserVO userVO = userMapper.selectByUserName(userLoginDTO.getUsername());
        if (userVO == null) {
            throw new ServiceException(StatusCode.USERNAME_ERROR);
        }
        if (!(userVO.getPassword().equals(userLoginDTO.getPassword()))) {
            throw new ServiceException(StatusCode.PASSWORD_ERROR);
        }
        return userVO;
    }
}
