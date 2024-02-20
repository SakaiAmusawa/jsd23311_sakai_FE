package top.sakai.web.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class WeiboDetailVO {
    @ApiModelProperty(value = "微博的内容")
    private String content;
    /*
       在属性上添加JsonFormat
       参数pattern:（模式）格式如下
       pattern1:yyyy-MM-dd HH:mm:ss
       pattern2:yyyy/MM/dd HH:mm:ss
       pattern3:yyyy年MM月dd日 HH时mm分ss秒

       参数timezone:（时区）格式如下
       timezone1:Asia/Shanghai
       timezone2:GMT+8

       */
    @ApiModelProperty(value = "微博的创建时间")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "Asia/Shanghai")
    private Date created;
    @ApiModelProperty(value = "微博的ID")
    private Integer id;
    @ApiModelProperty(value = "用户的昵称")
    private String nickname;
}
