package cn.swu.fun.picture.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.mail.handlers.multipart_mixed;

import cn.swu.fun.picture.service.PictureService;
@Service
@Transactional
public class PictureServiceImpl implements PictureService {
	
	
	/*option = {
		    title: {
		        text: '基础雷达图'
		    },
		    tooltip: {},
		    legend: {
		        data: ['预算分配（Allocated Budget）', '实际开销（Actual Spending）']
		    },
		    radar: {
		        // shape: 'circle',
		        indicator: [
		           { name: '销售（sales）', max: 6500},
		           { name: '管理（Administration）', max: 16000},
		           { name: '信息技术（Information Techology）', max: 30000},
		           { name: '客服（Customer Support）', max: 38000},
		           { name: '研发（Development）', max: 52000},
		           { name: '市场（Marketing）', max: 25000}
		        ]
		    },
		    series: [{
		        name: '预算 vs 开销（Budget vs spending）',
		        type: 'radar',
		        // areaStyle: {normal: {}},
		        data :[
		            {
		                value : [4300, 10000, 28000, 35000, 50000, 19000],
		                name : '预算分配（Allocated Budget）'
		            }, 
		             {
		                value : [5000, 14000, 28000, 31000, 42000, 21000],
		                name : '实际开销（Actual Spending）'
		            }
		        ]
		    }]
		};
*/
	@Override
	public Map<String, Object> getPicture() {
		Map<String,Object> map=new HashMap<String, Object>();
	    List<String> legend=new ArrayList<String>();
	    List<Map<String,String>> indicator=new ArrayList<Map<String,String>>();
	    List<Map<String,Object>> series=new ArrayList<Map<String,Object>>();
	    Map<String,String> indicatorMap1=new HashMap<String, String>();
	    Map<String,String> indicatorMap2=new HashMap<String, String>();
	    Map<String,String> indicatorMap3=new HashMap<String, String>();
	    Map<String,String> indicatorMap4=new HashMap<String, String>();
	    Map<String,String> indicatorMap5=new HashMap<String, String>();
	    Map<String,String> indicatorMap6=new HashMap<String, String>();
	    
	    Map<String,Object> seriesMap1=new HashMap<String, Object>();
	    Map<String,Object> seriesMap2=new HashMap<String, Object>();
	    List<String> seriesValue1=new ArrayList<String>();
	    List<String> seriesValue2=new ArrayList<String>();
	    
	    legend.add("预算分配（Allocated Budget）");
	    legend.add("实际开销（Actual Spending）");
	    map.put("legend",legend);
	
	   indicatorMap1.put("name", "销售（sales）");
	   indicatorMap1.put("max", "6500");
	   indicator.add(indicatorMap1);
	   
	    
	   indicatorMap2.put("name", "管理（Administration）");
	   indicatorMap2.put("max", "16000");
	   indicator.add(indicatorMap2);
	   
	   indicatorMap3.put("name", "信息技术（Information Techology）");
	   indicatorMap3.put("max", "30000");
	   indicator.add(indicatorMap3);
	   
	   indicatorMap4.put("name", "客服（Customer Support）");
	   indicatorMap4.put("max", "38000");
	   indicator.add(indicatorMap4);
	   
	   indicatorMap5.put("name", "研发（Development）");
	   indicatorMap5.put("max", " 52000");
	   indicator.add(indicatorMap5);
	   
	   indicatorMap6.put("name", "市场（Marketing）");
	   indicatorMap6.put("max", "25000");
	   indicator.add(indicatorMap6);
	  
	   map.put("indicator",indicator);
	 
	   seriesMap1.put("name", "预算分配（Allocated Budget）");
	   seriesValue1.add("4300");
	   seriesValue1.add("10000");
	   seriesValue1.add("28000");
	   seriesValue1.add("35000");
	   seriesValue1.add("50000");
	   seriesValue1.add("19000");
	   seriesMap1.put("value",seriesValue1);
	   series.add(seriesMap1);
	   
	   
	   seriesMap2.put("name", "实际开销（Actual Spending）");
	   seriesValue2.add("5000");
	   seriesValue2.add("14000");
	   seriesValue2.add("28000");
	   seriesValue2.add("31000");
	   seriesValue2.add("42000");
	   seriesValue2.add("21000");
	   seriesMap2.put("value",seriesValue2);
	   series.add(seriesMap2);
	   
	   
	   map.put("series",series);
	   
	  
	   
		return map;
	}

}
