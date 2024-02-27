package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.entity.Content;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}