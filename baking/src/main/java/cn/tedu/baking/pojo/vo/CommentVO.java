package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private Long id;
    private String userImgUrl;
    private String nickname;
    private String content;
    private Date createTime;
}
