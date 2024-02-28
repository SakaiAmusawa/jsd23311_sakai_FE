package cn.tedu.baking.pojo.vo;

import lombok.Data;

@Data
public class ContentUpdateVO {
    private Integer id;
    private String title;
    private String imgUrl;
    private String videoUrl;
    private String content;
    private Integer type;
    private Integer categoryId;
}
