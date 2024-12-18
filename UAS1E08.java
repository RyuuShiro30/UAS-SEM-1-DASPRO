import java.util.Scanner;

public class UAS1E08 {
    int jumlahMaksTim08 = 6;
    String[] namaTim08 = new String[jumlahMaksTim08];
    int[][] skorTim08 = new int[jumlahMaksTim08][2];
    int[] totalSkor08 = new int[jumlahMaksTim08];
    int jumlahTim08 = 0;
    Scanner scanner08 = new Scanner(System.in);

    public void menuUtama() {
        int menu08;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            menu08 = scanner08.nextInt();
            scanner08.nextLine();

            switch (menu08) {
                case 1:
                    inputDataSkor();
                    break;
                case 2:
                    tampilkanTabelSkor();
                    break;
                case 3:
                    tentukanJuara();
                    break;
                case 4:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih lagi.");
            }
        } while (menu08 != 4);
    }

    public void inputDataSkor() {
        for (int i08 = jumlahTim08; i08 < jumlahMaksTim08; i08++) {
            System.out.print("Masukkan nama tim ke-" + (i08 + 1) + ": ");
            namaTim08[i08] = scanner08.nextLine();

            for (int j08 = 0; j08 < 2; j08++) {
                System.out.print("Masukkan skor " + namaTim08[i08] + " untuk Level " + (j08 + 1) + ": ");
                skorTim08[i08][j08] = scanner08.nextInt();
            }
            scanner08.nextLine();

            totalSkor08[i08] = skorTim08[i08][0] + skorTim08[i08][1];
            jumlahTim08++;

            System.out.println("Data tim " + namaTim08[i08] + " berhasil ditambahkan!\n");
        }

        if (jumlahTim08 >= jumlahMaksTim08) {
            System.out.println("Data tim sudah penuh! Tidak bisa menambahkan lebih banyak tim.");
        }
    }

    public void tampilkanTabelSkor() {
        if (jumlahTim08 == 0) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }

        System.out.println("\nTabel Skor Turnamen");
        System.out.printf("%-13s %-9s %-9s %-9s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
        for (int i08 = 0; i08 < jumlahTim08; i08++) {
            System.out.printf("%-13s %-9d %-9d %-9d\n",
                    namaTim08[i08], skorTim08[i08][0], skorTim08[i08][1], totalSkor08[i08]);
        }
    }

    public void tentukanJuara() {
        if (jumlahTim08 == 0) {
            System.out.println("Tidak ada data yang bisa dianalisis.");
            return;
        }

        int skorTertinggi08 = totalSkor08[0];
        String juara08 = namaTim08[0];

        for (int i08 = 1; i08 < jumlahTim08; i08++) {
            if (totalSkor08[i08] > skorTertinggi08) {
                skorTertinggi08 = totalSkor08[i08];
                juara08 = namaTim08[i08];
            }
        }

        System.out.println("Selamat kepada Tim " + juara08 + " yang telah memenangkan kompetisi!");
    }

    public static void main(String[] args) {
        UAS1E08 turnamen = new UAS1E08();
        turnamen.menuUtama();
    }
}
