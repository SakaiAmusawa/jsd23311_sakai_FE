package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.ContentManagementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentService implements IContentService {
    @Autowired
    ContentMapper contentMapper;

    @Override
    public void insert(ContentDTO contentDTO) {
        Content content = new Content();
        BeanUtils.copyProperties(contentDTO, content);
        content.setCreateTime(new Date());
        contentMapper.insert(content);
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
}
