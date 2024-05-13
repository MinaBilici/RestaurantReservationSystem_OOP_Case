package com.minab;

//MusteriIslemleri ve RestoranIsleleri bu arayüzden implement edilmiştir.
//Müşteri işlemlerinde Object olarak müşteri , restoran işlerinde de restoran olduğu için T generic yapılmıştır.
public interface IYoneticiIslemleri <T> {

    void ekle();
    void sil();
    T ara();
    void listele();
    boolean varMi(T obj);
    T bul(String obj);

}
