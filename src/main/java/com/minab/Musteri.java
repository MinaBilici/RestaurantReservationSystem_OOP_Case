package com.minab;

public class Musteri extends Kullanici {
    private String telefon;
    private String eposta;

    public Musteri(String isim, String soyisim, String telefon, String eposta) {
        super(isim, soyisim);
        this.telefon = telefon;
        this.eposta = eposta;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    @Override
    public String toString() {
        return "Musteri{"+ super.toString()+
                "telefon='" + telefon + '\'' +
                ", eposta='" + eposta + '\'' +
                '}';

    }
}
