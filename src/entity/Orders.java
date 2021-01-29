package entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {
    @Id
    private String oid;
    private String date;
    @ManyToOne
    @JoinColumn(name = "id")
    private Customer customer;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<entity.OrderDetail> orderDetailList;

    public Orders() {
    }

    public Orders(String oid, String date, Customer customer, List<entity.OrderDetail> orderDetailList) {
        this.oid = oid;
        this.date = date;
        this.customer = customer;
        this.orderDetailList = orderDetailList;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<entity.OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<entity.OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
