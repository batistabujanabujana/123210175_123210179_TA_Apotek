/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;
import dao.daoPetugas;
import dao.implementPetugas;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.m_petugas;
import model.tabelModelpetugas;
import view.Petugas;

import dao.daoPetugas;
import dao.implementPetugas;
import java.util.List;
import model.m_petugas;
import model.tabelModelpetugas;
import view.Petugas;
/**
 *
 * @author M S I
 */    

public class petugascontroller {
    Petugas p;
    implementPetugas imppet;
    List<m_petugas> at;

    
    public petugascontroller(Petugas p) {
        this.p = p;
       imppet= new daoPetugas(); 
        at = imppet.getAll();
//        this.lt = lt;
    }

    public petugascontroller() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void isiTable(){
        at = imppet.getAll();
      tabelModelpetugas tmp = new tabelModelpetugas(at);
 p.getTabelpetugas().setModel(tmp);
    }
    
    public void reset(){
        p.getTextidPetugas().setText(null);
        p.getTextnama().setText(null);
       p.getTextusername().setText(null);
   p.getTextpass().setText(null);

       
    }
    public void simpan(){
        m_petugas mob = new m_petugas();
        mob.setId_petugas(p.getTextidPetugas().getText());
        mob.setNama_petugas(p.getTextnama().getText());
        mob.setUsername(p.getTextusername().getText());
        mob.setPassword(p.getTextpass().getText());
        imppet.Simpan(mob);
    }
    
    public void ubah(){
          m_petugas mob = new m_petugas();
        mob.setId_petugas(p.getTextidPetugas().getText());
        mob.setNama_petugas(p.getTextnama().getText());
        mob.setUsername(p.getTextusername().getText());
        mob.setPassword(p.getTextpass().getText());
    
        imppet.Ubah(mob);
        
    }
    
    public void hapus(){
        String id = p.getTextidPetugas().getText();
        imppet.Hapus(id);
    }
}


    

