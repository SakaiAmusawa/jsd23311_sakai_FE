package top.sakai.weibo.mapper;

import org.springframework.stereotype.Repository;
import top.sakai.weibo.pojo.entity.Comment;

@Repository
public interface CommentMapper {
    void insertComment(Comment comment);
}
