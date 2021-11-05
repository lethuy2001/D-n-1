/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

/**
 *
 * @author ASUS
 */
public class DiemSinhVien {
    private String MaSV ;
    private String Hoten ;
    private Double TiengAnh ;
    private Double TinHoc ;
    private Double GiaoDuc ;
    
    public DiemSinhVien(){}

    public DiemSinhVien(String MaSV, String Hoten, Double TiengAnh, Double TinHoc, Double GiaoDuc) {
        this.MaSV = MaSV;
        this.Hoten = Hoten;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GiaoDuc = GiaoDuc;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public Double getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(Double TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public Double getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(Double TinHoc) {
        this.TinHoc = TinHoc;
    }

    public Double getGiaoDuc() {
        return GiaoDuc;
    }

    public void setGiaoDuc(Double GiaoDuc) {
        this.GiaoDuc = GiaoDuc;
    }
    
    public Double getDiemTB(){
        return Math.ceil( (TiengAnh + TinHoc + GiaoDuc ) / 3 * 100) / 100 ;
    }
}
