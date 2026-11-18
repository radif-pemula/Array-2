import java.util.Scanner;

public class UjianUlang_264107060004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalBukuGambar = 0, totalKrayon = 0, totalCatAir = 0;
        int totalSemua = 0;
        int totalHariTertinggi = -1;
        int hariTertinggi = 0;
        String laporan = "";

        System.out.println("HASIL DATA PENJUALAN ATK");
        for (int hari = 1; hari <= 4; hari++) {
            System.out.println("\n Hari ke- " + hari);
            laporan += "Hari ke- " + hari + "\n";
            int totalHari = 0;

            for (int atk = 1; atk <= 3; atk++) {
                String jenis;
                if (atk == 1) {
                    jenis = "Buku Gambar";
                } else if (atk == 2) {
                    jenis = "Krayon";
                } else {
                    jenis = "Cat Air";
                }

                System.out.print("Jumlah " + jenis + " Terjual : ");
                int jumlah = sc.nextInt();

                laporan += " " + jenis + " : " + jumlah + "\n";

                if (atk == 1) {
                    totalBukuGambar += jumlah;
                } else if (atk == 2) {
                    totalKrayon += jumlah;
                } else {
                    totalCatAir += jumlah;
                }

                totalHari += jumlah;

            }

            totalSemua += totalHari;

            if (totalHari > totalHariTertinggi) {
                totalHariTertinggi = totalHari;
                hariTertinggi = hari;
            }
        }

        System.out.println("\nDATA PENJUALAN ATK");
        System.out.println(laporan);

        System.out.println("\nTOTAL PENJUALAN PER PRODUK");
        System.out.println("Buku Gambar     : " + totalBukuGambar);
        System.out.println("Krayon          : " + totalKrayon);
        System.out.println("Cat Air         : " + totalCatAir);

        System.out.println("\nTOTAL SELURUH PRODUK");
        System.out.println("Total produk terjual selama 4 hari :" + totalSemua);

        String produkTerlaris = "Buku Gambar";
        int jumlahProdukTerlaris = totalBukuGambar;

        if (totalKrayon > jumlahProdukTerlaris) {
            produkTerlaris = "Krayon";
            jumlahProdukTerlaris=totalKrayon;
        }
        if (totalCatAir > jumlahProdukTerlaris) {
            produkTerlaris = "Cat Air";
            jumlahProdukTerlaris=totalCatAir;
        }

        System.out.println("\nPRODUK TERLARIS");
        System.out.println("Produk Terlaris- " + produkTerlaris + " (" + jumlahProdukTerlaris + ") terjual");

        System.out.println("\nHARI PENJUALAN TERTINGGI");
        System.out.println("Hari Ke- " + hariTertinggi + " dengan total : " + totalHariTertinggi + " produk terjual");

        sc.close();
    }
}
// cara saya mencari nilai tertinggi di program ini dengan cara membandingkan antar produk dengan nilai awalannya adalah produk pertama yaitu buku gambar.