package com.masai.usecases;

import com.masai.bean.Tender;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.List;

public class AdministratorShowAllTenders {
    public void adminShowAllTenders() {
        try {
            List<Tender>tenders=new TenderManagementDaoImpl().showAllTenders();
            for (Tender tender:tenders){
                String message="";
                System.out.println("Tender ID : "+tender.getTenderID());
                System.out.println("Tender Name : "+tender.getBidName());
                System.out.println("Tender Price : "+tender.getBidPrice());
                int vendorID=tender.getVendorID();
                if(vendorID==0){
                    message="Available";
                }else {
                    message="Not Available, Already Assigned to VendorID : "+vendorID;
                }
                System.out.println("Tender Status : "+message);
                System.out.println("<---------------------------->");
            }
        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
