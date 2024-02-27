package cn.tedu.baking.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ContentManagementVO {
    private Integer id;
    private String title;
    private String brief;
    private Integer type;
    private String categoryName;
    private Integer viewCount;
    private Integer commentCount;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
