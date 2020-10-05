/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19library;

/**
 *
 * @author pupil
 */
import entity.Reader;
import entity.Book;
import java.util.Scanner;
import tools.CreatorBook;
import tools.ReadersList;

/**
 *
 * @author pupil
 */
class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[50];
    public void run(){
        System.out.println("--- Библиотека ---");
        boolean repeat = true;
        do{
            System.out.println("Задачи библеотеки: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Cписок книг");
            System.out.println("3. Зарегистрировать читателя");
            System.out.println("4. Список читателей");
            
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("---- Конец программы ----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Добавить новую книгу ---");
//                    Book book = new Book("Voina i mir", "L.Tolstoy", 2010, "123-1234");
                    CreatorBook creatorBook = new CreatorBook();
                    Book book = creatorBook.getBook();
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = book;
                            break;
                        }
                    }
                    System.out.println("Создана книга: "+book.getName());
                    //System.out.println(book.toString());
                    break;
                case "2":
                    System.out.println("--- Список книг ---");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(i+1+". " + books[i].toString());
                        }
                    }
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать нового читателя ---");
                    ReadersList readersList = new ReadersList();
                    Reader reader = ReadersList.getReader();
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            readers[i] = reader;
                            break;
                        }
                    }
                    break;
                case "4":
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.println(i+1+". " + readers[i].toString());
                        }
                    }
                    break;
                case "5":
                    ArchiveRegistr archiveRegistr = new ArchiveRegistr();
                    break;
                case "6":
                    System.out.println("");
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
