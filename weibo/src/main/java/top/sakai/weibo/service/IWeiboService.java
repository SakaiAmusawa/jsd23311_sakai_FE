package top.sakai.weibo.service;

import top.sakai.weibo.pojo.dto.WeiboDTO;
import top.sakai.weibo.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface IWeiboService {
    void post(WeiboDTO weiboDTO);

    List<WeiboIndexVO> listForIndex();

    List<WeiboIndexVO> listForId(Integer userId);

    void deleteByWeiboId(Integer id);
}
