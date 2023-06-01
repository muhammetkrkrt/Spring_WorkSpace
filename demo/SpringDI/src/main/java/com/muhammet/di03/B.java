package com.muhammet.di03;

public class B {

    A a;

    public  B(){
        a = new A();
    }

    public void print(){
        System.out.println(a.getMessage());
    }
}
