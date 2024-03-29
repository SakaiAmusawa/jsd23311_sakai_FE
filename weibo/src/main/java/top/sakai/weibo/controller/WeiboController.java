package top.sakai.weibo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sakai.weibo.pojo.dto.WeiboDTO;
import top.sakai.weibo.pojo.vo.WeiboDetailVO;
import top.sakai.weibo.pojo.vo.WeiboIndexVO;
import top.sakai.weibo.response.JsonResult;
import top.sakai.weibo.service.impl.WeiboService;

import java.util.List;

@RestController
@RequestMapping("/v1/weibo")
public class WeiboController {
    @Autowired
    WeiboService weiboService;

    @PostMapping("post")
    public JsonResult post(WeiboDTO weiboDTO) {
        weiboService.post(weiboDTO);
        return JsonResult.ok();
    }

    @GetMapping("list")
    public JsonResult listForIndex() {
        List<WeiboIndexVO> list = weiboService.listForIndex();
        return JsonResult.ok(list);
    }

    @GetMapping("")
    public JsonResult personalWeibo(Integer userId) {
        List<WeiboIndexVO> list = weiboService.listForId(userId);
        return JsonResult.ok(list);
    }

    @PostMapping("{id}/delete")
    public JsonResult deleteWeibo(@PathVariable Integer id) {
        weiboService.deleteByWeiboId(id);
        return JsonResult.ok();
    }

    @GetMapping("{id}/detail")
    public JsonResult weiboDetail(@PathVariable Integer id) {

        WeiboDetailVO weiboDetailVO = weiboService.selectWeiboDetail(id);
        return JsonResult.ok(weiboDetailVO);
    }
}
