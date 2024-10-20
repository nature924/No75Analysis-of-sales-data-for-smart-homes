package com.dao;

import com.entity.BingxiangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BingxiangxinxiVO;
import com.entity.view.BingxiangxinxiView;


/**
 * 冰箱信息
 * 
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
public interface BingxiangxinxiDao extends BaseMapper<BingxiangxinxiEntity> {
	
	List<BingxiangxinxiVO> selectListVO(@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);
	
	BingxiangxinxiVO selectVO(@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);
	
	List<BingxiangxinxiView> selectListView(@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);

	List<BingxiangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);
	
	BingxiangxinxiView selectView(@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);



}
