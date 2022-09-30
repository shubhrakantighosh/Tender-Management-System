package com.masai.usecases;

import com.masai.bean.Tender;
import com.masai.dao.TenderManagementAdminDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class AssignTender {
    public void adminAssignTender(){

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Tender ID : ");
            int tenderID=scanner.nextInt();
            System.out.println("Enter Vendor ID : ");
            int vendorID=scanner.nextInt();
            Tender tender=new Tender();
            tender.setTenderID(tenderID);
            tender.setVendorID(vendorID);

            String result=new TenderManagementAdminDaoImpl().assignTenderToVendor(tender);
            System.out.println(result);

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }

    }
}
