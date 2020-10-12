/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class CreatorHistory {

    public History takeOnBook(Book[] books, Reader[] readers) {
        System.out.println("--- Список читателей ---");
        History history = new History();
        for (int i = 0; i < readers.length; i++) {
            if(readers[i] != null) {
                System.out.println(i+1+". " + readers[i].toString());
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер читателя: ");
        int readerNumber = scanner.nextInt();
        scanner.nextLine();
        Reader reader = readers(readerNumber-1);
        history.setReader(reader);
        System.out.println("--- Список книг ---");
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null) {
                System.out.println(i+1+". " + books[i].toString());
            }
        }    
        return history;
    }

    public void returnBook(History[] histories) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}