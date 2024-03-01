package top.sakai.weibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sakai.weibo.pojo.dto.CommentDTO;
import top.sakai.weibo.pojo.vo.CommentVO;
import top.sakai.weibo.response.JsonResult;
import top.sakai.weibo.service.impl.CommentService;

import java.util.List;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("add-new")
    public JsonResult addNew(CommentDTO commentDTO) {
        commentService.insertComment(commentDTO);
        return JsonResult.ok();
    }

    @GetMapping("{id}")
    public JsonResult ListByWeiboId(@PathVariable Integer id) {
        List<CommentVO> list = commentService.selectListByWeiboId(id);
        return JsonResult.ok(list);
    }
}
