package com.dao;

import com.entity.DiscussbingxiangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbingxiangxinxiVO;
import com.entity.view.DiscussbingxiangxinxiView;


/**
 * bingxiangxinxi评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
public interface DiscussbingxiangxinxiDao extends BaseMapper<DiscussbingxiangxinxiEntity> {
	
	List<DiscussbingxiangxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussbingxiangxinxiEntity> wrapper);
	
	DiscussbingxiangxinxiVO selectVO(@Param("ew") Wrapper<DiscussbingxiangxinxiEntity> wrapper);
	
	List<DiscussbingxiangxinxiView> selectListView(@Param("ew") Wrapper<DiscussbingxiangxinxiEntity> wrapper);

	List<DiscussbingxiangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbingxiangxinxiEntity> wrapper);
	
	DiscussbingxiangxinxiView selectView(@Param("ew") Wrapper<DiscussbingxiangxinxiEntity> wrapper);
	

}
