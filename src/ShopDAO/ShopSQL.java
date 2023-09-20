package ShopDAO;

import ShopDTO.Products;
import ShopDTO.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopSQL {

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public void connect() {
        con = DBConnection.DBConnect();
    }

    public void conClose() {
        try {
            con.close();
            System.out.println();
            System.out.println("접속 해제되었습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinUsers(Users users) {
        String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, users.getU_id());
            pstmt.setString(2, users.getU_pw());
            pstmt.setString(3, users.getU_name());
            pstmt.setString(4, users.getU_phone());
            pstmt.setString(5, users.getU_addr());
            pstmt.setInt(6, users.getU_balance());
            pstmt.setInt(7, users.getU_code());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println();
                System.out.println("회원가입 성공!");
                System.out.println();
            } else {
                System.out.println("회원가입 실패!");
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkId(String uId) {
        boolean check1 = false;

        String sql = "SELECT * FROM USERS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uId);

            rs = pstmt.executeQuery();

            check1 = rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check1;
    }

    public boolean checkPw(String uPw) {
        boolean check2 = false;

        String sql = "SELECT * FROM USERS WHERE U_PW = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uPw);

            rs = pstmt.executeQuery();

            check2 = rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check2;
    }

    public boolean checkLogin(String uId, String uPw) {
        boolean check3 = false;

        String sql = "SELECT * FROM USERS WHERE U_ID = ? AND U_PW = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uId);
            pstmt.setString(2, uPw);

            rs = pstmt.executeQuery();

            check3 = rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check3;
    }

    public int checkCode(String uId) {
        int code = 0;
        String sql = "SELECT U_CODE FROM USERS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                code = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return code;
    }

    public int productNumber() {

        int pId = 0;

        String sql = "SELECT MAX(P_ID) FROM PRODUCTS";

        try {
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                pId = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pId;
    }

    public void joinProducts(Products products) {
        String sql = "INSERT INTO PRODUCTS VALUES(?, ?, ?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, products.getP_id());
            pstmt.setInt(2, products.getC_id());
            pstmt.setString(3, products.getP_name());
            pstmt.setString(4, products.getP_price());
            pstmt.setInt(5, products.getP_stock());
            pstmt.setString(6, products.getP_size());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println();
                System.out.println("물품등록 성공!");
            } else {
                System.out.println("물품등록 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkProduct(int c) {
        boolean check4 = false;
        String sql = "SELECT * FROM PRODUCTS WHERE P_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, c);

            rs = pstmt.executeQuery();

            check4 = rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check4;
    }

    public void modifyProducts(Products products, int c) {
        String sql = "UPDATE PRODUCTS SET P_NAME = ?, P_PRICE = ?, P_STOCK = ?, P_SIZE = ? WHERE P_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, products.getP_name());
            pstmt.setString(2, products.getP_price());
            pstmt.setInt(3, products.getP_stock());
            pstmt.setString(4, products.getP_size());
            pstmt.setInt(5, c);


            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("수정 성공!");
            } else {
                System.out.println("수정 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProducts(int d) {
        String sql = "DELETE FROM PRODUCTS WHERE P_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, d);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("상품 삭제 완료!");
            } else {
                System.out.println("상품 삭제 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void productsList() {
        String sql1 = "SELECT * FROM PRODUCTS";

        try {
            pstmt = con.prepareStatement(sql1);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("\t" + rs.getInt(1) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t" + rs.getInt(5) + "\t\t" + rs.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deposit(String u_id, int amount) {

        String sql = "UPDATE USERS SET U_BALANCE = U_BALANCE + ? WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, amount);
            pstmt.setString(2, u_id);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("충전 성공!");
            } else {
                System.out.println("충전 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void balanceSelect(String uId) {
        String sql = "SELECT U_BALANCE FROM USERS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, uId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("현재금액 : " + rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void viewProducts(int select) {
        String sql = "SELECT * FROM PRODUCTS WHERE C_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, select);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("\t" + rs.getInt(1) + "\t" + rs.getString(3) + "\t\t\t" + rs.getString(4) + "\t" + rs.getInt(5) + "\t\t" + rs.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int cartsNumber() {

        int cart_id = 0;

        String sql = "SELECT MAX(CART_ID) FROM CARTS";

        try {
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                cart_id = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cart_id;
    }

    public void joinShoppingBasket(int cartNum, String uId, int g, String p_name, String p_size, String p_price) {
        String sql = "INSERT INTO CARTS VALUES(?, ?, ?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, cartNum);
            pstmt.setString(2, uId);
            pstmt.setInt(3, g);
            pstmt.setString(4, p_name);
            pstmt.setString(5, p_size);
            pstmt.setString(6, p_price);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("장바구니에 상품을 담았습니다.");
            } else {
                System.out.println("장바구니에 상품을 담지 못했습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int usersBalance(String u_id) {
        String sql = "SELECT U_BALANCE FROM USERS WHERE U_ID = ?";
        int amount = 0;

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, u_id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                amount = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }

    public int productsBalance(int f) {
        int p_balance = 0;

        String sql = "SELECT P_PRICE FROM PRODUCTS WHERE P_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, f);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                p_balance = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p_balance;
    }

    public void withdraw(String uId, int i) {
        String sql = "UPDATE USERS SET U_BALANCE = U_BALANCE - ? WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, i);
            pstmt.setString(2, uId);

            int result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewCarts(String uId) {
        String sql = "SELECT * FROM CARTS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, uId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("\t" + rs.getInt(3) + "\t" + rs.getString(4) + "\t\t\t" + rs.getString(6) + "\t" + rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int productsStock(int f) {
        String sql = "SELECT MAX(P_STOCK) FROM PRODUCTS WHERE P_ID = ?";

        int g = 0;

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, f);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                g = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return g;
    }

    public void withdrawStock(int i, int f) {
        String sql = "UPDATE PRODUCTS SET P_STOCK = ? - 1 WHERE P_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, i);
            pstmt.setInt(2, f);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String selectP_name(int g) {
        String sql = "SELECT P_NAME FROM PRODUCTS WHERE P_ID = ?";

        String p_name = "";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, g);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                p_name = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p_name;
    }

    public String selectP_size(int g) {
        String sql = "SELECT P_SIZE FROM PRODUCTS WHERE P_ID = ?";

        String p_size = "";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, g);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                p_size = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p_size;
    }

    public String selectBalance(int g) {
        String sql = "SELECT P_PRICE FROM PRODUCTS WHERE P_ID = ?";

        String p_price = "";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, g);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                p_price = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p_price;
    }

    public void deleteCarts(int i) {
        String sql = "DELETE FROM CARTS WHERE CART_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, i);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("상품삭제 완료!");
            } else {
                System.out.println("상품삭제 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUsers(String uId) {
        String sql = "DELETE FROM USERS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, uId);

            int result = pstmt.executeUpdate();

            if (result > 0){
                System.out.println("성공적으로 탈퇴되었습니다.");
            }else {
                System.out.println("회원탈퇴에 실패하셨습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int ordersNumber() {

        int oId = 0;

        String sql = "SELECT MAX(O_NUM) FROM ORDERS";

        try {
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                oId = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oId;
    }

    public void joinOrders(int o_num, String u_id, int f, String s, String s1, String s2) {
        String sql = "INSERT INTO ORDERS VALUES(?, ?, ?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, o_num);
            pstmt.setString(2, u_id);
            pstmt.setInt(3, f);
            pstmt.setString(4, s);
            pstmt.setString(5, s1);
            pstmt.setString(6, s2);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewUsers(String uId) {
        String sql = "SELECT O_NUM, P_NAME, P_PRICE, P_SIZE FROM ORDERS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, uId);

            rs = pstmt.executeQuery();

            while (rs.next()){
                System.out.println("\t" + rs.getInt(1) + "\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t" + rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOrders(String uId) {
        String sql = "DELETE FROM ORDERS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, uId);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCarts(String uId) {
        String sql = "DELETE FROM CARTS WHERE U_ID = ?";

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, uId);

            int result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int productStockSelect(int f){
        String sql = "SELECT P_STOCK FROM PRODUCTS WHERE P_ID = ?";

        int t = 0;

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, f);

            rs = pstmt.executeQuery();

            if (rs.next()){
                t = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
