package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.vo.CategoryVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories/")
public class CategoryController {

    private ICategoryService categoryService;

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("type")
    public JsonResult typeList() {
        List<CategoryVO> list = categoryService.typeList();
        return JsonResult.ok(list);
    }

    @GetMapping("{type}/sub")
    public JsonResult subList(@PathVariable Integer type) {
        List<CategoryVO> list = categoryService.subList(type);
        return JsonResult.ok(list);
    }
}
