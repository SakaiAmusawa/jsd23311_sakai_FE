package cn.tedu.baking.pojo.dto;

import lombok.Data;

@Data
public class ContentDTO {
    private String brief;
    private Integer categoryId;
    private String content;
    private String imgUrl;
    private String videoUrl;
    private String title;
    private Integer type;
    private Integer updateBy;
    private Integer userId;
}
