package orders;

/**
 * @author Gataullin Kamil
 * 16.08.2014 22:16:42
 */
public class Good {
    private long id;
    private String name;
    private long price;

    public Good() {
    }

    public Good(long id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

}
