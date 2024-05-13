package com.minab;

import java.util.UUID;
// Bu sınıf müşteri ve yönetici sınıflarına, ortak field bulundurduğu için kalıtım sağlamaktadır.
public class Kullanici {
    private String kullaniciID;
    private String isim;
    private String soyisim;

    public Kullanici(String isim, String soyisim) {
        this.kullaniciID = UUID.randomUUID().toString();
        this.isim = isim;
        this.soyisim = soyisim;
    }

    public String getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(String kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "kullaniciID='" + kullaniciID + '\'' +
                ", isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                '}';
    }
}
