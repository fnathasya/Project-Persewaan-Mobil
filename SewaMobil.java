import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class done {
   static Scanner scanner = new Scanner(System.in);
    static int loggedInUserIndex = -1;
    static boolean lanjutSewa = true;
    static Date tanggalMulai;
    static int totalBiayaSewa = 0;
    static boolean berhenti = false;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Array untuk meyimpan data laporan keuangan per hari dan per bulan
    static int[] keuanganPerhari = new int[100];
    static int[] keuanganPerBulan = new int[100];

    // Data Username dan Password Untuk Login
    static String[] username = { "Faiza", "Paudra", "Yusuf" };
    static String[] password = { "f123", "p123", "y123" };
    static String[] roles = { "admin", "kasir", "manager" };
    static String loggedInUser = null;

    // Array untuk menyimpan histori pemesanan
    static String[] historiPemesanan = new String[100];
    static int jumlahPemesanan = 0;

    public static void main(String[] args) {
        while(!berhenti){
        System.out.println("--------------------------------------------");
        System.out.println("|                                          |");
        System.out.println("|       PERSEWAAN MOBIL YAPUZA             |");
        System.out.println("|                                          |");
        System.out.println("--------------------------------------------");
        System.out.println("| SELAMAT DATANG DI PERSEWAAN MOBIL YAPUZA |");
        System.out.println("--------------------------------------------");
        login();
        daftarMenu();
        }
    }

    // Fungsi untuk login
    static void login() {
        boolean loginSuccess = false;
        do {
            // Input user dan password
            System.out.print(" Masukkan username: ");
            String inputUsername = scanner.next();
            System.out.print(" Masukkan password: ");
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
                System.out.println("------------------------------------------");
                System.out.println("| LOGIN BERHASIL! Selamat Datang " + inputUsername + "!|");
                System.out.println("------------------------------------------");

            }
            // Jika username dan password salah maka login gagal dan terdapat perintah untuk
            // coba lagi
            else {
                System.out.println("-------------------------------------");
                System.out.println("| LOGIN GAGAL! SILAHKAN COBA LAGI ! |");
                System.out.println("-------------------------------------");

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
            System.out.println("|        1. DAFTAR MOBIL           |");
            System.out.println("|        2. PEMESANAN              |");
            System.out.println("|        3. PENGEMBALIAN           |");
            System.out.println("|        4. RIWAYAT PEMESANAN      |");
            System.out.println("|        5. GANTI ADMIN            |");
            System.out.println("|        6. KELUAR                 |");
            System.out.println("------------------------------------");

            System.out.print("| Pilih Menu : ");
            menu = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

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
                case 4:
                    tampilkanRiwayatPemesanan();
            }
        } while (menu < 5 && menu > 1);
        if(menu == 6){
        berhenti = true;
        System.out.println("------------------------------------------------");
        System.out.println("| TERIMA KASIH TELAH MENGGUNAKAN LAYANAN KAMI! |");
        System.out.println("------------------------------------------------");
        }
    }
    static String[][] mobilData = {
            { "Honda Brio ", "AB 1234 CD", "300000", "Ready Stok" },
            { "Honda Jazz ", "EF 5678 GH", "600000", "Ready Stok" },
            { "Toyota Fortuner", "IJ 9101 KL", "800000", "Ready Stok" },
            { "Isuzu Elf Long ", "MN 1112 OP", "1400000", "Ready Stok" },
            { "Mitsubishi Pajero", "QR 1314 ST", "750000", "Ready Stok" },
            { "Mitsubishi X-Pander ", "UV 1516 WX", "700000", "Ready Stok" }
    };

    // Fungsi untuk menampilkan daftar mobil
    static void tampilkanDaftarMobil() {
        System.out.println("----------------");
        System.out.println("| DAFTAR MOBIL |");
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        System.out.println(
                "|  NO   |                MOBIL                |  PLAT NOMOR  |       HARGA        |    STATUS    |");
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        for (int i = 0; i < mobilData.length; i++) {
            System.out.printf("| %-6d| %-35s | %-12s | Rp. %-14s | %-12s |\n",
                    i + 1, mobilData[i][0], mobilData[i][1], mobilData[i][2], mobilData[i][3]);
        }
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
    }

    // Fungsi untuk pemesanan mobil
    static void pesanMobil() {

        while (lanjutSewa) {

            System.out.println("--------------------------------");
            System.out.println("|  MASUKKAN INFORMASI PENYEWA  |");
            System.out.println("--------------------------------");

            System.out.print(" Nama Penyewa : ");
            String namaPenyewa = scanner.next();

            System.out.print(" Nomor Induk Kependudukan (NIK) : ");
            String NIK = scanner.next();

            System.out.println("--------------------------------");
            System.out.println("|          FORM SEWA           |");
            System.out.println("--------------------------------");

            System.out.print(" Masukkan jumlah hari penyewaan: ");
            int jumlahHari = scanner.nextInt();

            System.out.print(" Masukkan tanggal mulai penyewaan (1-31): ");
            tanggalMulaiSewa = scanner.nextInt();

            tampilkanDaftarMobil();

            int pilihanMobil;
            boolean mobilValid = false;

            do {
                System.out.print(" Masukkan nomor mobil yang dipilih (1 - " + mobilData.length + "): ");
                pilihanMobil = scanner.nextInt();

                if (pilihanMobil < 1 || pilihanMobil > mobilData.length) {
                    System.out.println("---------------------------");
                    System.out.println("| NOMOR MOBIL TIDAK VALID |");
                    System.out.println("---------------------------");
                    continue;
                }

                if (mobilData[pilihanMobil - 1][3].equalsIgnoreCase("Sedang Disewa")) {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("| MAAF, MOBIL TERSEBUT SEDANG DISEWA. SILAHKAN PILIH MOBIL LAIN. |");
                    System.out.println("------------------------------------------------------------------");

                } else {
                    mobilValid = true;
                }
            } while (!mobilValid);

            double hargaSewa = 0;
            String mobilSewa = mobilData[pilihanMobil - 1][0];
            hargaSewa = jumlahHari * Double.parseDouble(mobilData[pilihanMobil - 1][2]);
            totalBiayaSewa += hargaSewa;

            mobilData[pilihanMobil - 1][3] = "Sedang Disewa";

            // Tampilkan invoice setelah total pesanan mobil
            System.out.println("--------------------------------------------------");
            System.out.println("| Total Seluruh Pesanan Mobil: Rp. " + totalBiayaSewa + " |");
            System.out.println("--------------------------------------------------");

            // Tampilkan invoice setelah total pesanan mobil
            String invoice = tampilkanInvoice(mobilSewa, hargaSewa, jumlahHari, pilihanMobil, namaPenyewa, NIK);

            // Menyimpan histori pemesanan
            simpanHistoriPemesanan(invoice);

            System.out.print(" Apakah ingin memesan mobil lagi? (y/n): ");
            String pesanLagi = scanner.next();
            lanjutSewa = pesanLagi.equalsIgnoreCase("y");
        }
    }

    // Fungsi untuk menampilkan invoice dan mengembalikan informasi sebagai string
    static String tampilkanInvoice(String mobil, double harga, int hari, int pilihanMobil, String nama, String NIK) {
        StringBuilder invoice = new StringBuilder();
        invoice.append("----------------------------------------\n");
        invoice.append("|               INVOICE                |\n");
        invoice.append("----------------------------------------\n");
        invoice.append("| Mobil             : ").append(mobil).append("\n");
        invoice.append("| Harga Sewa Mobil  : Rp. ").append(mobilData[pilihanMobil - 1][2]).append("\n");
        invoice.append("| Jumlah Hari       : ").append(hari).append("\n");
        invoice.append("| Total Biaya       : Rp. ").append(totalBiayaSewa).append("\n");
        invoice.append("| Nama Pelanggan    : ").append(nama).append("\n");
        invoice.append("| NIK Pelanggan     : ").append(NIK).append("\n");
        invoice.append("----------------------------------------\n");

        System.out.println(invoice.toString());

        return invoice.toString();
    }

    // Fungsi untuk pengembalian mobil
    static void pengembalianMobil() {
        System.out.println("--------------------------------------------");
        System.out.println("|          FORM PENGEMBALIAN MOBIL         |");
        System.out.println("--------------------------------------------");

        System.out.print(" Masukkan nomor mobil yang dikembalikan: ");
        int nomorKembali = scanner.nextInt();

        if (nomorKembali >= 1 && nomorKembali <= mobilData.length) {
            if (mobilData[nomorKembali - 1][3].equalsIgnoreCase("Sedang Disewa")) {
                System.out.print(" Masukkan tanggal pengembalian: ");
                int tanggalKembali = scanner.nextInt();

                int batasHariSewa = 1;
                int denda = 0;
                if (tanggalKembali > tanggalMulaiSewa + batasHariSewa) {
                    denda = (tanggalKembali - (tanggalMulaiSewa + batasHariSewa)) * 100000;
                }

                mobilData[nomorKembali - 1][3] = "Ready Stok";

                System.out.println("--------------------------------------------");
                System.out.println("|            PENGEMBALIAN MOBIL            |");
                System.out.println("--------------------------------------------");
                System.out.println("|       MOBIL " + nomorKembali + " BERHASIL DIKEMBALIKAN!       |");
                System.out.println("|       Denda: Rp. " + denda + "           ");
                System.out.println("--------------------------------------------");

            } else {
                System.out.println("Mobil dengan nomor tersebut belum disewa.");
            }
        } else {
            System.out.println("Nomor mobil tidak valid.");
        }
    }

    // Fungsi untuk menampilkan riwayat pemesanan
    static void tampilkanRiwayatPemesanan() {
        System.out.println("----------------------------------------\n");
        System.out.println("|           RIWAYAT PEMESANAN            |\n");
        System.out.println("----------------------------------------\n");
        for (int i = 0; i < jumlahPemesanan; i++) {
            System.out.println(historiPemesanan[i]);
        }
        System.out.println("----------------------------");
    }

    // Fungsi untuk menyimpan histori pemesanan
    static void simpanHistoriPemesanan(String histori) {
        historiPemesanan[jumlahPemesanan] = histori;
        jumlahPemesanan++;
    }
// Fungsi untuk update keuangan per hari
    static void updateKeuanganPerHari(Date tanggal, int totalBiaya) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tanggal);
        int perHari = calendar.get(Calendar.DAY_OF_MONTH);
        keuanganPerhari[perHari] += totalBiaya;
    }

    // Fungsi untuk update keuangan per bulan
    static void updateKeuanganPerBulan(Date tanggal, int totalBiaya) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tanggal);
        int perBulan = calendar.get(Calendar.MONTH); // Ganti dengan indeks bulan
        keuanganPerBulan[perBulan] += totalBiaya;
    }

    // Fungsi untuk menampilkan laporan keuangan per hari
    static void tampilkanLaporanKeuanganPerHari() {
        System.out.println("----------------------------------------");
        System.out.println("|      LAPORAN KEUANGAN PER HARI       |");
        System.out.println("----------------------------------------");
        for (int i = 1; i < keuanganPerhari.length; i++) {
            if (keuanganPerhari[i] > 0) {
                System.out.println("| Tanggal: " + i + " - Total Pendapatan: Rp. " + keuanganPerhari[i] + " |");
            }
        }
        System.out.println("----------------------------------------");
    }

    // Fungsi untuk menampilkan laporan keuangan per bulan
    static void tampilkanLaporanKeuanganPerBulan() {
        System.out.println("----------------------------------------");
        System.out.println("|      LAPORAN KEUANGAN PER BULAN      |");
        System.out.println("----------------------------------------");
        String[] namaBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September",
                "Oktober", "November", "Desember" };

        // Perbarui loop agar sesuai dengan panjang array keuanganPerBulan
        for (int i = 0; i < keuanganPerBulan.length; i++) {
            if (keuanganPerBulan[i] > 0) {
                System.out
                        .println("| Bulan " + namaBulan[i] + " - Total Pendapatan: Rp. " + keuanganPerBulan[i] + " |");
            }
        }
        System.out.println("----------------------------------------");
    }
   // Fungsi untuk pemesanan mobil
    static void pesanMobil() {
        lanjutSewa = true;

        System.out.println("--------------------------------");
        System.out.println("|  MASUKKAN INFORMASI PENYEWA  |");
        System.out.println("--------------------------------");

        System.out.print(" Nama Penyewa : ");
        String namaPenyewa = scanner.next();

        System.out.print(" Nomor Induk Kependudukan (NIK) : ");
        String NIK = scanner.next();

        while (lanjutSewa) {
           
            System.out.println("--------------------------------");
            System.out.println("|          FORM SEWA           |");
            System.out.println("--------------------------------");

            System.out.print(" Masukkan jumlah hari penyewaan: ");
            int jumlahHari = scanner.nextInt();

            System.out.print(" Masukkan tanggal mulai penyewaan (dd/MM/yyyy): ");
            String inputTanggalMulai = scanner.next();

            try {
                tanggalMulai = dateFormat.parse(inputTanggalMulai);

                // Update keuangan per hari
                updateKeuanganPerHari(tanggalMulai, totalBiayaSewa);
                // Update keuangan per bulan
                updateKeuanganPerBulan(tanggalMulai, totalBiayaSewa);
                tampilkanDaftarMobil();

                int pilihanMobil;
                boolean mobilValid = false;

                do {
                    System.out.print(" Masukkan nomor mobil yang dipilih (1 - " + mobilData.length + "): ");
                    pilihanMobil = scanner.nextInt();

                    if (pilihanMobil < 1 || pilihanMobil > mobilData.length) {
                        System.out.println("---------------------------");
                        System.out.println("| NOMOR MOBIL TIDAK VALID |");
                        System.out.println("---------------------------");
                        continue;
                    }

                    if (mobilData[pilihanMobil - 1][3].equalsIgnoreCase("Sedang Disewa")) {
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("| MAAF, MOBIL TERSEBUT SEDANG DISEWA. SILAHKAN PILIH MOBIL LAIN. |");
                        System.out.println("------------------------------------------------------------------");

                    } else {
                        mobilValid = true;
                    }
                } while (!mobilValid);

                double hargaSewa = 0;
                String mobilSewa = mobilData[pilihanMobil - 1][0];
                hargaSewa = jumlahHari * Double.parseDouble(mobilData[pilihanMobil - 1][2]);
                totalBiayaSewa += hargaSewa;

                mobilData[pilihanMobil - 1][3] = "Sedang Disewa";

                // Tampilkan invoice setelah total pesanan mobil
                String invoice = tampilkanInvoice(mobilSewa, hargaSewa, jumlahHari, pilihanMobil, namaPenyewa, NIK,
                        tanggalMulai);

                // Menyimpan histori pemesanan
                simpanHistoriPemesanan(invoice);

                // menampilkan metode pembayaran
                tampilkanMetodePembayaran();

            } catch (ParseException e) {
                System.out.println("Format tanggal tidak valid.");
            }

            System.out.print(" Apakah ingin memesan mobil lagi? (y/n): ");
            String pesanLagi = scanner.next();
            lanjutSewa = pesanLagi.equalsIgnoreCase("y");
        }

    }

    // Fungsi untuk menampilkan pilihan metode pembayaran
    static void tampilkanMetodePembayaran() {
        System.out.println("----------------------------------------");
        System.out.println("|        METODE PEMBAYARAN             |");
        System.out.println("----------------------------------------");
        System.out.println("|  Pilih Metode Pembayaran:           |");
        System.out.println("|  1. Tunai                            |");
        System.out.println("|  2. QRIS                             |");
        System.out.println("|  3. Transfer                         |");
        System.out.println("----------------------------------------");
        System.out.print("|  Masukkan pilihan: ");
        int metodePembayaran = scanner.nextInt();

        // proses pembayaran
        switch (metodePembayaran) {
            case 1:
                System.out.println("--------------------------------------");
                System.out.println("| Pembayaran berhasil. Terima kasih! |");
                System.out.println("--------------------------------------");
                break;
            case 2:
                System.out.println("-----------------------------------------------------");
                System.out.println("| Silakan scan QRIS untuk pembayaran. Terima kasih! |");
                System.out.println("-----------------------------------------------------");
                break;
            case 3:
                System.out.println("---------------------------");
                System.out.println("| TRANSFER BCA 6212252908 |");
                System.out.println("--------------------------------------------------------------");
                System.out.println("| Silakan transfer ke nomor rekening tersebut. Terima kasih! |");
                System.out.println("--------------------------------------------------------------");
                break;
            default:
                System.out.println("---------------------------------------------------------");
                System.out.println("| Metode pembayaran tidak valid. Pembayaran dibatalkan. |");
                System.out.println("---------------------------------------------------------");

        }
    }

    // Fungsi untuk menampilkan invoice dan mengembalikan informasi sebagai string
    static String tampilkanInvoice(String mobil, double harga, int hari, int pilihanMobil, String nama, String NIK,
            Date tanggalMulai) {
        StringBuilder invoice = new StringBuilder();
        invoice.append("----------------------------------------\n");
        invoice.append("|               INVOICE                |\n");
        invoice.append("----------------------------------------\n");
        invoice.append("| Nama Pelanggan    : ").append(nama).append("\n");
        invoice.append("| NIK Pelanggan     : ").append(NIK).append("\n");
        invoice.append("| Mobil             : ").append(mobil).append("\n");
        invoice.append("| Harga Sewa Mobil  : Rp. ").append(mobilData[pilihanMobil - 1][2]).append("\n");
        invoice.append("| Tanggal Mulai     : ").append(tanggalMulai).append("\n");
        invoice.append("| Jumlah Hari       : ").append(hari).append("\n");
        invoice.append("| Total Biaya       : Rp. ").append(totalBiayaSewa).append("\n");
        invoice.append("----------------------------------------\n");

        System.out.println(invoice.toString());

        return invoice.toString();
    }

    // Fungsi untuk pengembalian mobil
    static void pengembalianMobil() {
        System.out.println("--------------------------------------------");
        System.out.println("|          FORM PENGEMBALIAN MOBIL         |");
        System.out.println("--------------------------------------------");

        System.out.print(" Masukkan nomor mobil yang dikembalikan: ");
        int nomorKembali = scanner.nextInt();

        if (nomorKembali >= 1 && nomorKembali <= mobilData.length) {
            if (mobilData[nomorKembali - 1][3].equalsIgnoreCase("Sedang Disewa")) {
                System.out.print(" Masukkan tanggal pengembalian (dd/MM/yyyy): ");
                String inputTanggalKembali = scanner.next();

                try {
                    Date tanggalKembali = dateFormat.parse(inputTanggalKembali);

                    long selisihHari = TimeUnit.DAYS.convert(tanggalKembali.getTime() - tanggalMulai.getTime(),
                            TimeUnit.MILLISECONDS);

                    int batasHariSewa = 1;
                    int denda = 0;
                    if (selisihHari > batasHariSewa) {
                        denda = (int) (selisihHari - batasHariSewa) * 100000;
                    }

                    mobilData[nomorKembali - 1][3] = "Ready Stok";

                    System.out.println("--------------------------------------------");
                    System.out.println("|            PENGEMBALIAN MOBIL            |");
                    System.out.println("--------------------------------------------");
                    System.out.println("|       MOBIL " + nomorKembali + " BERHASIL DIKEMBALIKAN!       |");
                    System.out.println("|       Denda: Rp. " + denda + "           ");
                    System.out.println("--------------------------------------------");

                } catch (ParseException e) {
                    System.out.println("Format tanggal tidak valid.");
                }
            } else {
                System.out.println("Mobil dengan nomor tersebut belum disewa.");
            }
        } else {
            System.out.println("Nomor mobil tidak valid.");
        }
    }
}
