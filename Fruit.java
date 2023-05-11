public class Fruit extends Crop implements Comparable<Fruit>{
    protected String taste;
    protected double price;
    private String color;

    private CropKeeper keeper;

    public Fruit(String name, double weight, String cultivatedSeason, String taste, double price) {
        super(name, weight, cultivatedSeason);
        this.taste = taste;
        this.price = price;
    }


    @Override
    public String toString() {
        return "NAME: " + super.getName() + " WEIGHT: " + super.getWeight() + " CULTIVATED SEASON: " + super.getCultivatedSeason() + " " + "TASTE: " + taste + " PRICE: " + price;
    }

    @Override
    public void consumeIt() {
        System.out.println("Fruits are consumed raw");
    }

    @Override
    public void storeIt() throws CapacityNotEnoughException {
        ((Store) keeper).importCrop(this);
    }
    @Override
    public int compareTo(Fruit fruit) {
        if(this.name == fruit.name && this.color == fruit.color) return 0;
        else return (int) (this.weight - fruit.weight);
    }


}
