package model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceHeader {
   //Data field parameter/members
    private int invoiceNum;
    private Date invoiceDate;
    private String customerName;
    // ArrayList[InvoiceLines];

    //Default constructor
    public InvoiceHeader(){
    }
    //another constructor with members field
    public InvoiceHeader(int invoiceNum,String customerName) {
        this.invoiceNum = invoiceNum;
        this.customerName = customerName;
    }

    //getter and setter InvoiceNum
    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
    //getter and setter CustomerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    // //getter  getDate  ,setter Automatic
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate= DateFor.format(date);
        return stringDate;
    }
    public String getHeader(){
        return  "Invoice"+getInvoiceNum()+"Num   "+"\nInvoice"+getInvoiceNum()+"Date ("+getDate()+")  "+getCustomerName()+"\n {";
    }
    public void setHeader(int invoiceNum,String customerName){
        this.invoiceNum=invoiceNum;
        this.customerName=customerName;

    }

}
