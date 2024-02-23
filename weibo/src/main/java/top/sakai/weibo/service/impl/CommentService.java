package top.sakai.weibo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakai.weibo.mapper.CommentMapper;
import top.sakai.weibo.pojo.dto.CommentDTO;
import top.sakai.weibo.pojo.entity.Comment;
import top.sakai.weibo.pojo.vo.CommentVO;
import top.sakai.weibo.service.ICommentService;

import java.util.Date;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentMapper commentMapper;

    public void insertComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setCreated(new Date());
        commentMapper.insertComment(comment);
    }

    @Override
    public List<CommentVO> selectListByWeiboId(Integer id) {
        List<CommentVO> commentVOS = commentMapper.selectListByWeiboId(id);
        return commentVOS;
    }
}
