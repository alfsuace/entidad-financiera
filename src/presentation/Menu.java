package presentation;

public class Menu {
    public void init(){
        // createNewPayment();
        // createNewCharge();
        // createNewMortgage();
        // createNewClient();
        // createNewBankAccount(customer, movement, movement2, product);
        // listClient();
    }

    private void createNewPayment(){
        NewPayment newPayment = new NewPayment();
        newPayment.createPayment();
    }
    private void createNewCharge(){
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
    private void createNewBankAccount(Customer customer, Movement movement, Movement movement2, Product product){
        NewBankAccount newBankAccount = new NewBankAccount();
        newBankAccount.createBankAccoutn(customer, movement, movement2, product);
    }

    private void listClient(){
        ListClient listClient = new  ListClient();
        listClient.listClients();

    }
}
