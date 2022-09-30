package com.masai.usecases;

import com.masai.bean.Tender;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class CreateTender {
    public void adminCreateTender() {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Bid Name : ");
            String bidName=scanner.nextLine();
            System.out.println("Enter Bid Price : ");
            int bidPrice=scanner.nextInt();

            Tender tender=new Tender();
            tender.setBidName(bidName);
            tender.setBidPrice(bidPrice);

            String result=new TenderManagementDaoImpl().createTender(tender);
            System.out.println(result);

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }
    }
}
