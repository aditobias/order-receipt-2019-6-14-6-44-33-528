package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final char TAB = '\t';
    public static final char NEW_LINE = '\n';
    public static final double SALE_TAX_PERCENTAGE = .10;
    private Order order;
    private StringBuilder receipt = new StringBuilder();

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        double totalSalesTax = 0d;
        double total = 0d;

        receipt.append("======Printing Orders======\n");

//        output.append("Date - " + order.getDate();
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        for (LineItem lineItem : order.getLineItemList()) {
            generateReceiptProductList(lineItem);
            totalSalesTax += calculateSalesTax(lineItem);
            total += lineItem.totalAmount() + calculateSalesTax(lineItem);
        }

        receipt.append("Sales Tax").append(TAB).append(totalSalesTax);
        receipt.append("Total Amount").append(TAB).append(total);

        return receipt.toString();
    }

    private void generateReceiptProductList(LineItem lineItem) {
        receipt.append(lineItem.getDescription()).append(TAB);
        receipt.append(lineItem.getPrice()).append(TAB);
        receipt.append(lineItem.getQuantity()).append(TAB);
        receipt.append(lineItem.totalAmount()).append(NEW_LINE);
    }

    private double calculateSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * SALE_TAX_PERCENTAGE;
    }
}