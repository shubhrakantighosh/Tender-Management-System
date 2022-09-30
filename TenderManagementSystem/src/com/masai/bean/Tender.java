package com.masai.bean;

public class Tender {
    private int TenderID;
    private String BidName;
    private int BidPrice;
    private int VendorID;

    public int getTenderID() {
        return TenderID;
    }

    public void setTenderID(int tenderID) {
        TenderID = tenderID;
    }

    public String getBidName() {
        return BidName;
    }

    public void setBidName(String bidName) {
        BidName = bidName;
    }

    public int getBidPrice() {
        return BidPrice;
    }

    public void setBidPrice(int bidPrice) {
        BidPrice = bidPrice;
    }

    public int getVendorID() {
        return VendorID;
    }

    public void setVendorID(int vendorID) {
        VendorID = vendorID;
    }

    public Tender(int tenderID, String bidName, int bidPrice, int vendorID) {
        TenderID = tenderID;
        BidName = bidName;
        BidPrice = bidPrice;
        VendorID = vendorID;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "TenderID=" + TenderID +
                ", BidName='" + BidName + '\'' +
                ", BidPrice=" + BidPrice +
                ", VendorID=" + VendorID +
                '}';
    }

    public Tender() {

    }
}
