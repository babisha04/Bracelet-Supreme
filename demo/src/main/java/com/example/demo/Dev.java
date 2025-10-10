package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {
  @Autowired                    // Field Injection
    private Computer comp;

  /*  public Dev(Laptop laptop) {     // Constructor Injection
        this.laptop = laptop;
    }*/
   /* @Autowired               //  Setter Injection
    public void setLaptop(Laptop laptop){
        this.laptop=laptop;
    }*/

    public void build(){
        comp.compile();
        System.out.println("working on a awesome project");
    }
}