package cn.swu.fun.system.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.swu.fun.system.dto.ResultDto;
import cn.swu.fun.system.entity.Dictionary;
import cn.swu.fun.system.service.DictionaryService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * 404，请求方法不存在
	 * @return
	 */
	@RequestMapping(value = "*")
	public ResultDto noFunction() {
		ResultDto result = new ResultDto();
		result.setCode(ResultDto.CODE_NO_SUCH_FUNCTION);
		result.setMessage("请求的方法不存在！");
		result.setData(new HashMap<String, Object>());
		return result;
	}

   
	@ResponseBody
	@RequestMapping(value = "/addDictionary")
	public String addDictionary(Dictionary dictionary) {
		dictionaryService.addDictionary(dictionary);
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/getDictionary")
	public List<Dictionary> getDictionary(String code) {
		return dictionaryService.getDictionary(code);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteDictionary")
	public String deleteDictionary(String dictionaryId) {
		dictionaryService.deleteDictionary(dictionaryId);
		return "success";
	}

}
