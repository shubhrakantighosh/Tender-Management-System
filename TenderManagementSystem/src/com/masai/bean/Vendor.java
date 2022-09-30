package com.masai.bean;

public class Vendor {

    private int vendorID;
    private String vendorName;
    private String userName;
    private String password;
    private int tenderID;

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTenderID() {
        return tenderID;
    }

    public void setTenderID(int tenderID) {
        this.tenderID = tenderID;
    }

    public Vendor(int vendorID, String vendorName, String userName, String password, int tenderID) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.userName = userName;
        this.password = password;
        this.tenderID = tenderID;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorID=" + vendorID +
                ", vendorName='" + vendorName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tenderID=" + tenderID +
                '}';
    }

    public Vendor() {

    }
}
