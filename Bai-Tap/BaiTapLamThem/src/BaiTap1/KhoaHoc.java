/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap1;

/**
 *
 * @author ASUS
 */
public class KhoaHoc {
    private String MaKH ;
    private String TenKH ;
    private float HocPhi ;
    private int ThoiGian ;

    public KhoaHoc(){}
    
    public KhoaHoc(String MaKH, String TenKH, float HocPhi, int ThoiGian) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.HocPhi = HocPhi;
        this.ThoiGian = ThoiGian;
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

    public float getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(float HocPhi) {
        this.HocPhi = HocPhi;
    }

    public int getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(int ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    @Override
    public String toString() {
        return  MaKH;
    }

        
    
}
