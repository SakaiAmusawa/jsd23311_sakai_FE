package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.ContentManagementVO;
import cn.tedu.baking.pojo.vo.ContentUpdateVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.impl.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("management")
    public JsonResult listForManagement(ContentManagementQueryDTO contentManagementQueryDTO) {
        List<ContentManagementVO> list = contentService.listForManagement(contentManagementQueryDTO);
        return JsonResult.ok(list);
    }

    @PostMapping("{id}/delete")
    public JsonResult deleteContent(@PathVariable Integer id) {
        System.out.println("id = " + id);
        contentService.deleteById(id);
        return JsonResult.ok();
    }

    @GetMapping("{id}/update")
    public JsonResult selectForUpdateById(@PathVariable Integer id){
        ContentUpdateVO contentUpdateVO = contentService.selectForUpdateById(id);
        return JsonResult.ok(contentUpdateVO);
    }
}
