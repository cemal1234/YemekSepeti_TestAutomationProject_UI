# YemekSepeti_TestAutomationProject_UI

YemekSepeti Test Otomasyon Çalışması: 

•	Test Mimarisi:

o	Test Framework: TestNG
o	Test Automation Library: Selenium
o	Programming Language: Java
o	Build Tool: Maven
o	Test Report: Allure Report & Extend Report
o	Logging: TestNG Listener
o	Browser Drivers: Chrome & Firefox

•	Testi çalıştırmadan önce bilinmesi gerekenler:

o	Testlerin tamamını sırayla çalıştırmak için testng.xml dosyası run edilmelidir.
o	Yapı Paralel ve CroosBrowser koşacak şekilde tasarlandı. testng.xml dosyasında 1. Satır yorumdan çıkarılarak paralel koşturulabilir. 
o	Default browser Chrome olarak ayarlandı. Değişiklik yapmak için properties içerisinde 6. Satır firefox olarak değiştirilmelidir.
o	Ayrıca TestBase class’ında 56. Satırda testin çalışacağı bilgisayarın Firefox path’i verilmeli.
o	Login işlemlerinde kullanılacak doğru username, password, usernameText, FacebookUsername, FacebookPassword bilgilerinin properties içerisinde değiştirilmesi gerekir.

•	Raporlama:

o	Allure Report ile testlerin sonuçlarına ulaşmak için terminal’e aşağıdaki komut yazılmalıdır;
o	allure serve ProjeninBağlıOlduğuDizin\YemekSepeti_TestAutomationProject_UI\allure-results
o	Extend Report için ise test-output->Extent.html dosyası browser’da açılmalıdır. 
