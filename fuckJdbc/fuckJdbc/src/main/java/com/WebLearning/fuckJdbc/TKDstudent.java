package com.WebLearning.fuckJdbc;

public class TKDstudent {
    private String id;
    private String Name;
    private int times;

    TKDstudent(String id,String Name, int times) {
        this.id = id;
        this.Name = Name;
        this.times = times;
    }


    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setTimes(int i){
        this.times = i;
    }

    public int getTimes(){
        return this.times;
    }
}
