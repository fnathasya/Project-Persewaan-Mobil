import java.util.Scanner;

public class coba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println("| SELAMAT DATANG DI PERSEWAAN MOBIL YAPUZA |");
        System.out.println("-------------------------------------------");

        boolean lanjutSewa = true;
        double totalBiayaSewa = 0;
        String invoice = "";
        String namaPenyewa = "";
        String pesanLagi = "";

        System.out.println("Masukkan informasi penyewa:");
        System.out.print("Nama penyewa: ");
        namaPenyewa = scanner.nextLine();

        while (lanjutSewa) {
            System.out.println("Daftar sewa Mobil per hari:");
            System.out.println("-------------------------------------------------");
            System.out.println("| No. |    Mobil               | Harga            |");
            System.out.println("-------------------------------------------------");
            System.out.println("| 1   | Honda Brio             | Rp. 300.000      |");
            System.out.println("|     | - Dengan Driver        | Rp. 600.000      |");
            System.out.println("| 2   | Isuzu Elf Long         | Rp. 1.000.000    |");
            System.out.println("|     | - Dengan Driver        | Rp. 1.400.000    |");
            System.out.println("| 3   | Mitsubishi X-Pander    | Rp. 450.000      |");
            System.out.println("|     | - Dengan Driver        | Rp. 750.000      |");
            System.out.println("--------------------------------------------------");

            // System.out.println("Masukkan informasi penyewa:");
            // System.out.print("Nama penyewa: ");
            // namaPenyewa = scanner.nextLine();

            // Memasukkan jumlah hari penyewaan
            System.out.print("Masukkan jumlah hari penyewaan: ");
            int jumlahHari = scanner.nextInt();

            // Memasukkan tipe mobil yang akan disewa
            System.out.print("Masukkan nomor yang dipilih (1 - 3): ");
            int pilihanMobil = scanner.nextInt();

            // Memilih apakah menggunakan driver atau tidak
            System.out.print("Apakah ingin menggunakan driver? (y/n): ");
            String menggunakanDriver = scanner.next();

            // Menghitung harga sewa
            double hargaSewa = 0;
            String mobilSewa = "";
            if (pilihanMobil == 1) { // Mobil Brio
                mobilSewa = "Mobil Honda Brio";
                if (menggunakanDriver.equalsIgnoreCase("y")) {
                    hargaSewa = jumlahHari * 600000;
                    mobilSewa += " (Dengan Driver)";
                } else if (menggunakanDriver.equalsIgnoreCase("n")) {
                    hargaSewa = jumlahHari * 300000;
                    mobilSewa += " (Lepas Kunci)";
                } else {
                    System.out.println("Input tidak valid");
                    continue;
                }
                 
            } else if (pilihanMobil == 2) { // Elf
                mobilSewa = "Mobil Isuzu Elf Long";
                if (menggunakanDriver.equalsIgnoreCase("y")) {
                    hargaSewa = jumlahHari * 1400000;
                    mobilSewa += " (Dengan Driver)";
                } else if (menggunakanDriver.equalsIgnoreCase("n")) {
                    hargaSewa = jumlahHari * 1000000;
                    mobilSewa += " (Lepas Kunci)";
                } else {
                    System.out.println("Input tidak valid");
                    continue;
                }
            } else if (pilihanMobil == 3) { // Mitsubishi X-Pander
                mobilSewa = "Mobil Mitsubishi X-Pander";
                if (menggunakanDriver.equalsIgnoreCase("y")) {
                    hargaSewa = jumlahHari * 750000;
                    mobilSewa += " (Dengan Driver)";
                } else if (menggunakanDriver.equalsIgnoreCase("n")) {
                    hargaSewa = jumlahHari * 450000;
                    mobilSewa += " (Lepas Kunci)";
                } else {
                    System.out.println("Input tidak valid");
                    continue;
                }
            } else {
                System.out.println("Input tidak valid");
                continue;
            }

            // Menambahkan harga sewa ke totalBiayaSewa
            totalBiayaSewa += hargaSewa;

            // Menambahkan informasi pemesanan ke invoice
            invoice += String.format("| %-25s | %-17s | Rp%-19.0f |%n", mobilSewa, jumlahHari + " hari", hargaSewa);

            // Menanyakan apakah pengguna ingin memesan mobil lagi
            System.out.print("Apakah ingin memesan mobil lagi? (y/n): ");
            pesanLagi = scanner.next();
            if (!pesanLagi.equalsIgnoreCase("y")) {
                lanjutSewa = false;
            }
            scanner.nextLine(); // Mengonsumsi karakter baru (newline) setelah input
        }

        // Menampilkan invoice
        System.out.println("---------------------------------------------------------------------|");
        System.out.println("|                              INVOICE                               |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("    Nama Penyewa: " + namaPenyewa                                      );
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|    Mobil                                   | Jumlah Hari  | Total Harga");
        System.out.println("----------------------------------------------------------------------");
        System.out.print(invoice);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("| Total Biaya Sewa:                          |               | Rp" + totalBiayaSewa + " ");
        System.out.println("----------------------------------------------------------------------");

        System.out.println("Terima kasih telah menggunakan layanan kami!");
        scanner.close();
    }
}
