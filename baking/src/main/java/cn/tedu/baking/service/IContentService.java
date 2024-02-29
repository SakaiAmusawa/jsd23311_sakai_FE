package cn.tedu.baking.service;

import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.dto.ContentIndexDTO;
import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.ContentDetailVO;
import cn.tedu.baking.pojo.vo.ContentIndexVO;
import cn.tedu.baking.pojo.vo.ContentManagementVO;
import cn.tedu.baking.pojo.vo.ContentUpdateVO;

import java.util.List;

public interface IContentService {
    void insert(ContentDTO contentDTO);

    List<ContentManagementVO> listForManagement(ContentManagementQueryDTO contentManagementQueryDTO);

    void deleteById(Integer id);

    ContentUpdateVO selectForUpdateById(Integer id);

    List<ContentIndexVO> selectContentByTypeCategoryId(ContentIndexDTO contentIndexDTO);

    ContentDetailVO selectDetailById(Long id);
}
