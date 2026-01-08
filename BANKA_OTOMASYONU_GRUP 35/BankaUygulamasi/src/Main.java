import java.util.Scanner;

class BankaUygulamasi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int SIFRE = 12345; // Uygulama içi şifre yönetimi için

        Hesap benimHesabim = new Hesap("Ali Yılmaz", 123456, 1000.0);
        GirisPaneli girisPaneli = new GirisPaneli();

        girisPaneli.Giris();

        if (girisPaneli.GirisKontrol) {
            boolean kontrol = false;

            while (!kontrol) {

                System.out.println("\n╔════════════════════════════════════╗");
                System.out.println("║              ANA MENÜ              ║");
                System.out.println("╠════════════════════════════════════╣");
                System.out.println("║  1. 📜 Bakiye ve Geçmiş            ║");
                System.out.println("║  2. ➕ Para Yatır                  ║");
                System.out.println("║  3. ➖ Para Çek                    ║");
                System.out.println("║  4. 💸 Para Gönder (Havale/EFT)    ║");
                System.out.println("║  5. 🔑 Şifre Değiştir              ║");
                System.out.println("║  0. 🚪 Çıkış                       ║");
                System.out.println("╚════════════════════════════════════╝");
                System.out.print("Seçiminiz: ");

                int secim = scan.nextInt();

                switch (secim) {
                    case 1:
                        benimHesabim.hesapOzeti();
                        break;
                    case 2:
                        System.out.print("Yatırılacak miktar: ");
                        benimHesabim.paraYatir(scan.nextDouble());
                        break;
                    case 3:
                        System.out.print("Çekilecek miktar: ");
                        benimHesabim.paraCek(scan.nextDouble());
                        break;
                    case 4:
                        benimHesabim.paraGönder();
                        break;
                    case 5:
                        System.out.print("Mevcut şifreyi tuşlayın: ");
                        if (scan.nextInt() == SIFRE) {
                            System.out.print("Yeni şifre: ");
                            SIFRE = scan.nextInt();
                            System.out.println("✔️ Şifre değiştirildi: " + SIFRE);
                        } else {
                            System.out.println("❌ Şifre yanlış!");
                        }
                        break;
                    case 0:
                        System.out.println("Güle güle...");
                        kontrol = true;
                        break;
                    default:
                        System.out.println("Geçersiz işlem.");
                }
            }
        }
        scan.close();
    }
}