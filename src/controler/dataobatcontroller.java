/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.daoObat;
import dao.implementObat;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.m_dataobat;
import model.tableModelObat;
import view.DataObat;

/**
 *
 * @author Febrian
 */
public class dataobatcontroller {
    DataObat ob;
    implementObat impObat;
    List<m_dataobat> lt;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    public dataobatcontroller(DataObat ob) {
        this.ob = ob;
        impObat = new daoObat(); 
        lt = impObat.getAll();
//        this.lt = lt;
    }
    
    public void isiTable(){
        lt = impObat.getAll();
        tableModelObat tmo = new tableModelObat(lt);
        ob.getTabelobat().setModel(tmo);
    }
    
    public void reset(){
        ob.getTextidobat().setText(null);
        ob.getTextnama().setText(null);
        ob.getTextjumlah().setText(null);
        ob.getTextidkategori().setText(null);
        ob.getTextkategoriobat().setText(null);
        ob.getJtanggal().setDate(null);
        ob.getTextharga().setText(null);
    }
    public void simpan(){
        m_dataobat mob = new m_dataobat();
        mob.setId_Obat(ob.getTextidobat().getText());
        mob.setNama_Obat(ob.getTextnama().getText());
        mob.setJumlah(ob.getTextjumlah().getText());
        mob.setId_kategori(ob.getTextidkategori().getText());
        mob.setKategori(ob.getTextkategoriobat().getText());
        mob.setTgl_kadaluarsa(String.valueOf(format.format(ob.getJtanggal().getDate())));
        mob.setHarga(ob.getTextharga().getText());
        impObat.Simpan(mob);
    }
    
    public void ubah(){
        m_dataobat mob = new m_dataobat();
        mob.setId_Obat(ob.getTextidobat().getText());
        mob.setNama_Obat(ob.getTextnama().getText());
        mob.setJumlah(ob.getTextjumlah().getText());
        mob.setId_kategori(ob.getTextidkategori().getText());
        mob.setKategori(ob.getTextkategoriobat().getText());
        mob.setTgl_kadaluarsa(String.valueOf(format.format(ob.getJtanggal().getDate())));
        mob.setHarga(ob.getTextharga().getText());
        impObat.Ubah(mob);
        
    }
    
    public void hapus(){
        String id = ob.getTextidobat().getText();
        impObat.Hapus(id);
    }
}
