import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class FileProcessor {
    // Metode untuk membaca isi file
    public String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        }
        return content.toString();
    }

    // Metode untuk memotong file menjadi beberapa bagian sesuai dengan jumlah bagian yang diminta pengguna
    public Queue<String> splitFileContent(String content, int partSize) {
        Queue<String> filePartsQueue = new LinkedList<>();
        int length = content.length();
        int start = 0;

        // Memotong isi file ke dalam bagian-bagian sesuai partSize
        while (start < length) {
            int end = Math.min(start + partSize, length);
            String part = content.substring(start, end);
            filePartsQueue.add(part);
            start = end;
        }

        return filePartsQueue;
    }

    // Metode untuk menampilkan bagian-bagian file
    public void displayFileParts(Queue<String> filePartsQueue) {
        int partNumber = 1;
        while (!filePartsQueue.isEmpty()) {
            System.out.println("Bagian " + partNumber + ":");
            System.out.println(filePartsQueue.poll());
            partNumber++;
        }
    }

    // Metode utama program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileProcessor processor = new FileProcessor();

        // Input nama file dari pengguna
        System.out.print("Masukkan nama file (dengan ekstensi): ");
        String fileName = scanner.nextLine();

        // Baca isi file
        String content = processor.readFile(fileName);
        if (content.isEmpty()) {
            System.out.println("File kosong atau tidak ditemukan.");
            return;
        }

        // Input ukuran bagian (partSize) dari pengguna
        System.out.print("Masukkan ukuran setiap bagian file (dalam karakter): ");
        int partSize = scanner.nextInt();

        // Memotong file sesuai ukuran bagian
        Queue<String> filePartsQueue = processor.splitFileContent(content, partSize);

        // Menampilkan bagian-bagian file
        System.out.println("\nHasil pemotongan file:");
        processor.displayFileParts(filePartsQueue);

        scanner.close();
    }
}
