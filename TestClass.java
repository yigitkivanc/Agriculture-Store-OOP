import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    public static CropKeeper getCropKeeper(String ID, ArrayList<Supplier> suppliers, ArrayList<Store> stores) {

        for (Supplier sp : suppliers) {
            if (sp.getID().equals(ID)) {
                return sp;
            }

        }
        for (Store s : stores) {

            if (s.getID().equals(ID)) {

                return s;
            }
        }

        return null;
    }
    public static Fruit createFruitObject(CropKeeper keeper){
        Scanner input=new Scanner(System.in);
         System.out.println("Enter the fruit taste:");  
           String taste=input.next();
           System.out.println("Enter the fruit price:");   
           double price=input.nextDouble();
            System.out.println("Enter the fruit color:");  
           String color=input.next();
           System.out.println("Enter the fruit name:");  
           String name=input.next();
           System.out.println("Enter the fruit weight:");   
           double weight=input.nextDouble();
           System.out.println("Enter the fruit cultivatedSeason:");  
           String season=input.next();
           Fruit f= new Fruit(taste,price,keeper,color,name,weight,season);
         //   public Fruit(String taste, double price, CropKeeper keeper, String color, String name, double weight, String cultivatedSeason) {
         return f;
    }
    public static Vegetable creatVegetableObject(CropKeeper keeper){
        Scanner input=new Scanner(System.in);
      //  public Vegetable(String cultivatedRegion, CropKeeper keeper, String name, double weight, String cultivatedSeason) {
      System.out.println("Enter the Vegetable region:");  
           String region=input.next();
          System.out.println("Enter the Vegetable name:");  
           String name=input.next();  
           System.out.println("Enter the Vegetable weight :");   
           double weight=input.nextDouble();
           System.out.println("Enter the Vegetable cultivatedSeason:");  
           String season=input.next();
           Vegetable v= new Vegetable(region, keeper, name, weight, season);
           return v;
    }
     public static Fruit getFruit(Fruit f,ArrayList<Store> stores){
         for(Store s: stores){
             Fruit fs=s.getFruit(f);
             
             if(fs!=null){
                return fs; 
             }
         }
         return null;
     }
    public static void main(String[] args) {
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        ArrayList<Store> stores = new ArrayList<Store>();
        try {
            suppliers.add(new Supplier("ArazMeyve", "1133", 1000));
            suppliers.add(new Supplier("AylarTarim", " 1298", 1500));
            suppliers.add(new Supplier("HasanBey", "1322", 200));
            suppliers.add(new Supplier("ZehraCiftci", "1429", 1250));
            stores.add(new Store("5343", "Migros", 1000, 12));
            stores.add(new Store("5967", "File", 1200, 10));
            //Supplier s= suppliers.get(suppliers.indexOf(args));

            File myObj = new File("src\\Crops.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] infos = data.split(",");
                System.out.println(infos[1]);
                if (infos[1].trim().equals("fruit")) {
                    Fruit f = new Fruit(infos[4], Double.parseDouble(infos[5]), getCropKeeper(infos[6].trim(), suppliers, stores), "red", infos[0], Double.parseDouble(infos[2]), infos[3]);
                } else if (infos[1].trim().equals("vegetable")) {
                 Vegetable v= new Vegetable(infos[3], getCropKeeper(infos[4].trim(),suppliers,stores), infos[0], Double.parseDouble(infos[2]),"winter"); 
        
                }
            }
            myReader.close();
             while(true){
      Scanner input= new Scanner(System.in);
      System.out.println(" 1=Display all suppliers \n 2= Display all stores \n 3=Buy a fruit crop \n 4= Sell a fruit crop \n 5= Remove a fruit from a store  \n 6=Remove a crop from a supplier \n 7=Add crop \n 8=Show remaining budget \n 9=Show remaining capacity \n  0=Quit");
      int a =input.nextInt();
         
       if(a==1){
           for(Supplier sp: suppliers){
              // System.out.println("me");
               System.out.println(sp.toString());
           }
       }
       else if(a==2){
         for(Store sp: stores){
             System.out.println(sp.toString());
         }
           
       }    
       else if(a==3){   
           System.out.println("Enter the ID:");
           String supID=input.next();
          
           
           Supplier sp= null;
           Store st= null;
           CropKeeper s= getCropKeeper(supID, suppliers, stores);
          if(s instanceof Supplier){
           sp=((Supplier)s);
            //  System.out.println("Enter the fruit name and color");
            //  String name=input.nextLine():
          
          }else{
              System.out.println("Your selected supplier ID is not found ");
          }
           System.out.println("Enter store ID");
           String storeID= input.next();
           CropKeeper store= getCropKeeper(storeID, suppliers, stores);
          if(store instanceof Store){
              st= ((Store)store);
          }else{
             System.out.println("Your selected store ID is not found "); 
          }
           System.out.println("Enter the fruit name and color"); 
           String fname=input.next();
           String fcolor=input.next();
           Crop c= new Fruit(fname,fcolor,st);
           
           if(sp!=null&&st!=null){
               sp.buyCrop(c);
           }
          }
          
       else if(a==4){ 
         
      } 
       else if(a==5){
           Store st= null;
        System.out.println("Enter store ID");
           String storeID= input.next();
           CropKeeper store= getCropKeeper(storeID, suppliers, stores);
          if(store instanceof Store){
              
              st= ((Store)store);
               System.out.println("Enter the fruit name and color"); 
           String fname=input.next();
           String fcolor=input.next();
           Crop c= new Fruit(fname,fcolor,st);
           Fruit f= st.getFruit(c);
           if(f!=null){
               st.exportCrop(f);
           }
          }else{
             System.out.println("Your selected store ID is not found "); 
          }
       }
       else if(a==6){
        System.out.println("Enter the Supplier ID:");
           String supID=input.next();
          
           
           Supplier sp= null;
           Store st= null;
           CropKeeper s= getCropKeeper(supID, suppliers, stores);
          if(s instanceof Supplier){
           sp=((Supplier)s);
          System.out.println("Select 1 for fruit or 2 for vegetable");
           int sselect= input.nextInt();
           Crop c=null;
           if(sselect==1){
                System.out.println("Enter the fruit name and color"); 
           String fname=input.next();
           String fcolor=input.next();
           Crop c1= new Fruit(fname,fcolor,sp);
              sp.removeCrop(c1);
           }
           else if(sselect==2){
             
           }
          
          }else{
              System.out.println("Your selected supplier ID is not found ");
          }
       }
       else if(a==7){
           try{
           System.out.println("Select 1 for store or 2 for supplier");
           int select= input.nextInt();
           if(select==1){
               Store st= null;
               System.out.println("Enter store ID");
           String storeID= input.next();
           CropKeeper store= getCropKeeper(storeID, suppliers, stores);
          if(store instanceof Store){
              st= ((Store)store);
          }else{
             System.out.println("Your selected store ID is not found "); 
          }
          if(st!=null){
             Fruit f= createFruitObject(st);
             st.importCrop(f);
          
          }
         
           }
           else if(select==2){
               System.out.println("Enter the Supplier ID:");
           String supID=input.next();
          
           
           Supplier sp= null;
           
           CropKeeper s= getCropKeeper(supID, suppliers, stores);
          if(s instanceof Supplier){
           sp=((Supplier)s);
            //  System.out.println("Enter the fruit name and color");
            //  String name=input.nextLine():
             System.out.println("Select 1 for fruit or 2 for vegetable");
           int sselect= input.nextInt();
           Crop c=null;
           if(sselect==1){
                
               c=createFruitObject(sp);
               sp.addCrop(c);
           }
           else if(sselect==2){
             c=creatVegetableObject(sp);
             sp.addCrop(c);
           }
          }else{
              System.out.println("Your selected supplier ID is not found ");
          }
                     
           }       
                  
           }catch(CapacityNotEnoughException ex){
               System.out.println(ex.toString());
           }
        
          
       }
       else if(a==8){
             System.out.println("Enter the Supplier ID:");
           String supID=input.next();
           
           
           Supplier sp= null;
           
           CropKeeper s= getCropKeeper(supID, suppliers, stores);
          if(s instanceof Supplier){
           sp=((Supplier)s);
            //  System.out.println("Enter the fruit name and color");
            //  String name=input.nextLine():
              System.out.println("remaining budget is: "+sp.avaibleBudget());
          }else{
              System.out.println("Your selected supplier ID is not found ");
          }
       }
       else if(a==9){
          Store st= null;
               System.out.println("Enter store ID");
           String storeID= input.next();
           CropKeeper store= getCropKeeper(storeID, suppliers, stores);
          if(store instanceof Store){
              st= ((Store)store);
          }else{
             System.out.println("Your selected store ID is not found "); 
          }
          if(st!=null){
              System.out.println("Avaible capacity is:"+st.avaibleCapacity()); 
             
          
          }
       }
       else if(a==0){
          break;
       }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
