import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Supplier implements CropKeeper {
    private String name;
    private String ID;
    private double budget;
    private ArrayList<Crop> cropList;

    public Supplier(String name, String ID, double budget) {
        this.name = name;
        this.ID = ID;
        this.budget = budget;
        this.cropList = new ArrayList<Crop>();
    }

    public String getID() {
        return ID;
    }
    

    @Override
    public String howtoStore(Crop c) {
       if(c instanceof Vegetable){
           return("vegetables in the field booths");
       }
       else if(c instanceof Fruit){
           return ("fruits in big refrigerators");
           
       }
       return "";
    }
       
   public void buyCrop(Crop c) throws SupplierHasNotEnougMoneyException, FruitNotAvailableException{
       if(c instanceof Fruit){
           try {
              
               Fruit f=(Fruit)c;
               Store s=(Store)f.getKeeper();
               Fruit fget=s.getFruit(f);
               if(fget==null){
                   
                   throw new FruitNotAvailableException("Fruit is not avaible");
               }
                if(budget<fget.getPrice()){
                   throw new SupplierHasNotEnougMoneyException("Supplier has not enough money");
               }
               addCrop(fget);
               s.exportCrop(fget);
               budget-=f.getPrice();
           } catch (FruitNotFoundException ex) {
               System.out.println(ex.toString());
           }
       }
       System.out.println(c.getName()+" added");
   }
    public double sellCrop(Crop c){
        return 0;
    }
    public int equals(int ID){
        if(this.ID.equals(ID)){
            return 0;
        }
        else{
            return -1;
        }
    }
    // ##kendim ekledim
    public void addCrop(Crop c){
        cropList.add(c);
    }
    public double avaibleBudget(){
        return budget;
    }
    public void removeCrop(Crop c){
        for(Crop c1: cropList){
            if(c1 instanceof Fruit && ((Fruit)c1).equals((Fruit)c)){
                cropList.remove(c1);
            }else if(c1 instanceof Vegetable && ((Vegetable)c1).equals((Vegetable)c)) {
                cropList.remove(c1);
            }
        }
        int x= cropList.indexOf(c);
        System.out.println(x);
        cropList.remove(c);
    }
   
    @Override
    public String toString(){
        String str= "\n name: "+name+"  ID:"+ID;
       
        for(Crop c: cropList){
            
            //System.out.println(c.getName()+c.toString());
           str+=c.toString();
           
           str+= c.consumeIt();
           str+= howtoStore(c);
         // System.out.println(str);
        str+= "\n";
        } 
        return str;
    }
    
    
   
}
