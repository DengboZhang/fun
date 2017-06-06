package cn.swu.fun.order.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.swu.fun.order.entity.Order;



/**
 * 订单dao层操作
 * @author zdb
 *
 */
public  interface  OrderDao extends JpaRepository<Order,String>{

	/*@Modifying
	@Query("update Customer as c set c.name = ?1 where c.userid=?2")
	public int updateUserById(int id);*/
	
	public List<Order> findMyOrderByCreatorId(String userId);
	
	public List<Order> findMyOrderByRecipientId(String recipientId);
    
	public List<Order> findOrderByCreateTime(String createTime);
	

} 
