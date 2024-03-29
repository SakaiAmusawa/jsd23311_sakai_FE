package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.dto.ContentIndexDTO;
import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.vo.*;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/content/")
public class ContentController {

    private IContentService contentService;

    @Autowired
    public void setContentService(IContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("add-new")
    public JsonResult addNew(ContentDTO contentDTO) {
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
        contentService.deleteById(id);
        return JsonResult.ok();
    }

    @GetMapping("{id}/update")
    public JsonResult selectForUpdateById(@PathVariable Integer id) {
        ContentUpdateVO contentUpdateVO = contentService.selectForUpdateById(id);
        return JsonResult.ok(contentUpdateVO);
    }

    @GetMapping("index")
    public JsonResult selectContentInIndex(ContentIndexDTO contentIndexDTO) {
        List<ContentIndexVO> list = contentService.selectContentByTypeCategoryId(contentIndexDTO);
        return JsonResult.ok(list);
    }

    @GetMapping("{id}/detail")
    public JsonResult selectDetailById(@PathVariable Long id) {
        ContentDetailVO contentDetailVO = contentService.selectDetailById(id);
        return JsonResult.ok(contentDetailVO);
    }

    @GetMapping("{userId}/other")
    public JsonResult selectOtherByUserId(@PathVariable Long userId) {
        List<ContentOtherVO> list = contentService.selectOtherByUserId(userId);
        return JsonResult.ok(list);
    }

    @GetMapping("hot")
    public JsonResult selectHot() {
        List<ContentHotVO> list = contentService.selectHot();
        return JsonResult.ok(list);
    }

    @GetMapping("{type}/type")
    public JsonResult showMore(@PathVariable Integer type) {
        List<ContentIndexVO> list = contentService.selectContentByType(type);
        return JsonResult.ok(list);
    }
}
