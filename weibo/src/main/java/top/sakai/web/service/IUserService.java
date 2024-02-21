package top.sakai.web.service;

import org.springframework.stereotype.Service;
import top.sakai.web.pojo.dto.UserLoginDTO;
import top.sakai.web.pojo.dto.UserRegDTO;

public interface IUserService {
    void reg(UserRegDTO userRegDTO);

    void login(UserLoginDTO userLoginDTO);
}
