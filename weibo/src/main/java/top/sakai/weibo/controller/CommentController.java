package top.sakai.weibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakai.weibo.pojo.dto.CommentDTO;
import top.sakai.weibo.response.JsonResult;
import top.sakai.weibo.service.impl.CommentService;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("add-new")
    public JsonResult addNew(CommentDTO commentDTO) {
        //System.out.println("commentDTO = " + commentDTO);
        commentService.insertComment(commentDTO);
        return JsonResult.ok();
    }
}
