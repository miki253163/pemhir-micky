import java.util.Scanner;

class Song {
    String title;
    Song next;

    public Song(String title) {
        this.title = title;
        this.next = null;
    }
}

class Playlist {
    private Song head;

    public Playlist() {
        this.head = null;
    }

    // Metode untuk menambahkan lagu di akhir playlist
    public void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
    }

    // Metode untuk menampilkan semua lagu di playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Song current = head;
        System.out.println("Daftar lagu di playlist:");
        while (current != null) {
            System.out.println(current.title);
            current = current.next;
        }
    }
}

public class PlaylistApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        while (true) {
            System.out.println("\n1. Tambah lagu");
            System.out.println("2. Tampilkan playlist");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul lagu: ");
                    String judul = scanner.nextLine();
                    playlist.addSong(judul);
                    System.out.println("Lagu \"" + judul + "\" ditambahkan ke playlist.");
                    break;

                case 2:
                    playlist.displayPlaylist();
                    break;

                case 3:
                    System.out.println("Keluar dari aplikasi.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }
    }
}
