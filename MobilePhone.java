
/**
 * Write a description of class MobilePhone here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MobilePhone
{
   private String brand;
   private String model;
   private double price;
   private int batteryLevel;
   private boolean isOn;
   
   public MobilePhone(){
       this.brand="unknown";
       this.model="unknown";
       this.price=0;
       this.batteryLevel=100;
       this.isOn=false;
   }
   public MobilePhone(String brand,String model,double price,int batteryLevel,boolean isOn){
   this.brand=brand;
   this.model=model;
   setPrice(price);
   this.batteryLevel=100;
   this.isOn=false;
}
public String getBrand(){
    return brand;
} public String getModel(){
       return model;
}
public double getPrice(){
    return price;
}
public int getBatteryLevel(){
    return batteryLevel;
}
public boolean getIsOn(){
    return isOn;
}
public void setPrice(double Price){
    if (price>0){
        this.price=price;
    }else{
        System.out.println("price must be positive");
    }
}

public void setBatteryLevel(int batteryLevel){
    if (batteryLevel>=0 && batteryLevel<=100){
        this.batteryLevel=batteryLevel;
    }else{
        System.out.println("must be within 100");
  }
}

public void turnon(){
    if  (batteryLevel>0){
        isOn=true;
        System.out.println("phone is on");
    }else{
        System.out.println("phone is not on");
    }
}

public void turnoff(){
    isOn=false;
    System.out.println("phone is off");
}

public void makeCall(String contactName){
    if(batteryLevel>=5){
        batteryLevel-=5;
        System.out.println("calling" +contactName);
    }else{
        System.out.println("not calling");
    }
}

public void chargeBattery (int minutes){
    int addedCharge=minutes+2;
    batteryLevel+=addedCharge;
    if(batteryLevel>100){
        System.out.println("phone charged for"+ minutes);
    }
}
public void displayInfo(){
    System.out.println("brand" +brand);
    System.out.println("model" +model);
    System.out.println("price" +price);
    System.out.println("batteryLevel" +batteryLevel);
    
}

public static void main(String[]args){
    System.out.println("Mobile Phone Exercise");
    MobilePhone phone1=new MobilePhone();
    MobilePhone phone2=new MobilePhone();
    
    phone2.turnon();
    
    phone2.makeCall("Raya");
    phone2.makeCall("Asya");
    phone2.makeCall("Khuzaima");
    
    phone2.displayInfo();
    phone2.chargeBattery(10);
    phone2.displayInfo();
    System.out.println("=====EXERCISE COMPLETE====");
}
    
}

