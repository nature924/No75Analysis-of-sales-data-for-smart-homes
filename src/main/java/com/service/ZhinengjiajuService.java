package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhinengjiajuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhinengjiajuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhinengjiajuView;


/**
 * 智能家居
 *
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
public interface ZhinengjiajuService extends IService<ZhinengjiajuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhinengjiajuVO> selectListVO(Wrapper<ZhinengjiajuEntity> wrapper);
   	
   	ZhinengjiajuVO selectVO(@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);
   	
   	List<ZhinengjiajuView> selectListView(Wrapper<ZhinengjiajuEntity> wrapper);
   	
   	ZhinengjiajuView selectView(@Param("ew") Wrapper<ZhinengjiajuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhinengjiajuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZhinengjiajuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZhinengjiajuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZhinengjiajuEntity> wrapper);

    List<Map<String, Object>> haopingshuSectionStat(Map<String, Object> params,Wrapper<ZhinengjiajuEntity> wrapper);


}

