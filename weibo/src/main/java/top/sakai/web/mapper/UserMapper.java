package top.sakai.web.mapper;

import org.springframework.stereotype.Repository;
import top.sakai.web.pojo.entity.User;
import top.sakai.web.pojo.vo.UserVO;

@Repository //表明这是一个持久层的接口
public interface UserMapper {
    UserVO selectByUserName(String username);//定义查询方法

    int insert(User user);//定义插入方法
}
