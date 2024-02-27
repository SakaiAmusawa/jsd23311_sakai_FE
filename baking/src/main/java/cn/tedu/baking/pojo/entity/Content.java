package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private Long id;
    private String title;
    private String imgUrl;
    private String videoUrl;
    private String content;
    private Integer type;
    private Integer viewCount;
    private Integer commentCount;
    private String brief;
    private Integer categoryId;
    private Integer userId;
    private Integer updateBy;
    private Date createTime;
    private Date updateTime;

}
