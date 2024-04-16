import java.io.*;
import java.util.*;

public class PetShop {
    public static void main(String[] args) {
        ArrayList<Dog> dogList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        FileWriter keluar = null;

        try {
            keluar = new FileWriter("output_Petshop.txt");

            // Menambahkan array untuk menyimpan inputan
            String[][] dogInputs = new String[5][5]; // Array dua dimensi untuk menyimpan input

            for (int i = 0; i < 5; i++) {
                System.out.println("Masukkan Jenis Anjing : ");
                String jenis = scan.nextLine();
                System.out.println("Masukkan nama Anjing : ");
                String nama = scan.nextLine();
                System.out.println("Masukkan ukuran Anjing : ");
                String ukuran = scan.nextLine();
                System.out.println("Sudah makan ?");
                boolean makanberapa = scan.nextBoolean();
                scan.nextLine(); // Membersihkan karakter baris baru dari buffer
                System.out.println("Sedang apa :");
                String sedangapa = scan.nextLine();

                jenis = jenis.toLowerCase();

                // Menyimpan inputan dalam array dua dimensi
                dogInputs[i][0] = jenis;
                dogInputs[i][1] = nama;
                dogInputs[i][2] = ukuran;
                dogInputs[i][3] = String.valueOf(makanberapa);
                dogInputs[i][4] = sedangapa;

                Dog woof;
                switch (jenis) {
                    case "beagle":
                        System.out.println("Ini adalah Anjing yang menyenangkan");
                        woof = new Beagle(jenis, nama, ukuran, makanberapa, sedangapa);
                        break;
                    case "chihuahua":
                        System.out.println("Ini adalah anjing kecil");
                        woof = new Chihua_hua(jenis, nama, ukuran, makanberapa, sedangapa);
                        break;
                    case "komondor":
                        System.out.println("Memiliki rambut gimbal yang unik");
                        woof = new Komondor(jenis, nama, ukuran, makanberapa, sedangapa);
                        break;
                    case "shihtzu":
                        System.out.println("Memiliki rambut panjang dan indah");
                        woof = new Shihtzu(jenis, nama, ukuran, makanberapa, sedangapa);
                        break;
                    case "poodle":
                        System.out.println("Memiliki sifat ceria dan setia");
                        woof = new poodle(jenis, nama, ukuran, makanberapa, sedangapa);
                        break;
                    default:
                        System.out.println("Nama anjing tidak ditemukan. Silakan coba lagi.");
                        i--;
                        continue;
                }

                // Tambahkan objek Dog ke dalam dogList
                dogList.add(woof);
            }

            // Menulis format tabel ke file
            keluar.write("+-------------------------------------------------------------------------------------------------+\n");
            keluar.write("|                                               Pet Shop                                          |\n");
            keluar.write("+-------------------------------------------------------------------------------------------------+\n");
            keluar.write("| No. | Nama       | Jenis                          | Ukuran | Sudah Makan | Sedang Apa           |\n");
            keluar.write("+-------------------------------------------------------------------------------------------------+\n");
            for (int j = 0; j < dogInputs.length; j++) {
                String[] dogInput = dogInputs[j];
                if (dogInput[0] == null) // Jika entri kosong, lanjutkan ke entri berikutnya
                    continue;

                keluar.write(String.format("| %-3d | %-10s | %-30s | %-6s | %-11s | %-20s |\n", j + 1, dogInput[1], dogInput[0], dogInput[2], dogInput[3], dogInput[4]));
            }
            keluar.write("+-------------------------------------------------------------------------------------------------+\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (keluar != null) {
                    keluar.close(); // Tutup file
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        scan.close();
    }
}


