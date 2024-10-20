package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbingxiangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbingxiangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbingxiangxinxiView;


/**
 * bingxiangxinxi评论表
 *
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
public interface DiscussbingxiangxinxiService extends IService<DiscussbingxiangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbingxiangxinxiVO> selectListVO(Wrapper<DiscussbingxiangxinxiEntity> wrapper);
   	
   	DiscussbingxiangxinxiVO selectVO(@Param("ew") Wrapper<DiscussbingxiangxinxiEntity> wrapper);
   	
   	List<DiscussbingxiangxinxiView> selectListView(Wrapper<DiscussbingxiangxinxiEntity> wrapper);
   	
   	DiscussbingxiangxinxiView selectView(@Param("ew") Wrapper<DiscussbingxiangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbingxiangxinxiEntity> wrapper);
   	

}

