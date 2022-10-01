package com.masai.usecases;

import com.masai.bean.Vendor_Tender;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.List;
import java.util.Scanner;

public class AllTheBidATender {
    public void bidATender(){

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Tender ID : ");
            int tenderID=scanner.nextInt();
            Vendor_Tender vendorTender=new Vendor_Tender();
            vendorTender.setTenderID(tenderID);

            List<Vendor_Tender>vendorList=new TenderManagementDaoImpl().administratorViewAllTheBids(vendorTender);
            System.out.println("All the BId against the tender No "+tenderID);
            for (Vendor_Tender vendor:vendorList){
                System.out.println("Vendor ID : "+vendor.getVendorID()+",  Price :"+vendor.getPrice());
                System.out.println("<--------------------------->");
            }

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }

    }
}
