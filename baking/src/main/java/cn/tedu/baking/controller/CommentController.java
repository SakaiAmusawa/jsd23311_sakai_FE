package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.CommentDTO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {
    private ICommentService commentService;

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("add-new")
    public JsonResult addNewComment(CommentDTO commentDTO) {
        commentService.insertComment(commentDTO);
        return JsonResult.ok();
    }
}
