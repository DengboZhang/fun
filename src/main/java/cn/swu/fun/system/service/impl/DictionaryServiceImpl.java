package cn.swu.fun.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.swu.fun.system.dao.DictionaryDao;
import cn.swu.fun.system.entity.Dictionary;
import cn.swu.fun.system.service.DictionaryService;


@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	public Dictionary addDictionary(Dictionary dictionary) {
		return dictionaryDao.saveAndFlush(dictionary);
	}

	public List<Dictionary> getDictionary(String code) {
		return dictionaryDao.findDictionaryByCode(code);
	}

	public void deleteDictionary(String dictionaryId) {
		dictionaryDao.delete(dictionaryId);
	}

}
