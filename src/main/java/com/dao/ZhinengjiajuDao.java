package com.dao;

import com.entity.ZhinengjiajuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhinengjiajuVO;
import com.entity.view.ZhinengjiajuView;


/**
 * 智能家居
 * 
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
public interface ZhinengjiajuDao extends BaseMapper<ZhinengjiajuEntity> {
	
	List<ZhinengjiajuVO> selectListVO(@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);
	
	ZhinengjiajuVO selectVO(@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);
	
	List<ZhinengjiajuView> selectListView(@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);

	List<ZhinengjiajuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);
	
	ZhinengjiajuView selectView(@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);

    List<Map<String, Object>> haopingshuSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);


}
