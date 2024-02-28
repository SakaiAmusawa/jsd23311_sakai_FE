package cn.tedu.baking.pojo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ContentDTO {
    //如果想复用新增为修改，需要传入id.
    private Integer id;
    private String brief;
    private Integer categoryId;
    private String content;
    private String imgUrl;
    private String videoUrl;
    private String title;
    private Integer type;
    private Integer updateBy;
    private Date updateTime;
    private Integer userId;
}
