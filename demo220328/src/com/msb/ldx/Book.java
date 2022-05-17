package com.msb.ldx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {

    static class BookInfo{
        int id;
        String name;
        float price;

        @Override
        public String toString() {
            return id +
                    "\t\t" + name +
                    "\t\t" + price;
        }

        public BookInfo(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    //存放我们系统所有的书籍
    static List<BookInfo> list = new ArrayList<>();

    static {
        list.add( new BookInfo(1,"水浒传" , 22));
        list.add( new BookInfo(2,"西游记" , 224));
        list.add( new BookInfo(3,"三国演义" , 24));
        list.add( new BookInfo(4,"红楼梦" , 124));
    }

    public static void main(String[] args) {

        System.out.println("欢迎使用xx的图书管理系统");
        System.out.println("------谁谁谁开发的");

        //Java知识点 : 方法;
        startManager();//开始我们的图书管理系统
    }

    /**
     * 方法 : 就是我做一大堆事情; 别人去使用就行了
     */
    private static void startManager() {

        //展示菜单
        showMenu();

        //进行功能选择
        功能选择();
    }

    private static void 功能选择() {
        System.out.println("----请选择你要执行的功能:");

        //从控制台里面接受你输入的信息
        Scanner scanner = new Scanner(System.in);
        //变量
        int choose = scanner.nextInt();

        //推荐大家使用swtich case
        switch (choose){
            case 1 : login(); break;
            case 2 : showBook(); break;
            case 3 : 借书(); break;
            case 4 : 还书(); break;
            default: 功能选择(); //递归
        }
    }

    private static void 还书() {

    }

    private static void 借书() {

    }

    private static void showBook() {
        System.out.println("展示系统里面所有的书籍信息-----------");

        System.out.println("编号\t\t名字\t\t价格");
        //我们所有的书籍信息
        for(BookInfo bi : list){
            System.out.println(bi);
        }

        功能选择();
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的用户名:");
        String name = scanner.nextLine();
        System.out.println("请输入你的密码:");
        String pass = scanner.nextLine();

        //针对用户名和密码的正确新去做校验
        if("jack".equals(name) && "123456".equals(pass)){
            System.out.println("登录成功");
            功能选择();
        }else{
            System.out.println("登录失败");
            login();
        }
    }


    //展示菜单
    private static void showMenu() {
        System.out.println("-----------");
        System.out.println("1: 登录");
        System.out.println("2: 查看书籍");
        System.out.println("3: 借阅书籍");
        System.out.println("4: 归还书籍");
        System.out.println("5: 退出程序");
        System.out.println("-----------");
    }
}
