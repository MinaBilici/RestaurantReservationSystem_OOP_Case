package com.minab;

public class Main {
    static RestoranIslemleriImpl restoranIslemleri=new RestoranIslemleriImpl();
    static MusteriIslemleriImpl musteriIslemleri=new MusteriIslemleriImpl();
    static RezervasyonIslemleri rezervasyonIslemleri=new RezervasyonIslemleri();

    //burada sadece menüler yer almaktadır.Ana menüden tüm işlemlere ulaşılabilinmektedir.
    //alt menüler private, ana menü public olacak şekilde düzenlenmiştir.
    //main metodu static olduğundan menüler ve işlem nesneleri static oluşturulmuştur.

    public static void main(String[] args) {

        //rezervasyon işlemlerini yapabilmek için en az bir müşteri ve bir restoran eklenmelidir.
        anaMenu();



    }

    public static void anaMenu(){
        int secim;
        do {
            System.out.println("1. Restoran İşlemleri");
            System.out.println("2. Müşteri İşlemleri");
            System.out.println("3. Rezervasyon İşlemleri");
            System.out.println("4. Çıkış");

            secim=Util.getIntegerValue("Yapmak istediğiniz işlemi seçiniz: ");

            switch (secim) {
                case 1:
                    restoranIslemleriMenu();
                    break;
                case 2:
                    musteriIslemleriMenu();
                    break;
                case 3:
                    rezervasyonIslemleriMenu();
                    break;
                case 4:
                    Util.basariliMesaj("Çıkış yapıldı.");
                    System.exit(4);
                    break;
                default:
                    Util.hataMesaji("Geçersiz seçim yaptınız. Lütfen 1 ile 4 arasında sayı girerek tekrar deneyiniz.");
            }
        } while (secim != 4);
    }

    private static void musteriIslemleriMenu(){
        int secim;
        do {
            System.out.println("1. Müşteri Ekle");
            System.out.println("2. Müşteri Sil");
            System.out.println("3. Müşteri Ara");
            System.out.println("4. Müşterileri Listele");
            System.out.println("5. Ana Menüye Dön");
            System.out.println("6. Çıkış");

            secim=Util.getIntegerValue("Yapmak istediğiniz işlemi seçiniz: ");

            switch (secim) {
                case 1:
                    musteriIslemleri.ekle();
                    break;
                case 2:
                    musteriIslemleri.sil();
                    break;
                case 3:
                    System.out.println("Aradığınız müşteri bilgileri: "+ musteriIslemleri.ara());
                    break;
                case 4:
                    musteriIslemleri.listele();
                    break;
                case 5:
                    anaMenu();
                    return;
                case 6:
                    Util.basariliMesaj("Çıkış yapıldı.");
                    System.exit(6);
                    break;
                default:
                    Util.hataMesaji("Geçersiz seçim yaptınız. Lütfen 1 ile 5 arasında sayı girerek tekrar deneyiniz.");
            }
        } while (secim != 5);
    }

    private static void restoranIslemleriMenu(){
        int secim;
        do {
            System.out.println("1. Restoran Ekle");
            System.out.println("2. Restoran Sil");
            System.out.println("3. Restoran Ara");
            System.out.println("4. Restoranları Listele");
            System.out.println("5. Ana Menüye Dön");
            System.out.println("6. Çıkış");

            secim=Util.getIntegerValue("Yapmak istediğiniz işlemi seçiniz: ");

            switch (secim) {
                case 1:
                    restoranIslemleri.ekle();
                    break;
                case 2:
                    restoranIslemleri.sil();
                    break;
                case 3:
                    System.out.println("Aradığınız restoranın bilgileri: "+ restoranIslemleri.ara());
                    break;
                case 4:
                   restoranIslemleri.listele();
                    break;
                case 5:
                    anaMenu();
                    return;
                case 6:
                    Util.basariliMesaj("Çıkış yapıldı.");
                    System.exit(6);
                    break;
                default:
                    Util.hataMesaji("Geçersiz seçim yaptınız. Lütfen 1 ile 5 arasında sayı girerek tekrar deneyiniz.");
            }
        } while (secim != 5);
    }

    private static void rezervasyonIslemleriMenu(){
        int secim;
        do {
            System.out.println("1. Rezervasyon Yap");
            System.out.println("2. Rezervasyon İptal Et");
            System.out.println("3. Rezervasyonları Listele");
            System.out.println("4. Ana Menüye Dön");
            System.out.println("5. Çıkış");

            secim=Util.getIntegerValue("Yapmak istediğiniz işlemi seçiniz: ");

            switch (secim) {
                case 1:
                    rezervasyonIslemleri.rezervasyonYap();
                    break;
                case 2:
                    rezervasyonIslemleri.rezervasyonIptalEt();
                    break;
                case 3:
                    rezervasyonIslemleri.rezervasyonlariListele();
                    break;

                case 4:
                    anaMenu();
                    return;
                case 5:
                    Util.basariliMesaj("Çıkış yapıldı.");
                    System.exit(5);
                    break;
                default:
                    Util.hataMesaji("Geçersiz seçim yaptınız. Lütfen 1 ile 4 arasında sayı girerek tekrar deneyiniz.");
            }
        } while (secim != 5);
    }


}