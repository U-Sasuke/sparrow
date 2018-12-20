package priv.yq.sparrow.service;

import priv.yq.sparrow.entity.Order;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yaoqing on 2018/11/28.
 */
public interface OrderService {

    /**
     * 保存订单
     *
     * @param order 订单
     */
    @Transactional
    Boolean save(Order order);

    /**
     * 保存订单列表
     *
     * @param orders 订单列表
     */
    @Transactional
    Boolean save(List<Order> orders);

    /**
     * 删除订单
     *
     * @param order 订单
     */
    @Transactional
    Boolean delete(Order order);

    /**
     * 删除订单列表
     *
     * @param orders 订单列表
     */
    @Transactional
    Boolean delete(List<Order> orders);

    /**
     * 根据订单编号查询订单
     *
     * @param num 订单编号
     */
    Order findByNum(int num);

    /**
     * 根据车票编号查询订单列表
     *
     * @param ticketCode 车票编号
     */
    List<Order> findByTicketCode(String ticketCode);

    /**
     * 根据购票用户查询订单列表
     *
     * @param username 用户名
     */
    List<Order> findByUsername(String username);

    /**
     * 根据订单状态查询订单列表
     *
     * @param status 订单状态
     */

    List<Order> findByStatus(String status);

}
