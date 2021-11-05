/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

/**
 *
 * @author ASUS
 */
public class TheLoai {
    private String MaTL , TenTL ;

    public TheLoai(){}
    
    public TheLoai(String MaTL, String TenTL) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    @Override
    public String toString() {
        return TenTL ;
    }
    
    
}
