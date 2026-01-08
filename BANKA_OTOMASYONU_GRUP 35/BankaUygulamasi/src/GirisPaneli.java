import java.util.Scanner;

public class GirisPaneli {
    Boolean GirisKontrol = false;
    String Girilen_Kullanıcı_Adı;
    String KULLANICI_ADI = "admin";
    int SIFRE = 12345;
    int Girilen_Sifre;
    Scanner scanner = new Scanner(System.in);

    void Giris() {
        while (GirisKontrol == false) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║         BANKA SİSTEMİ GİRİŞ        ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.print("  👤 Kullanıcı Adı : ");
            Girilen_Kullanıcı_Adı = scanner.nextLine();
            System.out.print("  🔑 Şifre         : ");
            Girilen_Sifre = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            if (Girilen_Kullanıcı_Adı.equals(KULLANICI_ADI) && Girilen_Sifre == SIFRE) {
                GirisKontrol = true;
                System.out.println("║    ✅ Giriş Başarılı!              ║");
                System.out.println("╚════════════════════════════════════╝");
            } else {
                System.out.println("║    ❌ Hatalı Bilgi! Tekrar Deneyin ║");
                System.out.println("╚════════════════════════════════════╝");
            }
        }
    }
}