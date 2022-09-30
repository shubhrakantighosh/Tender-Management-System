package com.masai.usecases;

import com.masai.bean.Vendor;
import com.masai.dao.TenderManagementAdminDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class CreateVendor {
    public void adminCreateVendor() {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Your Vendor Name : ");
            String vendorName=scanner.nextLine();

            Vendor vendor=new Vendor();
            vendor.setVendorName(vendorName);
            String result = new TenderManagementAdminDaoImpl().createVendor(vendor);

            System.out.println(result);

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
