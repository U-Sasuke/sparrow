package priv.yq.sparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.yq.sparrow.entity.Order;

import java.util.List;


/**
 * Created by yaoqing on 2018/11/28.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByNum(int num);

    List<Order> findByTicketCode(String ticketCode);

    List<Order> findByUsername(String username);

    List<Order> findByStatus(String status);

}
