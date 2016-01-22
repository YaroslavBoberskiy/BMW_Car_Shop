/**
 * Created by YB on 21.01.2016.
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

@RunWith(JUnit4.class)
public class ShopBusinessLogicTests {

    Transaction transaction1;
    Transaction transaction2;
    Transaction transaction3;
    Car car1;
    Car car2;
    Car car3;
    Client client;

    @Before
    public void Init () {
        car1 = new Car("VIN1", CarModel.M3, CarColor.ALPINE_WHITE, EngineType.PETROL, 3.0, BodyType.CONVERTIBLE, 109000);
        car2 = new Car("VIN4", CarModel.SERIES_3, CarColor.IMPERIAL_BLUE, EngineType.PETROL, 2.0, BodyType.COUPE, 59000);
        car3 = new Car("VIN6", CarModel.SERIES_5, CarColor.IMPERIAL_BLUE, EngineType.PETROL, 3.0, BodyType.COUPE, 81000);
        client = new Client(TilteBeforeClientName.Dr, "Elizabeth", "Koh", "23.11.1957", "077-99-00-31", "eh@mailx.com", "female", true);
        transaction1 = new Transaction("1", new Date().toString(), car1, client);
        transaction2 = new Transaction("2", new Date().toString(), car2, client);
        transaction3 = new Transaction("3", new Date().toString(), car3, client);
        test();
    }

    public void makeTransaction(Transaction tr) {
        setDiscount(tr.getCar());
        String transactionInfo = "ID: " + tr.getTransactionID() + ", DATE: " + tr.getTransactionDate() + ", CLIENT FIRST NAME: " +
                tr.getClient().getFirstName() + ", CLIENT LAST NAME: " + tr.getClient().getLastName() + ", CAR VIN: " +
                tr.getCar().getVinCode() + ", CAR MODEL: " + tr.getCar().getModel() + ", PRICE: " + tr.getCar().getPrice();

        tr.getTransactionsDB().add(transactionInfo);
        if (tr.getCar() instanceof Car) {
            tr.getSoldCars().add(tr.getCar());
        }
    }

    public void test () {
        makeTransaction(transaction1);
        makeTransaction(transaction2);
        makeTransaction(transaction3);
    }

    public void setDiscount (Car car) {
        if (car.getPrice() >= 80000 && car.getPrice() < 100000) {
            car.setPrice(car.getPrice() - (car.getPrice()*0.05));
        }
        if (car.getPrice() >= 100000) {
            car.setPrice(car.getPrice() - (car.getPrice()*0.1));
        }
    }

    @Test
    public void checkDiscount () {
        assertEquals((long) (109000 - 109000*0.1), (long)transaction1.getCar().getPrice());
        assertEquals((long) (59000), (long)transaction2.getCar().getPrice());
        assertEquals((long) (81000 - 81000*0.05), (long)transaction3.getCar().getPrice());
    }

}
