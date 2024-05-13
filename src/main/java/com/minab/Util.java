package com.minab;

import java.util.Scanner;
// bu sınıfta integer ve string input almayı kolaylaştıran metotlar, başarılı-hata mesajları ve başlık metodu yer almaktadır.
public class Util {
    static Scanner scanner = new Scanner(System.in);
    public static String getStringValue(String message) {
        System.out.println(message);
        String value = scanner.nextLine();
        return value;
    }
    public static int getIntegerValue(String message) {
        System.out.println(message);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static void hataMesaji(String mesaj){
        System.out.println("\u001B[31m" +mesaj+"\u001B[0m");
    }
    public static void basariliMesaj(String mesaj){

        System.out.println("\u001B[32m" +mesaj+"\u001B[0m");
    }

    public static void baslik(String metin){
        System.out.println("********************"+ metin+ "********************");
    }
}
