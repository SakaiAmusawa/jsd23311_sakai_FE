package cn.tedu.baking.service;

import cn.tedu.baking.pojo.dto.CommentDTO;
import cn.tedu.baking.pojo.dto.CommentQueryDTO;
import cn.tedu.baking.pojo.vo.CommentVO;

import java.util.List;

public interface ICommentService {
    void insertComment(CommentDTO commentDTO);

    List<CommentVO> selectForComment(CommentQueryDTO commentQueryDTO);
}
