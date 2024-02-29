package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.BannerMapper;
import cn.tedu.baking.pojo.vo.BannerIndexVO;
import cn.tedu.baking.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService implements IBannerService {
    private final BannerMapper bannerMapper;

    @Autowired
    public BannerService(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    @Override
    public List<BannerIndexVO> listForIndex() {
        return bannerMapper.listForIndex();
    }
}
