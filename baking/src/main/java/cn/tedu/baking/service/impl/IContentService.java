package cn.tedu.baking.service.impl;

import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.vo.ContentManagementVO;

import java.util.List;

public interface IContentService {
    void insert(ContentDTO contentDTO);

    List<ContentManagementVO> listForManagement(ContentManagementQueryDTO contentManagementQueryDTO);
}
