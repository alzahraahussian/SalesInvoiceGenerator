package model;

import javax.swing.*;
import java.io.IOException;

public class InvoiceTest  extends InvoiceLine{
    public static void main(String [] args) {

        InvoiceLine invoice1Num =new InvoiceLine();
        InvoiceLine invoice2Num =new InvoiceLine();
        InvoiceHeader invoice1Header=new InvoiceHeader();
        InvoiceHeader invoice2Header=new InvoiceHeader();
        //set invoice1 date
        invoice1Header.setHeader(1,"Zahraa");
        System.out.println(invoice1Header.getHeader());
        System.out.println(invoice1Num.getItem());
        //set invoice2 date
        invoice2Header.setHeader(2,"Talia");
        System.out.println(invoice2Header.getHeader());
        System.out.println(invoice2Num.getItem());

    }
}
