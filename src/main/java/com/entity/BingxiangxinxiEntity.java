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
 * 冰箱信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
@TableName("bingxiangxinxi")
public class BingxiangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BingxiangxinxiEntity() {
		
	}
	
	public BingxiangxinxiEntity(T t) {
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
	 * 来源
	 */
					
	private String laiyuan;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 价格
	 */
					
	private Float jiage;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 商品名称
	 */
					
	private String spmc;
	
	/**
	 * 商品产地
	 */
					
	private String spcd;
	
	/**
	 * 能效等级
	 */
					
	private String nxdj;
	
	/**
	 * 门款式
	 */
					
	private String mks;
	
	/**
	 * 制冷方式
	 */
					
	private String zlfs;
	
	/**
	 * 主色系
	 */
					
	private String zhusexi;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
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
	 * 设置：来源
	 */
	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}
	/**
	 * 获取：来源
	 */
	public String getLaiyuan() {
		return laiyuan;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：价格
	 */
	public void setJiage(Float jiage) {
		this.jiage = jiage;
	}
	/**
	 * 获取：价格
	 */
	public Float getJiage() {
		return jiage;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：商品名称
	 */
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	/**
	 * 获取：商品名称
	 */
	public String getSpmc() {
		return spmc;
	}
	/**
	 * 设置：商品产地
	 */
	public void setSpcd(String spcd) {
		this.spcd = spcd;
	}
	/**
	 * 获取：商品产地
	 */
	public String getSpcd() {
		return spcd;
	}
	/**
	 * 设置：能效等级
	 */
	public void setNxdj(String nxdj) {
		this.nxdj = nxdj;
	}
	/**
	 * 获取：能效等级
	 */
	public String getNxdj() {
		return nxdj;
	}
	/**
	 * 设置：门款式
	 */
	public void setMks(String mks) {
		this.mks = mks;
	}
	/**
	 * 获取：门款式
	 */
	public String getMks() {
		return mks;
	}
	/**
	 * 设置：制冷方式
	 */
	public void setZlfs(String zlfs) {
		this.zlfs = zlfs;
	}
	/**
	 * 获取：制冷方式
	 */
	public String getZlfs() {
		return zlfs;
	}
	/**
	 * 设置：主色系
	 */
	public void setZhusexi(String zhusexi) {
		this.zhusexi = zhusexi;
	}
	/**
	 * 获取：主色系
	 */
	public String getZhusexi() {
		return zhusexi;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
