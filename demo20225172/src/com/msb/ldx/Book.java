package com.msb.ldx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
//静态内部类
    static class BookInfo{
        int id;
        String name;
        float price;

    @Override
    public String toString() {
        return
                id +
                "\t\t" + name + "\t\t" +
                 price
                ;
    }


    public BookInfo(int id,String name,float price){
        this.id =id;
        this.name=name;
        this.price=price;
    }

}
//存放系统所有书籍
    static List<BookInfo> list =new ArrayList<>();
    //静态代码块
    static {

        list.add( new BookInfo(1,"水浒传", 22));
        list.add( new BookInfo(2,"西游记",23));
        list.add( new BookInfo(3,"红楼梦",24));


    }



    public static void main(String[] args) {
        System.out.println("欢迎使用图书管理系统");
        System.out.println("----作者：zsh");

        //方法
        startManager(); //开始我们的系统
    }

    private static void startManager() {
        //展示菜单
        showMenu();

        //功能选择
        choose();
    }

    private static void choose() {
        System.out.println("选择你要执行的功能：");
        Scanner scanner = new Scanner(System.in);

        int choose1= scanner.nextInt();

        System.out.println("你选择的功能是：" + choose1);

//        if (choose1 !=5){
//            choose();
//        }

        switch (choose1){
            case 1 :login(); break;
            case 2 :showbook(); break;
            case 3 :jbook(); break;
            case 4 :hbook(); break;
            default:choose(); //递归
        }
    }

    private static void hbook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你还书的id");
        int id2= scanner.nextInt();
        int id3=id2-1;
        switch (id3){
            case 0:list.add( new BookInfo(1,"水浒传", 22));break;
            case 1:list.add( new BookInfo(2,"西游记",23));break;
            case 2:list.add( new BookInfo(3,"红楼梦",24));break;
            default:
                System.out.println("该id不存在");;
        }
        showbook();


    }

    private static void jbook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你想借的书的id");
        int id1= scanner.nextInt();
        if (list.size()<id1){
            System.out.println("该id不存在");
        }else {
            list.remove(id1-1);
            System.out.println("以借出，剩余书为");
            showbook();
        }


    }

    private static void showbook() {
        System.out.println("所有书籍-------");
        System.out.println("编号名字价格");
        for(BookInfo bi: list){
            System.out.println(bi);
        }
        choose();
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入用户名");

        String name = scanner.nextLine();

        System.out.println("输入密码");

        String pass = scanner.nextLine();


        if("zsh".equals(name) && "123456".equals(pass)){
            System.out.println("登陆成功");
            choose();
        }
        else{
            System.out.println("登陆失败");
            login();
        }

        //后期用数据库
    }

    private static void showMenu() {
        System.out.println("-----");
        System.out.println("1.登陆");
        System.out.println("2.查看书籍");
        System.out.println("3.借阅书籍");
        System.out.println("4.归还书籍");
        System.out.println("5.退出程序");
        System.out.println("---------");

    }
}
