package model;

import javax.swing.*;
import java.util.Arrays;

public class InvoiceLine extends InvoiceHeader  {
    InvoiceHeader header1 = new InvoiceHeader();
    private String itemName;
    private int itemPrice;
    private int count;

    public InvoiceLine() {

    }

    public InvoiceLine(int invoiceNum, String customerName, String itemName, int itemPrice, int count) {
        setInvoiceNum(invoiceNum);
        setCustomerName(customerName);
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    //getter and setter ItemName
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    //getter and setter ItemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    //getter and setter Count
    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }


    //step 1 create Class Item
    public Object getItem () {
        int count,i = 0;
        String [][] data= {
                {"Item1Name", "Item1Price", "Count1"},
                {"Item2Name", "Item2Price", "Count2"},
                {"Item3Name", "Item3Price", "Count3"}};
        for( i=0;i < data.length;i++)
            System.out.println(Arrays.toString(data[i]));
       return "." + "\n." +"\n."+"\n}";
    }
}