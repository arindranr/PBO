import java.util.ArrayList;
import java.util.Scanner;

class Bus {
    String nama, fasilitas;
    int kapasitas, hargaSewa, jumlahUnit;
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Bus> buses = new ArrayList<>();

        int pilihan, indexUpdate, indexHapus;

        do {
            System.out.println("\n=== Menu Pendataan Bus di PO. Sinar Jaya ===");
            System.out.println("1. Tambah Data Bus");
            System.out.println("2. Tampilkan Data Bus");
            System.out.println("3. Edit Data Bus");
            System.out.println("4. Hapus Data Bus");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    createData(buses, scanner);
                    break;
                case 2:
                    readData(buses);
                    break;
                case 3:
                    indexUpdate = getIndexToUpdate(buses, scanner);
                    if (indexUpdate != -1) {
                        updateData(buses.get(indexUpdate), scanner);
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 4:
                    indexHapus = getIndexToDelete(buses, scanner);
                    if (indexHapus != -1) {
                        deleteData(buses, indexHapus);
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 5:
                    System.out.println("Anda memilih keluar dari program. Program berhenti");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        } while (pilihan != 5);


        scanner.close();
    }

    private static void readData(ArrayList<Bus> buses) {
        if (buses.isEmpty()) {
            System.out.println("Data kosong");
        } else {
            System.out.println("===================================================================================");
            System.out.printf("%-4s%-15s%-25s%-15s%-15s%-15s%n", "No.", "Nama Bus", "Fasilitas", "Kapasitas", "Harga Sewa", "Jumlah Unit");
            System.out.println("===================================================================================");

            for (int i = 0; i < buses.size(); i++) {
                Bus bus = buses.get(i);
                System.out.printf("%-4d%-15s%-25s%-15d%-15d%-15d%n", i + 1, bus.nama, bus.fasilitas, bus.kapasitas, bus.hargaSewa, bus.jumlahUnit);
            }
        }
    }

    private static void createData(ArrayList<Bus> buses, Scanner scanner) {
        Bus bus = new Bus();
        System.out.print("Masukkan Nama Bus: ");
        bus.nama = scanner.nextLine();
        System.out.print("Masukkan Fasilitas: ");
        bus.fasilitas = scanner.nextLine();

        while (true) {
            System.out.print("Masukkan Kapasitas: ");
            bus.kapasitas = scanner.nextInt();
            if (bus.kapasitas > 0) {
                break;
            }
            System.out.println("Kapasitas harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Harga Sewa: ");
            bus.hargaSewa = scanner.nextInt();
            if (bus.hargaSewa > 0) {
                break;
            }
            System.out.println("Harga sewa harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Jumlah Unit: ");
            bus.jumlahUnit = scanner.nextInt();
            if (bus.jumlahUnit > 0) {
                break;
            }
            System.out.println("Jumlah unit harus lebih dari 0 !");
        }

        buses.add(bus);

        System.out.println("Data berhasil ditambahkan.");
    }

    private static void updateData(Bus bus, Scanner scanner) {
        scanner.nextLine(); // consume newline
        System.out.print("Masukkan Nama Bus Baru: ");
        bus.nama = scanner.nextLine();
        System.out.print("Masukkan Fasilitas Baru: ");
        bus.fasilitas = scanner.nextLine();

        while (true) {
            System.out.print("Masukkan Kapasitas Baru: ");
            bus.kapasitas = scanner.nextInt();
            if (bus.kapasitas > 0) {
                break;
            }
            System.out.println("Kapasitas harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Harga Sewa Baru: ");
            bus.hargaSewa = scanner.nextInt();
            if (bus.hargaSewa > 0) {
                break;
            }
            System.out.println("Harga sewa harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Jumlah Unit Baru: ");
            bus.jumlahUnit = scanner.nextInt();
            if (bus.jumlahUnit > 0) {
                break;
            }
            System.out.println("Jumlah unit harus lebih dari 0 !");
        }

        System.out.println("Data berhasil diubah.");
    }

    private static void deleteData(ArrayList<Bus> buses, int indexHapus) {
        buses.remove(indexHapus);
        System.out.println("Data berhasil dihapus.");
    }

    private static int getIndexToUpdate(ArrayList<Bus> buses, Scanner scanner) {
        readData(buses);
        System.out.print("\nMasukkan Nama Bus yang Ingin Diedit: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).nama.equals(nama)) {
                return i;
            }
        }

        return -1;
    }

    private static int getIndexToDelete(ArrayList<Bus> buses, Scanner scanner) {
        readData(buses);
        System.out.print("Masukkan Nama Bus yang Ingin Dihapus: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).nama.equals(nama)) {
                return i;
            }
        }

        return -1;
    }
}
