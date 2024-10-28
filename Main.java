package org.example;

import java.util.Scanner;

/**
 * Kelas utama untuk aplikasi Pemesanan Penginapan.
 * Program ini menerima input pelanggan, tipe kamar, dan jumlah malam menginap,
 * kemudian menghitung dan menampilkan total biaya penginapan.
 */
class PemesananPenginapan {
    /**
     * Metode utama untuk menjalankan program Pemesanan Penginapan.
     *
     * @param args argumen baris perintah yang tidak digunakan
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ambil nama pelanggan
        String namaPelanggan = getNamaPelanggan(scanner);

        // Ambil tipe kamar
        String tipeKamar = tipekamar("Masukkan tipe kamar (Standard/Deluxe/Suite): ", scanner);

        // Ambil jumlah malam menginap
        int jumlahMalam = getJumlahMalam(scanner);

        // Hitung biaya
        Integer biayaPerMalam = getBiayaPerMalam(tipeKamar);
        if (biayaPerMalam == null) return;

        int totalBiaya = getTotalBiaya(jumlahMalam, biayaPerMalam);

        // Tampilkan informasi pemesanan
        System.out.println("Pelanggan: " + namaPelanggan);
        System.out.println("Tipe Kamar: " + tipeKamar);
        System.out.println("Jumlah Malam: " + jumlahMalam);
        System.out.println("Total Biaya: Rp " + totalBiaya);
    }

    /**
     * Menghitung total biaya penginapan berdasarkan jumlah malam dan biaya per malam.
     * @param jumlahMalam    jumlah malam menginap
     * @param biayaPerMalam  biaya per malam
     * @return total biaya penginapan
     */
    private static int getTotalBiaya(int jumlahMalam, Integer biayaPerMalam) {
        return getBiaya(jumlahMalam, biayaPerMalam);
    }

    /**
     * Mengambil biaya per malam berdasarkan tipe kamar.
     *
     * @param tipeKamar tipe kamar yang dipilih (Standard, Deluxe, Suite)
     * @return biaya per malam atau null jika tipe kamar tidak valid
     */
    private static Integer getBiayaPerMalam(String tipeKamar) {
        int biayapermalam = 0;
        if (tipeKamar.equalsIgnoreCase("Standard")) {
            biayapermalam = 500000;
        } else if (tipeKamar.equalsIgnoreCase("Deluxe")) {
            biayapermalam = 750000;
        } else if (tipeKamar.equalsIgnoreCase("Suite")) {
            biayapermalam = 1000000;
        } else {
            System.out.println("Tipe kamar tidak valid");
            return null;
        }
        return biayapermalam;
    }

    /**
     * Mengambil jumlah malam menginap dari input pengguna.
     *
     * @param scanner Scanner untuk membaca input
     * @return jumlah malam menginap
     */
    private static int getJumlahMalam(Scanner scanner) {
        System.out.println("Masukkan jumlah malam menginap: ");
        return scanner.nextInt();
    }

    /**
     * Mengambil nama pelanggan dari input pengguna.
     *
     * @param scanner Scanner untuk membaca input
     * @return nama pelanggan
     */
    protected static String getNamaPelanggan(Scanner scanner) {
        System.out.println("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        return namaPelanggan;
    }

    /**
     * Mengambil tipe kamar dari input pengguna.
     *
     * @param x pesan untuk ditampilkan
     * @param scanner Scanner untuk membaca input
     * @return tipe kamar
     */
    private static String tipekamar(String x, Scanner scanner) {
        System.out.println(x);
        String tipeKamar = scanner.nextLine();
        return tipeKamar;
    }

    /**
     * Menghitung total biaya berdasarkan jumlah malam dan biaya per malam.
     *
     * @param jumlahMalam jumlah malam menginap
     * @param biayaPerMalam biaya per malam
     * @return total biaya penginapan
     */
    private static int getBiaya(int jumlahMalam, Integer biayaPerMalam) {
        int totalBiaya = jumlahMalam * biayaPerMalam;
        return totalBiaya;
    }
}