package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.vo.BannerIndexVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    List<BannerIndexVO> listForIndex();
}
