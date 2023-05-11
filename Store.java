import java.util.ArrayList;


public class Store implements CropKeeper {
    private String ID;
    private String Name;
    private double maxCapacityArea;
    private double usedCapacityArea=0;
    private double KGperSquareMeter=10;
    private ArrayList<Fruit> fruitList;

    public Store(String ID, String Name, double maxCapacityArea, double KGperSquareMeter) {
        this.ID = ID;
        this.Name = Name;
        this.maxCapacityArea = maxCapacityArea;
        this.KGperSquareMeter = KGperSquareMeter;
        this.fruitList = new ArrayList<Fruit>();
    }

    public String getID() {
        return ID;
    }
    
     public Fruit getFruit(Crop c){
        for(Fruit f: fruitList){
            if(f.equals((Fruit)c)){
                return f;
            }
        }
        return null;
    }
    
    

    @Override
    public String howtoStore(Crop c) {
        if(c instanceof Fruit){
           return ("fruits in large refrigerated\n" +
"cooler rooms”");
        }else if(c instanceof Vegetable){
           return ("vegetables in sheds, not listed");
        }
       return "";
    }
    public double avaibleCapacity(){
        return maxCapacityArea - usedCapacityArea;
    }
    public boolean canBeStored(Fruit f){
        if(f.getWeight()<=avaibleCapacity()){
            return true;
        }
        return false;
    }
    public void importCrop(Fruit f)throws CapacityNotEnoughException {
        if(canBeStored(f)){
            usedCapacityArea+=f.getWeight();
            int index = fruitList.indexOf(f);
            System.out.println(f.toString());
            if(index !=-1){
                System.out.println("buldumm"+index);
                Fruit f1= fruitList.get(index);
                f1.setWeight(f1.getWeight()+f.getWeight());
            }
            else{
                fruitList.add(f);
            }
        }
        else {
            throw new CapacityNotEnoughException("Capacity is not enough");
        }
    }
    public void exportCrop(Fruit f)throws FruitNotFoundException{
        int index = fruitList.indexOf(f);
        
        if(index !=-1){
            usedCapacityArea-=f.getWeight();
            fruitList.remove(index);
        }
        else{
            throw new FruitNotFoundException("Fruit not found");
       
        }
        
    }
    @Override
    public String toString(){
        String str= "\n name: "+Name;
       
        for(Crop c: fruitList){
            
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
