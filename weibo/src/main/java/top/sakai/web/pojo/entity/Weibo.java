package top.sakai.web.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Weibo {
    private Integer id;
    private String content;
    private Date created;
    private Integer userId;

}
