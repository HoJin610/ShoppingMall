package ShopDAO;

public class ShopDesignSQL {
    public static final String purple="\u001B[35m";
    public static final String red = "\u001B[31m";
    public static final String exit="\u001B[0m";

    public void shopMain() {
        System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
        System.out.println(purple + "                       GALLERIA                  " + exit);
        System.out.println("                                ⣀⠤⠔⠒⠒⡄⢀⣠⠤⠤⠦⡄           ");
        System.out.println("                            ⢀⡴⠋⠀⠀⠀⣀⠴⠊⣡⣴⣾⡿⣣⠃⠀⠀          ");
        System.out.println("                          ⢰⠋⠀⠀⠀⡤⠊⠁⣠⣾⡿⠟⣉⠴⠁              ");
        System.out.println("                        ⡠⠓⠀⠀⠀⠘⠁⢒⣿⠍⠓⠒⠉⠀                 ");
        System.out.println("                     ⢠⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⣄⠀                     ");
        System.out.println("                     ⡏⠀⠀⠀⠀⠴⠂⠀⠀⠀⠀⠀⠘⢦⠀                    ");
        System.out.println("                   ⢸⠘⠉⠀⠀⠀⣴⣶⢶⢀⠤⠀⠀⠀⠀⡇⠀                   ");
        System.out.println("⠀                  ⢷⣿⣵⣴⡆⢙⠉⡘⠟⠉⠁⠀⢀⡼⠁⠀                   ");
        System.out.println("                  ⢀⣾⡉⠣⠵⠶⠎⠉⠀⠀⠀⡠⠖⠛⠉⠉⠉⠙⢦⡀               ");
        System.out.println("       ⠀           ⠊⠑⠂⠀⠤⣄⠀⠀⠀⠀⠀⠀⢀⣠⠄⠒⠀⠘⠁                 ");
        System.out.println("                 ⣴⣒⠤⢤⡠⠔⡏⠀⠀⣀⠀⠀⠀⠀⠈⠙⠒⠢⢴⠑⢢                ");
        System.out.println("                   ⠈⠉⠉⠉⠉⠱⡀⠀⠀⠀⠀⠰⠀⠀⠀⠀⠀⠀⡏⠁                ");
        System.out.println("                         ⢸⠉⠒⠤⠤⢤⡇⠀⠀⠀⠀⢀⢼⣇                ");
        System.out.println("                      ⢠⠶⠿⠤⠤⠔⠛⡞⠦⣄⡠⡤⢊⣾⠟⠀                ");
        System.out.println("                       ⢱⣤⣤⣤⠠⢶⡿⠀⠀⠀⠙⠶⠽⠟⠀                 ");
        System.out.println("         ⠀               ⠉⠁⠀                             ");
        System.out.println("                     [" + "환영합니다" + "]                     ");
        System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
    }

    public void shopMenu(){
        System.out.println(" ╔═════════════════════════════════════════════════════╗ ");
        System.out.println("                   ▶▷      MENU     ◁◀                   ");
        System.out.println("                                                         ");
        System.out.println("                       [1] JOIN                          ");
        System.out.println("                       [2] LOGIN                         ");
        System.out.println("                       [3] EXIT                          ");
        System.out.println("                                                         ");
        System.out.println(" ╚═════════════════════════════════════════════════════╝ ");
    }

    public void adminMenu(){
        System.out.println(" ╔═════════════════════════════════════════════════════╗ ");
        System.out.println("                                                         ");
        System.out.println("                        ※ 관리자 ※                        ");
        System.out.println("                                                         ");
        System.out.println("                       1) 상품등록                         ");
        System.out.println("                       2) 상품수정                         ");
        System.out.println("                       3) 상품삭제                         ");
        System.out.println("                       4) 상품목록                         ");
        System.out.println("                       5) 로그아웃                         ");
        System.out.println("                                                         ");
        System.out.println(" ╚═════════════════════════════════════════════════════╝ ");
    }

    public void insertProduct(){
        System.out.println(" ╔═════════════════════════════════════════════════════╗ ");
        System.out.println("                                                         ");
        System.out.println("                       ※ 관리자 ※                         ");
        System.out.println("                                                         ");
        System.out.println("                       ┏ 상품등록 ┓                        ");
        System.out.println("                       ┗ 카테고리 ┛                        ");
        System.out.println("                                                         ");
        System.out.println("                        1) 가방                           ");
        System.out.println("                        2) 의류                           ");
        System.out.println("                        3) 신발                           ");
        System.out.println("                                                         ");
        System.out.println(" ╚═════════════════════════════════════════════════════╝ ");
    }

    public void upLine(){
        System.out.println(" ╔═════════════════════════════════════════════════════╗ ");
    }

    public void downLine(){
        System.out.println(" ╚═════════════════════════════════════════════════════╝ ");
    }

    public void userMenu(){
        System.out.println(" ╔═════════════════════════════════════════════════════╗ ");
        System.out.println("                                                         ");
        System.out.println("                       ※ 사용자 ※                         ");
        System.out.println("                                                         ");
        System.out.println("                       1) 충전                            ");
        System.out.println("                       2) 상품목록                        ");
        System.out.println("                       3) 장바구니                        ");
        System.out.println("                       4) 구매내역                        ");
        System.out.println("                       5) 로그아웃                        ");
        System.out.println(red+"                       6) 회원탈퇴                        " + exit);
        System.out.println("                                                         ");
        System.out.println(" ╚═════════════════════════════════════════════════════╝ ");
    }

    public void userCategory(){
        System.out.println(" ╔═════════════════════════════════════════════════════╗ ");
        System.out.println("                       ※ 카테고리 ※                        ");
        System.out.println("                                                         ");
        System.out.println("                        1) 가방                           ");
        System.out.println("                        2) 의류                           ");
        System.out.println("                        3) 신발                           ");
        System.out.println("                                                         ");
        System.out.println(" ╚═════════════════════════════════════════════════════╝ ");
    }

    public void productList(){
        System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
        System.out.println("                       ※ 상품목록 ※                         ");
        System.out.println();
        System.out.println("\tNO.\t[상품이름]\t[가격]\t[수량]\t[사이즈]");
    }

    public void productBuy() {

        System.out.println();
        System.out.println("   1) 구매\t 2) 장바구니에 넣기\t 3) 돌아가기");
        System.out.println();

    }

    public void cartList(){
        System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
        System.out.println("                       ※ 장바구니 ※                         ");
        System.out.println();
        System.out.println("\tNO.\t[상품이름]\t[가격]\t[사이즈]");
    }

    public void cartBuy() {

        System.out.println();
        System.out.println("   1) 상품 구매\t 2) 상품 삭제\t 3) 돌아가기");
        System.out.println();

    }

    public void buyList(){
        System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
        System.out.println("                       ※ 구매내역 ※                         ");
        System.out.println();
        System.out.println("\tNO.\t[상품이름]\t[가격]\t[사이즈]");
    }

    public void close(){
        System.out.println(" ╭━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╮ ");
        System.out.println("                                                         ");
        System.out.println("                ["+" 감사합니다. 안녕히가세요."+"]            ");
        System.out.println("                                                         ");
        System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
    }
}
