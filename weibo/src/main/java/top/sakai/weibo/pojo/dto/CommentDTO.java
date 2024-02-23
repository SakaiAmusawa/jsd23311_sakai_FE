package top.sakai.weibo.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentDTO {
    @ApiModelProperty(value = "评论的内容", required = true)
    private String content;
    @ApiModelProperty(value = "微博的ID", required = true)
    private Integer weiboId;

    private Integer userId;

}
