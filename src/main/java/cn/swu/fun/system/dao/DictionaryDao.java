package cn.swu.fun.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.swu.fun.system.entity.Dictionary;



public interface DictionaryDao extends JpaRepository<Dictionary, String> {

	public List<Dictionary> findDictionaryByCode(String code);

}
