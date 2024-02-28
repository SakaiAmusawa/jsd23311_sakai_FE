package cn.tedu.baking.pojo.vo;

import lombok.Data;

@Data
public class ContentIndexVO {
    //内容表
    private Integer id;
    private String title;
    private String imgUrl;//封面图片
    //用户名
    private String userImgUrl;
    private String nickname;
    //分类表
    private String categoryName;
}
