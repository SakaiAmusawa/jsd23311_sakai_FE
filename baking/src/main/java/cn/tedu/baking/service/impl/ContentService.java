package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.dto.ContentIndexDTO;
import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.*;
import cn.tedu.baking.service.IContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentService implements IContentService {

    private ContentMapper contentMapper;

    @Autowired
    public void setContentMapper(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

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

    @Override
    public ContentDetailVO selectDetailById(Long id) {
        ContentDetailVO contentDetailVO = contentMapper.selectDetailById(id);
        contentMapper.updateViewById(id);
        return contentDetailVO;
    }

    @Override
    public List<ContentOtherVO> selectOtherByUserId(Long userId) {
        List<ContentOtherVO> list = contentMapper.selectOtherByUserId(userId);
        return list;
    }

    @Override
    public List<ContentHotVO> selectHot() {
        List<ContentHotVO> list = contentMapper.selectHot();
        return list;
    }


}
