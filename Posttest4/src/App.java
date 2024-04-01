import java.util.ArrayList;
import java.util.Scanner;
import dataBis.BusRegular;
import dataBis.BusVIP;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BusRegular> regularBuses = new ArrayList<>();
        ArrayList<BusVIP> VIPBuses = new ArrayList<>();

        int pilihan1, pilihan2, indexUpdate, indexHapus;

        do {
            System.out.println("\n=== Menu Pendataan Bus di PO. Sinar Jaya ===");
            System.out.println("1. Bus Regular");
            System.out.println("2. Bus VIP");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu (1-3): ");
            pilihan1 = scanner.nextInt();
            scanner.nextLine(); // consume newline
            do {
                if (pilihan1 == 1) {
                    System.out.println("\n=== Menu Pendataan Bus Regular di PO. Sinar Jaya ===");
                } else {
                    System.out.println("\n=== Menu Pendataan Bus VIP di PO. Sinar Jaya ===");
                }
                System.out.println("1. Tambah Data Bus");
                System.out.println("2. Tampilkan Data Bus");
                System.out.println("3. Edit Data Bus");
                System.out.println("4. Hapus Data Bus");
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu (1-5): ");
                pilihan2 = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (pilihan2) {
                    case 1:
                        if (pilihan1 == 1) {
                            createDataRegular(regularBuses, scanner);
                        } else if (pilihan1 == 2) {
                            createDataVIP(VIPBuses, scanner);
                        }
                        break;
                    case 2:
                        if (pilihan1 == 1) {
                            readDataRegular(regularBuses);
                        } else if (pilihan1 == 2) {
                            readDataVIP(VIPBuses);
                        }
                        break;
                    case 3:
                        if (pilihan1 == 1) {
                            indexUpdate = getIndexToUpdateRegular(regularBuses, scanner);
                            if (indexUpdate != -1) {
                                updateDataRegular(regularBuses.get(indexUpdate), scanner);
                            } else {
                                System.out.println("Data tidak ditemukan.");
                            }
                        } else if (pilihan1 == 2) {
                            indexUpdate = getIndexToUpdateVIP(VIPBuses, scanner);
                            if (indexUpdate != -1) {
                                updateDataVIP(VIPBuses.get(indexUpdate), scanner);
                            } else {
                                System.out.println("Data tidak ditemukan.");
                            }
                        }

                        break;
                    case 4:
                        if (pilihan1 == 1) {
                            indexHapus = getIndexToDeleteRegular(regularBuses, scanner);
                            if (indexHapus != -1) {
                                deleteDataRegular(regularBuses, indexHapus);
                            } else {
                                System.out.println("Data tidak ditemukan.");
                            }
                        } else if (pilihan1 == 2) {
                            indexHapus = getIndexToDeleteVIP(VIPBuses, scanner);
                            if (indexHapus != -1) {
                                deleteDataVIP(VIPBuses, indexHapus);
                            } else {
                                System.out.println("Data tidak ditemukan.");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Anda memilih keluar dari program. Program berhenti");
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                }
            } while (pilihan2 != 5);
        } while (pilihan1 != 3);

        scanner.close();
    }

    // ------------------------- Regular -----------------------------

    private static void readDataRegular(ArrayList<BusRegular> regularBuses) {
        if (regularBuses.isEmpty()) {
            System.out.println("Data kosong");
        } else {
            System.out.println("=====================================================================================");
            System.out.printf("%-6s%-15s%-15s%-15s%-15s%-15s%n", "No.", "Nama Bus", "Kapasitas", "Harga Sewa",
                    "Jumlah Unit", "Musik");
            System.out.println("=====================================================================================");

            for (int i = 0; i < regularBuses.size(); i++) {
                BusRegular bus = regularBuses.get(i);
                System.out.println((i + 1) + bus.info()); // Memanggil method info() untuk menampilkan detail bus
            }

        }
    }

    private static void createDataRegular(ArrayList<BusRegular> regularBuses, Scanner scanner) {
        BusRegular bus = new BusRegular();
        System.out.print("Masukkan Nama Bus: ");
        bus.setNama(scanner.nextLine());

        while (true) {
            System.out.print("Masukkan Kapasitas: ");
            int kapasitas = scanner.nextInt();
            if (kapasitas > 0) {
                bus.setKapasitas(kapasitas);
                break;
            }
            System.out.println("Kapasitas harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Harga Sewa: ");
            int hargaSewa = scanner.nextInt();
            if (hargaSewa > 0) {
                bus.setHargaSewa(hargaSewa);
                break;
            }
            System.out.println("Harga sewa harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Jumlah Unit: ");
            int jumlahUnit = scanner.nextInt();
            if (jumlahUnit > 0) {
                bus.setJumlahUnit(jumlahUnit);
                break;
            }
            System.out.println("Jumlah unit harus lebih dari 0 !");
        }

        System.out.print("Apakah bus memiliki musik? (Ya/Tidak): ");
        String inputMusik = scanner.next();
        boolean memilikiMusik = inputMusik.equalsIgnoreCase("Ya");
        bus.setMusik(memilikiMusik);

        regularBuses.add(bus);

        System.out.println("Data berhasil ditambahkan.");
    }

    private static void updateDataRegular(BusRegular bus, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Masukkan Nama Bus Baru: ");
        bus.setNama(scanner.nextLine());

        while (true) {
            System.out.print("Masukkan Kapasitas Baru: ");
            int kapasitas = scanner.nextInt();
            if (kapasitas > 0) {
                bus.setKapasitas(kapasitas);
                break;
            }
            System.out.println("Kapasitas harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Harga Sewa Baru: ");
            int hargaSewa = scanner.nextInt();
            if (hargaSewa > 0) {
                bus.setHargaSewa(hargaSewa);
                break;
            }
            System.out.println("Harga sewa harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Jumlah Unit Baru: ");
            int jumlahUnit = scanner.nextInt();
            if (jumlahUnit > 0) {
                bus.setJumlahUnit(jumlahUnit);
                break;
            }
            System.out.println("Jumlah unit harus lebih dari 0 !");
        }

        System.out.print("Apakah bus memiliki musik? (Ya/Tidak): ");
        String inputMusik = scanner.next();
        boolean memilikiMusik = inputMusik.equalsIgnoreCase("Ya");
        bus.setMusik(memilikiMusik);

        System.out.println("Data berhasil diubah.");
    }

    private static void deleteDataRegular(ArrayList<BusRegular> regularBuses, int indexHapus) {
        regularBuses.remove(indexHapus);
        System.out.println("Data berhasil dihapus.");
    }

    private static int getIndexToUpdateRegular(ArrayList<BusRegular> regularBuses, Scanner scanner) {
        readDataRegular(regularBuses);
        System.out.print("\nMasukkan Nama Bus yang Ingin Diedit: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < regularBuses.size(); i++) {
            if (regularBuses.get(i).getNama().equals(nama)) {
                return i;
            }
        }

        return -1;
    }

    private static int getIndexToDeleteRegular(ArrayList<BusRegular> regularBuses, Scanner scanner) {
        readDataRegular(regularBuses);
        System.out.print("Masukkan Nama Bus yang Ingin Dihapus: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < regularBuses.size(); i++) {
            if (regularBuses.get(i).getNama().equals(nama)) {
                return i;
            }
        }

        return -1;
    }

    // ------------------------- VIP -----------------------------

    private static void readDataVIP(ArrayList<BusVIP> VIPBuses) {
        if (VIPBuses.isEmpty()) {
            System.out.println("Data kosong");
        } else {
            System.out.println("=======================================================================================");
            System.out.printf("%-6s%-15s%-15s%-15s%-15s%-15s%-15s%n", "No.", "Nama Bus", "Kapasitas", "Harga Sewa",
                    "Jumlah Unit", "Guide", "Wifi");
            System.out.println("=======================================================================================");

            for (int i = 0; i < VIPBuses.size(); i++) {
                BusVIP bus = VIPBuses.get(i);
                System.out.println((i + 1) + bus.info()); // Memanggil method info() untuk menampilkan detail bus
            }
        }
    }

    private static void createDataVIP(ArrayList<BusVIP> VIPBuses, Scanner scanner) {
        BusVIP bus = new BusVIP();
        System.out.print("Masukkan Nama Bus: ");
        bus.setNama(scanner.nextLine());

        while (true) {
            System.out.print("Masukkan Kapasitas: ");
            int kapasitas = scanner.nextInt();
            if (kapasitas > 0) {
                bus.setKapasitas(kapasitas);
                break;
            }
            System.out.println("Kapasitas harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Harga Sewa: ");
            int hargaSewa = scanner.nextInt();
            if (hargaSewa > 0) {
                bus.setHargaSewa(hargaSewa);
                break;
            }
            System.out.println("Harga sewa harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Jumlah Unit: ");
            int jumlahUnit = scanner.nextInt();
            if (jumlahUnit > 0) {
                bus.setJumlahUnit(jumlahUnit);
                break;
            }
            System.out.println("Jumlah unit harus lebih dari 0 !");
        }

        System.out.print("Apakah bus memiliki pemandu? (Ya/Tidak): ");
        String inputPemandu = scanner.next();
        boolean memilikiPemandu = inputPemandu.equalsIgnoreCase("Ya");
        bus.setPemandu(memilikiPemandu);

        System.out.print("Apakah bus memiliki wifi? (Ya/Tidak): ");
        String inputWifi = scanner.next();
        boolean memilikiWifi = inputWifi.equalsIgnoreCase("Ya");
        bus.setWifi(memilikiWifi);

        VIPBuses.add(bus);

        System.out.println("Data berhasil ditambahkan.");
    }

    private static void updateDataVIP(BusVIP bus, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Masukkan Nama Bus Baru: ");
        bus.setNama(scanner.nextLine());

        while (true) {
            System.out.print("Masukkan Kapasitas Baru: ");
            int kapasitas = scanner.nextInt();
            if (kapasitas > 0) {
                bus.setKapasitas(kapasitas);
                break;
            }
            System.out.println("Kapasitas harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Harga Sewa Baru: ");
            int hargaSewa = scanner.nextInt();
            if (hargaSewa > 0) {
                bus.setHargaSewa(hargaSewa);
                break;
            }
            System.out.println("Harga sewa harus lebih dari 0 !");
        }

        while (true) {
            System.out.print("Masukkan Jumlah Unit Baru: ");
            int jumlahUnit = scanner.nextInt();
            if (jumlahUnit > 0) {
                bus.setJumlahUnit(jumlahUnit);
                break;
            }
            System.out.println("Jumlah unit harus lebih dari 0 !");
        }

        System.out.print("Apakah bus memiliki pemandu? (Ya/Tidak): ");
        String inputPemandu = scanner.next();
        boolean memilikiPemandu = inputPemandu.equalsIgnoreCase("Ya");
        bus.setPemandu(memilikiPemandu);

        System.out.print("Apakah bus memiliki wifi? (Ya/Tidak): ");
        String inputWifi = scanner.next();
        boolean memilikiWifi = inputWifi.equalsIgnoreCase("Ya");
        bus.setWifi(memilikiWifi);

        System.out.println("Data berhasil diubah.");
    }

    private static void deleteDataVIP(ArrayList<BusVIP> VIPBuses, int indexHapus) {
        VIPBuses.remove(indexHapus);
        System.out.println("Data berhasil dihapus.");
    }

    private static int getIndexToUpdateVIP(ArrayList<BusVIP> VIPBuses, Scanner scanner) {
        readDataVIP(VIPBuses);
        System.out.print("\nMasukkan Nama Bus yang Ingin Diedit: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < VIPBuses.size(); i++) {
            if (VIPBuses.get(i).getNama().equals(nama)) {
                return i;
            }
        }

        return -1;
    }

    private static int getIndexToDeleteVIP(ArrayList<BusVIP> VIPBuses, Scanner scanner) {
        readDataVIP(VIPBuses);
        System.out.print("Masukkan Nama Bus yang Ingin Dihapus: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < VIPBuses.size(); i++) {
            if (VIPBuses.get(i).getNama().equals(nama)) {
                return i;
            }
        }

        return -1;
    }
}

