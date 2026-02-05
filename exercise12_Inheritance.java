/**
 * Write a description of class Person here.
 *
 * @author (24BIA035)
 * @version (a version number or a date)
 */

class Vehicle
{
 protected String brand;
 protected String model;
 protected int year;
 protected double price;
 
 public Vehicle(String brand, String model, int year, double price){
     this.brand=brand;
     this.model=model;
     this.year=year;
     this.price=price;
     System.out.println("Vehicle constructor called");
 }
 public void displayInfo(){
     System.out.println("Brand of vehicle:" +brand);
     System.out.println("Model of vehicle;" +model);
     System.out.println("Year of vehicle:" +year);
     System.out.println("Price of vehicle:" +price);
 }
 public void startEngine(){
     System.out.println(brand+ " "+model+ "engine started");
 }
 public void stopEngine(){
     System.out.println(brand+ " " +model+ "engine stopped");
 }
}
class Car extends Vehicle{
    private int numDoors;
    private String fuelType;
    
    public Car(String brand, String model, int year,double price,int numDoors,String fuelType){
        super(brand,model,year,price);
        this.numDoors=numDoors;
        this.fuelType=fuelType;
        System.out.println("Car constructor called");
    } 
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Doors:" +numDoors);
        System.out.println("Fuel Type:" +fuelType);
    }
    public void honk(){
        System.out.println(brand+ " "+model+ "says: Beep! Beep!");
    }
    public void openTrunk(){
        System.out.println("Opening trunk of" +brand+ " "+model);
    }
}
class Motorcycle extends Vehicle{
    private int engineCC;
    private boolean hasHelmetStorage;
    
    public Motorcycle(String brand, String model, int year,double price,int engineCC,boolean hasHelmetStorage){
        super(brand,model,year,price);
        this.engineCC=engineCC;
        this.hasHelmetStorage=hasHelmetStorage;
        System.out.println("Motorcycle constructor called");
    } 
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Engine:" +engineCC+ "CC");
        System.out.println("Helmet Storage:" +(hasHelmetStorage? "Yes": "No"));
    }          
    public void wheelie(){
        System.out.println(brand+ " " +model+ "is doing a wheelie!");
    }
    public void kickStart(){
        System.out.println("Kick starting" +brand+ " "+model);
    }
}

class ElectricCar extends Car{
    private double batteryCapacity;
    private int range;
    
    public ElectricCar(String brand, String model, int year,double price,int numDoors,String fuelType,double batteryCapacity,int range){
        super(brand,model,year,price,numDoors,fuelType);
        this.batteryCapacity=batteryCapacity;
        this.range=range;
        System.out.println("ElectricCar constructor called");
    } 
    @Override
    public void startEngine(){
        System.out.println(brand+ " " +model+ "electric motor activated silently");
    }
    public void charge(){
        System.out.println("charging"+brand+ " " +model+"....battery:"+batteryCapacity+"km" );
    }
    public void displayBatteryStatus(){
        System.out.println("Battery capacity:" +batteryCapacity+"km");
        System.out.println("range:"+range+ "km");
    }
}
public class exercise12_Inheritance{
    public static void main(String[]args){
    System.out.println("=== VEHICLE HIERACHY TEST ===\n");
    Car car=new Car("Toyota","Corolla",2023,4500000,4,"Petrol");
    Motorcycle motorcycle=new Motorcycle("Honda","CBR500R", 2022, 1500000, 500,false);
    ElectricCar electricCar=new ElectricCar("Tesla", "Model 3", 2024,8500000, 4,"Electric", 75.0,450);
        
    System.out.println("---Testing Car ---");
    car.displayInfo();

    car.startEngine();
    car.honk();
    car.openTrunk();
    car.stopEngine();
         
    System.out.println("\n--- Testing Motorcycle ---");
    motorcycle.displayInfo();
    motorcycle.startEngine();
    motorcycle.wheelie();
    motorcycle.kickStart();
    motorcycle.stopEngine();
        
    System.out.println("\n--- Testing Electric Car ---");
    electricCar.displayInfo();
    electricCar.startEngine(); 
    electricCar.charge();
    electricCar.displayBatteryStatus();
    electricCar.honk();  
    electricCar.stopEngine();
        
    System.out.println("\n--- Polymorphism Demo ---");
    Vehicle[] vehicles = {car, motorcycle, electricCar};
    for (Vehicle v : vehicles) {
        v.displayInfo();
        v.startEngine();
        System.out.println();
        

        System.out.println("\n=== END OF TEST ===");
    }
}

}
