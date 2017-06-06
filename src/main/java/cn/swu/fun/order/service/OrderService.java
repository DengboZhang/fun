package cn.swu.fun.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.swu.fun.order.entity.Order;
import cn.swu.fun.user.entity.User;
/**
 * order的service层
 * @author zdb
 *
 */
public interface OrderService {

   /*
    * 创建订单
    */
   public void createOrder(Order order,User user);
   
   /*
    * 查询当天所有订单
    */
   public List<Order> findAllOrders();
   
   /*
    * 查询跟用户相创建的订单
    */
   public List<Order> findMyOrder(String userId);
  
   /*
    * 查询用户的抢单
    */
   public List<Order> findMyCatchOrder(String userId);
    
   /*
    * 修改我的订单
    */
   public void updateMyOrder(Order order);
   
   /*
    * 删除我的订单
    */
   public void deleteMyOrder(String orderId);
   
   /*
    * 抢单
    */
   public void catcheOrder(String orderId, String recipientId);
    
   /*
    * 分页查询
    */
   public Page<Order> findOrderByFlashTimes(Pageable pageable);

}
