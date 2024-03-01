package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.CommentMapper;
import cn.tedu.baking.pojo.dto.CommentDTO;
import cn.tedu.baking.pojo.entity.Comment;
import cn.tedu.baking.service.ICommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService implements ICommentService {

    private CommentMapper commentMapper;

    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public void insertComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setCreateTime(new Date());
        System.out.println(comment);
        commentMapper.insertComment(comment);

    }
}
