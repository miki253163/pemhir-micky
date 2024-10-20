import java.util.Scanner;

class Passenger {
    String name;
    Passenger next;

    Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    // Metode untuk menambahkan penumpang di akhir daftar
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    // Metode untuk menghapus penumpang berdasarkan nama
    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Penumpang " + name + " dihapus.");
            return;
        }

        Passenger current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Penumpang dengan nama " + name + " tidak ditemukan.");
        } else {
            current.next = current.next.next;
            System.out.println("Penumpang " + name + " dihapus.");
        }
    }

    // Metode untuk menampilkan semua penumpang
    public void displayPassengers() {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        Passenger current = head;
        System.out.println("Daftar Penumpang:");
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }

    // Metode statis utama untuk menjalankan program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flight flight = new Flight();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPilih tindakan:");
            System.out.println("1. Tambah Penumpang");
            System.out.println("2. Hapus Penumpang");
            System.out.println("3. Tampilkan Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama penumpang: ");
                    String nameToAdd = scanner.nextLine();
                    flight.addPassenger(nameToAdd);
                    System.out.println("Penumpang " + nameToAdd + " ditambahkan.");
                    break;
                case 2:
                    System.out.print("Masukkan nama penumpang yang akan dihapus: ");
                    String nameToRemove = scanner.nextLine();
                    flight.removePassenger(nameToRemove);
                    break;
                case 3:
                    flight.displayPassengers();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }

        scanner.close();
    }
}
