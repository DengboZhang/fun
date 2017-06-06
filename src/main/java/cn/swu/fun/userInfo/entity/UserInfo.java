package cn.swu.fun.userInfo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户个人资料编辑
 * @author zdb
 *2017年3月29日16:19:27
 */
@Entity
@Table(name = "userinfo")
public class UserInfo {
       
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;
	//昵称
	@Column(name = "niname")
	private String niname;
	//性别
	@Column(name = "sex")
	private String sex;
	//年龄
	@Column(name = "age")
	private String age;
	//生日
	@Column(name ="birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	//星座
	@Column(name = "star")
	private String star;
	//个性签名
	@Column(name = "signature")
	private String signature;
	//兴趣爱好
	@Column(name = "hobby")
	private String hobby;
    //头像
	@Column(name = "photo")
	private String photo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNiname() {
		return niname;
	}
	public void setNiname(String niname) {
		this.niname = niname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", niname=" + niname + ", sex=" + sex + ", age=" + age + ", birthday=" + birthday
				+ ", star=" + star + ", signature=" + signature + ", hobby=" + hobby + ", photo=" + photo + "]";
	}
    
	
	
	
}
