package com.minab;

import javax.swing.*;
import java.util.Scanner;
//Bu sınıf müşteri ve restoran işlemlerinden farklı görevler aldığı için diğerleri gibi implemet edilmemiştir.
public class RezervasyonIslemleri {
    MusteriIslemleriImpl musteriIslemleri=new MusteriIslemleriImpl();
    RestoranIslemleriImpl restoranIslemleri=new RestoranIslemleriImpl();
    public void rezervasyonYap(){
        Scanner scanner=new Scanner(System.in);

        //kullanıcıdan girilen bilgiler doğrultusunda gerekli kontroller sağlandıktan sonra rezervasyon nesnesi oluşturulur.
        String musteriID=Util.getStringValue("Müşteri ID'sini giriniz.");
        Musteri musteri=musteriIslemleri.bul(musteriID);

        //müşteri, müşteri listesinde yoksa hata mesajı verilip metot sonlandırılır.
        if (musteri==null){
            Util.hataMesaji("Girdiğiniz ID herhangi müşteriye ait değildir.Önce müşteri ekleme işlemi yapmalısınız.");
            return;
        }

        //restoran ıd'lerini görüntülenmesi ve kolaylık sağlanması için restoran listelemesi yapılır.
        restoranIslemleri.listele();
        String restoranID=Util.getStringValue("Rezervasyon yapmak istediğiniz restoranın ID'sini giriniz.");

        Restoran restoran=restoranIslemleri.bul(restoranID);

        //restoran listesinde olup olmadığı kontrol edilir, yoksa hata mesajı verip metot sonlandırılır.
        if (restoran==null){
            Util.hataMesaji("Böyle bir restoran bulunmamaktadır.");
            return;
        }
        int kisiSayisi=Util.getIntegerValue("Rezervasyon kişi sayısını giriniz.");

        Rezervasyon rezervasyon=new Rezervasyon(musteri,restoran,kisiSayisi);

        //Eğer restoranın durumu açık ise rezervasyon yapılabilir.
        if (restoran.getDurum()==Durum.ACIK) {

            //restorandaki rezervasyon yapan kişi sayısına rezervasyon yapılmak istenen kişi sayısı eklenir.
            rezervasyon.getRestoran().setRezervasyonYapanMusteriSayisi(rezervasyon.getRestoran().getRezervasyonYapanMusteriSayisi() + kisiSayisi);

            //kapasiteye göre kontrol sağlanır.
            if (rezervasyon.getRestoran().getRezervasyonYapanMusteriSayisi() > rezervasyon.getRestoran().getKapasite()) {
                Util.hataMesaji("Rezervasyon yapmak istediğiniz restoran kapasitesi dolmuştur. İlginiz için teşekkür ederiz.");
            } else {
                //kapasite uygunsa rezervasyon işlemi gerçekleşir.
                DataBase.rezervasyonListesi.add(rezervasyon);
                Util.basariliMesaj(rezervasyon.getRezervasyonID() + " Id numaralı rezervasyonunuz gerçekleştirilmiştir.");
            }
        }else {
            Util.hataMesaji("Rezervasyon yapmak istediğiniz restoran kapalıdır.");
        }


    }
    public void rezervasyonIptalEt(){
        Scanner scanner=new Scanner(System.in);
        rezervasyonlariListele();

        //rezervasyon listesi boşsa uyarı verip metot sonlandırılır.
        if (DataBase.rezervasyonListesi.isEmpty()){
            return;
        }
        String restoranID=Util.getStringValue("İptal etmek istediğiniz rezervasyon Id'sini girininiz.");
        Rezervasyon rezervasyon=rezervasyonBul(restoranID);

        //eğer verilen ıd'de rezervasyon varsa işlem yapılır.
        if (rezervasyon!=null){
            DataBase.rezervasyonListesi.remove(rezervasyon);
            //Restorandaki rezervasyon yapan sayısı iptal olan rezervasyon kişi sayısı kadar çıkartılır.
            rezervasyon.getRestoran().setRezervasyonYapanMusteriSayisi(rezervasyon.getRestoran().getRezervasyonYapanMusteriSayisi()-rezervasyon.getKisiSayisi());
            Util.basariliMesaj(rezervasyon.getRezervasyonID()+ " ID numaralı rezervasyon iptal edilmiştir.");
        }

    }
    public void rezervasyonlariListele(){
        if (!DataBase.rezervasyonListesi.isEmpty()) {
            Util.baslik("REZERVASYON LİSTESİ");
           for (Rezervasyon rezervasyon : DataBase.rezervasyonListesi) {
               if (rezervasyon != null) {
                   System.out.println(rezervasyon);
               }
           }
       }else {
           Util.hataMesaji("Rezervasyon bulunmamaktadır.");

       }

    }
    //diğer metotlarda kullanılmak için oluşturulmuş bir metoddur o yüzden private yapılmıştır.
    private Rezervasyon rezervasyonBul(String rezervasyonID){
        for (Rezervasyon rezervasyon: DataBase.rezervasyonListesi){
            if (rezervasyon.getRezervasyonID().equalsIgnoreCase(rezervasyonID)){
                return rezervasyon;
            }
        }
        System.out.println("Böyle bir rezervasyon bulunamadı.");
        return null;
    }
}
