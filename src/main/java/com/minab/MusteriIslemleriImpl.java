package com.minab;

public class MusteriIslemleriImpl implements IYoneticiIslemleri<Musteri> {
    @Override
    public void ekle() {
        //kullanıcıdan girilen bilgiler doğrultusunda müşteri nesnesi oluşturulur.
        String isim= Util.getStringValue("Müşterinin ismini giriniz.");
        String soyisim=Util.getStringValue("Müşterinin soyismini giriniz.");
        String telefon=Util.getStringValue("Müsterinin telefon numarasını giriniz.");
        String eposta=Util.getStringValue("Müşterinin eposta adresini giriniz.");

        Musteri musteri=new Musteri(isim,soyisim,telefon,eposta);

        //müşterinin daha önce listeye eklenip eklenmediği kontrol edilir.
        if (varMi(musteri)){
            Util.hataMesaji(musteri.getKullaniciID()+ " ID numaralı müşteri daha önce eklenmiştir.");
        }else {
            Util.basariliMesaj(musteri.getKullaniciID()+ " ID numaralı müşteri eklenmiştir.");
            DataBase.musteriListesi.add(musteri);
        }
    }

    @Override
    public void sil() {
        listele();
        //liste boşsa metot sonlanır.
        if (DataBase.musteriListesi.isEmpty()){
            return;
        }
        Musteri musteri=ara();
        if (musteri!=null){
            DataBase.musteriListesi.remove(musteri);
            Util.basariliMesaj(musteri.getKullaniciID()+ " ID numaralı müşteri silinmiştir.");
        }
    }

    @Override
    public Musteri ara() {
        String ID=Util.getStringValue("İşlem yapmak istediğiniz müşterinin id'sini giriniz.");

        for (Musteri musteri: DataBase.musteriListesi){
            if (musteri!=null && musteri.getKullaniciID().equals(ID)){
                return musteri;
            }
        }
        Util.hataMesaji("Müşteri bulunamamıştır.");
        return null;
    }

    @Override
    public void listele() {
        if (!DataBase.musteriListesi.isEmpty()) {
            Util.baslik("MÜŞTERİ LİSTESİ");
            for (Musteri musteri : DataBase.musteriListesi) {
                if (musteri != null) {
                    System.out.println(musteri);
                }
            }
        }else {
            Util.hataMesaji("Müşteri bulunmamaktadır.");
        }
    }

    //Musteri eklerken kontrol amaçlı oluşturulmuş bir metottur.

    @Override
    public boolean varMi(Musteri musteri) {
        for (int i = 0; i < DataBase.musteriListesi.size(); i++) {
            if (DataBase.musteriListesi.get(i) != null && DataBase.musteriListesi.get(i).getKullaniciID().equals(musteri.getKullaniciID())) {
                return true;
            }
        }
        return false;
    }
    //Kullanıcı ID' sinden musteri döndüren metot, Rezervasyon yapılırken kontrol amaçlı yazılmıştır.

    @Override
    public Musteri bul(String ID) {
        for (Musteri musteri : DataBase.musteriListesi) {
            if (musteri.getKullaniciID().equals(ID)) {
                return musteri;
            }
        }
        return null;
    }
}
