package sismul.periodik.table.tabelperiodik.Model;

import com.google.gson.annotations.SerializedName;

import java.io.InputStream;

/**
 * Created by x on 28/01/18.
 */

public class Unsur {
    @SerializedName("id")
    private int id;
    @SerializedName("simbol")
    private String simbol;
    @SerializedName("nama_unsur")
    private String nama_unsur;
    @SerializedName("masa_atom")
    private String masa_atom;
    @SerializedName("nomor_atom")
    private String nomor_atom;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("golongan")
    private String golongan;
    @SerializedName("periode")
    private String periode;
    @SerializedName("ikon_file_name")
    private String ikon_file_name;

    public Unsur(int id, String simbol, String nama_unsur, String masa_atom, String nomor_atom, String deskripsi, String golongan, String periode, String ikon_file_name) {
        this.id = id;
        this.simbol = simbol;
        this.nama_unsur = nama_unsur;
        this.masa_atom = masa_atom;
        this.nomor_atom = nomor_atom;
        this.deskripsi = deskripsi;
        this.golongan = golongan;
        this.periode = periode;
        this.ikon_file_name = ikon_file_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getMasa_atom() {
        return masa_atom;
    }

    public void setMasa_atom(String masa_atom) {
        this.masa_atom = masa_atom;
    }

    public String getNomor_atom() {
        return nomor_atom;
    }

    public void setNomor_atom(String nomor_atom) {
        this.nomor_atom = nomor_atom;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getIkon_file_name() {
        return ikon_file_name;
    }

    public void setIkon_file_name(String ikon_file_name) {
        this.ikon_file_name = ikon_file_name;
    }
}
