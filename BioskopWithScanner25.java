import java.util.InputMismatchException;
import java.util.Scanner;

public class BioskopWithScanner25 {

    static int bacaAngka(Scanner sc, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                int angka = sc.nextInt();
                sc.nextLine(); 
                return angka;
            } catch (InputMismatchException e) {
                sc.nextLine(); 
                System.out.println("Input harus berupa angka, silakan ulangi.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] penonton = new String[4][2];
        int menu;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            menu = bacaAngka(sc, "Pilih menu: ");

            switch (menu) {
                case 1: {
                    String pilihan;
                    do {
                        System.out.print("Masukkan Nama : ");
                        String nama = sc.nextLine();

                        int baris, kolom;
                        while (true) {
                            baris = bacaAngka(sc, "Masukkan Baris : ");
                            kolom = bacaAngka(sc, "Masukkan Kolom : ");

                            if (baris < 1 || baris > penonton.length) {
                                System.out.println("Baris " + baris + " tidak tersedia (tersedia 1 - " + penonton.length + ").");
                            } else if (kolom < 1 || kolom > penonton[baris - 1].length) {
                                System.out.println("Kolom " + kolom + " tidak tersedia (tersedia 1 - " + penonton[baris - 1].length + ").");
                            } else if (penonton[baris - 1][kolom - 1] != null) {
                                System.out.println("Kursi sudah terisi oleh " + penonton[baris - 1][kolom - 1] + ", pilih kursi lain.");
                            } else {
                                break; 
                            }
                        }

                        penonton[baris - 1][kolom - 1] = nama;

                        System.out.print("Input penonton lainnya? (y/n) ");
                        pilihan = sc.nextLine();
                    } while (!pilihan.equalsIgnoreCase("n"));
                    break;
                }
                case 2: {
                    System.out.println("Daftar penonton:");
                    for (int i = 0; i < penonton.length; i++) {
                        System.out.print("Baris " + (i + 1) + ": ");
                        for (int j = 0; j < penonton[i].length; j++) {
                            System.out.print((penonton[i][j] == null ? "***" : penonton[i][j]) + "\t");
                        }
                        System.out.println();
                    }
                    break;
                }
                case 3:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (menu != 3);
    }
}