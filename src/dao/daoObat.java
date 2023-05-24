/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Connector;
import model.m_dataobat;

/**
 *
 * @author Febrian
 */
public class daoObat implements implementObat{
    Connection connection;
    
    public String TampilData = "SELECT * FROM `obat`";
    public String Ubah = "UPDATE `obat` SET `nama_obat`=?, `jumlah`=?, `id_kategori`=?, `kategori`=?, `tgl_kadaluarsa`=?, `harga`=? Where `id_obat`=?";
    public String Simpan = "INSERT INTO `obat` VALUES (?, ?, ?, ?, ?, ?,?)";
    public String Hapus = "DELETE FROM `obat` WHERE id_obat=?";

    public daoObat() {
        connection = Connector.connection();
    }
    
    @Override
    public void TampilData(m_dataobat a) {
    }

    @Override
    public void Simpan(m_dataobat a) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Simpan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getId_Obat());
            statement.setString(2, a.getNama_Obat());
            statement.setString(3, a.getJumlah());
            statement.setString(4, a.getId_kategori());
            statement.setString(5, a.getKategori());
            statement.setString(6, a.getTgl_kadaluarsa());
            statement.setString(7, a.getHarga());
            
             
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                a.setId_Obat(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoObat.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Ubah(m_dataobat a) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Ubah);
            statement.setString(1, a.getNama_Obat());
            statement.setString(2, a.getJumlah());
            statement.setString(3, a.getId_kategori());
            statement.setString(4, a.getKategori());
            statement.setString(5, a.getTgl_kadaluarsa());
            statement.setString(6, a.getHarga());
            statement.setString(7, a.getId_Obat());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoObat.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Hapus(String id_obat) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Hapus);
            statement.setString(1, id_obat);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoObat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<m_dataobat> getAll() {
        List<m_dataobat> lt = null;
        try {
            lt = new ArrayList<m_dataobat>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(TampilData);
            while (rs.next()) {
                m_dataobat dobat = new m_dataobat();
                dobat.setId_Obat(rs.getString("id_Obat"));
                dobat.setNama_Obat(rs.getString("nama_obat"));
                dobat.setJumlah(rs.getString("jumlah"));
                dobat.setId_kategori(rs.getString("id_kategori"));
                dobat.setKategori(rs.getString("kategori"));
                dobat.setTgl_kadaluarsa(rs.getString("tgl_kadaluarsa"));
                dobat.setHarga(rs.getString("harga"));
                lt.add(dobat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoObat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;
    }
    
}
