package com.masai.usecases;

import com.masai.bean.Vendor_Tender;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.List;
import java.util.Scanner;

public class VendorBidHistory {
    public void bidHistory() {
        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Vendor ID :");
            int vendorID=scanner.nextInt();

            Vendor_Tender vendor_tender=new Vendor_Tender();
            vendor_tender.setVendorID(vendorID);

            List<Vendor_Tender>tenderList=new TenderManagementDaoImpl().vendorBidHistory(vendor_tender);

            if(tenderList==null) {

                System.out.println("Vendor ID :" + vendorID + ", All the Bid History of tender ");
                for (Vendor_Tender vendorTender : tenderList) {
                    System.out.println(vendorTender.getTenderID());
                }
            }else System.out.println("Doesn't not exit Or No bid history");

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
