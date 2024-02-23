package top.sakai.weibo.mapper;

import org.springframework.stereotype.Repository;
import top.sakai.weibo.pojo.entity.Comment;
import top.sakai.weibo.pojo.vo.CommentVO;

import java.util.List;

@Repository
public interface CommentMapper {
    void insertComment(Comment comment);

    List<CommentVO> selectListByWeiboId(Integer id);
}
