package top.sakai.web.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data

public class CommentVO {
    @ApiModelProperty(value = "评论的内容")
    private String content;
    @ApiModelProperty(value = "评论的时间")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
    @ApiModelProperty(value = "评论的编号")
    private Integer id;
    @ApiModelProperty("用户的昵称")
    private String nickname;

}
