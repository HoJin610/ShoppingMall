package ShopDTO;

public class Products {
    private int p_id;
    private int c_id;
    private String p_name;
    private String p_price;
    private int p_stock;
    private String p_size;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getP_size() {
        return p_size;
    }

    public void setP_size(String p_size) {
        this.p_size = p_size;
    }

    public int getP_stock() {
        return p_stock;
    }

    public void setP_stock(int p_stock) {
        this.p_stock = p_stock;
    }

    @Override
    public String toString() {
        return "Products{" +
                "p_id=" + p_id +
                ", c_id=" + c_id +
                ", p_name='" + p_name + '\'' +
                ", p_price='" + p_price + '\'' +
                ", p_stock=" + p_stock +
                ", p_size='" + p_size + '\'' +
                '}';
    }
}
