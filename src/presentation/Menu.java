package presentation;

import domain.models.Customer;
import domain.models.Movement;
import domain.models.Product;

import java.sql.SQLException;

public class Menu {
    public void init(){
        // createNewPayment();
        // createNewCharge();
        // createNewMortgage();
        // createNewClient();
        //createNewBankAccount(customer, movement, movement2, product);
        // listClient();
    }

    private void createNewPayment() throws SQLException {
        NewPayment newPayment = new NewPayment();
        newPayment.createPayment();
    }
    private void createNewCharge() throws SQLException {
        NewCharge newCharge=new NewCharge();
        newCharge.createCharge();
    }
    private void createNewMortgage(){
        NewMortgage newMortgage = new NewMortgage();
        newMortgage.createMortgage();
    }
    private void createNewClient(){
        NewClient newClient = new NewClient();
        newClient.createClient();
    }
    private void createNewBankAccount(Customer customer, Movement movement, Movement movement2, Product product) throws SQLException {
        NewBankAccount newBankAccount = new NewBankAccount();
        newBankAccount.createBankAccount(customer, movement, movement2, product);
    }

    private void listClient(){
        ListClient listClient = new  ListClient();
        listClient.listClients();

    }
}
