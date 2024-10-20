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


import com.dao.ZhinengjiajuDao;
import com.entity.ZhinengjiajuEntity;
import com.service.ZhinengjiajuService;
import com.entity.vo.ZhinengjiajuVO;
import com.entity.view.ZhinengjiajuView;

@Service("zhinengjiajuService")
public class ZhinengjiajuServiceImpl extends ServiceImpl<ZhinengjiajuDao, ZhinengjiajuEntity> implements ZhinengjiajuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhinengjiajuEntity> page = this.selectPage(
                new Query<ZhinengjiajuEntity>(params).getPage(),
                new EntityWrapper<ZhinengjiajuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhinengjiajuEntity> wrapper) {
		  Page<ZhinengjiajuView> page =new Query<ZhinengjiajuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhinengjiajuVO> selectListVO(Wrapper<ZhinengjiajuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhinengjiajuVO selectVO(Wrapper<ZhinengjiajuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhinengjiajuView> selectListView(Wrapper<ZhinengjiajuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhinengjiajuView selectView(Wrapper<ZhinengjiajuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ZhinengjiajuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ZhinengjiajuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ZhinengjiajuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> haopingshuSectionStat(Map<String, Object> params, Wrapper<ZhinengjiajuEntity> wrapper) {
        return baseMapper.haopingshuSectionStat(params, wrapper);
    }



}
