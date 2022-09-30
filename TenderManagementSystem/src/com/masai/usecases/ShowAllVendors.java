package com.masai.usecases;

import com.masai.bean.Vendor;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.List;

public class ShowAllVendors {
    public void adminShowAllVendors() {

        try {
            List<Vendor> vendors=new TenderManagementDaoImpl().showAllVendors();
            for (Vendor vendor:vendors){
                System.out.println("Vendor ID : "+vendor.getVendorID());
                System.out.println("Vendor Name : "+vendor.getVendorName());
                System.out.println("<---------------------------->");
            }
        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
