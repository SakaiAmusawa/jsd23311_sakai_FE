package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.dto.ContentManagementQueryDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.ContentManagementVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentMapper {
    public void insert(Content content);

    List<ContentManagementVO> selectForManagement(ContentManagementQueryDTO contentManagementQueryDTO);

    void deleteById(Integer id);
}
