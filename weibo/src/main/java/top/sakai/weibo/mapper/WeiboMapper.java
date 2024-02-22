package top.sakai.weibo.mapper;

import org.springframework.stereotype.Repository;
import top.sakai.weibo.pojo.entity.Weibo;

@Repository
public interface WeiboMapper {
    int post(Weibo weibo);
}
