package top.sakai.weibo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakai.weibo.pojo.dto.WeiboDTO;
import top.sakai.weibo.response.JsonResult;
import top.sakai.weibo.service.impl.WeiboService;

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
}
