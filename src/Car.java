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

    public void setModel(CarModel model) {
        this.model = model;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
