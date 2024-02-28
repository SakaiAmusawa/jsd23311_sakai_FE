package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.dto.ContentIndexDTO;
import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.ContentIndexVO;
import cn.tedu.baking.pojo.vo.ContentManagementVO;
import cn.tedu.baking.pojo.vo.ContentUpdateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentService implements IContentService {
    @Autowired
    ContentMapper contentMapper;

    //重构新建方法
    @Override
    public void insert(ContentDTO contentDTO) {
        Content content = new Content();
        BeanUtils.copyProperties(contentDTO, content);
        if (contentDTO.getId() == null) {//没有ID 为新增
            content.setCreateTime(new Date());
            contentMapper.insert(content);
        } else {//有ID 为修改
            content.setUpdateTime(new Date());
            contentMapper.updateById(contentDTO);
        }
    }

    @Override
    public List<ContentManagementVO> listForManagement(ContentManagementQueryDTO contentManagementQueryDTO) {
        List<ContentManagementVO> list = contentMapper.selectForManagement(contentManagementQueryDTO);
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        contentMapper.deleteById(id);
    }

    @Override
    public ContentUpdateVO selectForUpdateById(Integer id) {
        ContentUpdateVO contentUpdateVO = contentMapper.selectForUpdateById(id);
        return contentUpdateVO;
    }

    @Override
    public List<ContentIndexVO> selectContentByTypeCategoryId(ContentIndexDTO contentIndexDTO) {
        List<ContentIndexVO> list = contentMapper.selectContentByTypeCategoryId(contentIndexDTO);
        System.out.println(list);
        return list;
    }


}
