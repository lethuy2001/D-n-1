/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poly2;

/**
 *
 * @author ASUS
 */
public class SinhVien {
    private String Ma ;
    private String HoTen ;
    private int tuoi ;

    public SinhVien(){}
    
    public SinhVien(String Ma, String HoTen, int tuoi) {
        this.Ma = Ma;
        this.HoTen = HoTen;
        this.tuoi = tuoi;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return Ma;
    }
    
    
}
