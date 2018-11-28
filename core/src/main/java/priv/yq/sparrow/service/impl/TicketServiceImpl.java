package priv.yq.sparrow.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.yq.sparrow.entity.Ticket;
import priv.yq.sparrow.repository.TicketRepository;
import priv.yq.sparrow.service.TicketService;

import java.util.List;

/**
 * Created by yaoqing on 2018/11/28.
 */
@Service
public class TicketServiceImpl implements TicketService {

    private static Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Boolean save(Ticket ticket) {
        try {
            if (ticket == null) {
                return false;
            }
            ticketRepository.save(ticket);
            return true;
        } catch (Exception e) {
            log.error("TicketServiceImpl save error:{}", e);
            return false;
        }
    }

    @Override
    public Boolean save(List<Ticket> tickets) {
        try {
            if (tickets == null || tickets.size() == 0) {
                return false;
            }
            ticketRepository.saveAll(tickets);
            return true;
        } catch (Exception e) {
            log.error("TicketServiceImpl save list error:{}", e);
            return false;
        }
    }

    @Override
    public Boolean delete(Ticket ticket) {
        try {
            if (ticket == null) {
                return false;
            }
            ticketRepository.delete(ticket);
            return true;
        } catch (Exception e) {
            log.error("TicketServiceImpl delete error:{}", e);
            return false;
        }
    }

    @Override
    public Boolean delete(List<Ticket> tickets) {
        try {
            if (tickets == null || tickets.size() == 0) {
                return false;
            }
            ticketRepository.deleteAll(tickets);
            return true;
        } catch (Exception e) {
            log.error("TicketServiceImpl delete list error:{}", e);
            return false;
        }
    }

    @Override
    public Ticket findByIndexCode(String indexCode) {
        try {
            if (StringUtils.isBlank(indexCode)) {
                return null;
            }
            return ticketRepository.findByIndexCode(indexCode);
        } catch (Exception e) {
            log.error("TicketServiceImpl findByIndexCode error:{}", e);
            return null;
        }
    }

    @Override
    public List<Ticket> findByPrice(double price) {
        try {
            if (price == 0) {
                return null;
            }
            return ticketRepository.findByPrice(price);
        } catch (Exception e) {
            log.error("TicketServiceImpl findByPrice error:{}", e);
            return null;
        }
    }

}
