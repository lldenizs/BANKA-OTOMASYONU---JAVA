import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// Hesap işlemlerini yöneten sınıf
class BankaUygulamasi {

    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Boolean AnaMenuKontrol = false;
        Boolean kontrol = false;
        Boolean kontrol3 = false;
        int SİFRE_KONTROL;
        int SİFRE = 12345;


        // Örnek hesaplar oluşturuyoruz
        Hesap benimHesabim = new Hesap("Ali Yılmaz", 123456, 1000.0);


        GirisPaneli girisPaneli = new GirisPaneli();
        girisPaneli.Giris();

        if (girisPaneli.GirisKontrol == true) {


            while (kontrol == false) {
                System.out.println("\n1. Bakiye ve Geçmiş\n2. Para Yatır\n3. Para Çek\n4.Para gönder\n5. sifre degistir\n0. Çıkış");
                System.out.print("Seçiminiz: ");
                int secim = scan.nextInt();
                kontrol3 = false;

                switch (secim) {
                    case 1:
                        benimHesabim.hesapOzeti();
                        break;
                    case 2:
                        System.out.print("Yatırılacak miktar: ");
                        double yatir = scan.nextDouble();
                        benimHesabim.paraYatir(yatir);
                        break;
                    case 3:
                        System.out.print("Çekilecek miktar: ");
                        double cek = scan.nextDouble();
                        benimHesabim.paraCek(cek);
                        break;

                    case 4:
                        benimHesabim.paraGönder();
                        kontrol = false;
                        break;

                    case 5:
                        while (kontrol3 == false) {
                            System.out.println("mevcut şifreyi tuşlayın : ");
                            SİFRE_KONTROL = scan.nextInt();
                            if (SİFRE_KONTROL == SİFRE) {

                                System.out.println("şifre doğru \n yeni şifreyi girin : ");
                                SİFRE = scan.nextInt();
                                System.out.println("şifre değiştirilidi. yeni şifre : " + SİFRE);
                                kontrol3 = true;
                                AnaMenuKontrol = false;

                            } else {
                                System.out.println("mevcut şifreyi yanlış girdiniz tekrar deneyin : \n");

                            }
                        }
                        break;


                    case 0:
                        System.out.println("Çıkış yapılıyor...");
                        AnaMenuKontrol = false;
                        break;
                    default:
                        System.out.println("Geçersiz işlem.");
                }
            }
        }

    }}

