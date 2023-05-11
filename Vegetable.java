public class Vegetable extends Crop implements Comparable<Vegetable> {
    
   private String cultivatedRegion;  
   private CropKeeper keeper;

    public Vegetable(String cultivatedRegion, CropKeeper keeper, String name, double weight, String cultivatedSeason) {
        super(name, weight, cultivatedSeason);
        this.cultivatedRegion = cultivatedRegion;
        this.keeper = keeper;
        //System.out.println("vegetable construct");
        if(keeper instanceof Supplier){
            ((Supplier)keeper).addCrop(this);
            //System.out.println("supplier geldi----------------");
        }else if(keeper instanceof Store){
            System.out.println("store geldi------");
        }else{
            System.out.println("bulamadım");
        }
            
    }
   
   
    @Override
    public String consumeIt() {
        return ("vegetables are cooked”");
    }

    @Override
    public void storeIt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    
         public String toString() {
        return "cultivatedRegion: "+ cultivatedRegion + " Vegetable name:"+ getName()+ " weight" +getWeight() + " cultivatedSeason:" +getCultivatedSeason();
    }

    

    @Override
    public int compareTo(Vegetable o) {
        if(this.equals(o)){
            return 0;
        }
        else 
          return (this.getWeight()-o.getWeight())>0?1:-1;
    }

    
    public boolean equals(Vegetable obj) {
        return obj.getName().equals(this.getName());
    }
    
    
    
    
}
