package top.sakai.weibo.service;

import top.sakai.weibo.pojo.dto.UserLoginDTO;
import top.sakai.weibo.pojo.dto.UserRegDTO;
import top.sakai.weibo.pojo.vo.UserVO;

public interface IUserService {
    void reg(UserRegDTO userRegDTO);

    UserVO login(UserLoginDTO userLoginDTO);
}
