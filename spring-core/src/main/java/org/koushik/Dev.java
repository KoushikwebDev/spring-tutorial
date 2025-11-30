package org.koushik;

public class Dev {

    private Laptop laptopObj; // reference variable

    private int random;
    private int random2;

    public Dev(){
        System.out.println("Dev constructor");
    }


//    this value will be assign by the xml constructor-arg tag
    public Dev(int random, int random2, Laptop laptopObj) {
        this.random = random;
        this.random2 = random2;
        this.laptopObj = laptopObj;
    }

    public void doCode (){
       laptopObj.compile();
   }

    public String getRandom() {
        return this.random + " " + this.random2;
    }

    public void setRandom(int value){
         this.random = value;
    }

    public Laptop getLaptopObj() {
        return laptopObj;
    }

    public void setLaptopObj(Laptop laptopObj) {
        this.laptopObj = laptopObj;
    }
}
