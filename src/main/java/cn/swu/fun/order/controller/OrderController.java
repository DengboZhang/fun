package cn.swu.fun.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.swu.fun.order.entity.Order;
import cn.swu.fun.order.service.OrderService;
import cn.swu.fun.user.entity.User;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
      
	@Autowired 
	private OrderService orderService;
	
	
	
	/*
	 * 前台 用户创建订单
	 */
	@RequestMapping(value="createOrder")
	public void  createOrder(Order order,HttpSession session){
		   User user=(User) session.getAttribute("user");
		   orderService.createOrder(order,user);
	}
	
	/*
	 * 前台 查看当天所有订单
	 */
	@ResponseBody
	@RequestMapping(value="findAllOrders")
	public List<Order> findAllOrders(){
		   List<Order> orders=orderService.findAllOrders();
		   if (orders.size()>0) {
			return orders;
		   }
	        return null;
    }
	
	/*
	 * 前台 查看我发出的订单
	 */
	@ResponseBody
	@RequestMapping(value="findMyOrder")
	public List<Order> findMyOrder(String userId){
		    List<Order> myOrders=orderService.findMyOrder(userId);
		    if(myOrders.size()>0){
		    	return myOrders;
		    }
		    return null;
	 }
	
	/*
	 * 前台 查看我抢到的订单
	 */
	@ResponseBody
	@RequestMapping(value="findMyCatchOrder")
	public List<Order> findMyCatchOrder(String userId){
		    List<Order> myCacheOrders=orderService.findMyCatchOrder(userId);
		    if(myCacheOrders.size()>0){
		    	return myCacheOrders;
		    }
		    return null;
	 }
	
	/*
	 * 前台 修改我到的订单 状态是0 和 1 的可以修改 ，1 不能修改金额
	 */
	@ResponseBody
	@RequestMapping(value="updateMyOrder")
	public String updateMyOrder(Order order){
		if(order!=null){//空值判断
		  orderService.updateMyOrder(order);
		}
		    return null;
	 }
	
	/*
	 * 前台 删除我的订单 状态是0 可以删除
	 */
	@ResponseBody
	@RequestMapping(value="deleteMyOrder")
	public String deleteMyOrder(String orderId){
		if(orderId!=null){//空值判断
			if(orderId.equals("0")){
		      orderService.deleteMyOrder(orderId);
		      return "1";//删除成功
			}
		 }
		    return "0";//删除失败
	 }
	
	@ResponseBody
	@RequestMapping(value="catcheOrder")
	public String catcheOrder(String orderId,String recipientId){
		if((orderId!=null)&&(recipientId!=null)){//空值判断
			orderService.catcheOrder(orderId,recipientId);
			return "1";//抢单成功
		 }
		    return "0";//抢单失败失败
	 }
	
	@ResponseBody
	@RequestMapping(value="getOrdersByFlashTimes")
	public Page<Order> getOrdersByFlashTimes(@RequestParam(value = "flashTimes", defaultValue = "0") Integer page,
	        @RequestParam(value = "size", defaultValue = "2") Integer size) {
		  Sort sort = new Sort(Direction.ASC, "id");//page页数-从前台传过来，size煤业现实的数据后台设定，前台也能动态修改
		  Pageable pageable = new PageRequest(page,size,sort);
		if(page!=null){//空值判断
		    return orderService.findOrderByFlashTimes(pageable);//刷新成功
		 }
		    return null;//刷新失败
	 }
	
}
