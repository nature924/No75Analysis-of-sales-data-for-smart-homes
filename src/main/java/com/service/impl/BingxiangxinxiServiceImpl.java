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


import com.dao.BingxiangxinxiDao;
import com.entity.BingxiangxinxiEntity;
import com.service.BingxiangxinxiService;
import com.entity.vo.BingxiangxinxiVO;
import com.entity.view.BingxiangxinxiView;

@Service("bingxiangxinxiService")
public class BingxiangxinxiServiceImpl extends ServiceImpl<BingxiangxinxiDao, BingxiangxinxiEntity> implements BingxiangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BingxiangxinxiEntity> page = this.selectPage(
                new Query<BingxiangxinxiEntity>(params).getPage(),
                new EntityWrapper<BingxiangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BingxiangxinxiEntity> wrapper) {
		  Page<BingxiangxinxiView> page =new Query<BingxiangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BingxiangxinxiVO> selectListVO(Wrapper<BingxiangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BingxiangxinxiVO selectVO(Wrapper<BingxiangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BingxiangxinxiView> selectListView(Wrapper<BingxiangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BingxiangxinxiView selectView(Wrapper<BingxiangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<BingxiangxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<BingxiangxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<BingxiangxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
