import java.util.Scanner;
import java.util.Stack;

class TextEditor {
    private StringBuilder currentText = new StringBuilder();
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    // Fungsi write: Menambahkan teks baru ke dalam teks editor
    public void write(String text) {
        undoStack.push(currentText.toString()); // Simpan keadaan sebelum perubahan
        currentText.append(text);
        redoStack.clear(); // Hapus redo stack ketika ada penambahan baru
    }

    // Fungsi undo: Mengembalikan isi teks ke isi sebelumnya
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText.toString()); // Simpan keadaan saat ini ke redo stack
            currentText = new StringBuilder(undoStack.pop()); // Kembalikan ke keadaan sebelumnya
        } else {
            System.out.println("Tidak ada tindakan yang bisa di-undo.");
        }
    }

    // Fungsi redo: Memulihkan pengembalian isi teks ke isi yang lebih baru
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText.toString()); // Simpan keadaan saat ini ke undo stack
            currentText = new StringBuilder(redoStack.pop()); // Kembalikan ke keadaan lebih baru
        } else {
            System.out.println("Tidak ada tindakan yang bisa di-redo.");
        }
    }

    // Fungsi show: Menampilkan semua teks yang ada di text editor
    public void show() {
        System.out.println("Teks saat ini: ");
        System.out.println(currentText.toString().isEmpty() ? "(Kosong)" : currentText.toString());
    }

    // Fungsi utama program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor textEditor = new TextEditor();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPilih tindakan:");
            System.out.println("1. Tulis teks (write)");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tampilkan teks (show)");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan teks yang ingin ditulis: ");
                    String text = scanner.nextLine();
                    textEditor.write(text);
                    System.out.println("Teks berhasil ditambahkan.");
                    break;
                case 2:
                    textEditor.undo();
                    System.out.println("Undo dilakukan.");
                    break;
                case 3:
                    textEditor.redo();
                    System.out.println("Redo dilakukan.");
                    break;
                case 4:
                    textEditor.show();
                    break;
                case 5:
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
