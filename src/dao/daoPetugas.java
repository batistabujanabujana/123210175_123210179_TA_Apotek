/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author M S I
 */
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
import model.m_petugas;


public class daoPetugas implements implementPetugas{
    Connection connection;
    
    public String TampilData = "SELECT * FROM `petugas`";
    public String Ubah = "UPDATE `petugas` SET `nama_petugas`=?, `username`=?, `password`=? Where `id_petugas`=?";
    public String Simpan = "INSERT INTO `petugas` VALUES (?, ?, ?, ?)";
    public String Hapus = "DELETE FROM `petugas` WHERE id_petugas=?";

    public daoPetugas() {
        connection = Connector.connection();
    }
    
    @Override
    public void TampilData(m_petugas b) {
    }

    @Override
    public void Simpan(m_petugas b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Simpan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getId_petugas ());
            statement.setString(2, b.getNama_petugas());
            statement.setString(3, b.getUsername());
            statement.setString(4, b.getPassword());
            
            
             
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId_petugas(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Ubah(m_petugas b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Ubah);
             statement.setString(1, b.getNama_petugas ());
            statement.setString(2, b.getUsername());
            statement.setString(3, b.getPassword());
            statement.setString(4, b.getId_petugas());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Hapus(String id_petugas) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Hapus);
            statement.setString(1, id_petugas);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<m_petugas> getAll() {
        List<m_petugas> at = null;
        try {
            at = new ArrayList<m_petugas>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(TampilData);
            while (rs.next()) {
                m_petugas dpetugas = new m_petugas();
                dpetugas.setId_petugas(rs.getString("id_petugas"));
                dpetugas.setNama_petugas(rs.getString("nama_petugas"));
               dpetugas.setUsername(rs.getString("username"));
               dpetugas.setPassword(rs.getString("password"));
        
                at.add(dpetugas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoPetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return at;
    }
    
}

