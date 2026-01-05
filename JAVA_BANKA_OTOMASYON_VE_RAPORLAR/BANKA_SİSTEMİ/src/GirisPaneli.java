import java.util.Scanner;

public class GirisPaneli {
    Boolean GirisKontrol = false;
    String Girilen_Kullanıcı_Adı;
    String KULLANICI_ADI = "admin";
    int SİFRE = 12345;

    int Girilen_Sifre;
    Scanner scanner = new Scanner(System.in);

    void Giris(){


    while(GirisKontrol == false) {
        System.out.println("Hoşgeldiniz, ");
        System.out.println("kullanıcı adı : ");
        //Scanner scanner = new Scanner(System.in);
        Girilen_Kullanıcı_Adı = scanner.nextLine();
        System.out.println("sifre : ");
        Girilen_Sifre = scanner.nextInt();
        scanner.nextLine();

        if (Girilen_Kullanıcı_Adı.equals(KULLANICI_ADI) && Girilen_Sifre == SİFRE) {
            GirisKontrol = true;

        } else {
            System.out.println("girilen bilgiler yanlış tekrar deneyin ... ");

        }
    }}
}
