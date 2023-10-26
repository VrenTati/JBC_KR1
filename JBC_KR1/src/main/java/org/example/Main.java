package org.example;

import java.util.Scanner;

public class Main {
    /*public static void main(String[] args) {
        SouvenirManager manager = new SouvenirManager();

        // Зчитування даних з файлової системи при запуску програми
        manager.loadDataFromFileSystem();

        // Додавання сувенірів та виробників
        manager.addManufacturer("Виробник 4", "Україна");
        manager.addManufacturer("Виробник 5", "США");

        manager.addSouvenir("Сувенір 6", "Виробник 1", "2023-10-20", "10.00");
        manager.addSouvenir("Сувенір 7", "Виробник 2", "2023-10-15", "12.50");

        // Редагування сувеніра
        manager.editSouvenir("Сувенір 1", "Виробник 1", "15.00");

        // Перегляд всіх виробників та всіх сувенірів
        System.out.println("Всі виробники:");
        manager.viewAllManufacturers();
        System.out.println("Всі сувеніри:");
        manager.viewAllSouvenirs();

        // Вивести інформацію про сувеніри заданого виробника
        System.out.println("Сувеніри виробника Виробник 2:");
        manager.findSouvenirsByManufacturer("Виробник 2");

        // Вивести інформацію про сувеніри, виготовлені в заданій країні
        System.out.println("Сувеніри, виготовлені в Україні:");
        manager.findSouvenirsByCountry("Україна");

        // Вивести інформацію про виробників, чиї ціни на сувеніри менше заданої
        System.out.println("Виробники з цінами менше 13.00:");
        manager.findManufacturersByPrice(13.00);

        // Вивести інформацію по всіх виробниках та їх сувенірах
        System.out.println("Всі виробники та їх сувеніри:");
        manager.viewAllManufacturersWithSouvenirs();

        // Вивести інформацію про виробників заданого сувеніра, виробленого у заданому році
        System.out.println("Виробники сувеніра Сувенір 1 в 2023 році:");
        manager.findManufacturersBySouvenirAndYear("Сувенір 1", "2023");

        // Для кожного року вивести список сувенірів, зроблених цього року
        System.out.println("Сувеніри, виготовлені у 2023 році:");
        manager.findSouvenirsByYear("2023");

        // Видалити заданого виробника та його сувеніри
        System.out.println("Видалення виробника Виробник 1:");
        manager.deleteManufacturer("Виробник 1");

        // Збереження даних до файлової системи перед закінченням програми
        manager.saveDataToFileSystem();
    }*/
    public static void main(String[]argv){
        Main main = new Main();
        main.run();
    }

    private void run() {
        SouvenirManager manager = new SouvenirManager();
        ConsoleMain consoleMain = new ConsoleMain();
        Scanner in = new Scanner(System.in);

        manager.loadDataFromFileSystem();

        int choice = 0;
        while(choice != 13){
            consoleMain.printChoice();
            choice = in.nextInt();
            consoleMain.processChoice(choice, manager, in);
        }

    }
}
