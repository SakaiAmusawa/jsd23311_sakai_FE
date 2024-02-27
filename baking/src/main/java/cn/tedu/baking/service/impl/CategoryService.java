package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.CategoryMapper;
import cn.tedu.baking.pojo.vo.CategoryVO;
import cn.tedu.baking.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> typeList() {
        return categoryMapper.selectForType();
    }

    @Override
    public List<CategoryVO> subList(Integer type) {
        return categoryMapper.selectForSub(type);
    }

}
