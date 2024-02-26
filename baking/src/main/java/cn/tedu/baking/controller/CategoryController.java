package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.vo.CategoryVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories/")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("type")
    public JsonResult typeList() {
        List<CategoryVO> list = categoryService.typeList();
        return JsonResult.ok(list);
    }

}
