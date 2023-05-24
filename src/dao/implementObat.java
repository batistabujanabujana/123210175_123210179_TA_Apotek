/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.m_dataobat;

/**
 *
 * @author Febrian
 */
public interface implementObat {
    public void TampilData(m_dataobat a);
    
    public void Simpan(m_dataobat a);
    
    public void Ubah(m_dataobat a);
    
    public void Hapus(String id_obat);
    
    public List<m_dataobat> getAll();
    public String user = "";
}
