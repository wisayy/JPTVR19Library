/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

import entity.Book;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author pupil
 */
public class ReaderSaver {
    private final String fileName = "readers";
    
    public void saveReaders(Reader[] readers) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("readers");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

 public Reader[] loadReaders() {
        Reader[] readers = new Reader[50];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("Readers");
            ois = new ObjectInputStream(fis);
            readers = (Reader[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return readers;
    }

    public Reader[] loadFile() {
        Reader[] readers = new Reader[10];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            return (Reader[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ошибка: не найден класс");
        }
        return readers;
    }
}
