package com.testapi;

import com.testapi.model.Book;
import com.testapi.service.ApiService;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ApiService apiService = new ApiService();

    public static void main(String[] args) {
        System.out.println("=== TESTING API GET, POST, PUT, DELETE ===\n");
        
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    testGET();
                    break;
                case 2:
                    testPOST();
                    break;
                case 3:
                    testPUT();
                    break;
                case 4:
                    testDELETE();
                    break;
                case 5:
                    System.out.println("Terima kasih! 👋");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        }
    }

    private static void showMenu() {
        System.out.println("=== MENU TESTING API ===");
        System.out.println("1. GET - Ambil data");
        System.out.println("2. POST - Kirim data baru");
        System.out.println("3. PUT - Update data");
        System.out.println("4. DELETE - Hapus data");
        System.out.println("5. Keluar");
        System.out.print("Pilihan (1-5): ");
    }

    private static void testGET() {
        System.out.println("\n--- TEST GET (Mengambil 5 data pertama) ---");
        try {
            List<Book> books = apiService.getAllBooks();
            if (books != null) {
                System.out.println("✅ GET SUCCESS!");
                System.out.println("Data yang diterima:");
                books.forEach(System.out::println);
            } else {
                System.out.println("❌ GET GAGAL!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println("\n==========================================\n");
    }

    private static void testPOST() {
        System.out.println("\n--- TEST POST (Membuat data baru) ---");
        System.out.print("Masukkan Judul Buku: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan Pengarang: ");
        String author = scanner.nextLine();
        System.out.print("Masukkan Tahun: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        try {
            Book newBook = new Book(0, title, author, year);
            Book created = apiService.createBook(newBook);
            if (created != null) {
                System.out.println("✅ POST SUCCESS!");
                System.out.println("Data yang dibuat:");
                System.out.println(created);
            } else {
                System.out.println("❌ POST GAGAL!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println("\n==========================================\n");
    }

    private static void testPUT() {
        System.out.println("\n--- TEST PUT (Update data) ---");
        System.out.print("Masukkan ID yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Judul Baru: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan Pengarang Baru: ");
        String author = scanner.nextLine();
        System.out.print("Masukkan Tahun Baru: ");
        int year = scanner.nextInt();
        
        try {
            Book updatedBook = new Book(id, title, author, year);
            Book updated = apiService.updateBook(id, updatedBook);
            if (updated != null) {
                System.out.println("✅ PUT SUCCESS!");
                System.out.println("Data setelah update:");
                System.out.println(updated);
            } else {
                System.out.println("❌ PUT GAGAL!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println("\n==========================================\n");
    }

    private static void testDELETE() {
        System.out.println("\n--- TEST DELETE (Menghapus data) ---");
        System.out.print("Masukkan ID yang akan dihapus: ");
        int id = scanner.nextInt();
        
        try {
            boolean deleted = apiService.deleteBook(id);
            if (deleted) {
                System.out.println("✅ DELETE SUCCESS!");
                System.out.println("Data dengan ID " + id + " berhasil dihapus");
            } else {
                System.out.println("❌ DELETE GAGAL!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println("\n==========================================\n");
    }
}
