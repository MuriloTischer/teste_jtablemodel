/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xmuproject.teste_jtablemodel;

import com.xmuproject.teste_jtablemodel.model.SocioTableModelTest;

import java.awt.EventQueue;

/**
 *
 * @author muuti
 */
public class Main {
       public static void main(String[] args) {
           EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SocioTableModelTest().setVisible(true);
            }
        });
    }
}
