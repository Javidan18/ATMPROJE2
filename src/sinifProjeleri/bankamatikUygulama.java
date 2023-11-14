package sinifProjeleri;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class bankamatikUygulama {

	public static void main(String[] args) {
		 String[][] users = {{"user1", "password1"}, {"user2", "password2"}, {"user3", "password3"}, {"user4", "password4"}, {"user5", "password5"}};
	        Scanner input = new Scanner(System.in);
	        boolean loggedIn = false;
	        String currentUser = "";
	        double balance = 1000.0;
	        long loginTime = 0;
	        LocalDateTime zaman =LocalDateTime.now();
	        while (!loggedIn) {
	            System.out.print("Kullanıcı adı: ");
	            String username = input.nextLine();
	            System.out.print("Şifre: ");
	            String password = input.nextLine();
	            for (String[] user : users) {
	                if (user[0].equals(username) && user[1].equals(password)) {
	                    loggedIn = true;
	                    currentUser = username;
	                    loginTime = System.currentTimeMillis();
	                    break;
	                }
	            }
	            if (!loggedIn) {
	                System.out.println("Kullanıcı adı veya şifre yanlış. Lütfen tekrar deneyin.");
	            }
	        }
	        System.out.println("Hoş geldiniz, " + currentUser + "!");
	        System.out.println("Giris zamani :"+zaman);
	        while (true) {
	            System.out.println("Lütfen bir işlem seçin:");
	            System.out.println("1. Para çekme");
	            System.out.println("2. Para yatırma");
	            System.out.println("3. Bakiye sorgula");
	            System.out.println("4. Çıkış");
	            int choice = input.nextInt();
	            switch (choice) {
	                case 1:
	                	System.out.print("Toplam bakiye :" + balance);
	                    System.out.println("Çekmek istediğiniz miktarı girin: ");
	                    
	                    double amount = input.nextDouble();
	                    if (amount > balance) {
	                        System.out.println("Yetersiz bakiye. Lütfen tekrar deneyin.");
	                    } else {
	                        balance -= amount;
	                        System.out.println("Para çekme işlemi gerçekleştirildi. Yeni bakiyeniz: " + balance + " TL");
	                    }
	                    break;
	                case 2:
	                    System.out.print("Yatırmak istediğiniz miktarı girin: ");
	                    amount = input.nextDouble();
	                    balance += amount;
	                    System.out.println("Para yatırma işlemi gerçekleştirildi. Yeni bakiyeniz: " + balance + " TL");
	                    break;
	                case 3:
	                    System.out.println("Mevcut bakiyeniz: " + balance + " TL");
	                    break;
	                case 4:
	                    System.out.println("Çıkış yapıldı.");
	                    loggedIn = false;
	                    break;
	                default:
	                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
	                    break;
	            }
	            if (!loggedIn) {
	                break;
	            }
	        }
	        long logoutTime = System.currentTimeMillis();
	        System.out.println("Toplam oturum süresi: " + (logoutTime - loginTime) / 1000 + " saniye");
	        System.out.println("Giriş ekranına geri dönülüyor...");
	}

}
