package com.entity.view;

import com.entity.DiscusszhinengjiajuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 智能家居评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
@TableName("discusszhinengjiaju")
public class DiscusszhinengjiajuView  extends DiscusszhinengjiajuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhinengjiajuView(){
	}
 
 	public DiscusszhinengjiajuView(DiscusszhinengjiajuEntity discusszhinengjiajuEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhinengjiajuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
