public class main_Animals {
    static double distance_run = 100;
    static double distance_jump = 1;
    static double distance_swim = 1;

    public static void main(String[] args){

        Dog dog1 = new Dog("Sharik",5);
        Cat cat1 = new Cat("Kisa", 10);

        // get the dog with an unusual parameters
        Dog dog2 = new Dog("Alma", 2);
        dog2.set_runlimit(1);
        dog2.set_jumplimit(2);
        dog2.set_swimlimit(5);

        // ---------------------RUN ------------------
        System.out.println("Distance to run is " + distance_run);
        System.out.println(dog1.run(100));
        System.out.println(cat1.run(100));
        System.out.println(dog2.run(100));
        // ---------------------JUMP -----------------
        System.out.println("Distance to jump is " + distance_jump);
        System.out.println(dog1.jump(1));
        System.out.println(cat1.jump(1));
        System.out.println(dog2.jump(1));
        // ---------------------SWIM -----------------
        System.out.println("Distance to swim is " + distance_swim);
        System.out.println(dog1.swim(1));
        System.out.println(cat1.swim(1));
        System.out.println(dog2.swim(1));
        //--------------------------------------------





    }

}
