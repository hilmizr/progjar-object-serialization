package com.objectmessage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hp
 */
import java.io.Serializable;

public class Person implements Serializable {
        private String fullname;
        private int age;
        
        public String getFullname() {
            return fullname;
        }
        
        public void setFullname(String fullname) {
            this.fullname = fullname;
        }
        
        public int getAge() {
            return age;
        }
        
        public void setAge(int age) {
            this.age = age;
        }
}

