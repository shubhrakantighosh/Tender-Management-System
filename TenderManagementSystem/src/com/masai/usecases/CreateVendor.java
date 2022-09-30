package com.masai.usecases;

import com.masai.bean.Vendor;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class CreateVendor {
    public void adminCreateVendor() {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Vendor Name :");
            String vendorName=scanner.nextLine();
            System.out.println("Enter Vendor Username :");
            String username=scanner.next();
            System.out.println("Enter Password");
            String password=scanner.next();

            Vendor vendor=new Vendor();
            vendor.setVendorName(vendorName);
            vendor.setUsername(username);
            vendor.setPassword(password);
            String result = new TenderManagementDaoImpl().createVendor(vendor);

            System.out.println(result);

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
