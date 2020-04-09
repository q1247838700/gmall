package com.atguigu.gmall.pms.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.atguigu.gmall.pms.dao.CategoryDao;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.atguigu.gmall.pms.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageVo(page);
    }

    /**
     *获取树和指定等级的方法
     * @param parentCid 父级id
     * @param level 当前节点id
     * @return 返回category的list集合
     */
    @Override
    public List<CategoryEntity> getCategoryTree(Long parentCid, Integer level) {
        //1.判断parentCid是否为0
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        if (parentCid!=null){
            wrapper.eq("parent_cid", parentCid);
        }
        //2.判断当前level有没有,有了就加上
        if (level!=0){
            wrapper.eq("cat_level", level);
        }
        List<CategoryEntity> list = baseMapper.selectList(wrapper);
        return list;
    }

}