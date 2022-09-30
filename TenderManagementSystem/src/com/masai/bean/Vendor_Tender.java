package com.masai.bean;

public class Vendor_Tender {
    private int VendorID;
    private int TenderID;
    private int price;

    public int getVendorID() {
        return VendorID;
    }

    public void setVendorID(int vendorID) {
        VendorID = vendorID;
    }

    public int getTenderID() {
        return TenderID;
    }

    public void setTenderID(int tenderID) {
        TenderID = tenderID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Vendor_Tender(int vendorID, int tenderID, int price) {
        VendorID = vendorID;
        TenderID = tenderID;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vendor_Tender{" +
                "VendorID=" + VendorID +
                ", TenderID=" + TenderID +
                ", price=" + price +
                '}';
    }

    public Vendor_Tender() {

    }
}
