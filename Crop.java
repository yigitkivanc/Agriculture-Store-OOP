public abstract class Crop {
    final protected String name;
    protected double weight;
    final protected String cultivatedSeason;


    public Crop(String name, double weight, String cultivatedSeason) {
        this.name = name;
        this.weight = weight;
        this.cultivatedSeason = cultivatedSeason;
    }
    public abstract String toString();
    public abstract void consumeIt();
    public abstract void storeIt() throws CapacityNotEnoughException;

    public double getWeight() {
        return weight;
    }

    public String getCultivatedSeason() {
        return cultivatedSeason;
    }

    public String getName() {
        return name;
    }
}
