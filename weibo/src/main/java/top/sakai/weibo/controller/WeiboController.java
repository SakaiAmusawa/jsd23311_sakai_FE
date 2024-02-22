package top.sakai.weibo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakai.weibo.pojo.dto.WeiboDTO;
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
        System.out.println("weiboDTO = " + weiboDTO);
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
        System.out.println("UserId = " + userId);
        List<WeiboIndexVO> list = weiboService.listForId(userId);
        return JsonResult.ok(list);
    }
}
