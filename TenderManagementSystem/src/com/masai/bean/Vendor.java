package com.masai.bean;

public class Vendor {

    private int vendorID;
    private String vendorName;
    private String username;
    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Vendor(int vendorID, String vendorName, String username, String password) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorID=" + vendorID +
                ", vendorName='" + vendorName + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Vendor() {

    }
}
