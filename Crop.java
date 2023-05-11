public abstract class Crop{
    
 private String name;
 private double weight;
 private String cultivatedSeason;

    public Crop(String name, double weight, String cultivatedSeason) {
        this.name = name;
        this.weight = weight;
        this.cultivatedSeason = cultivatedSeason;
    }
 public Crop(){
     
 }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setWeight(double weight) {
        this.weight = weight;
    }
    

    public String getCultivatedSeason() {
        return cultivatedSeason;
    }
   public abstract String consumeIt();
       
    public abstract void storeIt() throws CanNotBeStoredException;  
 @Override
 public abstract String toString();
     
 
    
    
    
    
    
    
    
    
    
    
    
}
