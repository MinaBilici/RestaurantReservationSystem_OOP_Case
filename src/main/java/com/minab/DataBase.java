package com.minab;

import java.util.ArrayList;

    // müşteri, restoran ve rezervasyon listelerini tutabilmek için oluşturulan bir sınıftır.
    //Sınıf üzerinden erişilebilmesi için listeler static oluşturulmuştur.
public class DataBase {
    public static ArrayList<Musteri> musteriListesi=new ArrayList<>();
    public static ArrayList<Restoran> restoranListesi=new ArrayList<>();
    public static ArrayList<Rezervasyon> rezervasyonListesi=new ArrayList<>();
}
