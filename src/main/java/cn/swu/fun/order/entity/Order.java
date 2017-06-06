package cn.swu.fun.order.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 订单表
 * @author zdb
 * 2017年3月24日17:04:32
 */
@Entity
@Table(name = "userorder")
public class Order {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	//订单id
	private String id;
	// 订单状态 0 刚创建没人抢单 有人抢单 1（此时不能再抢） 2 （完成交易） 
    @Column(name = "state")
	private String state;
	//创建人的id
	@Column(name = "creatorId")
	private String creatorId;
	//报酬 单位  整数  Rmb 元
	@Column(name = "pay")
	private String pay;
	//快递详情描述（大小，重量，类别。。等）
	@Column(name = "description")
	private String description;
	//接单人的id
	@Column(name = "recipientId") 
	private String recipientId;
	//去哪里取您的快递
	@Column(name = "expressAddress")
	private String expressAddress;
	//发单人的联系方式
	@Column(name = "contact")
	private String contact;
	//将您的快递送到哪里呢
	@Column(name = "toAddress")
	private String toAddress;
	//订单创建的时间
	@Column(name = "create_time")
	private String createTime;
	//订单结束的时间
	@Column(name = "end_time")
	private String endTime;
	//订单结束的时间
    @Column(name = "expressCode")
	private String expressCode;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	
	public String getExpressAddress() {
		return expressAddress;
	}
	public void setExpressAddress(String expressAddress) {
		this.expressAddress = expressAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getExpressCode() {
		return expressCode;
	}
	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", state=" + state + ", creatorId=" + creatorId + ", pay=" + pay + ", description="
				+ description + ", recipientId=" + recipientId + ", expressAddress=" + expressAddress + ", contact="
				+ contact + ", toAddress=" + toAddress + ", createTime=" + createTime + ", endTime=" + endTime
				+ ", expressCode=" + expressCode + "]";
	}
	
	
    
	
    

}
