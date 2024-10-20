package com.entity.model;

import com.entity.ZhinengjiajuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 智能家居
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
public class ZhinengjiajuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品价格
	 */
	
	private Integer shangpinjiage;
		
	/**
	 * 商品图片
	 */
	
	private String shangpintupian;
		
	/**
	 * 商品类型
	 */
	
	private String shangpinleixing;
		
	/**
	 * 商品品牌
	 */
	
	private String shangpinpinpai;
		
	/**
	 * 好评数
	 */
	
	private Integer haopingshu;
		
	/**
	 * 差评数
	 */
	
	private Integer chapingshu;
		
	/**
	 * 总评论数
	 */
	
	private Integer zongpinglunshu;
				
	
	/**
	 * 设置：商品价格
	 */
	 
	public void setShangpinjiage(Integer shangpinjiage) {
		this.shangpinjiage = shangpinjiage;
	}
	
	/**
	 * 获取：商品价格
	 */
	public Integer getShangpinjiage() {
		return shangpinjiage;
	}
				
	
	/**
	 * 设置：商品图片
	 */
	 
	public void setShangpintupian(String shangpintupian) {
		this.shangpintupian = shangpintupian;
	}
	
	/**
	 * 获取：商品图片
	 */
	public String getShangpintupian() {
		return shangpintupian;
	}
				
	
	/**
	 * 设置：商品类型
	 */
	 
	public void setShangpinleixing(String shangpinleixing) {
		this.shangpinleixing = shangpinleixing;
	}
	
	/**
	 * 获取：商品类型
	 */
	public String getShangpinleixing() {
		return shangpinleixing;
	}
				
	
	/**
	 * 设置：商品品牌
	 */
	 
	public void setShangpinpinpai(String shangpinpinpai) {
		this.shangpinpinpai = shangpinpinpai;
	}
	
	/**
	 * 获取：商品品牌
	 */
	public String getShangpinpinpai() {
		return shangpinpinpai;
	}
				
	
	/**
	 * 设置：好评数
	 */
	 
	public void setHaopingshu(Integer haopingshu) {
		this.haopingshu = haopingshu;
	}
	
	/**
	 * 获取：好评数
	 */
	public Integer getHaopingshu() {
		return haopingshu;
	}
				
	
	/**
	 * 设置：差评数
	 */
	 
	public void setChapingshu(Integer chapingshu) {
		this.chapingshu = chapingshu;
	}
	
	/**
	 * 获取：差评数
	 */
	public Integer getChapingshu() {
		return chapingshu;
	}
				
	
	/**
	 * 设置：总评论数
	 */
	 
	public void setZongpinglunshu(Integer zongpinglunshu) {
		this.zongpinglunshu = zongpinglunshu;
	}
	
	/**
	 * 获取：总评论数
	 */
	public Integer getZongpinglunshu() {
		return zongpinglunshu;
	}
			
}
