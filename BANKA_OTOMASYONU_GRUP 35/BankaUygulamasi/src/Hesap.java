import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

    public class Hesap {
        private String isim;
        private int hesapNo;
        private double bakiye;
        private ArrayList<String> hareketler;
        Scanner scanner = new Scanner(System.in);

        public Hesap(String isim, int hesapNo, double baslangicBakiye) {
            this.isim = isim;
            this.hesapNo = hesapNo;
            this.bakiye = baslangicBakiye;
            this.hareketler = new ArrayList<>();
            hareketEkle("Hesap açıldı. Bakiye: " + baslangicBakiye + " TL");
        }

        public void paraGönder() {
            while (true) {
                System.out.println("\n╔════════════════════════════════════╗");
                System.out.println("║          PARA GÖNDERİMİ            ║");
                System.out.println("╠════════════════════════════════════╣");
                System.out.println("║ 1. IBAN ile gönder                 ║");
                System.out.println("║ 2. Kolay Adres (GSM)               ║");
                System.out.println("║ 3. Hesap Numarası ile              ║");
                System.out.println("║ 0. Ana Menüye Dön                  ║");
                System.out.println("╚════════════════════════════════════╝");
                System.out.print("Seçiminiz: ");
                int secim2 = scanner.nextInt();

                if (secim2 == 0) break;

                System.out.println("Güncel bakiye: " + bakiye + " TL");
                double miktar;

                switch (secim2) {
                    case 1:
                        System.out.print("IBAN tuşlayın: ");
                        double iban = scanner.nextDouble();
                        System.out.print("Miktar: ");
                        miktar = miktarKontrol();
                        islemYap("Havale Giden (IBAN: " + iban + ")", miktar);
                        break;
                    case 2:
                        System.out.print("GSM No tuşlayın: ");
                        double gsm = scanner.nextDouble();
                        System.out.print("Miktar: ");
                        miktar = miktarKontrol();
                        islemYap("Havale Giden (GSM: " + gsm + ")", miktar);
                        break;
                    case 3:
                        System.out.print("Hesap No tuşlayın: ");
                        double hNo = scanner.nextDouble();
                        System.out.print("Miktar: ");
                        miktar = miktarKontrol();
                        islemYap("Havale Giden (No: " + hNo + ")", miktar);
                        break;
                }
                break; // İşlem bittiğinde alt menüden çık
            }
        }

        private double miktarKontrol() {
            double m = scanner.nextDouble();
            while (m > bakiye) {
                System.out.print("❌ Yetersiz bakiye! Tekrar miktar girin: ");
                m = scanner.nextDouble();
            }
            return m;
        }

        private void islemYap(String aciklama, double miktar) {
            bakiye -= miktar;
            String detay = aciklama + ": -" + miktar + " TL";
            hareketEkle(detay);
            dekontOlustur(detay);
            System.out.println("✅ Başarılı...");
        }

        public void paraYatir(double miktar) {
            bakiye += miktar;
            String islem = "Para Yatırma: +" + miktar + " TL";
            hareketEkle(islem);
            dekontOlustur(islem);
            System.out.println("✔️ İşlem Başarılı. Yeni Bakiye: " + bakiye);
        }

        public void paraCek(double miktar) {
            if (miktar > bakiye) {
                System.out.println("❌ Yetersiz Bakiye!");
            } else {
                bakiye -= miktar;
                String islem = "Para Çekme: -" + miktar + " TL";
                hareketEkle(islem);
                dekontOlustur(islem);
                System.out.println("✔️ İşlem Başarılı. Kalan Bakiye: " + bakiye);
            }
        }

        public void hesapOzeti() {
            System.out.println("\n╔═════════ " + isim + " HESAP ÖZETİ ═════════╗");
            for (String h : hareketler) {
                System.out.println("  • " + h);
            }
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("  💰 Güncel Bakiye: " + bakiye + " TL");
            System.out.println("╚════════════════════════════════════════╝");
        }

        private void hareketEkle(String aciklama) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            hareketler.add(LocalDateTime.now().format(dtf) + " - " + aciklama);
        }

        private void dekontOlustur(String islemDetay) {
            try (FileWriter writer = new FileWriter("dekont.txt")) {
                writer.write("--- BANKA DEKONTU ---\n");
                writer.write("Müşteri: " + isim + "\n");
                writer.write("Hesap No: " + hesapNo + "\n");
                writer.write("İşlem: " + islemDetay + "\n");
                writer.write("Tarih: " + LocalDateTime.now() + "\n");
                writer.write("---------------------\n");
                System.out.println(">> Dekont 'dekont.txt' dosyasına kaydedildi.");
            } catch (IOException e) {
                System.out.println("Dekont hatası!");
            }
        }
    }

