package top.sakai.weibo.service;

import top.sakai.weibo.pojo.dto.UserLoginDTO;
import top.sakai.weibo.pojo.dto.UserRegDTO;

public interface IUserService {
    void reg(UserRegDTO userRegDTO);

    void login(UserLoginDTO userLoginDTO);
}
