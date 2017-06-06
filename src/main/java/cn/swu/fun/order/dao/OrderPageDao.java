package cn.swu.fun.order.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.swu.fun.order.entity.Order;

public interface OrderPageDao extends PagingAndSortingRepository<Order,String>{
        
	  public Page<Order> findOrderByCreateTime(Pageable pageable,String date);
}
