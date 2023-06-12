package data.local;

import domain.models.BankAccount;
import domain.models.Product;
import domain.models.Customer;
import domain.models.Movement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BankAccountFileDataSource {
    private String nameFile = "BankAccount.txt";



    private static BankAccountFileDataSource instance = null;



    public void save(BankAccount model) {
        List<BankAccount> models = findAll();
        models.add(model);
        saveToFile(models);
    }



    public void saveList(List<BankAccount> models) {
        saveToFile(models);
    }



    private void saveToFile(List<BankAccount> models) {
        try {
            FileWriter writer = new FileWriter(nameFile);
            for (BankAccount model : models) {
                String line = model.getId() + "," + model.getAccNumber() + ","
                        + model.getOwner().getId() + "," + model.getTransaction().getId() + ","
                        + model.getProduct().getCode() + "," + model.getBalance() + "\n";
                writer.write(line);
            }
            writer.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }



    public BankAccount findById(String id) {
        List<BankAccount> models = findAll();
        for (BankAccount model : models) {
            if (Objects.equals(model.getId(), id)) {
                return model;
            }
        }
        return null;
    }



    public List<BankAccount> findAll() {
        List<BankAccount> models = new ArrayList<>();
        try {
            File file = new File(nameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 6) {
                    String id = data[0];
                    String accNumber = data[1];
                    String ownerId = data[2];
                    String transactionId = data[3];
                    String productCode = data[4];
                    Integer balance = Integer.parseInt(data[5]);

                    Customer owner = new Customer();
                    owner.setId(ownerId);
                    Movement transaction = new Movement();
                    transaction.setId(transactionId);
                    Product product = new Product();
                    product.setCode(productCode);

                    BankAccount model = new BankAccount();
                    model.setId(id);
                    model.setAccNumber(accNumber);
                    model.setOwner(owner);
                    model.setTransaction(transaction);
                    model.setProduct(product);
                    model.setBalance(balance);

                    models.add(model);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return models;
    }



    public void delete(String modelId) {
        List<BankAccount> newList = new ArrayList<>();
        List<BankAccount> models = findAll();
        for (BankAccount model : models) {
            if (!Objects.equals(model.getId(), modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }


    public static BankAccountFileDataSource getInstance() {
        if (instance == null) {
            instance = new BankAccountFileDataSource();
        }
        return instance;
    }
}