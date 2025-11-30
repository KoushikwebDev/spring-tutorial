package org.koushik;

public class Dev {

    private Computer compObj; // reference variable


    public Dev(){
        System.out.println("Dev constructor");
    }

    public Computer getCompObj() {
        return compObj;
    }

    public void setCompObj(Computer compObj) {
        this.compObj = compObj;
    }

    public void doCode (){
        compObj.compile();
   }



}
