import java.util.Scanner;
import java.util.Stack;

class BrowserHistory {
    private Stack<String> history = new Stack<>();

    // Fungsi browse: Menambahkan website baru ke dalam history
    public void browse(String url) {
        history.push(url);
        System.out.println("Browsing: " + url);
    }

    // Fungsi back: Menghapus history terakhir dan kembali ke website sebelumnya
    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
        } else {
            String removed = history.pop();
            System.out.println("Kembali dari: " + removed);
            if (!history.isEmpty()) {
                System.out.println("Sekarang di: " + history.peek());
            } else {
                System.out.println("History kosong.");
            }
        }
    }

    // Fungsi view: Menampilkan semua history browser dari yang terbaru
    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("History Browser (Terbaru ke Terlama):");
            Stack<String> tempStack = new Stack<>();
            while (!history.isEmpty()) {
                tempStack.push(history.pop());
            }
            while (!tempStack.isEmpty()) {
                String current = tempStack.pop();
                System.out.println("- " + current);
                history.push(current); // Menyimpan kembali ke stack asli
            }
        }
    }

    // Fungsi utama program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrowserHistory browserHistory = new BrowserHistory();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPilih tindakan:");
            System.out.println("1. Browse website");
            System.out.println("2. Back (kembali ke website sebelumnya)");
            System.out.println("3. View history");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan URL website: ");
                    String url = scanner.nextLine();
                    browserHistory.browse(url);
                    break;
                case 2:
                    browserHistory.back();
                    break;
                case 3:
                    browserHistory.view();
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
