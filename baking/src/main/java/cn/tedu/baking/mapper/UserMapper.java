package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void insertUser(User user);

    UserVO selectByUsername(String username);

    void update(User userUpdateDTO);
}
