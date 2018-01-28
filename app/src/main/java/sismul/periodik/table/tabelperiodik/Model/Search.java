package sismul.periodik.table.tabelperiodik.Model;

/**
 * Created by x on 27/01/18.
 */

public class Search {
    String simbol, nama_unsur, ikon_file_name;
    Integer golongan, periode;

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public String getNama_unsur() {
        return nama_unsur;
    }

    public void setNama_unsur(String nama_unsur) {
        this.nama_unsur = nama_unsur;
    }

    public String getIkon_file_name() {
        return ikon_file_name;
    }

    public void setIkon_file_name(String ikon_file_name) {
        this.ikon_file_name = ikon_file_name;
    }

    public Integer getGolongan() {
        return golongan;
    }

    public void setGolongan(Integer golongan) {
        this.golongan = golongan;
    }

    public Integer getPeriode() {
        return periode;
    }

    public void setPeriode(Integer periode) {
        this.periode = periode;
    }
}
