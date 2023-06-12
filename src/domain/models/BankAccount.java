package domain.models;

public class BankAccount {
    private String id;
    private String accNumber;
    private Customer owner;
    private Movement transaction;
    private Product product;
    private Integer balance;

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setTransaction(Movement transaction) {
        this.transaction = transaction;
    }
    public Movement getTransaction(){
        return transaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "MyClass{" +
                "id='" + id + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", owner=" + owner.toString() +
                ", transaction=" + transaction.toString() +
                ", product=" + product.toString() +
                ", balance=" + balance +
                '}';
    }
}