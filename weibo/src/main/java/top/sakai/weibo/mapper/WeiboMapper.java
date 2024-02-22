package top.sakai.weibo.mapper;

import org.springframework.stereotype.Repository;
import top.sakai.weibo.pojo.entity.Weibo;
import top.sakai.weibo.pojo.vo.WeiboIndexVO;

import java.util.List;

@Repository
public interface WeiboMapper {
    int post(Weibo weibo);

    List<WeiboIndexVO> selectForIndex();

    List<WeiboIndexVO> selectForId(Integer userId);
}
