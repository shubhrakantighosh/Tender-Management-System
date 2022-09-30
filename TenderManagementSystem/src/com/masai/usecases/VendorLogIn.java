package com.masai.usecases;

import com.masai.bean.Vendor;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class VendorLogIn {
    public boolean vendorLogin() {
        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Vendor ID : ");
            int vendorID=scanner.nextInt();
            System.out.println("Enter Username : ");
            String userName=scanner.next();
            System.out.println("Enter Password : ");
            String password=scanner.next();

            Vendor vendor=new Vendor();
            vendor.setVendorID(vendorID);
            vendor.setUsername(userName);
            vendor.setPassword(password);

            String message=new TenderManagementDaoImpl().vendorLogIn(vendor);
            System.out.println(message);

            if (message.equalsIgnoreCase("Login Successfully")){
                return true;
            }

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
