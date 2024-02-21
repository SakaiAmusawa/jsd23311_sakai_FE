package top.sakai.web.service;

import top.sakai.web.pojo.dto.UserLoginDTO;
import top.sakai.web.pojo.dto.UserRegDTO;

public interface IUserService {
    void reg(UserRegDTO userRegDTO);

    void login(UserLoginDTO userLoginDTO);
}
