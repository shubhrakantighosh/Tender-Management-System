package com.masai.dao;

import com.masai.bean.Administrator;
import com.masai.bean.Tender;
import com.masai.bean.Vendor;
import com.masai.bean.Vendor_Tender;
import com.masai.exceptions.TenderManagementException;

import java.util.List;

public interface TenderManagementDao {

    public String administratorLogIn(Administrator administrator) throws TenderManagementException;
    public String createVendor(Vendor vendor) throws TenderManagementException;
    public List<Vendor> showAllVendors() throws TenderManagementException;
    public String createTender(Tender tender) throws TenderManagementException;
    public List<Tender> showAllTenders() throws TenderManagementException;
    public String assignTenderToVendor(Tender tender) throws TenderManagementException;
    public String vendorLogIn(Vendor vendor) throws TenderManagementException;
    public String placeBidAgainstTender(Vendor_Tender vendor_tender) throws TenderManagementException;
    public String statusOfBid(Vendor_Tender vendor_tender) throws TenderManagementException;
    public List<Vendor_Tender> vendorBidHistory(Vendor_Tender vendor_tender) throws TenderManagementException;

}
