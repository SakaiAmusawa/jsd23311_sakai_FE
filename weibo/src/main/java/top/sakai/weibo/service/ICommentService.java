package top.sakai.weibo.service;

import top.sakai.weibo.pojo.dto.CommentDTO;
import top.sakai.weibo.pojo.vo.CommentVO;

import java.util.List;

public interface ICommentService {
    public void insertComment(CommentDTO commentDTO);

    List<CommentVO> selectListByWeiboId(Integer id);
}
