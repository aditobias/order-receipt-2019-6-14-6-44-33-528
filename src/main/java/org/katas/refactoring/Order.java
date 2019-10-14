package org.katas.refactoring;

import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<LineItem> lineItemList;

    public Order(String name, String address, List<LineItem> lineItemList) {
        this.name = name;
        this.address = address;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }
}
