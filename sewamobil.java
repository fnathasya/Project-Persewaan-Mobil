import java.util.Scanner;

public class sewamobil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean lanjutSewa = true;
        double totalBiayaSewa = 0;
        String invoice = "", namaPenyewa = "", NIK = "", pesanLagi = "";

        // Implementasi materi array untuk menyimpan nama-nama mobil, harga, dan plat nomor
        String[][] mobilData = {
            {"Honda Brio ", "AB 1234 CD", "300000"},
            {"Honda Brio ", "EF 5678 GH", "600000"},
            {"Isuzu Elf Long ", "IJ 9101 KL", "1000000"},
            {"Isuzu Elf Long ", "MN 1112 OP", "1400000"},
            {"Mitsubishi X-Pander ", "QR 1314 ST", "450000"},
            {"Mitsubishi X-Pander ", "UV 1516 WX", "750000"}
        };

        System.out.println("-------------------------------------------");
        System.out.println("| SELAMAT DATANG DI PERSEWAAN MOBIL YAPUZA |");
        System.out.println("-------------------------------------------");

        // Input Informasi penyewa
        System.out.println(" MASUKKAN INFORMASI PENYEWA : ");
        System.out.print(" Nama Penyewa : ");
        namaPenyewa = sc.nextLine();

        System.out.print(" Nomor Induk Kependudukan (NIK) : ");
        NIK = sc.nextLine();

        // Menu
        int menu;
        do {
            System.out.println("------------------------------------");
            System.out.println("|            MENU UTAMA            |");
            System.out.println("------------------------------------");
            System.out.println("| 1. Daftar Mobil                  |");
            System.out.println("| 2. Daftar Pengurutan Harga mobil |");
            System.out.println("| 3. Pemesanan                     |");
            System.out.println("------------------------------------");

            System.out.print(" Pilih Menu : ");
            menu = sc.nextInt();
            sc.nextLine(); // Membersihkan newline dari input sebelumnya

            switch (menu) {
                case 1:
                    // Menampilkan daftar mobil
                    System.out.println("Daftar sewa Mobil per hari:");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    System.out.println("| No.   |    Mobil                            | Plat Nomor    | Harga             |");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    for (int i = 0; i < mobilData.length; i++) {
                        System.out.printf("| %-6d| %-35s | %-12s | Rp. %-14s|\n",
                                i + 1, mobilData[i][0], mobilData[i][1], mobilData[i][2]);
                    }
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    break;

                case 2:
                    // Sort mobilData berdasarkan harga
                    for (int i = 1; i < mobilData.length; i++) {
                        double key = Double.parseDouble(mobilData[i][2]);
                        String[] keyData = mobilData[i];
                        int j = i - 1;
                        while (j >= 0 && Double.parseDouble(mobilData[j][2]) > key) {
                            mobilData[j + 1] = mobilData[j];
                            j--;
                        }
                        mobilData[j + 1] = keyData;
                    }

                    System.out.println("Daftar Harga Sewa Mobil dari Termurah:");
                    System.out.println("--------------------------------------------------------");
                    System.out.println("|       Mobil                         | Plat Nomor | Harga  |");
                    System.out.println("--------------------------------------------------------");
                    for (int i = 0; i < mobilData.length; i++) {
                        System.out.printf("| %-35s| %-10s | Rp. %-8s|\n",
                                mobilData[i][0], mobilData[i][1], mobilData[i][2]);
                    }
                    System.out.println("--------------------------------------------------------");
                    break;

                case 3:
                    while (lanjutSewa) {
                        // Memasukkan jumlah hari penyewaan
                        System.out.print("Masukkan jumlah hari penyewaan: ");
                        int jumlahHari = sc.nextInt();

                        // Menampilkan daftar mobil
                        System.out.println("Daftar sewa Mobil per hari:");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.println("| No.   |    Mobil                            | Plat Nomor    | Harga             |");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        for (int i = 0; i < mobilData.length; i++) {
                            System.out.printf("| %-6d| %-35s | %-12s | Rp. %-14s|\n",
                                    i + 1, mobilData[i][0], mobilData[i][1], mobilData[i][2]);
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------");

                        // Memasukkan nomor mobil yang dipilih
                        System.out.print("Masukkan nomor mobil yang dipilih (1 - " + mobilData.length + "): ");
                        int pilihanMobil = sc.nextInt();

                        // Menentukan apakah menggunakan driver atau tidak
                        System.out.print("Apakah ingin menggunakan driver? (y/n): ");
                        String menggunakanDriver = sc.next();

                        // Menentukan harga sewa berdasarkan pilihan mobil dan penggunaan driver
                        double hargaSewa = 0;
                        String mobilSewa = "";
                        if (pilihanMobil >= 1 && pilihanMobil <= mobilData.length) {
                            mobilSewa = mobilData[pilihanMobil - 1][0];
                            if (menggunakanDriver.equalsIgnoreCase("y")) {
                                hargaSewa = jumlahHari * Double.parseDouble(mobilData[pilihanMobil - 1][2]) * 2;
                                mobilSewa += " (Dengan Driver)";
                            } else if (menggunakanDriver.equalsIgnoreCase("n")) {
                                hargaSewa = jumlahHari * Double.parseDouble(mobilData[pilihanMobil - 1][2]);
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

                        // Menyusun informasi invoice
                        invoice += "-----------------------------------\n";
                        invoice += "Nama Penyewa: " + namaPenyewa + "\n";
                        invoice += "Nomor Induk Kependudukan (NIK): " + NIK + "\n";
                        invoice += "Mobil Sewa: " + mobilSewa + "\n";
                        invoice += "Plat Nomor: " + mobilData[pilihanMobil - 1][1] + "\n";
                        invoice += "Jumlah Hari: " + jumlahHari + "\n";
                        invoice += "Harga Sewa: Rp. " + hargaSewa + "\n";
                        invoice += "-----------------------------------\n";

                        // Menanyakan apakah pengguna ingin memesan mobil lagi
                        System.out.print("Apakah ingin memesan mobil lagi? (y/n): ");
                        pesanLagi = sc.next();
                        if (pesanLagi.equalsIgnoreCase("n")) {
                            lanjutSewa = false;
                        } else {
                            lanjutSewa = true;
                        }
                        sc.nextLine(); // Mengonsumsi karakter baru (newline) setelah input
                    }

                    System.out.println("Terima kasih telah menggunakan layanan kami!");

                    // Menampilkan invoice
                    System.out.println("Invoice:\n" + invoice);

                    break;
            }
        } while (menu != 3);

        System.out.println("Total Seluruh Pesanan Mobil: Rp. " + totalBiayaSewa);
    }
}
