package com.masai.dao;

import com.masai.Utility.DBUtil;
import com.masai.bean.Administrator;
import com.masai.bean.Tender;
import com.masai.bean.Vendor;
import com.masai.bean.Vendor_Tender;
import com.masai.exceptions.TenderManagementException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TenderManagementDaoImpl implements TenderManagementDao {

    @Override
    public String administratorLogIn(Administrator administrator) throws TenderManagementException {
        String message="Wrong Username Or Password";

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(" select if(Username=? AND Password=?, 'Yes', 'No')Result from Administrator");
            preparedStatement.setString(1,administrator.getUsername());
            preparedStatement.setString(2,administrator.getPassword());

            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                String result=resultSet.getString("Result");
                if (result.equalsIgnoreCase("Yes")){
                    message="Login Successfully";
                }
            }

        } catch (SQLException sqlException) {
            throw new TenderManagementException(sqlException.getMessage());
        }

        return message;
    }

    @Override
    public String createVendor(Vendor vendor) throws TenderManagementException {
        String message="Vendor Not Added";

        try (Connection connection =new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into Vendors (VendorName , Username , Password) VALUES(?,?,?);");
            preparedStatement.setString(1,vendor.getVendorName());
            preparedStatement.setString(2,vendor.getUsername());
            preparedStatement.setString(3,vendor.getPassword());

            if(preparedStatement.executeUpdate()>0){
                message="Vendor Added";
            }

        } catch (SQLException sqlException) {
            throw new TenderManagementException(sqlException.getMessage());
        }

        return message;
    }

    @Override
    public List<Vendor> showAllVendors() throws TenderManagementException {
        List<Vendor>vendors=null;

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement("select vendorID, VendorName from Vendors;");
            ResultSet resultSet=preparedStatement.executeQuery();
            vendors=new ArrayList<>();
            while (resultSet.next()){
                Vendor vendor=new Vendor();
                vendor.setVendorID(resultSet.getInt("vendorID"));
                vendor.setVendorName(resultSet.getString("VendorName"));
                vendors.add(vendor);
            }

        } catch (SQLException sqlException) {
            throw new TenderManagementException(sqlException.getMessage());
        }

        return vendors;
    }

    @Override
    public String createTender(Tender tender) throws TenderManagementException {
        String message="Not Added";

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into Tenders (BidName,BidPrice,VendorID) values (?,?,null);");
            preparedStatement.setString(1,tender.getBidName());
            preparedStatement.setInt(2,tender.getBidPrice());

            if (preparedStatement.executeUpdate()>0){
                message="Tender Added";
            }

        } catch (SQLException sqlException) {
            throw new TenderManagementException(sqlException.getMessage());
        }
        return message;
    }

    @Override
    public List<Tender> showAllTenders() throws TenderManagementException {
        List<Tender>tenders=null;

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from Tenders;");
            ResultSet resultSet=preparedStatement.executeQuery();
            tenders=new ArrayList<>();
            while (resultSet.next()){
                Tender tender=new Tender();
                tender.setTenderID(resultSet.getInt("TenderID"));
                tender.setBidName(resultSet.getString("BidName"));
                tender.setBidPrice(resultSet.getInt("BidPrice"));
                tender.setVendorID(resultSet.getInt("VendorID"));
                tenders.add(tender);
            }

        } catch (SQLException sqlException) {
            throw new TenderManagementException(sqlException.getMessage());
        }

        return tenders;
    }

    @Override
    public String assignTenderToVendor(Tender tender) throws TenderManagementException {
        String message="Not Assign";

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement("update Tenders set VendorID=? where TenderId=?;");
            preparedStatement.setInt(1,tender.getVendorID());
            preparedStatement.setInt(2,tender.getTenderID());

            if (preparedStatement.executeUpdate()>0){
                message="Assign Tender ID : "+tender.getTenderID()+" to Vendor ID : "+tender.getVendorID();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return message;
    }

    @Override
    public String vendorLogIn(Vendor vendor) throws TenderManagementException {
        String message="Wrong Username Or Password";

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(" select if(Username=? AND Password=?, 'Yes', 'No')Result from Vendors where vendorID=?;");
            preparedStatement.setString(1,vendor.getUsername());
            preparedStatement.setString(2,vendor.getPassword());
            preparedStatement.setInt(3,vendor.getVendorID());

            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                String result=resultSet.getString("Result");
                if (result.equalsIgnoreCase("Yes")){
                    message="Login Successfully";
                }
            }

        } catch (SQLException sqlException) {
            throw new TenderManagementException(sqlException.getMessage());
        }

        return message;
    }

    @Override
    public String placeBidAgainstTender(Vendor_Tender vendor_tender) throws TenderManagementException {
        String message="Not assign to Bid";

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into Vendor_Tender VALUES (?,?,?);");
            preparedStatement.setInt(1,vendor_tender.getVendorID());
            preparedStatement.setInt(2,vendor_tender.getTenderID());
            preparedStatement.setInt(3,vendor_tender.getPrice());

            if (preparedStatement.executeUpdate()>0)
                message="Vendor ID :"+vendor_tender.getVendorID() +", Place a Bid against a Tender : "+vendor_tender.getTenderID();

        } catch (SQLException sqlException) {
            throw new TenderManagementException(sqlException.getMessage());
        }

        return message;
    }

    @Override
    public String statusOfBid(Vendor_Tender vendor_tender) throws TenderManagementException {
        String message="";

        try (Connection connection=new DBUtil().provideConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement("select vendorID from tenders where tenderid in(select tenderid from vendor_tender where tenders.tenderid=vendor_tender.?);");
            preparedStatement.setInt(1,vendor_tender.getTenderID());

            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return message;
    }

}
