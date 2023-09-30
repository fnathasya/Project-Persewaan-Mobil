import java.util.Scanner;

public class PenugasanJ5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("| SELAMAT DATANG DI PERSEWAAN MOBIL |");
        System.out.println("-------------------------------------");

        // Daftar mobil dan harga
        System.out.println("Daftar sewa Mobil per hari:");
        System.out.println("1. Avanza - Rp. 325.000");
        System.out.println("2. Brio  - Rp.300.000 ");
        System.out.println("3. Elf - Rp. 1.400.000");

        // Meminta input dari pengguna
        System.out.print("Masukkan nomor yang dipilih (1 - 3): ");
        int nomorMobil = input.nextInt();

        // Variabel untuk menyimpan nama menu dan harga
        String namaMobil = "";
        int hargaSewa = 0;

        // Menggunakan switch-case untuk menentukan daftar mobil berdasarkan nomor yang dimasukkan
        switch (nomorMobil) {
            case 1:
                namaMobil = "Avanza";
                hargaSewa = 325000;
                break;
            case 2:
                namaMobil = "Brio";
                hargaSewa = 350000;
                break;
            case 3:
                namaMobil = "Elf";
                hargaSewa = 1400000;
                break;
            default:
                System.out.println("Nomor menu tidak valid.");
                return;
        }

        System.out.print("Lama Sewa/ hari :");
        int lamaSewa = input.nextInt();
        int total = hargaSewa * lamaSewa;

        // Menampilkan pesanan pelanggan
        System.out.println("Anda telah memilih: " + namaMobil);
        System.out.println("Harga: Rp " + total);

    }
}
