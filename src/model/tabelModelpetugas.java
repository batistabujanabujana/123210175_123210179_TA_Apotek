/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_petugas;

/**
 *
 * @author M S I
 */
public class tabelModelpetugas extends AbstractTableModel {

    List<m_petugas> at;

    public tabelModelpetugas(List<m_petugas> at) {
        this.at = at;
    }

    @Override
    public int getRowCount() {
        return at.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id_petugas";
            case 1:
                return "nama_petugas";
            case 2:
                return "username";
            case 3:
                return "password";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return at.get(row).getId_petugas();
            case 1:
                return at.get(row).getNama_petugas();
            case 2:
                return at.get(row).getUsername();
            case 3:
                return at.get(row).getPassword();
            default:
                return null;
        }
    }
}
