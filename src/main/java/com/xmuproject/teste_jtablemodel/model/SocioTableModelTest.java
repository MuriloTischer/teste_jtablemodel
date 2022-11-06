/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xmuproject.teste_jtablemodel.model;

import com.xmuproject.teste_jtablemodel.MensalidadeCellRenderer;
import com.xmuproject.teste_jtablemodel.entity.Socio;
import com.xmuproject.teste_jtablemodel.model.SocioTableModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author muuti
 */
public class SocioTableModelTest extends JFrame {
    private JTable tblSocios;
    private SocioTableModel tableModel;
    
    public SocioTableModelTest(){
        super("SocioTableModelTest");
        initialize();
    }
    
    private void initialize(){
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new JScrollPane(getTblSocios()));
    }
    
    private JTable getTblSocios() {
        if (tblSocios == null) {
            tblSocios = new JTable();
            tblSocios.setModel(getTableModel());
            tblSocios.setDefaultRenderer(BigDecimal.class, new MensalidadeCellRenderer());
        }
        return tblSocios;
    }
 
    private SocioTableModel getTableModel() {
        if (tableModel == null) {
            tableModel = new SocioTableModel(criaSocios());
        }
        return tableModel;
    }
 
    // cria uma lista com 5 sócios meramente ilustrativos
    private List<Socio> criaSocios() {
        List<Socio> socios = new ArrayList<Socio>();
        for (int i = 1; i <= 5; i++) {
            Socio socio = new Socio();
            socio.setNome("Nome" + i);
            socio.setEndereco("Endereço" + i);
            socio.setAtivo(true);
            socio.setMensalidade(new BigDecimal(i * 10));
            socios.add(socio);
        }
        return socios;
    }
 
 
 

    
}
