/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19library;

import tools.managers.BookManager;
import tools.managers.LibraryManager;
import tools.savers.HistorySaver;
import tools.savers.BookSaver;
import tools.savers.CreatorReader;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Scanner;
import tools.managers.ReaderManager;
import tools.savers.CreatorBook;
import tools.savers.CreatorHistory;
import tools.savers.ReaderSaver;

/**
 *
 * @author Melnikov
 */
class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    private History[] histories = new History[10];
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private LibraryManager libraryManager = new LibraryManager();
    private BookSaver bookSaver = new BookSaver();
    private ReaderSaver readerSaver = new ReaderSaver();
    private HistorySaver historySaver = new HistorySaver();

    public App() {
        books = bookSaver.loadBooks();
        readers = readerSaver.loadReaders();
        histories = historySaver.loadHistories();
    }
    
    public void run(){
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Список книг");
            System.out.println("3. Зарегистрировать читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу в библиотеку");
            System.out.println("7. Список выданных книг");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Добавить новую книгу ---");
                    Book book = bookManager.createBook();
                    bookManager.addBookToArray(book,books);
                    bookSaver.saveBooks(books);
                    break;
                case "2":
                    System.out.println("--- Список книг ---");
                    bookManager.printListBooks(books);
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать читателя ---");
                    Reader reader = readerManager.createReader();
                    readerManager.addReaderToArray(reader,readers);
                    readerSaver.saveReaders(readers);
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    readerManager.printListReaders(readers);
                    break;
                case "5":
                    System.out.println("--- Выдать книгу читателю ---");
                    History history = libraryManager.takeOnBook(books, readers);
                    libraryManager.addHistoryToArray(history,histories);
                    historySaver.saveHistories(histories);
                    break;
                case "6":
                    System.out.println("--- Вернуть книгу в библиотеку ---");
                    libraryManager = new LibraryManager();
                    libraryManager.returnBook(histories);
                    historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    break;
                case "7":
                    System.out.println("--- Список выданных книг ---");
                    libraryManager.printListReadBooks(histories);
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
