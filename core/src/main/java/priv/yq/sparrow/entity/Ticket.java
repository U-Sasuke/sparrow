package priv.yq.sparrow.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaoqing on 2018/11/28.
 */
@Entity
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String indexCode;

    private String begin;

    private String end;

    private Date startTime;

    private Double price;

    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", indexCode='" + indexCode + '\'' +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", startTime=" + startTime +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

}
