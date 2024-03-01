package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.CommentDTO;
import cn.tedu.baking.pojo.dto.CommentQueryDTO;
import cn.tedu.baking.pojo.vo.CommentVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {
    private final ICommentService commentService;

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("add-new")
    public JsonResult addNewComment(CommentDTO commentDTO) {
        commentService.insertComment(commentDTO);
        return JsonResult.ok();
    }

    @GetMapping("list")
    public JsonResult showComment(CommentQueryDTO commentQueryDTO) {
        List<CommentVO> list = commentService.selectForComment(commentQueryDTO);
        return JsonResult.ok(list);
    }
}
