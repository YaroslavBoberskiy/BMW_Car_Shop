/**
 * Created by YB on 02.11.2015.
 */
public class Car {

    private CarModel model;
    private CarColor color;
    private EngineType engineType;
    private BodyType bodyType;
    private String vinCode;
    private double engineSize;
    private double price;

    Car () {

        model = CarModel.UNKNOWN;
        color = CarColor.UNKNOWN;
        engineType = EngineType.UNKNOWN;
        bodyType = BodyType.UNKNOWN;
        vinCode = "_";
        engineSize = 0;
        price = 0;
    }

    Car (String vinCode, CarModel model, CarColor color, EngineType engineType, double engineSize, BodyType bodyType, double price) {

        this.model = model;
        this.color = color;
        this.engineType = engineType;
        this.bodyType = bodyType;
        this.vinCode = vinCode;
        this.engineSize = engineSize;
        this.price = price;

    }

    public CarModel getModel() {
        return model;
    }

    public CarColor getColor() {
        return color;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getVinCode() {
        return vinCode;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
