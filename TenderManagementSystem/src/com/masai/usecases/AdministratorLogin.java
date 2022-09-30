package com.masai.usecases;

import com.masai.bean.Administrator;
import com.masai.dao.TenderManagementAdminDao;
import com.masai.dao.TenderManagementAdminDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class AdministratorLogin {
    public boolean adminLogIn() {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter User Name : ");
            String userName=scanner.next();
            System.out.println("Enter Password : ");
            String password=scanner.next();

            Administrator administrator=new Administrator(userName,password);

            String message=new TenderManagementAdminDaoImpl().administratorLogIn(administrator);
            System.out.println(message);

            if (message.equalsIgnoreCase("Administrator Login Successfully")){
                return true;
            }

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
