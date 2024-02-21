package top.sakai.weibo.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WeiboIndexVO {
    @ApiModelProperty(value = "微博的内容")
    private String content;
    @ApiModelProperty(value = "微博的ID")
    private Integer id;
    @ApiModelProperty(value = "用户的昵称")
    private String nickname;
}
