package data.local;

import domain.models.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CustomerFileDataSource {
    private String nameFile = "Customer.txt";
    private static CustomerFileDataSource instance = null;

    public void save(Customer model) {
        List<Customer> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Customer> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Customer> models) {
        try {
            FileWriter writer = new FileWriter(nameFile);
            for (Customer model : models) {
                String line = model.getId() + "," + model.getAddress() + ","
                        + model.getTown() + "," + model.getAddressCode() + ","
                        + model.getDni() + "," + model.getName() + ","
                        + model.getSurname() + "\n";
                writer.write(line);
            }
            writer.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public Customer findById(String id) {
        List<Customer> models = findAll();
        for (Customer model : models) {
            if (Objects.equals(model.getId(), id)) {
                return model;
            }
        }
        return null;
    }

    public List<Customer> findAll() {
        List<Customer> models = new ArrayList<>();
        try {
            File file = new File(nameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 7) {
                    String id = data[0];
                    String address = data[1];
                    String town = data[2];
                    String addressCode = data[3];
                    String dni = data[4];
                    String name = data[5];
                    String surname = data[6];

                    Customer model = new Customer();
                    model.setId(id);
                    model.setAddress(address);
                    model.setTown(town);
                    model.setAddressCode(addressCode);
                    model.setDni(dni);
                    model.setName(name);
                    model.setSurname(surname);

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
        List<Customer> newList = new ArrayList<>();
        List<Customer> models = findAll();
        for (Customer model : models) {
            if (!Objects.equals(model.getId(), modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    public static CustomerFileDataSource getInstance() {
        if (instance == null) {
            instance = new CustomerFileDataSource();
        }
        return instance;
    }
}
