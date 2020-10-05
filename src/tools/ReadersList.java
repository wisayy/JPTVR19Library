/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ReadersList {

    public static Reader getReader() {
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        reader.setFirstname(scanner.nextLine());
        System.out.println("Введите вашу фамилию");
        reader.setLastname(scanner.nextLine());
        System.out.println("Введите ваш номер телфона");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
    
}
