package com.minab;

import java.time.LocalDateTime;
import java.util.UUID;

public class Rezervasyon {
    private String rezervasyonID;
    private LocalDateTime rezervasyonTarihi;
    private int kisiSayisi;
    private Musteri musteri; //rezervasyonda müşteri bilgisi olması için Id yerine müşteri fieldı oluşturdum.
    private Restoran restoran; //aynı şekilde restoran bilgisine ihtiyacım olacağından ID yerine retoran fieldı oluşturdum.

    public Rezervasyon(Musteri musteri, Restoran restoran,int kisiSayisi) {
        this.rezervasyonID = UUID.randomUUID().toString();
        this.rezervasyonTarihi = LocalDateTime.now();
        this.kisiSayisi = kisiSayisi;
        this.musteri = musteri;
        this.restoran = restoran;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }



    public String getRezervasyonID() {
        return rezervasyonID;
    }

    public void setRezervasyonID(String rezervasyonID) {
        this.rezervasyonID = rezervasyonID;
    }


    public LocalDateTime getRezervasyonTarihi() {
        return rezervasyonTarihi;
    }

    public void setRezervasyonTarihi(LocalDateTime rezervasyonTarihi) {
        this.rezervasyonTarihi = rezervasyonTarihi;
    }

    public int getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" +
                "rezervasyonID='" + rezervasyonID + '\'' +
                ", rezervasyonTarihi=" + rezervasyonTarihi +
                ", kisiSayisi=" + kisiSayisi +
                ", musteri=" + musteri.getIsim() +
                ", restoran=" + restoran.getAd() +
                '}';
    }
}
