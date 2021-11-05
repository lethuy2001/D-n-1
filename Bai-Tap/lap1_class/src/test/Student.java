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
public abstract class Student implements SV_Interface{
        private String ID ;
    private String name ;
    private String national ;

    public Student(){
    
    }
    
    public Student(String ID, String name, String national) {
        this.ID = ID;
        this.name = name;
        this.national = national;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }
    
    public abstract double getDiemTB() ;
    
    public void Input(){
        Scanner sk = new Scanner(System.in);
        System.out.println("Nhập ID: ");
        ID = sk.nextLine();
        
        System.out.println("Nhập Tên: ");
        name = sk.nextLine();
        
        System.out.println("Nhập national: ");
        national = sk.nextLine();
    }

    public void Output(){
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "Student{" + "ID=" + ID + ", name=" + name + ", national=" + national + '}';
    }
}
