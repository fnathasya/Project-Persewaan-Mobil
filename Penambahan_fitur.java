import java.util.Scanner;

public class Penambahan_Fitur {
    static Scanner scanner = new Scanner(System.in);
    static boolean lanjutSewa = true;
    static int totalBiayaSewa = 0;
    static int tanggalMulaiSewa = 0;

    // Data Username dan Password Untuk Login
    static String[] username = { "Faiza", "Paudra", "Yusuf" };
    static String[] password = { "f123", "p123", "y123" };

    public static void main(String[] args) {
        login();
        daftarMenu();
    }

    // Fungsi untuk login
    static void login() {
        boolean loginSuccess = false;
        do {
            // Input user dan password
            System.out.print("Masukkan username: ");
            String inputUsername = scanner.next();
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.next();

            // Loop untuk memeriksa apakah username dan password yang diinputkan benar
            for (int i = 0; i < username.length; i++) {
                if (username[i].equalsIgnoreCase(inputUsername) && password[i].equals(inputPassword)) {
                    loginSuccess = true;
                    break; // Keluar dari loop jika login berhasil
                }
            }

            // Jika username dan password benar maka login berhasil
            if (loginSuccess) {
                System.out.println("Login Success! Selamat Datang " + inputUsername + "!");
            }
            // Jika username dan password salah maka login gagal dan terdapat perintah untuk coba lagi
            else {
                System.out.println("Login Gagal! Silahkan Coba Lagi !");
            }
        } while (!loginSuccess);
    }

    // Fungsi untuk menampilkan daftar menu utama
    static void daftarMenu() {
        int menu;
        do {
            System.out.println("------------------------------------");
            System.out.println("|            MENU UTAMA            |");
            System.out.println("------------------------------------");
            System.out.println("| 1. Daftar Mobil                  |");
            System.out.println("| 2. Pemesanan                     |");
            System.out.println("| 3. Pengembalian                  |");
            System.out.println("| 4. Keluar                        |");
            System.out.println("------------------------------------");

            System.out.print(" Pilih Menu : ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    tampilkanDaftarMobil();
                    break;

                case 2:
                    pesanMobil();
                    break;

                case 3:
                    pengembalianMobil();
                    break;
            }
        } while (menu != 4);

        System.out.println("Terima kasih telah menggunakan layanan kami!");
    }

    // Fungsi untuk menampilkan daftar mobil
    static void tampilkanDaftarMobil() {
        System.out.println("Daftar sewa Mobil per hari:");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("| No.   |    Mobil                            | Plat Nomor    | Harga             | Status       |");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (int i = 0; i < mobilData.length; i++) {
            System.out.printf("| %-6d| %-35s | %-12s | Rp. %-14s | %-12s |\n",
                    i + 1, mobilData[i][0], mobilData[i][1], mobilData[i][2], mobilData[i][3]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    // Fungsi untuk pemesanan mobil
    static void pesanMobil() {
        while (lanjutSewa) {
            System.out.print("Masukkan jumlah hari penyewaan: ");
            int jumlahHari = scanner.nextInt();

            System.out.print("Masukkan tanggal mulai penyewaan (1-31): ");
            tanggalMulaiSewa = scanner.nextInt();

            tampilkanDaftarMobil();

            int pilihanMobil;
            boolean mobilValid = false;

            do {
                System.out.print("Masukkan nomor mobil yang dipilih (1 - " + mobilData.length + "): ");
                pilihanMobil = scanner.nextInt();

                if (pilihanMobil < 1 || pilihanMobil > mobilData.length) {
                    System.out.println("Nomor mobil tidak valid.");
                    continue;
                }

                if (mobilData[pilihanMobil - 1][3].equalsIgnoreCase("Sedang Disewa")) {
                    System.out.println("Maaf, mobil tersebut sedang disewa. Silakan pilih mobil lain.");
                } else {
                    mobilValid = true;
                }
            } while (!mobilValid);

            double hargaSewa = 0;
            String mobilSewa = "";
            mobilSewa = mobilData[pilihanMobil - 1][0];
            hargaSewa = jumlahHari * Double.parseDouble(mobilData[pilihanMobil - 1][2]);

            totalBiayaSewa += hargaSewa;

            tampilkanInvoice(mobilSewa, hargaSewa);

            mobilData[pilihanMobil - 1][3] = "Sedang Disewa";

            System.out.print("Apakah ingin memesan mobil lagi? (y/n): ");
            String pesanLagi = scanner.next();
            lanjutSewa = pesanLagi.equalsIgnoreCase("y");
        }
        System.out.println("Total Seluruh Pesanan Mobil: Rp. " + totalBiayaSewa);
    }

    // Fungsi untuk menampilkan invoice
    static void tampilkanInvoice(String mobilSewa, double hargaSewa) {
        System.out.println("-----------------------------------");
        System.out.println("            INVOICE               ");
        System.out.println("-----------------------------------");
        System.out.println("Nama Penyewa: " + namaPenyewa);
        System.out.println("Nomor Induk Kependudukan (NIK): " + NIK);
        System.out.println("Mobil Sewa: " + mobilSewa);
        System.out.println("Plat Nomor: " + mobilData[pilihanMobil - 1][1]);
        System.out.println("Tanggal Mulai Penyewaan: " + tanggalMulaiSewa);
        System.out.println("Jumlah Hari: " + jumlahHari);
        System.out.println("Harga Sewa: Rp. " + hargaSewa);
        System.out.println("-----------------------------------");
    }

    // Fungsi untuk pengembalian mobil
    static void pengembalianMobil() {
        System.out.print("Masukkan nomor mobil yang dikembalikan: ");
        int nomorKembali = scanner.nextInt();

        if (nomorKembali >= 1 && nomorKembali <= mobilData.length) {
            if (mobilData[nomorKembali - 1][3].equalsIgnoreCase("Sedang Disewa")) {
                System.out.print("Masukkan tanggal pengembalian: ");
                int tanggalKembali = scanner.nextInt();

                int batasHariSewa = 1;
                int denda = 0;
                if (tanggalKembali > tanggalMulaiSewa + batasHariSewa) {
                    denda = (tanggalKembali - (tanggalMulaiSewa + batasHariSewa)) * 1000000;
                }

                mobilData[nomorKembali - 1][3] = "Ready Stok";

                System.out.println("Mobil berhasil dikembalikan.");
                System.out.println("Denda: Rp. " + denda);
            } else {
                System.out.println("Mobil dengan nomor tersebut belum disewa.");
            }
        } else {
            System.out.println("Nomor mobil tidak valid.");
        }
    }

    static String[][] mobilData = {
            {"Honda Brio ", "AB 1234 CD", "300000", "Ready Stok"},
            {"Honda Jazz ", "EF 5678 GH", "600000", "Ready Stok"},
            {"Toyota Fortuner", "IJ 9101 KL", "800000", "Ready Stok"},
            {"Isuzu Elf Long ", "MN 1112 OP", "1400000", "Ready Stok"},
            {"Mitsubishi Pajero", "QR 1314 ST", "750000", "Ready Stok"},
            {"Mitsubishi X-Pander ", "UV 1516 WX", "700000", "Ready Stok"}
    };

    static String namaPenyewa;
    static String NIK;
    static int jumlahHari;
    static int pilihanMobil;
}
