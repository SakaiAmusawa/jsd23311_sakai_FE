package cn.tedu.baking.pojo.dto;

import lombok.Data;

@Data
public class CommentQueryDTO {
    private Long userId;
    private Long contentId;
}
