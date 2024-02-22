package top.sakai.weibo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakai.weibo.exception.ServiceException;
import top.sakai.weibo.mapper.WeiboMapper;
import top.sakai.weibo.pojo.dto.WeiboDTO;
import top.sakai.weibo.pojo.entity.Weibo;
import top.sakai.weibo.pojo.vo.WeiboDetailVO;
import top.sakai.weibo.pojo.vo.WeiboIndexVO;
import top.sakai.weibo.response.StatusCode;
import top.sakai.weibo.service.IWeiboService;

import java.util.Date;
import java.util.List;

@Service
public class WeiboService implements IWeiboService {
    @Autowired
    WeiboMapper weiboMapper;

    @Override
    public void post(WeiboDTO weiboDTO) {
        Weibo weibo = new Weibo();
        BeanUtils.copyProperties(weiboDTO, weibo);
        weibo.setCreated(new Date());
        int rows = weiboMapper.post(weibo);
        if (rows == 0) {
            throw new ServiceException(StatusCode.OPERATION_FAILED);
        }
    }

    @Override
    public List<WeiboIndexVO> listForIndex() {
        List<WeiboIndexVO> list = weiboMapper.selectForIndex();
        return list;

    }

    @Override
    public List<WeiboIndexVO> listForId(Integer userId) {
        List<WeiboIndexVO> list = weiboMapper.selectForId(userId);
        return list;
    }

    @Override
    public void deleteByWeiboId(Integer id) {
        weiboMapper.deleteByWeiboId(id);
    }

    @Override
    public WeiboDetailVO selectWeiboDetail(Integer id) {
        WeiboDetailVO weiboDetailVO=weiboMapper.selectWeiboDetail(id);
        return weiboDetailVO;
    }
}
