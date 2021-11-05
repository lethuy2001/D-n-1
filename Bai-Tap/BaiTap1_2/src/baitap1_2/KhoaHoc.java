/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap1_2;

/**
 *
 * @author ASUS
 */
public class KhoaHoc {
    private String MaKH ;
    private String TenKH ;

    public KhoaHoc(){
    
    }
    
    public KhoaHoc(String MaKH, String TenKH) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
    }
    
    

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    @Override
    public String toString() {
        return MaKH;
    }
    
    
}
