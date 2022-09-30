package com.masai.usecases;

import com.masai.bean.Tender;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.List;

public class VendorShowAllTenders {
    public void vendorAllTenders() {

        try {
            List<Tender> tenders=new TenderManagementDaoImpl().showAllTenders();
            for (Tender tender:tenders){

                if(tender.getVendorID()==0) {
                    System.out.println("Tender ID : " + tender.getTenderID());
                    System.out.println("Tender Name : " + tender.getBidName());
                    System.out.println("Tender Price : " + tender.getBidPrice());
                    System.out.println("Tender Status : Available");
                    System.out.println("<---------------------------->");
                }
            }
        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
