/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide5_class;

/**
 *
 * @author ASUS
 */
public class HocSinh {
    private String MaSV ;
    private String HoTen ;
    private String GioiTinh ;
    private Float Diem ;

    public HocSinh(){
    }
    
    public HocSinh(String MaSV, String HoTen, String GioiTinh, Float Diem) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.Diem = Diem;
    }

    
    
    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Float getDiem() {
        return Diem;
    }

    public void setDiem(Float Diem) {
        this.Diem = Diem;
    }

    @Override
    public String toString() {
        return MaSV;
    }
    
    
}
