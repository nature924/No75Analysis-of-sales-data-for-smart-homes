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

import com.entity.DiscussbingxiangxinxiEntity;
import com.entity.view.DiscussbingxiangxinxiView;

import com.service.DiscussbingxiangxinxiService;
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
 * bingxiangxinxi评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-05 15:46:47
 */
@RestController
@RequestMapping("/discussbingxiangxinxi")
public class DiscussbingxiangxinxiController {
    @Autowired
    private DiscussbingxiangxinxiService discussbingxiangxinxiService;
    @Autowired
    private JavaSparkContext javaSparkContext;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussbingxiangxinxiEntity discussbingxiangxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussbingxiangxinxiEntity> ew = new EntityWrapper<DiscussbingxiangxinxiEntity>();

		PageUtils page = discussbingxiangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbingxiangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussbingxiangxinxiEntity discussbingxiangxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussbingxiangxinxiEntity> ew = new EntityWrapper<DiscussbingxiangxinxiEntity>();

		PageUtils page = discussbingxiangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbingxiangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussbingxiangxinxiEntity discussbingxiangxinxi){
       	EntityWrapper<DiscussbingxiangxinxiEntity> ew = new EntityWrapper<DiscussbingxiangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussbingxiangxinxi, "discussbingxiangxinxi")); 
        return R.ok().put("data", discussbingxiangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussbingxiangxinxiEntity discussbingxiangxinxi){
        EntityWrapper< DiscussbingxiangxinxiEntity> ew = new EntityWrapper< DiscussbingxiangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussbingxiangxinxi, "discussbingxiangxinxi")); 
		DiscussbingxiangxinxiView discussbingxiangxinxiView =  discussbingxiangxinxiService.selectView(ew);
		return R.ok("查询bingxiangxinxi评论表成功").put("data", discussbingxiangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussbingxiangxinxiEntity discussbingxiangxinxi = discussbingxiangxinxiService.selectById(id);
        return R.ok().put("data", discussbingxiangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussbingxiangxinxiEntity discussbingxiangxinxi = discussbingxiangxinxiService.selectById(id);
        return R.ok().put("data", discussbingxiangxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussbingxiangxinxiEntity discussbingxiangxinxi, HttpServletRequest request){
    	discussbingxiangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussbingxiangxinxi);
        discussbingxiangxinxiService.insert(discussbingxiangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussbingxiangxinxiEntity discussbingxiangxinxi, HttpServletRequest request){
    	discussbingxiangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussbingxiangxinxi);
        discussbingxiangxinxiService.insert(discussbingxiangxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussbingxiangxinxiEntity discussbingxiangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussbingxiangxinxi);
        discussbingxiangxinxiService.updateById(discussbingxiangxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussbingxiangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
