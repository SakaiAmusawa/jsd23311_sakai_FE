package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.dto.CommentQueryDTO;
import cn.tedu.baking.pojo.entity.Comment;
import cn.tedu.baking.pojo.vo.CommentVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    void insertComment(Comment comment);

    List<CommentVO> selectForComment(CommentQueryDTO commentQueryDTO);
}
