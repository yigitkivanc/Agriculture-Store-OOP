/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApplication7.src.javaapplication7;





/**
 *
 * @author yigit
 */
public class Fruit extends Crop implements Comparable<Fruit> {
  
    private String taste;
    private double price;
    private CropKeeper keeper;
    private String color;

    public Fruit(String taste, double price, CropKeeper keeper, String color, String name, double weight, String cultivatedSeason) {
        super(name, weight, cultivatedSeason);
        this.taste = taste;
        this.price = price;
        this.keeper = keeper;
        this.color = color;
        if(keeper instanceof Supplier){
           ((Supplier)keeper).addCrop(this);
         //   System.out.println("supplier geldi"); 
        }else if(keeper instanceof Store){
            try {
                ((Store)keeper).importCrop(this);
            } catch (CapacityNotEnoughException ex) {
                
            }
           
        }else{
          //  System.out.println("bir şey gelmedi");
        }
    }

    
    
    public Fruit(String name,String color,CropKeeper keeper){
        this.color=color;
        setName(name);
        this.keeper=keeper;
    }

    public String getColor() {
        return color;
    }

    public CropKeeper getKeeper() {
        return keeper;
    }
 public double getPrice() {
        return price;
    }
   
    @Override
    public String consumeIt() {
       return "fruits are consumed raw";
    }

    @Override
    public void storeIt() throws CanNotBeStoredException {
        
        if(keeper instanceof Store ){
            try {
                ((Store)keeper).importCrop(this);
            } catch (CapacityNotEnoughException ex) {
                System.out.println(ex.toString());
            }
        
      }else{
            throw new CanNotBeStoredException("Supplier can not be stored");
        }
    }

    @Override
    public String toString() {
        return " taste:"+taste +" price"+price +" color" +color+" name"+ getName()+ " weight" +getWeight() + " cultivatedSeason:" +getCultivatedSeason();
    }

    @Override
    public int compareTo(Fruit o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean equals(Fruit obj) {
        
        return obj.getName().equals(this.getName())&& obj.getColor().equals(this.getColor());
        
    }
    
    
}
