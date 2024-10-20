package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhinengjiajuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhinengjiajuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhinengjiajuView;


/**
 * 智能家居评论表
 *
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
public interface DiscusszhinengjiajuService extends IService<DiscusszhinengjiajuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhinengjiajuVO> selectListVO(Wrapper<DiscusszhinengjiajuEntity> wrapper);
   	
   	DiscusszhinengjiajuVO selectVO(@Param("ew") Wrapper<DiscusszhinengjiajuEntity> wrapper);
   	
   	List<DiscusszhinengjiajuView> selectListView(Wrapper<DiscusszhinengjiajuEntity> wrapper);
   	
   	DiscusszhinengjiajuView selectView(@Param("ew") Wrapper<DiscusszhinengjiajuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhinengjiajuEntity> wrapper);
   	

}

