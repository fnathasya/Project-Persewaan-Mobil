import java.util.Scanner;

public class Penambahan_Fitur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjutSewa = true;
        int totalBiayaSewa = 0;
        int tanggalMulaiSewa = 0;

        //  Data Username dan Password Untuk Login
        String[] username = { "Faiza", "Paudra", "Yusuf" };
        String[] password = { "f123", "p123", "y123" };

        boolean loginSuccess = false;
        do {
                // Input user dan password
                System.out.print("Masukkan username: ");
                String inputUsername = scanner.next();
                System.out.print("Masukkan password: ");
                String inputPassword = scanner.next();

                // loop untuk memeriksa apakah username dan passowrd yang diinputkan benar
                for (int i = 0; i < username.length; i++) {
                    if (username[i].equalsIgnoreCase(inputUsername) && password[i].equals(inputPassword)) {
                        loginSuccess = true;
                        break; // Keluar dari loop jika login berhasil
                    }
                }
                
                // jika username dan password benar maka login berhasil
                if (loginSuccess) {
                    System.out.println("Login Success! Selamat Datang " + inputUsername +"!");
                    // jika username dan password salah maka login gagal dan terdapat perintah untuk coba lagi
                } else {
                    System.out.println("Login Gagal! Silahkan Coba Lagi !");
                }
        } while (!loginSuccess);


        String[][] mobilData = {
                {"Honda Brio ", "AB 1234 CD", "300000", "Ready Stok"},
                {"Honda Jazz ", "EF 5678 GH", "600000", "Ready Stok"},
                {"Toyota Fortuner", "IJ 9101 KL", "800000", "Ready Stok"},
                {"Isuzu Elf Long ", "MN 1112 OP", "1400000", "Ready Stok"},
                {"Mitsubishi Pajero", "QR 1314 ST", "750000", "Ready Stok"},
                {"Mitsubishi X-Pander ", "UV 1516 WX", "700000", "Ready Stok"}
        };

        System.out.println("-------------------------------------------");
        System.out.println("| SELAMAT DATANG DI PERSEWAAN MOBIL YAPUZA |");
        System.out.println("-------------------------------------------");

        System.out.println(" MASUKKAN INFORMASI PENYEWA : ");
        System.out.print(" Nama Penyewa : ");
        String namaPenyewa = scanner.next();

        System.out.print(" Nomor Induk Kependudukan (NIK) : ");
        String NIK = scanner.next();

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
                    // Menampilkan daftar mobil
                    System.out.println("Daftar sewa Mobil per hari:");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    System.out.println("| No.   |    Mobil                            | Plat Nomor    | Harga             | Status       |");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    for (int i = 0; i < mobilData.length; i++) {
                        System.out.printf("| %-6d| %-35s | %-12s | Rp. %-14s | %-12s |\n",
                                i + 1, mobilData[i][0], mobilData[i][1], mobilData[i][2], mobilData[i][3]);
                    }
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    break;

                case 2:
                    while (lanjutSewa) {
                        System.out.print("Masukkan jumlah hari penyewaan: ");
                        int jumlahHari = scanner.nextInt();

                        System.out.print("Masukkan tanggal mulai penyewaan (1-31): ");
                        tanggalMulaiSewa = scanner.nextInt();

                        System.out.println("Daftar sewa Mobil per hari:");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.println("| No.   |    Mobil                            | Plat Nomor    | Harga             | Status       |");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        for (int i = 0; i < mobilData.length; i++) {
                            System.out.printf("| %-6d| %-35s | %-12s | Rp. %-14s | %-12s |\n",
                                    i + 1, mobilData[i][0], mobilData[i][1], mobilData[i][2], mobilData[i][3]);
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------");

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

                        mobilData[pilihanMobil - 1][3] = "Sedang Disewa";

                        System.out.print("Apakah ingin memesan mobil lagi? (y/n): ");
                        String pesanLagi = scanner.next();
                        lanjutSewa = pesanLagi.equalsIgnoreCase("y");
                    }
                    System.out.println("Total Seluruh Pesanan Mobil: Rp. " + totalBiayaSewa);
                    break;

                case 3:
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
                    break;
            }
        } while (menu != 4);
        System.out.println("Terima kasih telah menggunakan layanan kami!");
    }
}
