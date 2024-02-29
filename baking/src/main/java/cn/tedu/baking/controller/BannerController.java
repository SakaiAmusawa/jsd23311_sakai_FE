package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.vo.BannerIndexVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/banner/")
public class BannerController {
    private final IBannerService bannerService;

    @Autowired
    public BannerController(IBannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("index")
    public JsonResult listForIndex() {
        List<BannerIndexVO> list = bannerService.listForIndex();
        System.out.println("list:" + list);
        return JsonResult.ok(list);
    }
}
