package ShopDTO;

public class Users {
    private String u_id;
    private String u_pw;
    private String u_name;
    private String u_phone;
    private String u_addr;
    private int u_balance;
    private int u_code;

    public int getU_code() {
        return u_code;
    }

    public void setU_code(int u_code) {
        this.u_code = u_code;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pw() {
        return u_pw;
    }

    public void setU_pw(String u_pw) {
        this.u_pw = u_pw;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_addr() {
        return u_addr;
    }

    public void setU_addr(String u_addr) {
        this.u_addr = u_addr;
    }

    public int getU_balance() {
        return u_balance;
    }

    public void setU_balance(int u_balance) {
        this.u_balance = u_balance;
    }

    @Override
    public String toString() {
        return "Users{" +
                "u_id='" + u_id + '\'' +
                ", u_pw='" + u_pw + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_phone='" + u_phone + '\'' +
                ", u_addr='" + u_addr + '\'' +
                ", u_balance=" + u_balance +
                ", u_code=" + u_code +
                '}';
    }
}
