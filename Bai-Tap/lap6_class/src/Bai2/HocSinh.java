/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author ASUS
 */
public class HocSinh {
    private String name ;
    private String address ;
    private String parentName ;
    private String contactNo ;
    private String Standard ;
    private Double fee ;
    
    public HocSinh(){}

    public HocSinh(String name, String address, String parentName, String contactNo, String Standard, Double fee) {
        this.name = name;
        this.address = address;
        this.parentName = parentName;
        this.contactNo = contactNo;
        this.Standard = Standard;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String Standard) {
        this.Standard = Standard;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
    
    
}
