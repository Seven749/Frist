package level3;

import java.util.Scanner;

class Dishes {
    private String name;
    private int price;

    void show() {
        System.out.println(name + "\t" +price +"元");
    }

    void setName(String n) {
        name = n;
    }

    void setPrice(int p) {
        price = p;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
class Menu {
    Dishes dishes1 = new Dishes();
    Dishes dishes2 = new Dishes();
    Dishes dishes3 = new Dishes();
    Dishes dishes4 = new Dishes();
    Dishes dishes5 = new Dishes();
    Dishes dishes6 = new Dishes();
    void menuIn() {
        dishes1.setName("肥宅快乐堡");
        dishes1.setPrice(15);

        dishes2.setName("肥宅快乐条");
        dishes2.setPrice(7);

        dishes3.setName("肥宅快乐挞");
        dishes3.setPrice(7);

        dishes4.setName("肥宅快乐腿");
        dishes4.setPrice(9);

        dishes5.setName("肥宅快乐片");
        dishes5.setPrice(6);

        dishes6.setName("嘤料");
        dishes6.setPrice(5);
    }
    void menuOut() {
        dishes1.show();
        dishes2.show();
        dishes3.show();
        dishes4.show();
        dishes5.show();
        dishes6.show();
    }
}
class stringArrays {
    public String[] sort(String[] systemGet) {
        String cache;
        for(int x=0;x<systemGet.length;x++)
            for(int y=0;y<systemGet.length;y++){
                if(systemGet[x].compareTo(systemGet[y]) > 0){
                    cache=systemGet[x];
                    systemGet[x]=systemGet[y];
                    systemGet[y]=cache;
                }
            }
        return systemGet;
    }

}
class MenuAndPrice {
    Menu menuCache = new Menu();

    Integer menuOut (int number,int price) {
        switch (number) {
            case (1): {
                System.out.println("1*肥宅快乐堡 15元");
                price += 15;
                break;
            }
            case (2): {
                System.out.println("1*肥宅快乐条 7元");
                price += 7;
                break;
            }
            case (3): {
                System.out.println("1*肥宅快乐挞 7元");
                price = 7;
                break;
            }
            case (4):{
                System.out.println("1*肥宅快乐腿 9元");
                price += 9;
                break;
            }
            case (5): {
                System.out.println("1*肥宅快乐片 6元");
                price += 6;
                break;
            }
            case (6): {
                System.out.println("1*嘤料 5元");
                price += 5;
                break;
            }
        }
        return price;
    }
}
class RunSystem {
    Menu menuCache = new Menu();

    void first() {
        System.out.println(
                "欢迎来到樱花食间肥宅快乐家，" +
                "今日菜单是：");
    }
    boolean second() {
        System.out.println(
                "您还有什么需要补充的菜品吗？\n" +
                "1.需要\t" +
                "2.不需要");
        Scanner x = new Scanner(System.in);
        Integer isContinued = x.nextInt();
        if (isContinued == 1)
            return true;
        return false;
    }
    void menu() {
        menuCache.menuIn();
        menuCache.menuOut();
        /*System.out.println(
                "1.肥宅快乐堡 15元\n" +
                "2.肥宅快乐条 7元\n" +
                "3.肥宅快乐挞 7元\n" +
                "4.肥宅快乐腿 9元\n" +
                "5.肥宅快乐片 6元\n" +
                "6.嘤料 5元");
         */
    }
    String[] order() {
        System.out.println("输入您需要点的菜品序号");
        Scanner x = new Scanner(System.in);
        String input = x.nextLine();
        input = input.replaceAll("[^\\d+]", " ");
        String[] systemGet = input.split(" ");
        stringArrays cache = new stringArrays();
        systemGet = cache.sort(systemGet);
        return systemGet;
    }
    Integer totalFirst(String[] systemGet,int cache) {
        //int cache = 0;
        for (String stringNumber : systemGet) {
            int number = Integer.parseInt(stringNumber);
            MenuAndPrice userMenu = new MenuAndPrice();
            cache = userMenu.menuOut(number,cache);
            }
        return cache;
    }
    Integer totalSecond(String[] systemGet,int cache) {
        for (String stringNumber : systemGet) {
            int number = Integer.parseInt(stringNumber);
            MenuAndPrice userMenu = new MenuAndPrice();
            cache = userMenu.menuOut(number,cache);
        }
        return cache;
    }
    void collection(int cache) {
        System.out.println("请选择支付方式：\n" +
                "1.校园一卡通\t" +
                "2.支付宝\t" +
                "3.微信支付");
        Scanner x = new Scanner(System.in);
        Integer choice = x.nextInt();
        switch (choice) {
            case (1): {
                System.out.println("请刷卡.\n.\n....\n" +
                        "刷卡成功！");
                break;
            }
            case (2): {
                System.out.println("请出示二维码.\n.\n.\n....\n" +
                        "支付宝到账" + cache + "元");
                break;
            }
            case (3): {
                System.out.println("请出示二维码.\n.\n.\n....\n" +
                        "微信收款" + cache + "元");
                break;
            }
        }
    }

}
public class level3 {
    public static void main(String[] args) {
        RunSystem run = new RunSystem();
        run.first();
        run.menu();
        int cache =0;
        System.out.println("点单：");
        cache=run.totalFirst(run.order(),cache);
        System.out.println("现计" + cache + "元");
        if (run.second()) {
            run.menu();
            System.out.println("添加：");
            cache = run.totalSecond(run.order(),cache);
            System.out.println("合计" + cache + "元");
        }
        else
            System.out.println("合计" + cache + "元");
        run.collection(cache);
    }
}
