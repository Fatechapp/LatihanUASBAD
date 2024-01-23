package main;

import connection.DatabaseConnection;

import java.sql.Connection;

public class kategori {
    private String Kd_Kategori;
    private String Nm_Kategori;

    public kategori(String kd_Kategori, String nm_Kategori) {
        Kd_Kategori = kd_Kategori;
        Nm_Kategori = nm_Kategori;
    }

    public String getKd_Kategori() {
        return Kd_Kategori;
    }

    public void setKd_Kategori(String kd_Kategori) {
        Kd_Kategori = kd_Kategori;
    }

    public String getNm_Kategori() {
        return Nm_Kategori;
    }

    public void setNm_Kategori(String nm_Kategori) {
        Nm_Kategori = nm_Kategori;
    }
}
