package cn.swu.fun.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据字典
 * @author zdb
 */
@Entity
@Table(name = "dictionary")
public class Dictionary {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;
	// 字典父节点标识码
	@Column(name = "code")
	private String code;
	// 字典标识码
	@Column(name = "dict_code")
	private String dictCode;
	// 字典标题
	@Column(name = "dict_title")
	private String dictTitle;
	// 字典内容
	@Column(name = "dict_text")
	private String dictText;
	// 是否叶子节点
	@Column(name = "leaf")
	private String leaf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictTitle() {
		return dictTitle;
	}

	public void setDictTitle(String dictTitle) {
		this.dictTitle = dictTitle;
	}

	public String getDictText() {
		return dictText;
	}

	public void setDictText(String dictText) {
		this.dictText = dictText;
	}

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}

}
