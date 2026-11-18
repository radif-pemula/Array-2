import java.util.Scanner;

public class SurveiKepuasan25 {
    public static void main(String[] args) {
        final int JUMLAH_RESPONDEN = 10;
        final int JUMLAH_PERTANYAAN = 6;
        final int NILAI_MIN = 1;
        final int NILAI_MAX = 5;

        Scanner sc = new Scanner(System.in);

        // baris = responden, kolom = pertanyaan
        int[][] survei = new int[JUMLAH_RESPONDEN][JUMLAH_PERTANYAAN];

        // a. Menyimpan hasil survei
        for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
            System.out.println("RESPONDEN KE-" + (i + 1));
            for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
                int nilai = 0;
                boolean valid = false;
                while (!valid) {
                    System.out.print("  Pertanyaan ke-" + (j + 1) + " ("
                            + NILAI_MIN + "-" + NILAI_MAX + "): ");
                    if (sc.hasNextInt()) {
                        nilai = sc.nextInt();
                        valid = nilai >= NILAI_MIN && nilai <= NILAI_MAX;
                    } else {
                        sc.next(); // buang input yang bukan angka
                    }
                    if (!valid) {
                        System.out.println("  Input tidak valid, masukkan angka "
                                + NILAI_MIN + "-" + NILAI_MAX + ".");
                    }
                }
                survei[i][j] = nilai;
            }
        }

        // b. Rata-rata setiap responden (jumlah per baris)
        System.out.println("\nRATA-RATA SETIAP RESPONDEN");
        for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
            int total = 0; // di-reset untuk setiap responden
            for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
                total += survei[i][j];
            }
            double rata = (double) total / JUMLAH_PERTANYAAN;
            System.out.printf("Responden ke-%d: %.2f%n", (i + 1), rata);
        }

        // c. Rata-rata setiap pertanyaan (jumlah per kolom)
        System.out.println("\nRATA-RATA SETIAP PERTANYAAN");
        for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
            int total = 0; // di-reset untuk setiap pertanyaan
            for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
                total += survei[i][j];
            }
            double rata = (double) total / JUMLAH_RESPONDEN;
            System.out.printf("Pertanyaan ke-%d: %.2f%n", (j + 1), rata);
        }

        // d. Rata-rata keseluruhan
        int totalSemua = 0;
        for (int i = 0; i < JUMLAH_RESPONDEN; i++) {
            for (int j = 0; j < JUMLAH_PERTANYAAN; j++) {
                totalSemua += survei[i][j];
            }
        }
        double rataSemua = (double) totalSemua / (JUMLAH_RESPONDEN * JUMLAH_PERTANYAAN);
        System.out.printf("%nRATA-RATA KESELURUHAN: %.2f%n", rataSemua);

        sc.close();
    }
}