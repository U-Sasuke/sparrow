package priv.yq.sparrow.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.yq.sparrow.entity.Order;
import priv.yq.sparrow.repository.OrderRepository;
import priv.yq.sparrow.service.OrderService;

import java.util.List;


/**
 * Created by yaoqing on 2018/11/28.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Boolean save(Order order) {
        if (order == null) {
            return false;
        }
        orderRepository.save(order);
        return true;
    }

    @Override
    public Boolean save(List<Order> orders) {
        if (orders == null || orders.size() == 0) {
            return false;
        }
        orderRepository.saveAll(orders);
        return true;
    }

    @Override
    public Boolean delete(Order order) {
        if (order == null) {
            return false;
        }
        orderRepository.delete(order);
        return true;
    }

    @Override
    public Boolean delete(List<Order> orders) {
        if (orders == null || orders.size() == 0) {
            return false;
        }
        orderRepository.deleteAll(orders);
        return true;
    }

    @Override
    public Order findByNum(int num) {
        try {
            if (num <= 0) {
                return null;
            }
            return orderRepository.findByNum(num);
        } catch (Exception e) {
            log.error("OrderServiceImpl findByNum error:{}", e);
            return null;
        }
    }

    @Override
    public List<Order> findByTicketCode(String ticketCode) {
        try {
            if (StringUtils.isBlank(ticketCode)) {
                return null;
            }
            return orderRepository.findByTicketCode(ticketCode);
        } catch (Exception e) {
            log.error("OrderServiceImpl findByTicketCode error:{}", e);
            return null;
        }
    }

    @Override
    public List<Order> findByUsername(String username) {
        try {
            if (StringUtils.isBlank(username)) {
                return null;
            }
            return orderRepository.findByUsername(username);
        } catch (Exception e) {
            log.error("OrderServiceImpl findByUsername error:{}", e);
            return null;
        }
    }

    @Override
    public List<Order> findByStatus(String status) {
        try {
            if (StringUtils.isBlank(status)) {
                return null;
            }
            return orderRepository.findByStatus(status);
        } catch (Exception e) {
            log.error("OrderServiceImpl findByStatus error:{}", e);
            return null;
        }
    }

}
