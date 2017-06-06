package cn.swu.fun.picture.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.swu.fun.picture.service.PictureService;

@Controller
@RequestMapping(value = "/picture")
public class PictureController {
          
	
	@Autowired
	private  PictureService pictureService; 
	
	/**
	 * 获取画图数据
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getPicture")
	public Map<String, Object> getPicture() throws Exception {
		System.out.println(pictureService.getPicture().toString());
		 return pictureService.getPicture();
	}
}
