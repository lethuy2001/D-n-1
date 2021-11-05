/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class StudentUD extends Student{
    private double  DiemJava ;
    private double DiemMod ;

    public StudentUD(){
         super();
    }

    public StudentUD(double DiemJava, double DiemMod, String ID, String name, String national) {
        super(ID, name, national);
        this.DiemJava = DiemJava;
        this.DiemMod = DiemMod;
    }
    
    public double getDiemJava() {
        return DiemJava;
    }

    public void setDiemJava(double DiemJava) {
        this.DiemJava = DiemJava;
    }

    public double getDiemMod() {
        return DiemMod;
    }

    public void setDiemMod(double DiemMod) {
        this.DiemMod = DiemMod;
    }
    
    public double getDiemTB(){
        return (DiemJava + DiemMod )/ 2 ;
    }
    
    @Override
    public void Input(){
        this.Input();
        Scanner sk = new  Scanner(System.in);
        System.out.println("Nhập Diểm Java: ");
        DiemJava = Double.parseDouble(sk.nextLine());
        
        System.out.println("Nhập điểm MoD: ");
        DiemMod = Double.parseDouble(sk.nextLine());
    }
    
    @Override
    public void Output(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "StudentUD{" + "DiemJava=" + DiemJava + ", DiemMod=" + DiemMod + '}';
    }   
}
