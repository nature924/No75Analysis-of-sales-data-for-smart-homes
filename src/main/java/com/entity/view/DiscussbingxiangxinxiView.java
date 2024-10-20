package com.entity.view;

import com.entity.DiscussbingxiangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * bingxiangxinxi评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
@TableName("discussbingxiangxinxi")
public class DiscussbingxiangxinxiView  extends DiscussbingxiangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussbingxiangxinxiView(){
	}
 
 	public DiscussbingxiangxinxiView(DiscussbingxiangxinxiEntity discussbingxiangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussbingxiangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
