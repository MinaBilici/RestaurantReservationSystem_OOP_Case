package com.minab;

public class RestoranIslemleriImpl implements IYoneticiIslemleri<Restoran> {

    public void ekle() {
        //kullanıcıdan girilen bilgiler doğrultusunda restoran nesnesi oluşturulur.
        String ad=Util.getStringValue("Restoranın adını giriniz.");
        String adres=Util.getStringValue("Restoranın adresini giriniz.");
        String telefon=Util.getStringValue("Restoranın telefon numarasını giriniz.");
        int kapasite=Util.getIntegerValue("Restoranın kapasitesini giriniz.");

        Restoran restoran=new Restoran(ad,adres,telefon,kapasite);

        //restoranın daha önce listeye eklenip eklenmediği kontrol edilir.
        if (varMi(restoran)){
            Util.hataMesaji(restoran.getRestoranID()+ " ID numaralı restoran daha önce eklenmiştir.");
        }else {
            Util.basariliMesaj(restoran.getRestoranID()+ " ID numaralı restoran eklenmiştir.");
            DataBase.restoranListesi.add(restoran);
        }

    }


    public void sil() {
        listele();
        //liste boşsa metot sonlanır.
        if (DataBase.restoranListesi.isEmpty()){
            return;
        }
        Restoran restoran=ara();
        if (restoran!=null){
            DataBase.restoranListesi.remove(restoran);
            Util.basariliMesaj(restoran.getRestoranID()+ " Id numaralı restoran silinmiştir.");
        }

    }


    public Restoran ara() {
        String ID=Util.getStringValue("İşlem yapmak istediğiniz restoranın id'sini giriniz.");

        for (Restoran restoran: DataBase.restoranListesi){
            if (restoran!=null && restoran.getRestoranID().equals(ID)){
                return restoran;
            }
        }
        Util.hataMesaji("Restoran bulunamamıştır.");
        return null;
    }


    public void listele() {
       if (!DataBase.restoranListesi.isEmpty()){
        Util.baslik("RESTORAN LİSTESİ");
        for (Restoran restoran: DataBase.restoranListesi){
            if (restoran!=null){
                System.out.println(restoran);
            }
        }
       }else {
           Util.hataMesaji("Restoran bulunmamaktadır.");
       }
    }

    //Restoran eklerken kontrol amaçlı oluşturulmuş bir metottur.
    public boolean varMi(Restoran restoran) {
        for (int i = 0; i < DataBase.restoranListesi.size(); i++) {
            if (DataBase.restoranListesi.get(i) != null && DataBase.restoranListesi.get(i).getRestoranID().equals(restoran.getRestoranID())) {
                return true;
            }
        }
        return false;
    }

    //Restoran ID sinden Restoran döndüren metot, Rezervasyon yapılırken kontrol amaçlı yazılmıştır.
    @Override
    public Restoran bul(String ID) {
        for (Restoran restoran : DataBase.restoranListesi) {
            if (restoran.getRestoranID().equals(ID)) {
                return restoran;
            }
        }
        return null;
    }




}
