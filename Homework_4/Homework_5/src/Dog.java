public class Dog extends Animal{


    public Dog(String name, int age) {
        super(name, age);
        super.run_limit = 500;
        super.jump_limit = 0.5;
        super.swim_limit = 10;

    }
}
