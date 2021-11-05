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
public class ThongTinSP {
    private String MaSP ;
    private String TenSP ;
    private String DVT ;
    private Double DonGia ;
    private String NhaCC ;

    public ThongTinSP(){
    
    }
    
    public ThongTinSP(String MaSP, String TenSP, String DVT, Double DonGia, String NhaCC) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DVT = DVT;
        this.DonGia = DonGia;
        this.NhaCC = NhaCC;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public Double getDonGia() {
        return DonGia;
    }

    public void setDonGia(Double DonGia) {
        this.DonGia = DonGia;
    }

    public String getNhaCC() {
        return NhaCC;
    }

    public void setNhaCC(String NhaCC) {
        this.NhaCC = NhaCC;
    }
    
    
}
