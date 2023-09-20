package ShopMain;

import ShopDAO.ShopDesignSQL;
import ShopDAO.ShopSQL;
import ShopDTO.Carts;
import ShopDTO.Categories;
import ShopDTO.Products;
import ShopDTO.Users;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class ShopMain {
    public static void main(String[] args) {
        Carts carts = new Carts();
        Categories categories = new Categories();
        Products products = new Products();
        Users users = new Users();
        ShopSQL sql = new ShopSQL();
        ShopDesignSQL designSQL = new ShopDesignSQL();

        Scanner sc = new Scanner(System.in);

        boolean run = true;

        int menu = 0;

        sql.connect();

        designSQL.shopMain();

        while (run) {
            designSQL.shopMenu();

            System.out.print(">> ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    designSQL.upLine();
                    System.out.println();
                    System.out.print("아이디 >> ");
                    String u_id = sc.next();
                    System.out.print("비밀번호 >> ");
                    String u_pw = sc.next();
                    System.out.print("이름 >> ");
                    String u_name = sc.next();
                    System.out.print("전화번호 >> ");
                    String u_phone = sc.next();
                    System.out.print("주소 >> ");
                    String u_addr = sc.next();
                    System.out.println();
                    designSQL.downLine();

                    int balance = 0;
                    int u_code = 0;

                    users.setU_id(u_id);
                    users.setU_pw(u_pw);
                    users.setU_name(u_name);
                    users.setU_phone(u_phone);
                    users.setU_addr(u_addr);
                    users.setU_balance(balance);
                    users.setU_code(u_code);

                    sql.joinUsers(users);

                    break;
                case 2:
                    designSQL.upLine();
                    System.out.println();
                    System.out.print("아이디 >> ");
                    u_id = sc.next();
                    System.out.print("비밀번호 >> ");
                    u_pw = sc.next();
                    System.out.println();
                    designSQL.downLine();

                    boolean check1 = sql.checkId(u_id);

                    if (check1) {
                        boolean check2 = sql.checkPw(u_pw);

                        if (check2) {
                            boolean check3 = sql.checkLogin(u_id, u_pw);
                            int code = sql.checkCode(u_id);

                            if (check3) {
                                if (code == 1) {
                                    boolean run2 = true;
                                    while (run2) {
                                        designSQL.adminMenu();
                                        System.out.print(">> ");

                                        menu = sc.nextInt();

                                        switch (menu) {
                                            case 1:
                                                designSQL.insertProduct();
                                                System.out.print(">> ");


                                                int select = sc.nextInt();
                                                categories.setC_id(select);
                                                boolean b = true;

                                                while (b) {
                                                    if (select == 1 || select == 2 || select == 3 || select == 4) {
                                                        int pId = sql.productNumber() + 1;
                                                        designSQL.upLine();
                                                        System.out.println();
                                                        System.out.print("상품 이름 >> ");
                                                        String p_name = sc.next();
                                                        System.out.print("상품 가격 >> ");
                                                        String p_price = sc.next();
                                                        System.out.print("상품 수량 >> ");
                                                        int p_stock = sc.nextInt();
                                                        System.out.print("상품 사이즈 >> ");
                                                        String p_size = sc.next();
                                                        System.out.println();
                                                        designSQL.downLine();

                                                        products.setP_id(pId);
                                                        products.setC_id(categories.getC_id());
                                                        products.setP_name(p_name);
                                                        products.setP_price(p_price);
                                                        products.setP_stock(p_stock);
                                                        products.setP_size(p_size);

                                                        sql.joinProducts(products);
                                                        b = false;
                                                    } else {
                                                        System.out.println();
                                                        System.out.println("1~4까지의 숫자를 입력해주세요");
                                                    }
                                                }
                                                break;

                                            case 2:
                                                System.out.print("수정할 상품 번호 >> ");
                                                int c = sc.nextInt();
                                                boolean check4 = sql.checkProduct(c);
                                                if (check4) {
                                                    designSQL.upLine();
                                                    System.out.println();
                                                    System.out.print("수정할 상품 이름 >> ");
                                                    String p_name = sc.next();
                                                    System.out.print("수정할 상품 가격 >> ");
                                                    String p_price = sc.next();
                                                    System.out.print("수정할 상품 수량 >> ");
                                                    int p_stock = sc.nextInt();
                                                    System.out.print("수정할 상품 사이즈 >> ");
                                                    String p_size = sc.next();
                                                    System.out.println();
                                                    designSQL.downLine();

                                                    products.setP_id(c);
                                                    products.setP_name(p_name);
                                                    products.setP_price(p_price);
                                                    products.setP_stock(p_stock);
                                                    products.setP_size(p_size);

                                                    sql.modifyProducts(products, c);
                                                } else {
                                                    System.out.println();
                                                    System.out.println("상품번호를 확인해주세요.");
                                                    System.out.println();
                                                }
                                                break;
                                            case 3:
                                                designSQL.upLine();
                                                System.out.println();
                                                System.out.print("삭제할 상품 번호 >> ");
                                                int d = sc.nextInt();
                                                System.out.println();
                                                designSQL.downLine();
                                                boolean check5 = sql.checkProduct(d);
                                                if (check5) {
                                                    sql.deleteProducts(d);
                                                } else {
                                                    System.out.println();
                                                    System.out.println("상품번호를 확인해주세요.");
                                                    System.out.println();
                                                }
                                                break;
                                            case 4:
                                                designSQL.productList();
                                                System.out.println();
                                                sql.productsList();
                                                System.out.println();
                                                System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
                                                break;
                                            case 5:
                                                run2 = false;
                                                break;
                                        }
                                    }
                                } else {
                                    boolean run3 = true;
                                    while (run3) {
                                        designSQL.userMenu();
                                        System.out.print(">> ");
                                        menu = sc.nextInt();
                                        switch (menu) {
                                            case 1:
                                                designSQL.upLine();
                                                System.out.println();
                                                System.out.print("충전할 금액 >> ");
                                                int amount = sc.nextInt();
                                                System.out.println();
                                                designSQL.downLine();
                                                sql.deposit(u_id, amount);
                                                sql.balanceSelect(u_id);
                                                System.out.println();
                                                break;
                                            case 2:
                                                designSQL.userCategory();
                                                System.out.print(">> ");

                                                int select = sc.nextInt();
                                                boolean c = true;

                                                while (c) {
                                                    if (select == 1 || select == 2 || select == 3 || select == 4) {
                                                        designSQL.productList();
                                                        System.out.println();
                                                        sql.viewProducts(select);
                                                        System.out.println();
                                                        System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
                                                        designSQL.productBuy();
                                                        System.out.print(">> ");
                                                        int e = sc.nextInt();

                                                        if (e == 1 || e == 2 || e == 3) {
                                                            if (e == 1) {
                                                                System.out.println();
                                                                System.out.print("구매할 상품번호 >> ");
                                                                int f = sc.nextInt();
                                                                if (sql.usersBalance(u_id) >= sql.productsBalance(f) && sql.productStockSelect(f) > 0) {
                                                                    sql.withdraw(u_id, sql.productsBalance(f));
                                                                    sql.withdrawStock(sql.productsStock(f), f);
                                                                    int o_num = sql.ordersNumber() + 1;
                                                                    sql.joinOrders(o_num, u_id, f, sql.selectP_name(f), sql.selectBalance(f), sql.selectP_size(f));
                                                                    System.out.println();
                                                                    System.out.println("상품 구매완료!");
                                                                    System.out.println();
                                                                } else if (sql.usersBalance(u_id) < sql.productsBalance(f)) {
                                                                    System.out.println(sql.usersBalance(u_id) - sql.productsBalance(f) + "원이 부족합니다.");
                                                                } else if (sql.productStockSelect(f) <= 0) {
                                                                    System.out.println();
                                                                    System.out.println("상품 재고가 부족합니다.");
                                                                    System.out.println();
                                                                }

                                                            } else if (e == 2) {
                                                                System.out.println();
                                                                System.out.print("상품번호 >> ");
                                                                int g = sc.nextInt();
                                                                int cart_num = sql.cartsNumber() + 1;
                                                                sql.joinShoppingBasket(cart_num, u_id, g, sql.selectP_name(g), sql.selectP_size(g), sql.selectBalance(g));
                                                                System.out.println();
                                                            } else if (e == 3) {
                                                                c = false;
                                                            }
                                                        } else {
                                                            System.out.println();
                                                            System.out.println("1~3까지의 숫자를 입력해주세요");
                                                            System.out.println();
                                                        }
                                                    } else {
                                                        System.out.println();
                                                        System.out.println("1~4까지의 숫자를 입력해주세요");
                                                        System.out.println();
                                                    }
                                                }
                                                break;
                                            case 3:
                                                designSQL.cartList();
                                                sql.viewCarts(u_id);
                                                System.out.println();
                                                System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
                                                boolean d = true;
                                                while (d) {
                                                    designSQL.cartBuy();
                                                    System.out.print(">> ");
                                                    int h = sc.nextInt();

                                                    if (h == 1 || h == 2 || h == 3) {
                                                        if (h == 1) {
                                                            System.out.print("구매할 No. >> ");
                                                            int j = sc.nextInt();
                                                            if (sql.usersBalance(u_id) >= sql.productsBalance(j) && sql.productStockSelect(j) > 0) {
                                                                sql.withdraw(u_id, sql.productsBalance(j));
                                                                sql.withdrawStock(sql.productsStock(j), j);
                                                                int o_num = sql.ordersNumber() + 1;
                                                                sql.joinOrders(o_num, u_id, j, sql.selectP_name(j), sql.selectBalance(j), sql.selectP_size(j));
                                                                System.out.println();
                                                                System.out.println("상품 구매완료!");
                                                                System.out.println();
                                                            } else if (sql.usersBalance(u_id) < sql.productsBalance(j)) {
                                                                System.out.println();
                                                                System.out.println(sql.usersBalance(u_id) - sql.productsBalance(j) + "원이 부족합니다.");
                                                                System.out.println();
                                                            } else if (sql.productStockSelect(j) <= 0) {
                                                                System.out.println();
                                                                System.out.println("상품 재고가 부족합니다.");
                                                                System.out.println();
                                                            }
                                                        } else if (h == 2) {
                                                            System.out.print("삭제할 No. >> ");
                                                            int i = sc.nextInt();
                                                            sql.deleteCarts(i);
                                                        } else if (h == 3) {
                                                            d = false;
                                                        }
                                                    } else {
                                                        System.out.println();
                                                        System.out.println("1~3까지의 숫자를 입력해주세요");
                                                        System.out.println();
                                                    }
                                                }
                                                break;
                                            case 4:
                                                designSQL.buyList();
                                                sql.viewUsers(u_id);
                                                System.out.println();
                                                System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
                                                break;
                                            case 5:
                                                run3 = false;
                                                break;
                                            case 6:
                                                System.out.println();
                                                System.out.println("정말로 탈퇴하시겠습니까? [Y/N]");
                                                System.out.print(">> ");
                                                String find = sc.next();
                                                if (find.equals("Y") || find.equals("y")) {
                                                    sql.deleteOrders(u_id);
                                                    sql.deleteCarts(u_id);
                                                    System.out.println();
                                                    sql.deleteUsers(u_id);
                                                    System.out.println();
                                                } else if (find.equals("N") || find.equals("n")) {
                                                    break;
                                                }else {
                                                    System.out.println();
                                                    System.out.println("입력이 올바르지 않습니다.");
                                                    System.out.println();
                                                }
                                                run3 = false;
                                                break;
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println();
                            System.out.println("비밀번호가 틀렸습니다.");
                            System.out.println();
                        }
                    } else {
                        System.out.println();
                        System.out.println("아이디가 틀렸습니다.");
                        System.out.println();
                    }
                    break;
                case 3:
                    run = false;
                    designSQL.close();
                    sql.conClose();
                    break;
            }
        }
    }
}
