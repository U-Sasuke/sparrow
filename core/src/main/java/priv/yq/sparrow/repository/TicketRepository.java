package priv.yq.sparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.yq.sparrow.entity.Ticket;

import java.util.List;

/**
 * Created by yaoqing on 2018/11/28.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findByIndexCode(String indexCode);

    List<Ticket> findByPrice(double price);

}
