package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusszhinengjiajuEntity;
import com.entity.view.DiscusszhinengjiajuView;

import com.service.DiscusszhinengjiajuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 * 智能家居评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
@RestController
@RequestMapping("/discusszhinengjiaju")
public class DiscusszhinengjiajuController {
    @Autowired
    private DiscusszhinengjiajuService discusszhinengjiajuService;
    @Autowired
    private JavaSparkContext javaSparkContext;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhinengjiajuEntity discusszhinengjiaju,
		HttpServletRequest request){
        EntityWrapper<DiscusszhinengjiajuEntity> ew = new EntityWrapper<DiscusszhinengjiajuEntity>();

		PageUtils page = discusszhinengjiajuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhinengjiaju), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhinengjiajuEntity discusszhinengjiaju, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhinengjiajuEntity> ew = new EntityWrapper<DiscusszhinengjiajuEntity>();

		PageUtils page = discusszhinengjiajuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhinengjiaju), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhinengjiajuEntity discusszhinengjiaju){
       	EntityWrapper<DiscusszhinengjiajuEntity> ew = new EntityWrapper<DiscusszhinengjiajuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhinengjiaju, "discusszhinengjiaju")); 
        return R.ok().put("data", discusszhinengjiajuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhinengjiajuEntity discusszhinengjiaju){
        EntityWrapper< DiscusszhinengjiajuEntity> ew = new EntityWrapper< DiscusszhinengjiajuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhinengjiaju, "discusszhinengjiaju")); 
		DiscusszhinengjiajuView discusszhinengjiajuView =  discusszhinengjiajuService.selectView(ew);
		return R.ok("查询智能家居评论表成功").put("data", discusszhinengjiajuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhinengjiajuEntity discusszhinengjiaju = discusszhinengjiajuService.selectById(id);
        return R.ok().put("data", discusszhinengjiaju);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhinengjiajuEntity discusszhinengjiaju = discusszhinengjiajuService.selectById(id);
        return R.ok().put("data", discusszhinengjiaju);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhinengjiajuEntity discusszhinengjiaju, HttpServletRequest request){
    	discusszhinengjiaju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhinengjiaju);
        discusszhinengjiajuService.insert(discusszhinengjiaju);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhinengjiajuEntity discusszhinengjiaju, HttpServletRequest request){
    	discusszhinengjiaju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhinengjiaju);
        discusszhinengjiajuService.insert(discusszhinengjiaju);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusszhinengjiajuEntity discusszhinengjiaju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhinengjiaju);
        discusszhinengjiajuService.updateById(discusszhinengjiaju);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhinengjiajuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
