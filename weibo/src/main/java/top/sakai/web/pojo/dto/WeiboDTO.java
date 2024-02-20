package top.sakai.web.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WeiboDTO {
    @ApiModelProperty(value = "微博的内容", required = true)
    private String content;

}
