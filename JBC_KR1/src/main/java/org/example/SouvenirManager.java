package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SouvenirManager {
    private final List<Souvenir> souvenirs;
    private final List<Manufacturer> manufacturers;
    private final String souvenirDataPath = "SouvenirsDatabase/Souvenirs";
    private final String manufacturerDataPath = "SouvenirsDatabase/Manufacturers/";

    public SouvenirManager() {
        souvenirs = new ArrayList<>();
        manufacturers = new ArrayList<>();
    }

    // Зчитування даних із файлової системи
    void loadDataFromFileSystem() {
        loadDataFromDirectory(souvenirDataPath, souvenirs);
        loadDataFromDirectory(manufacturerDataPath, manufacturers);
    }

    // Зчитування даних із каталогу
    private void loadDataFromDirectory(String directoryPath, List<?> data) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 4) {
                                String name = parts[0].trim();
                                String manufacturer = parts[1].trim();
                                String releaseDate = parts[2].trim();
                                double price = Double.parseDouble(parts[3].trim());

                                souvenirs.add(new Souvenir(name, manufacturer, releaseDate, String.valueOf(price)));
                            }
                            if(parts.length == 2){
                                String name = parts[0].trim();
                                String country = parts[1].trim();

                                manufacturers.add(new Manufacturer(name, country));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Збереження даних до файлової системи
    void saveDataToFileSystem() {
        saveDataToDirectory(souvenirDataPath, souvenirs);
        saveDataToDirectory(manufacturerDataPath, manufacturers);
    }

    // Збереження даних в каталог
    private void saveDataToDirectory(String directoryPath, List<?> data) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        for (Object item : data) {
            String fileName = generateUniqueFileName(item);

            try (FileWriter fileWriter = new FileWriter(new File(directory, fileName));
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(item.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Генерація унікального імені файлу
    private String generateUniqueFileName(Object item) {
        return item.hashCode() + ".txt";
    }

    // Додавання сувеніру в список
    public void addSouvenir(String name, String manufacturer, String releaseDate, String price) {
        souvenirs.add(new Souvenir(name, manufacturer, releaseDate, price));
    }

    // Додавання виробника в список
    public void addManufacturer(String name, String country) {
        manufacturers.add(new Manufacturer(name, country));
    }

    // Зміна ціни сувеніра
    public void editSouvenir(String name, String manufacturer, String newPrice) {
        souvenirs.stream()
                .filter(souvenir -> souvenir.getName().equals(name) && souvenir.getManufacturer().equals(manufacturer))
                .findFirst()
                .ifPresent(souvenir -> souvenir.setPrice(newPrice));
    }

    // Перегляд всіх сувенірів
    public void viewAllSouvenirs() {
        souvenirs.forEach(System.out::println);
    }

    // Перегляд всіх виробників
    public void viewAllManufacturers() {
        manufacturers.forEach(System.out::println);
    }

    public List<Souvenir> getSouvenirs() {
        return souvenirs;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    // Знаходження сувенірів по виробнику
    public void findSouvenirsByManufacturer(String manufacturerName) {
        souvenirs.stream()
                .filter(souvenir -> souvenir.getManufacturer().equals(manufacturerName))
                .forEach(System.out::println);
    }

    // Знаходження сувенірів за країною
    public void findSouvenirsByCountry(String country) {
        souvenirs.stream()
                .filter(souvenir -> manufacturers.stream()
                        .anyMatch(manufacturer ->
                                manufacturer.getName().equals(souvenir.getManufacturer()) &&
                                        manufacturer.getCountry().equals(country)
                        ))
                .forEach(System.out::println);
    }

    // Знаходження виробників за ціною
    public void findManufacturersByPrice(double maxPrice) {
        souvenirs.stream()
                .filter(souvenir -> Double.parseDouble(souvenir.getPrice()) <= maxPrice)
                .map(Souvenir::getManufacturer)
                .distinct()
                .forEach(manufacturerName -> manufacturers.stream()
                        .filter(manufacturer -> manufacturer.getName().equals(manufacturerName))
                        .findFirst()
                        .ifPresent(System.out::println));
    }

    // Знайти всіх виробників з сувнірами
    public void viewAllManufacturersWithSouvenirs() {
        manufacturers.forEach(manufacturer -> {
            System.out.println(manufacturer);
            souvenirs.stream()
                    .filter(souvenir -> souvenir.getManufacturer().equals(manufacturer.getName()))
                    .forEach(System.out::println);
        });
    }

    // Знайти іиробників за сувеніром та роком
    public void findManufacturersBySouvenirAndYear(String souvenirName, String year) {
        souvenirs.stream()
                .filter(souvenir -> souvenir.getName().equals(souvenirName) && souvenir.getReleaseDate().startsWith(year))
                .map(Souvenir::getManufacturer)
                .distinct()
                .forEach(manufacturerName -> manufacturers.stream()
                        .filter(manufacturer -> manufacturer.getName().equals(manufacturerName))
                        .findFirst()
                        .ifPresent(System.out::println));
    }

    // Знайти сувенір за роком
    public void findSouvenirsByYear(String year) {
        souvenirs.stream()
                .filter(souvenir -> souvenir.getReleaseDate().startsWith(year))
                .forEach(System.out::println);
    }

    //Видалити виробника
    public void deleteManufacturer(String name) {
        Manufacturer manufacturerToRemove = manufacturers.stream()
                .filter(manufacturer -> manufacturer.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (manufacturerToRemove != null) {
            manufacturers.remove(manufacturerToRemove);

            List<Souvenir> souvenirsToRemove = souvenirs.stream()
                    .filter(souvenir -> souvenir.getManufacturer().equals(name))
                    .collect(Collectors.toList());

            souvenirs.removeAll(souvenirsToRemove);
        }
    }

}
