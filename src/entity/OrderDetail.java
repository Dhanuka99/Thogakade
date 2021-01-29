package entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @EmbeddedId
    private CompositeKey compositeKey = new CompositeKey();

    @ManyToOne
    @MapsId("order_Id")
    @JoinColumn(name = "oid")
    private Orders orders;

    @ManyToOne
    @MapsId("item_Code")
    @JoinColumn(name = "code")
    private Item item;

    private int qty;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(CompositeKey compositeKey, Orders orders, Item item, int qty, double price) {
        this.compositeKey = compositeKey;
        this.orders = orders;
        this.item = item;
        this.qty = qty;
        this.price = price;
    }

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(CompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
