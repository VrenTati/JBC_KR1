package org.example;

import java.util.Scanner;

public class ConsoleMain {

    // Побудова таблиці вибору для користувача
    public void printChoice() {
        System.out.println("+---------------------------------------------------+");
        System.out.println("| Варіанти вибору                                   |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| 1. Додати виробника                              |");
        System.out.println("| 2. Додати сувенір                                |");
        System.out.println("| 3. Редагувати сувенір                            |");
        System.out.println("| 4. Всі виробники                                 |");
        System.out.println("| 5. Всі сувеніри                                  |");
        System.out.println("| 6. Сувеніри виробника                            |");
        System.out.println("| 7. Сувеніри за країною                           |");
        System.out.println("| 8. Виробники з цінами менше                      |");
        System.out.println("| 9. Всі виробники та їх сувеніри                  |");
        System.out.println("| 10. Виробники сувеніра в заданому році           |");
        System.out.println("| 11. Сувеніри за рік                              |");
        System.out.println("| 12. Видалити виробника                           |");
        System.out.println("| 13. Завершити програму                           |");
        System.out.println("+---------------------------------------------------+");
    }

    // Обробка вибору користувачапрацює?
    public void processChoice(int choice, SouvenirManager manager, Scanner scanner) {
        switch (choice) {
            case 1 -> {
                System.out.print("Назва виробника: ");
                String manufacturerName = scanner.nextLine();
                System.out.print("Країна виробника: ");
                String manufacturerCountry = scanner.nextLine();
                manager.addManufacturer(manufacturerName, manufacturerCountry);
            }
            case 2 -> {
                System.out.print("Назва сувеніра: ");
                String souvenirName = scanner.nextLine();
                System.out.print("Назва виробника: ");
                String souvenirManufacturer = scanner.nextLine();
                System.out.print("Дата виготовлення: ");
                String souvenirDate = scanner.nextLine();
                System.out.print("Ціна: ");
                String souvenirPrice = scanner.nextLine();
                manager.addSouvenir(souvenirName, souvenirManufacturer, souvenirDate, souvenirPrice);
            }
            case 3 -> {
                System.out.print("Назва сувеніра: ");
                String editSouvenirName = scanner.nextLine();
                System.out.print("Назва виробника: ");
                String editManufacturerName = scanner.nextLine();
                System.out.print("Нова ціна: ");
                String newPrice = scanner.nextLine();
                manager.editSouvenir(editSouvenirName, editManufacturerName, newPrice);
            }
            case 4 -> {
                System.out.println("Всі виробники:");
                manager.viewAllManufacturers();
            }
            case 5 -> {
                System.out.println("Всі сувеніри:");
                manager.viewAllSouvenirs();
            }
            case 6 -> {
                scanner.nextLine();
                System.out.print("Назва виробника: ");
                String manufacturerToFind = scanner.nextLine();
                System.out.println("Сувеніри виробника " + manufacturerToFind + ":");
                manager.findSouvenirsByManufacturer(manufacturerToFind);
            }
            case 7 -> {
                scanner.nextLine();
                System.out.print("Країна: ");
                String countryToFind = scanner.nextLine();
                System.out.println("Сувеніри, виготовлені в " + countryToFind + ":");
                manager.findSouvenirsByCountry(countryToFind);
            }
            case 8 -> {
                System.out.print("Ціна: ");
                double priceToFind = scanner.nextDouble();
                System.out.println("Виробники з цінами менше " + priceToFind + ":");
                manager.findManufacturersByPrice(priceToFind);
            }
            case 9 -> {
                System.out.println("Всі виробники та їх сувеніри:");
                manager.viewAllManufacturersWithSouvenirs();
            }
            case 10 -> {
                scanner.nextLine();
                System.out.print("Назва сувеніра: ");
                String souvenirToFind = scanner.nextLine();
                System.out.print("Рік: ");
                String yearToFind = scanner.nextLine();
                System.out.println("Виробники сувеніра " + souvenirToFind + " в " + yearToFind + " році:");
                manager.findManufacturersBySouvenirAndYear(souvenirToFind, yearToFind);
            }
            case 11 -> {
                scanner.nextLine();
                System.out.print("Рік: ");
                String yearToFind1 = scanner.nextLine();
                System.out.println("Сувеніри, виготовлені у " + yearToFind1 + " році:");
                manager.findSouvenirsByYear(yearToFind1);
            }
            case 12 -> {
                scanner.nextLine();
                System.out.print("Назва виробника: ");
                String manufacturerToDelete = scanner.nextLine();
                System.out.println("Видалення виробника " + manufacturerToDelete + ":");
                manager.deleteManufacturer(manufacturerToDelete);
            }
            case 13 -> {
                manager.saveDataToFileSystem();
                System.out.println("Програму завершено.");
                System.exit(0);
            }
            default -> System.out.println("Неправильний вибір. Спробуйте ще раз.");
        }
    }

}
