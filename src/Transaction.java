/**
 * Created by YB on 02.11.2015.
 */
public class Transaction {

    private String transactionID;
    private String transactionDate;
    private double totalSum;
    private double tax;
    private Client client;
    private Car car;
    private String transactionInfo;
    private String[] transactionsDB = new String[30];
    private Car soldCars[] = new Car[30];

    Transaction() {
        transactionID = "-";
        transactionDate = "-";
        totalSum = 0;
        tax = 0;
        client = null;
        car = null;
        transactionInfo = null;
    }

    Transaction(String transactionID, String transactionDate, Car car, Client client) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.car = car;
        this.client = client;

    }

    public void makeTransaction(Transaction tr) {
        transactionInfo = "ID: " + tr.transactionID + ", DATE: " + tr.transactionDate + ", CLIENT FIRST NAME: " +
                tr.client.getFirstName() + ", CLIENT LAST NAME: " + tr.client.getLastName() + ", CAR VIN: " +
                tr.car.getVinCode() + ", CAR MODEL: " + tr.car.getModel() + ", PRICE: " + tr.car.getPrice();

        for (int i = 0; i < transactionsDB.length; i++) {
            if (transactionsDB[i] == null) {
                transactionsDB[i] = transactionInfo;
                break;
            }
        }

        for (int i = 0; i < soldCars.length; i++) {
            if (soldCars[i] == null) {
                soldCars[i] = tr.car;
                break;
            }
        }

    }

    public void printAllTransactions() {
        for (int i = 0; i < transactionsDB.length; i++) {
            if (transactionsDB[i] != null) {
                System.out.println(transactionsDB[i]);
            }
        }
    }
}
