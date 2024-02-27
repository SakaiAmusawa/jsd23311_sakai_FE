package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.impl.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/content/")
public class ContentController {

    @Autowired
    ContentService contentService;

    @PostMapping("add-new")
    public JsonResult addNew(ContentDTO contentDTO) {
        System.out.println("contentDTO = " + contentDTO);
        contentService.insert(contentDTO);
        return JsonResult.ok();
    }

}
