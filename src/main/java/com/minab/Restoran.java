package com.minab;

import java.util.UUID;

public class Restoran {
    private String restoranID;
    private String ad;
    private String adres;
    private String telefon;
    private int kapasite;
    private Durum durum;
    private int rezervasyonYapanMusteriSayisi; // restoranın kapasitesine göre rezervasyon almak için veriyi tutabilmek adına bu field'a ihtiyaç duydum.

    public int getRezervasyonYapanMusteriSayisi() {
        return rezervasyonYapanMusteriSayisi;
    }

    public void setRezervasyonYapanMusteriSayisi(int rezervasyonYapanMusteriSayisi) {
        this.rezervasyonYapanMusteriSayisi = rezervasyonYapanMusteriSayisi;
    }

    public Restoran(String ad, String adres, String telefon, int kapasite) {
        this.restoranID = UUID.randomUUID().toString();
        this.ad = ad;
        this.adres = adres;
        this.telefon = telefon;
        this.kapasite = kapasite;
        this.durum = Durum.ACIK; //restoran açık olarak eklenmektedir.
    }

    public String getRestoranID() {
        return restoranID;
    }

    public void setRestoranID(String restoranID) {
        this.restoranID = restoranID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public Durum getDurum() {
        return durum;
    }

    public void setDurum(Durum durum) {
        this.durum = durum;
    }

    @Override
    public String toString() {
        return "Restoran{" +
                "restoranID='" + restoranID + '\'' +
                ", ad='" + ad + '\'' +
                ", adres='" + adres + '\'' +
                ", telefon='" + telefon + '\'' +
                ", kapasite=" + kapasite +
                ", durum=" + durum +
                ", rezervasyonYapanMusteriSayisi=" + rezervasyonYapanMusteriSayisi +
                '}';
    }
}
