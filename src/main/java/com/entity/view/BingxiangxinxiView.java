package com.entity.view;

import com.entity.BingxiangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 冰箱信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
@TableName("bingxiangxinxi")
public class BingxiangxinxiView  extends BingxiangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BingxiangxinxiView(){
	}
 
 	public BingxiangxinxiView(BingxiangxinxiEntity bingxiangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, bingxiangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
