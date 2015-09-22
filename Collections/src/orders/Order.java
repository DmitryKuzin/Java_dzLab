package orders;

import java.util.Date;

/**
 * @author Gataullin Kamil
 * 16.08.2014 22:21:45
 */
public class Order {
    private long id;
    private String name;
    private Date creationDate;
    private Customer customer;
    private Good[] goods;

    public Order() {
    }

    public Order(long id, Date creationDate, Customer customer, Good[] goods) {
        this.id = id;
        this.creationDate = creationDate;
        this.customer = customer;
        this.goods = goods;
    }

    public Order(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Good[] getGoods() {
        return goods;
    }

    public void setGoods(Good[] goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Order equals method");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if((!name.equals(((Order) o).getName()))&&(id!=((Order) o).getId())) return false;
        if (id != order.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        System.out.println("Order hashcode method");
        return (int) (id ^ (id >>> 32));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
