/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

/**
 *
 * @author Sujeet
 */
public class Crudoperation {
    private int  id;
    private String fname;
    private int mark;

    public Crudoperation(int id, String fname, int mark) {
        super();
        this.id = id;
        this.fname = fname;
        this.mark = mark;
    }

    public Crudoperation(String fname, int mark) {
        super();
        this.fname = fname;
        this.mark = mark;
    }

    public Crudoperation() {
        super();
    }

    @Override
    public String toString() {
        return "Crudoperation{" + "id=" + id + ", fname=" + fname + ", mark=" + mark + '}';
    }

   

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public int getMark() {
        return mark;
    }
     public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    
    
    
    
}
