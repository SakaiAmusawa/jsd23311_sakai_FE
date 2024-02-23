package top.sakai.weibo.service;

import top.sakai.weibo.pojo.dto.CommentDTO;
import top.sakai.weibo.response.JsonResult;

public interface ICommentService {
    public void insertComment(CommentDTO commentDTO);
}
