/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;
import model.m_petugas;
/**
 *
 * @author M S I
 */
public interface implementPetugas {
    public void TampilData(m_petugas b);
    
    public void Simpan(m_petugas b);
    
    public void Ubah(m_petugas b);
    
    public void Hapus(String id_petugas);
    
    public List<m_petugas> getAll();
    public String user = "";
}
