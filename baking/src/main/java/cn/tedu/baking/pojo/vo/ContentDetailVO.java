package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ContentDetailVO {
    private Long id;
    private String title;
    private String brief;
    private String content;
    private String nickname;
    private String userImgUrl;
    private Date createTime;
    private Integer viewCount;
    private Long userId;
    private Integer type;
    private String videoUrl;
}
