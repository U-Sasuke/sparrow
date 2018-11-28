package priv.yq.sparrow.service;

import priv.yq.sparrow.entity.Ticket;

import java.util.List;

/**
 * Created by yaoqing on 2018/11/28.
 */
public interface TicketService {

    /**
     * 保存车票
     *
     * @param ticket 车票
     */
    Boolean save(Ticket ticket);

    /**
     * 保存车票列表
     *
     * @param tickets 车票列表
     */
    Boolean save(List<Ticket> tickets);

    /**
     * 删除车票
     *
     * @param ticket 车票
     */
    Boolean delete(Ticket ticket);

    /**
     * 删除车票列表
     *
     * @param tickets 车票列表
     */
    Boolean delete(List<Ticket> tickets);

    /**
     * 根据车票编号查询车票
     *
     * @param indexCode 车票编号
     */
    Ticket findByIndexCode(String indexCode);

    /**
     * 根据车票价格查询车票列表
     *
     * @param price 车票价格
     */
    List<Ticket> findByPrice(double price);

}
