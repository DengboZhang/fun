package cn.swu.fun.order.service.impl;


import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.swu.fun.order.dao.OrderDao;
import cn.swu.fun.order.dao.OrderPageDao;
import cn.swu.fun.order.entity.Order;
import cn.swu.fun.order.service.OrderService;
import cn.swu.fun.user.entity.User;
import cn.swu.fun.util.DateUtil;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
     
	//注入dao
	@Autowired
	private OrderDao orderDao;
	@Autowired 
	private OrderPageDao orderPageDao;
	
	
	
	
    //查询用户创建的所有订单
	@Override
	public List<Order> findMyOrder(String userId) {
		List<Order> orders=orderDao.findMyOrderByCreatorId(userId);
		if(orders.size()>0){
			return orders;
		}
		return null;
	}

   
	//查询用户的抢单
	@Override
	public List<Order> findMyCatchOrder(String userId) {
	List<Order> orders=orderDao.findMyOrderByRecipientId(userId);
	if(orders.size()>0){
		return orders;
	}
	    return null;
	}
     
    
	//创建一个新的订单
	@Override
	public void createOrder(Order order,User user) {
		order.setCreatorId(user.getId());
		order.setCreateTime(DateUtil.dateToString(new Date()));
		order.setState("0");
		orderDao.save(order);
	}

    //查询所有订单
	@Override
	public List<Order> findAllOrders() {
		 List<Order> orders=orderDao.findOrderByCreateTime(DateUtil.dateToString(new Date()));
		 if(orders!=null){
			 return orders;
		 }
		    return null;
	}

    //修改我的订单，只能是状态为0的时候修改
	@Override
	public void updateMyOrder(Order modifyOrder) {
	  Order order=orderDao.findOne(modifyOrder.getId());
	  order=modifyOrder;
	  orderDao.saveAndFlush(order);
	}

    //状态不是 1 就可以删除
	@Override
	public void deleteMyOrder(String orderId) {
		orderDao.delete(orderId);
	}

    //抢单状态设置为1
	@Override
	public void catcheOrder(String orderId, String recipientId) {
	    Order order=orderDao.findOne(orderId);
	    order.setState("1");
	    order.setRecipientId(recipientId);
	    orderDao.saveAndFlush(order);
	}

    //分页查询
	@Override
	public Page<Order> findOrderByFlashTimes(Pageable pageable) {
		Page<Order> orderPageBean=orderPageDao.findOrderByCreateTime(pageable,DateUtil.dateToString(new Date()));
		if(orderPageBean!=null){
			return orderPageBean;
		}
		return null;
	}


	

 
}
