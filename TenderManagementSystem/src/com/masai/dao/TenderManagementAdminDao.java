package com.masai.dao;

import com.masai.bean.Administrator;
import com.masai.bean.Tender;
import com.masai.bean.Vendor;
import com.masai.exceptions.TenderManagementException;

import java.util.List;

public interface TenderManagementAdminDao {

    public String administratorLogIn(Administrator administrator) throws TenderManagementException;
    public String createVendor(Vendor vendor) throws TenderManagementException;
    public List<Vendor> showAllVendors() throws TenderManagementException;
    public String createTender(Tender tender) throws TenderManagementException;
    public List<Tender> showAllTenders() throws TenderManagementException;
    public String assignTenderToVendor(Tender tender) throws TenderManagementException;
}
