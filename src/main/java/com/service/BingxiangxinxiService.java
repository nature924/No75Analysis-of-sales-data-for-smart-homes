package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BingxiangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BingxiangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BingxiangxinxiView;


/**
 * 冰箱信息
 *
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
public interface BingxiangxinxiService extends IService<BingxiangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BingxiangxinxiVO> selectListVO(Wrapper<BingxiangxinxiEntity> wrapper);
   	
   	BingxiangxinxiVO selectVO(@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);
   	
   	List<BingxiangxinxiView> selectListView(Wrapper<BingxiangxinxiEntity> wrapper);
   	
   	BingxiangxinxiView selectView(@Param("ew") Wrapper<BingxiangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BingxiangxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<BingxiangxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<BingxiangxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<BingxiangxinxiEntity> wrapper);



}

