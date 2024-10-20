package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussbingxiangxinxiDao;
import com.entity.DiscussbingxiangxinxiEntity;
import com.service.DiscussbingxiangxinxiService;
import com.entity.vo.DiscussbingxiangxinxiVO;
import com.entity.view.DiscussbingxiangxinxiView;

@Service("discussbingxiangxinxiService")
public class DiscussbingxiangxinxiServiceImpl extends ServiceImpl<DiscussbingxiangxinxiDao, DiscussbingxiangxinxiEntity> implements DiscussbingxiangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbingxiangxinxiEntity> page = this.selectPage(
                new Query<DiscussbingxiangxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussbingxiangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbingxiangxinxiEntity> wrapper) {
		  Page<DiscussbingxiangxinxiView> page =new Query<DiscussbingxiangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussbingxiangxinxiVO> selectListVO(Wrapper<DiscussbingxiangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbingxiangxinxiVO selectVO(Wrapper<DiscussbingxiangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbingxiangxinxiView> selectListView(Wrapper<DiscussbingxiangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbingxiangxinxiView selectView(Wrapper<DiscussbingxiangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
