🏦 Java Konsol Banka Sistemi Uygulaması
Bu proje, temel bankacılık işlemlerini (para yatırma, çekme, transfer, hesap özeti) simüle eden, nesne yönelimli programlama (OOP) prensipleriyle geliştirilmiş bir Java Konsol Uygulamasıdır.

📌 İçindekiler
Proje Hakkında

Öne Çıkan Özellikler

Kullanılan Teknolojiler

Proje Yapısı ve Sınıf Analizi

Kurulum ve Çalıştırma

Kullanım Senaryosu

Dosya Çıktıları (Dekont Sistemi)

Gelecek Geliştirmeler

📖 Proje Hakkında
Bu uygulama, bir kullanıcının banka hesabını dijital ortamda yönetmesini sağlar. Güvenli bir giriş paneli ile başlayan süreç, kullanıcının ana menü üzerinden bakiye kontrolü yapmasına, farklı yöntemlerle para göndermesine ve yaptığı her işlemin dijital bir dekontunu almasına olanak tanır.

✨ Öne Çıkan Özellikler
Güvenli Giriş Sistemi: Kullanıcı adı ve şifre doğrulama mekanizması.

Dinamik Hesap Özeti: Tüm işlemlerin tarih ve saat bilgisiyle kronolojik olarak listelenmesi.

Gelişmiş Para Transferi: IBAN, GSM numarası veya Hesap No ile transfer seçenekleri.

Bakiye Kontrolü: Yetersiz bakiye durumunda işlemin reddedilmesi ve kullanıcıya uyarı verilmesi.

Otomatik Dekont Oluşturma: Her finansal işlem sonrası dekont.txt dosyasına işlem detaylarının yazılması.

Şifre Yönetimi: Uygulama içerisinden mevcut şifrenin değiştirilebilmesi.

🛠 Kullanılan Teknolojiler
Dil: Java (JDK 8 veya üzeri)

Kütüphaneler:

java.util.Scanner (Kullanıcı etkileşimi için)

java.util.ArrayList (İşlem geçmişini tutmak için)

java.time.LocalDateTime (Tarih ve saat damgaları için)

java.io.FileWriter (Dosya sistemine dekont yazmak için)

🏗 Proje Yapısı ve Sınıf Analizi
Proje üç temel sınıftan oluşmaktadır:

1. BankaUygulamasi.java
Uygulamanın giriş noktasıdır (main metodu). Ana menü döngüsünü yönetir ve kullanıcı seçimlerine göre ilgili sınıfların metodlarını çağırır.

2. Hesap.java
Projenin "Business Logic" (İş Mantığı) katmanıdır.

Bakiye Yönetimi: Para yatırma ve çekme metotları.

Transfer Sistemi: Farklı alıcı türlerine göre özelleştirilmiş gönderim seçenekleri.

Veri Kaydı: İşlem geçmişini ArrayList yapısında tutar ve her işlemde dekontOlustur() metodunu tetikler.

3. GirisPaneli.java
Kullanıcı etkileşiminin başladığı ilk noktadır. Kimlik doğrulama süreçlerini (Authentication) ve hatalı giriş denemelerini kontrol eder.

🚀 Kurulum ve Çalıştırma
Depoyu Klonlayın:

Bash

git clone https://github.com/kullaniciadi/banka-sistemi-java.git
Dosyaları Derleyin: Terminal üzerinden proje klasörüne giderek şu komutu çalıştırın:

Bash

javac BankaUygulamasi.java Hesap.java GirisPaneli.java
Uygulamayı Başlatın:

Bash

java BankaUygulamasi
🕹 Kullanım Senaryosu
Giriş: Varsayılan kullanıcı adı admin, şifre 12345 olarak belirlenmiştir.

Ana Menü: Giriş sonrası sizi karşılayan menüden 1-5 arası bir seçim yapın.

Transfer: Para gönderimi yaparken IBAN veya telefon numarasını girip miktarı belirleyin.

Çıkış: 0 tuşuna basarak güvenli bir şekilde oturumu kapatın.

📄 Dosya Çıktıları (Dekont Sistemi)
Yapılan her başarılı işlem (Yatırma, Çekme, Transfer) sonrası sistem otomatik olarak projenin ana dizininde bir dekont.txt dosyası oluşturur.

Örnek Dekont İçeriği:

Plaintext

--- BANKA DEKONTU ---
Müşteri: Ali Yılmaz
Hesap No: 123456
İşlem: Havale Giden (IBAN: 1.0234567E7): -200.0 TL
Tarih: 2026-01-09T14:30:15.123
---------------------
🛤 Gelecek Geliştirmeler
[ ] Verilerin bir veri tabanında (MySQL/PostgreSQL) saklanması.

[ ] Birden fazla hesap açma özelliği.

[ ] Swing veya JavaFX kullanılarak bir Grafik Kullanıcı Arayüzü (GUI) eklenmesi.

[ ] Döviz hesabı ve anlık kur dönüşüm entegrasyonu.

⭐ Bu projeyi beğendiyseniz yıldız vermeyi unutmayın!
