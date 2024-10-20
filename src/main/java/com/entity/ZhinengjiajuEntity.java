package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 智能家居
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
@TableName("zhinengjiaju")
public class ZhinengjiajuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhinengjiajuEntity() {
		
	}
	
	public ZhinengjiajuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 商品链接
	 */
					
	private String shangpinlianjie;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：商品链接
	 */
	public void setShangpinlianjie(String shangpinlianjie) {
		this.shangpinlianjie = shangpinlianjie;
	}
	/**
	 * 获取：商品链接
	 */
	public String getShangpinlianjie() {
		return shangpinlianjie;
	}
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
