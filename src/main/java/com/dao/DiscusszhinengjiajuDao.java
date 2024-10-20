package com.dao;

import com.entity.DiscusszhinengjiajuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhinengjiajuVO;
import com.entity.view.DiscusszhinengjiajuView;


/**
 * 智能家居评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
public interface DiscusszhinengjiajuDao extends BaseMapper<DiscusszhinengjiajuEntity> {
	
	List<DiscusszhinengjiajuVO> selectListVO(@Param("ew") Wrapper<DiscusszhinengjiajuEntity> wrapper);
	
	DiscusszhinengjiajuVO selectVO(@Param("ew") Wrapper<DiscusszhinengjiajuEntity> wrapper);
	
	List<DiscusszhinengjiajuView> selectListView(@Param("ew") Wrapper<DiscusszhinengjiajuEntity> wrapper);

	List<DiscusszhinengjiajuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhinengjiajuEntity> wrapper);
	
	DiscusszhinengjiajuView selectView(@Param("ew") Wrapper<DiscusszhinengjiajuEntity> wrapper);
	

}
