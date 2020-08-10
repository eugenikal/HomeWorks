public class Animal {
    private String name;
    private int age;
    protected double run_limit;
    protected double jump_limit;
    protected double swim_limit;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    //Animal(){}

    public String run(double distance){
        if (distance < run_limit) {return(name + " has ran successfully");} else return(name + " failed");
    }
    public String swim(double distance){
        if (distance < swim_limit) {return(name + " has swum successfully");} else return(name + " failed");
    }
    public String jump(double distance){
        if (distance < jump_limit) {return(name + " has jumped over successfully");} else return(name + " failed");
    }

    // ---setters to make distances differ from default ones---
    public void set_runlimit(double new_runlimit){
        this.run_limit = new_runlimit;
    }
    public void set_jumplimit(double new_jumplimit){
        this.jump_limit = new_jumplimit;
    }
    public void set_swimlimit(double new_swimlimit){
        this.swim_limit = new_swimlimit;
    }

    public double get_runlimit(){
        return this.run_limit;
    }
}
