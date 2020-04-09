package com.atguigu.gmall.pms.dao;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author lyg
 * @email 1247838700@qq.com
 * @date 2020-04-09 15:31:51
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
