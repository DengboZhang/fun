package cn.swu.fun;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.swu.fun.order.dao.OrderDao;
import cn.swu.fun.order.entity.Order;
import cn.swu.fun.order.service.OrderService;
import cn.swu.fun.user.dao.UserDao;
import cn.swu.fun.user.entity.User;
import cn.swu.fun.user.service.UserService;
import cn.swu.fun.util.DateUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring.xml","classpath:/spring-hibernate.xml"})
@Transactional
public class DaoTest {
       
	 @Autowired
	 private UserService userService;
	 @Autowired
	 private UserDao userDao;
	 @Autowired
	 private OrderDao orderDao;
	 @Autowired
	 private OrderService orderService;
	 
	 
	 
	 
	 @Rollback(false)
	 @Test
	 public void catchOrder(){
		   orderService.catcheOrder("40280c815c7c4a29015c7c4a30b50000", "40280c815c7c48b4015c7c48b99a0000");
	 }
	 
	 
	 @Rollback(false)
	 @Test
	 public void testUpdateOrder(){
		 Order modifyOrder=new Order();
		 modifyOrder.setId("40280c815c7c4a29015c7c4a30b50000");
		 modifyOrder.setContact("134627146039");
		 modifyOrder.setCreatorId("40280c815c7c48b4015c7c48b9b00001");
		 modifyOrder.setExpressAddress("西师街京东快递");
		 modifyOrder.setDescription("一个耳机");
		 modifyOrder.setExpressCode("7689");
		 modifyOrder.setCreateTime(DateUtil.dateToString(new Date()));
		 modifyOrder.setPay("10");
		 modifyOrder.setState("0");
		 modifyOrder.setToAddress("梅园1舍");
		 Order order=orderDao.findOne(modifyOrder.getId());
		 order=modifyOrder;
		 System.out.println(order.toString());//更新前id=40280c815c7c4a29015c7c4a30b50000
		 orderDao.saveAndFlush(order);        //更新后id=40280c815c7c4a29015c7c4a30b50000
	     //更新订单成功
	 }
	 
	 
	 @Test
	 public void testObject(){
		 User user1=new User();
		 User user2=new User();
		 user1.setUsername("zdb");
		 user1.setPassword("120");
		 user2.setUsername("qwe");
		 user2.setEmail("aaa@qq.com");
		 user2=user1;
		 System.out.println(user2.toString());
	 }
	 
	 
	 @Test
	 public void findMyOrder(){
		User user = userDao.findUserByUsername("zdb");
		System.out.println(user.getId());
		List<Order> list=orderService.findMyOrder(user.getId());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}    
	 }
	 
	 @Test
	 public void findAllOrders(){
		 List<Order> lsit=orderService.findAllOrders();
		 for (Order order : lsit) {
			System.out.println(order.toString());
		}
	 }
	 
	 @Rollback(false)
	 @Test
	 public void testCreateOrder(){
		 User user=userDao.findUserByUsername("zdb");
		 System.out.println(user.toString());
		 Order order=new Order();
		 order.setExpressAddress("韵达快递公司");
		 order.setDescription("装饰品");
		 order.setPay("1元");
		 order.setExpressCode("36ac");
		 order.setToAddress("25教楼下");
		 order.setContact("15934792648");
		 orderService.createOrder(order, user);
		 User user2=userDao.findUserByUsername("qwe");
		 System.out.println(user2.toString());
		 Order order2=new Order();
		 order2.setExpressAddress("申通快递公司");
		 order2.setDescription("一本书");
		 order2.setPay("6元");
		 order2.setToAddress("八教楼下");
		 order2.setExpressCode("42p3");
		 order2.setContact("13489726348");
		 orderService.createOrder(order2, user2);
		 
	 }
	 
	 @Test
	 public void testLogin(){
		 User user=userService.login("zdb","000000");
		 System.out.println(user.toString());
	 }
	 
	 @Test
	 @Rollback(false)
	 public void testCrudUser(){
		 User user=new User();
		 user.setEmail("bbb@qq.com");
		 user.setPassword("000000");
		 user.setPhone("120");
		 user.setUsername("qwe");
		 User user2=new User();
		 user2.setEmail("aaa@qq.com");
		 user2.setPassword("000000");
		 user2.setPhone("110");
		 user2.setUsername("zdb");
		 userDao.save(user);
		 userDao.save(user2);
		/* 更新代码，先查在保存刷新，必须设置 事务回滚为 false 才能让数据库的数据生效
		User user=userDao.findOne("40280c815c7838ad015c7838b4990000");
	    user.setEmail("xxx@qqq.com");
	    userDao.saveAndFlush(user);
		System.out.println(user);   */
		//userDao.delete("40280c815c7838ad015c7838b4990000");
	 }
	 
	 @Test
	 public void testSaveUser(){
		User user=new User();
		user.setPassword("000000");
		user.setPhone("110");
		user.setUsername("zdb");
	    userService.register(user);	
	 }
	 
	 @Test
	 public void testDate(){
		 String time=DateUtil.dateToString(new Date());
		 System.out.println(time);
	 }
	 
}
