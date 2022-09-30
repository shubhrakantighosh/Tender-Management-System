package com.masai.usecases;

import com.masai.bean.Vendor_Tender;
import com.masai.dao.TenderManagementDao;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class PlaceBidAgainstTender {
    public void placeBid() {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Vendor ID :");
            int vendorID=scanner.nextInt();
            System.out.println("Enter Tender ID :");
            int tenderID=scanner.nextInt();
            System.out.println("Enter Price :");
            int price=scanner.nextInt();

            Vendor_Tender vendor_tender=new Vendor_Tender(vendorID,tenderID,price);

            String result=new TenderManagementDaoImpl().placeBidAgainstTender(vendor_tender);
            System.out.println(result);

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }

    }
}
