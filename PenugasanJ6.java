import java.util.Scanner;

public class Tugasdaspro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println("| SELAMAT DATANG DI PERSEWAAN MOBIL YAPUZA |");
        System.out.println("-------------------------------------------");

        System.out.println("Daftar sewa Mobil per hari:");
        System.out.println("-------------------------------------------------");
        System.out.println("| No. |    Mobil               | Harga            |");
        System.out.println("-------------------------------------------------");
        System.out.println("| 1   | Brio - Lepas Kunci     | Rp. 300.000      |");
        System.out.println("|     | - Dengan Driver        | Rp. 600.000      |");
        System.out.println("| 2   | Isuzu Elf Long         | Rp. 1.400.000    |");
        System.out.println("| 3   | Mitsubishi X-Pander    | Rp. 450.000      |");
        System.out.println("|     | - Dengan Driver        | Rp. 750.000      |");
        System.out.println("-------------------------------------------------");

        // Memasukkan jumlah hari penyewaan
        System.out.print("Masukkan jumlah hari penyewaan: ");
        int jumlahHari = scanner.nextInt();

        // Memasukkan tipe mobil yang akan disewa

        System.out.print("Masukkan nomor yang dipilih (1 - 3): ");
        int pilihanMobil = scanner.nextInt();

        // Memilih apakah menggunakan driver atau tidak
        System.out.print("Apakah ingin menggunakan driver? (y/n)");
        String menggunakanDriver = scanner.next();

        // Menghitung harga sewa
        double hargaSewa = 0;
        if (pilihanMobil == 1) { // Mobil Brio
            System.out.println("Anda memilih mobil Brio");
            if (menggunakanDriver.equalsIgnoreCase("y")) {
                hargaSewa = jumlahHari * 600000;
                System.out.println("Harga sewa mobil Brio selama " + jumlahHari + " hari dengan driver adalah: " + hargaSewa);
            } else if (menggunakanDriver.equalsIgnoreCase("n")) {
                hargaSewa = jumlahHari * 300000;
                System.out.println("Harga sewa mobil Brio selama " + jumlahHari + " hari tanpa driver adalah: " + hargaSewa);
            } else {
                System.out.println("Input tidak valid");
            }    
        
        } else if (pilihanMobil == 2) { // Elf
            System.out.println("Anda memilih mobil Isuzu Elf Long");
            if (menggunakanDriver.equalsIgnoreCase("y")) {
                hargaSewa = jumlahHari * 1400000;
                System.out.println("Harga sewa mobil Suzuki selama " + jumlahHari + " hari dengan driver adalah: " + hargaSewa);
            } else if (menggunakanDriver.equalsIgnoreCase("n")) {
                System.out.println("Mobil tidak tersedia tanpa driver");
            } else {
                System.out.println("Input tidak valid");
            }

          } else if (pilihanMobil == 3) { // Mitsubishi X-Pander
            System.out.println("Anda memilih mobil Mitsubishi X-Pander");
            if (menggunakanDriver.equalsIgnoreCase("y")) {
                hargaSewa = jumlahHari * 750000;
                System.out.println("Harga sewa mobil Suzuki selama " + jumlahHari + " hari dengan driver adalah: " + hargaSewa);
            } else if (menggunakanDriver.equalsIgnoreCase("n")) {
                 hargaSewa = jumlahHari * 450000;
                System.out.println("Harga sewa mobil Brio selama " + jumlahHari + " hari tanpa driver adalah: " + hargaSewa);   
            } else {
                System.out.println("Input tidak valid");
            }
        } else  {
            System.out.println("Input tidak valid");
        }
    }
}
