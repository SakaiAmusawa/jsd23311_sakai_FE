package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.CommentMapper;
import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.pojo.dto.CommentDTO;
import cn.tedu.baking.pojo.dto.CommentQueryDTO;
import cn.tedu.baking.pojo.entity.Comment;
import cn.tedu.baking.pojo.vo.CommentVO;
import cn.tedu.baking.service.ICommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    private CommentMapper commentMapper;
    private ContentMapper contentMapper;

    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Autowired
    public void setContentMapper(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    @Override
    public void insertComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setCreateTime(new Date());
        commentMapper.insertComment(comment);
        //没新增一条评论，该文章的评论量+1
        contentMapper.updateCommentCountById(comment.getContentId());

    }

    @Override
    public List<CommentVO> selectForComment(CommentQueryDTO commentQueryDTO) {
        List<CommentVO> list = commentMapper.selectForComment(commentQueryDTO);
        return list;
    }
}
