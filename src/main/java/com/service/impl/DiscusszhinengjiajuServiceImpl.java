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


import com.dao.DiscusszhinengjiajuDao;
import com.entity.DiscusszhinengjiajuEntity;
import com.service.DiscusszhinengjiajuService;
import com.entity.vo.DiscusszhinengjiajuVO;
import com.entity.view.DiscusszhinengjiajuView;

@Service("discusszhinengjiajuService")
public class DiscusszhinengjiajuServiceImpl extends ServiceImpl<DiscusszhinengjiajuDao, DiscusszhinengjiajuEntity> implements DiscusszhinengjiajuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhinengjiajuEntity> page = this.selectPage(
                new Query<DiscusszhinengjiajuEntity>(params).getPage(),
                new EntityWrapper<DiscusszhinengjiajuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhinengjiajuEntity> wrapper) {
		  Page<DiscusszhinengjiajuView> page =new Query<DiscusszhinengjiajuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhinengjiajuVO> selectListVO(Wrapper<DiscusszhinengjiajuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhinengjiajuVO selectVO(Wrapper<DiscusszhinengjiajuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhinengjiajuView> selectListView(Wrapper<DiscusszhinengjiajuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhinengjiajuView selectView(Wrapper<DiscusszhinengjiajuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
