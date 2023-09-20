package ShopDTO;

public class Carts {
    private int cart_id;
    private String u_id;
    private String p_id;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "Carts{" +
                "cart_id=" + cart_id +
                ", u_id='" + u_id + '\'' +
                ", p_id='" + p_id + '\'' +
                '}';
    }
}
