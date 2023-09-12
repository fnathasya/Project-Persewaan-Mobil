import java.util.Scanner;

public class TugasJS3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Masukkan informasi mobil:");
        System.out.print("Merk mobil: ");
        String merkMobil = input.nextLine();
        
        System.out.print("Harga sewa per hari: ");
        double hargaPerHari = input.nextDouble();
        
        System.out.println("\nMasukkan informasi penyewa:");
        input.nextLine(); // Membuang karakter newline
        System.out.print("Nama penyewa: ");
        String namaPenyewa = input.nextLine();
        
        System.out.print("Lama sewa (dalam hari): ");
        int lamaSewa = input.nextInt();
        
        double totalBiaya = hargaPerHari * lamaSewa;
        
        System.out.println("\nDetail Transaksi:");
        System.out.println("Merk Mobil: " + merkMobil);
        System.out.println("Harga sewa per hari: Rp" + hargaPerHari);
        System.out.println("Nama Penyewa: " + namaPenyewa);
        System.out.println("Lama sewa (dalam hari): " + lamaSewa + " hari");
        System.out.println("Total Biaya: Rp" + totalBiaya);
    }
}       
       