package domain.models;

public class BankAccount {

    private Integer NºCuenta;
    private Customer customer;
    private Movements movements;
    private String ProductoContrtado;
    private Integer saldo;

    public Integer getNºCuenta() {
        return NºCuenta;
    }

    public void setNºCuenta(Integer nºCuenta) {
        NºCuenta = nºCuenta;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movements getMovements() {
        return movements;
    }

    public void setMovements(Movements movements) {
        this.movements = movements;
    }

    public String getProductoContrtado() {
        return ProductoContrtado;
    }

    public void setProductoContrtado(String productoContrtado) {
        ProductoContrtado = productoContrtado;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}