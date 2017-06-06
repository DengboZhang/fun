package cn.swu.fun.system.service;

import java.util.List;

import cn.swu.fun.system.entity.Dictionary;



public interface DictionaryService {
	/**
	 * 添加字典
	 * @param dictionary
	 */
	public Dictionary addDictionary(Dictionary dictionary);

	public List<Dictionary> getDictionary(String code);

	public void deleteDictionary(String dictionaryId);
}
