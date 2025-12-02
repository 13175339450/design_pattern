package com.hxl.proxy.entity;

/**
 * 房东2
 * @author hengxiaoliang
 */
public class HouseOwnerTwo implements HouseTransaction{

    // 房东姓名
    private String name;

    // 房子地址
    private String houseAddress;

    // 房子价格
    private Double price;

    public HouseOwnerTwo(String name, String houseAddress, Double price) {
        this.name = name;
        this.houseAddress = houseAddress;
        this.price = price;
    }

    @Override
    public void viewHouse() {
        System.out.println("房主 " + name + " 带您看 " + houseAddress + " 的房子");
        System.out.println("房主说：这房子采光很好，价格是 " + price + " 万");
    }

    @Override
    public void makeDeal() {
        System.out.println("与房主 " + name + " 直接交易");
        System.out.println("付款 " + price + " 万给房主");
        System.out.println("房主给您房产证");
    }
}
