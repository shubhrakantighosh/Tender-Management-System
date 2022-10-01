package com.masai.startapplication;

import com.masai.usecases.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        while (true){

            System.out.println("LogIn Administrator : 1 ");
            System.out.println("LogIn Vendor : 2 ");
            System.out.println("Exit : 3");

            int userInput=scanner.nextInt();

            if (userInput==3){
                break;
            }

            if (userInput==1){

                Boolean result=new AdministratorLogin().adminLogIn();

                if (result){

                    while (true){

                        System.out.println("Register new Vendor : 1");
                        System.out.println("View all the vendors : 2");
                        System.out.println("Create new tenders : 3");
                        System.out.println("View All the Tenders : 4");
                        System.out.println("View All the Bids of a tender : 5 ");
                        System.out.println("Assign tender to a vendor : 6");
                        System.out.println("Exit : 6");

                        int userAdminInput=scanner.nextInt();

                        if (userAdminInput==6){
                            break;
                        }

                        switch (userAdminInput){

                            case 1:
                                new CreateVendor().adminCreateVendor();
                                break;

                            case 2:
                                new ShowAllVendors().adminShowAllVendors();
                                break;

                            case 3:
                                new CreateTender().adminCreateTender();
                                break;

                            case 4:
                                new AdministratorShowAllTenders().adminShowAllTenders();
                                break;

                            case 5:
                                new AssignTender().adminAssignTender();
                                break;

                            default:
                                System.out.println("Wrong Key");
                                break;

                        }

                    }

                }

            } else if (userInput==2) {

                Boolean result=new VendorLogIn().vendorLogin();

                if (result){

                    while (true){

                        System.out.println("View all the current Tenders : 1");
                        System.out.println("Place a Bid against a Tender : 2");
                        System.out.println("Assign tender to a vendor : 3");
                        System.out.println("View his own Bid History : 4");
                        System.out.println("Exit : 5");

                        int userVendorInput=scanner.nextInt();

                        if (userVendorInput==5){
                            break;
                        }

                        switch (userVendorInput){

                            case 1:
                                new VendorShowAllTenders().vendorAllTenders();
                                break;

                            case 2:
                                new PlaceBidAgainstTender().placeBid();
                                break;

                            case 3:
                                new CreateTender().adminCreateTender();
                                break;

                            case 4:
                                new VendorBidHistory().bidHistory();
                                break;

                            default:
                                System.out.println("Wrong Key");
                                break;

                        }

                    }

                }


            }else System.out.println("Entered Wrong Key");
        }
    }
}
