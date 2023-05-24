/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_dataobat;

/**
 *
 * @author Febrian
 */
public class tableModelObat extends AbstractTableModel {

    List<m_dataobat> lt;

    public tableModelObat(List<m_dataobat> lt) {
        this.lt = lt;
    }

    @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id_Obat";
            case 1:
                return "nama_Obat";
            case 2:
                return "jumlah";
            case 3:
                return "id_kategori";
            case 4:
                return "kategori";
            case 5:
                return "tgl_kadaluarsa";
            case 6:
                return "harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lt.get(row).getId_Obat();
            case 1:
                return lt.get(row).getNama_Obat();
            case 2:
                return lt.get(row).getJumlah();
            case 3:
                return lt.get(row).getId_kategori();
            case 4:
                return lt.get(row).getKategori();
            case 5:
                return lt.get(row).getTgl_kadaluarsa();
            case 6:
                return lt.get(row).getHarga();
            default:
                return null;
        }
    }
}
