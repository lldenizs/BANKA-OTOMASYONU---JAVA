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
    double IBAN;
    double miktar;
    double HesapNo;
    double GSM;
    public Boolean kontrol2 = false;

    Scanner scanner = new Scanner(System.in);
    private ArrayList<String> hareketler; // Hesap geçmişi listesi

    public Hesap(String isim, int hesapNo, double baslangicBakiye) {
        this.isim = isim;
        this.hesapNo = hesapNo;
        this.bakiye = baslangicBakiye;
        this.hareketler = new ArrayList<>();
        hareketEkle("Hesap açıldı. Bakiye: " + baslangicBakiye + " TL");
    }
    int secim2;
    public void paraGönder(){

        while(!false){
            System.out.println("1. ibana para gönder\n 2. kolay adrese para gönder\n 3.hesap numarası ile para gönder\n 0. cikis");
            System.out.println("secim yapiniz : ");
            secim2 = scanner.nextInt();


        switch(secim2){

            case 1 : System.out.println("güncel bakiye : " + bakiye);
                System.out.println("para göndereceğiniz ibanı tuşlayın : ");
                    IBAN = scanner.nextDouble();
                    System.out.println(IBAN +  "iban numaralı hesaba aktaracağınız miktar (TL) : ");
                    miktar = scanner.nextDouble();
                   if(miktar > bakiye){
                       System.out.println("bakiye yetersiz , tekrar miktar giriniz :");
                       miktar = scanner.nextDouble();
                   }
                String gonderenIslem = "Havale Giden (" + IBAN + "): -" + miktar + " TL";
                this.hareketEkle(gonderenIslem);
                this.dekontOlustur(gonderenIslem);
                bakiye -= miktar;
                System.out.println("basarili...");
                kontrol2 = false;

                break;


            case 2 : System.out.println("güncel bakiye : " + bakiye);
                System.out.println("para göndereceğiniz kolay adresi tuşlayın (GSM) : ");
                    GSM = scanner.nextDouble();
                    System.out.println( GSM + "numaralı hesaba göndereceğiniz miktar : ");
                    miktar = scanner.nextDouble();
                if(miktar > bakiye){
                    System.out.println("bakiye yetersiz , tekrar miktar giriniz :");
                    miktar = scanner.nextDouble();
                }
                String gonderenIslem2 = "Havale Giden (" + GSM + "): -" + miktar + " TL";
                this.hareketEkle(gonderenIslem2);
                this.dekontOlustur(gonderenIslem2);
                    bakiye -= miktar;
                    System.out.println("basarili...");
                    kontrol2 = false;
                    break;


            case 3 : System.out.println("güncel bakiye : " + bakiye);
                System.out.println("para göndereceğiniz hesap numarasını tuşlayın : ");
                    HesapNo = scanner.nextDouble();
                    System.out.println(HesapNo + "numaralı hesaba göndereceğiniz miktar (TL) : ");
                    miktar = scanner.nextDouble();
                if(miktar > bakiye){
                    System.out.println("bakiye yetersiz , tekrar miktar giriniz :");
                    miktar = scanner.nextDouble();
                }
                String gonderenIslem3 = "Havale Giden (" + HesapNo + "): -" + miktar + " TL";
                this.hareketEkle(gonderenIslem3);
                this.dekontOlustur(gonderenIslem3);
                    bakiye -= miktar;
                    System.out.println("basarili...");
                    kontrol2 = false;
                    break;

            case 0 : System.out.println("cikis yapiliyor...");
                System.exit(0);

                break;

            default: System.out.println("yanliş secim yaptiniz tekrar deneyin");



        }}



    }
    public void paraYatir(double miktar) {
        bakiye += miktar;
        String islem = "Para Yatırma: +" + miktar + " TL";
        hareketEkle(islem);
        dekontOlustur(islem);
        System.out.println("İşlem Başarılı. Yeni Bakiye: " + bakiye);
    }

    public void paraCek(double miktar) {
        if (miktar > bakiye) {
            System.out.println("Yetersiz Bakiye!");
        } else {
            bakiye -= miktar;
            String islem = "Para Çekme: -" + miktar + " TL";
            hareketEkle(islem);
            dekontOlustur(islem);
            System.out.println("İşlem Başarılı. Kalan Bakiye: " + bakiye);
        }
    }



    public void hesapOzeti() {
        System.out.println("\n--- " + isim + " HESAP ÖZETİ ---");
        for (String h : hareketler) {
            System.out.println(h);
        }
        System.out.println("Güncel Bakiye: " + bakiye + " TL\n");
    }

    // Listeye tarihli kayıt ekler
    private void hareketEkle(String aciklama) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        hareketler.add(LocalDateTime.now().format(dtf) + " - " + aciklama);
    }

    // İşlemi .txt dosyasına yazar
    private void dekontOlustur(String islemDetay) {
        try {
            FileWriter writer = new FileWriter("dekont.txt");
            writer.write("--- BANKA DEKONTU ---\n");
            writer.write("Müşteri: " + isim + "\n");
            writer.write("Hesap No: " + hesapNo + "\n");
            writer.write("İşlem: " + islemDetay + "\n");
            writer.write("Tarih: " + LocalDateTime.now() + "\n");
            writer.write("---------------------\n");
            writer.close();
            System.out.println(">> Dekont 'dekont.txt' dosyasına yazdırıldı.");
        } catch (IOException e) {
            System.out.println("Dekont oluşturulurken hata oluştu.");
        }
    }

    public String getIsim() { return isim; }
}



