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

import com.entity.ZhinengjiajuEntity;
import com.entity.view.ZhinengjiajuView;

import com.service.ZhinengjiajuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.service.StoreupService;
import com.entity.StoreupEntity;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 * 智能家居
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-05 15:46:46
 */
@RestController
@RequestMapping("/zhinengjiaju")
public class ZhinengjiajuController {
    @Autowired
    private ZhinengjiajuService zhinengjiajuService;
    @Autowired
    private JavaSparkContext javaSparkContext;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhinengjiajuEntity zhinengjiaju,
		HttpServletRequest request){
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();

		PageUtils page = zhinengjiajuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhinengjiaju), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhinengjiajuEntity zhinengjiaju, 
		HttpServletRequest request){
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();

		PageUtils page = zhinengjiajuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhinengjiaju), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhinengjiajuEntity zhinengjiaju){
       	EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhinengjiaju, "zhinengjiaju")); 
        return R.ok().put("data", zhinengjiajuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhinengjiajuEntity zhinengjiaju){
        EntityWrapper< ZhinengjiajuEntity> ew = new EntityWrapper< ZhinengjiajuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhinengjiaju, "zhinengjiaju")); 
		ZhinengjiajuView zhinengjiajuView =  zhinengjiajuService.selectView(ew);
		return R.ok("查询智能家居成功").put("data", zhinengjiajuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhinengjiajuEntity zhinengjiaju = zhinengjiajuService.selectById(id);
        return R.ok().put("data", zhinengjiaju);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhinengjiajuEntity zhinengjiaju = zhinengjiajuService.selectById(id);
        return R.ok().put("data", zhinengjiaju);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhinengjiajuEntity zhinengjiaju, HttpServletRequest request){
    	zhinengjiaju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhinengjiaju);
        zhinengjiajuService.insert(zhinengjiaju);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhinengjiajuEntity zhinengjiaju, HttpServletRequest request){
    	zhinengjiaju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhinengjiaju);
        zhinengjiajuService.insert(zhinengjiaju);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhinengjiajuEntity zhinengjiaju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhinengjiaju);
        zhinengjiajuService.updateById(zhinengjiaju);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhinengjiajuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    ZhinengjiajuEntity zhinengjiajuEntity =new ZhinengjiajuEntity();
                    zhinengjiajuEntity.setId(new Date().getTime());
                    String shangpinlianjie = CommonUtil.getCellValue(row.getCell(0));
                    zhinengjiajuEntity.setShangpinlianjie(shangpinlianjie);
                    String shangpinjiage = CommonUtil.getCellValue(row.getCell(1));
                    zhinengjiajuEntity.setShangpinjiage(Integer.parseInt(shangpinjiage));
                    String shangpinleixing = CommonUtil.getCellValue(row.getCell(2));
                    zhinengjiajuEntity.setShangpinleixing(shangpinleixing);
                    String shangpinpinpai = CommonUtil.getCellValue(row.getCell(3));
                    zhinengjiajuEntity.setShangpinpinpai(shangpinpinpai);
                    String haopingshu = CommonUtil.getCellValue(row.getCell(4));
                    zhinengjiajuEntity.setHaopingshu(Integer.parseInt(haopingshu));
                    String chapingshu = CommonUtil.getCellValue(row.getCell(5));
                    zhinengjiajuEntity.setChapingshu(Integer.parseInt(chapingshu));
                    String zongpinglunshu = CommonUtil.getCellValue(row.getCell(6));
                    zhinengjiajuEntity.setZongpinglunshu(Integer.parseInt(zongpinglunshu));
                     
                    //想数据库中添加新对象
                    zhinengjiajuService.insert(zhinengjiajuEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }

    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
        List<Map<String, Object>> result = zhinengjiajuService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhinengjiajuService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
        List<Map<String, Object>> result = zhinengjiajuService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhinengjiajuService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
        List<Map<String, Object>> result = zhinengjiajuService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分段统计
     */
    @RequestMapping("/sectionStat/haopingshu")
    @IgnoreAuth
    public R haopingshuSectionStat(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
        List<Map<String, Object>> result = zhinengjiajuService.haopingshuSectionStat(params, ew);
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }



    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ZhinengjiajuEntity zhinengjiaju, HttpServletRequest request){
        EntityWrapper<ZhinengjiajuEntity> ew = new EntityWrapper<ZhinengjiajuEntity>();
        int count = zhinengjiajuService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhinengjiaju), params), params));
        return R.ok().put("data", count);
    }


}
