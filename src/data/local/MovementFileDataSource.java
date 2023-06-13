package data.local;

import domain.models.Movement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovementFileDataSource {
    private String nameFile = "Movement.txt";
    private static MovementFileDataSource instance = null;

    public void save(Movement model) {
        List<Movement> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Movement> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Movement> models) {
        try {
            FileWriter writer = new FileWriter(nameFile);
            for (Movement model : models) {
                String line = model.getId() + "," + model.getDescription() + ","
                        + model.getAmount() + "\n";
                writer.write(line);
            }
            writer.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public Movement findById(String id) {
        List<Movement> models = findAll();
        for (Movement model : models) {
            if (model.getId().equals(id)) {
                return model;
            }
        }
        return null;
    }

    public List<Movement> findAll() {
        List<Movement> models = new ArrayList<>();
        try {
            File file = new File(nameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    String id = data[0];
                    String description = data[1];
                    int amount = Integer.parseInt(data[2]);

                    Movement model = new Movement();
                    model.setId(id);
                    model.setDescription(description);
                    model.setAmount(amount);

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
        List<Movement> newList = new ArrayList<>();
        List<Movement> models = findAll();
        for (Movement model : models) {
            if (!model.getId().equals(modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    public static MovementFileDataSource getInstance() {
        if (instance == null) {
            instance = new MovementFileDataSource();
        }
        return instance;
    }
}