public class Cat extends Animal{


    public Cat(String name, int age) {
        super(name, age);
        super.run_limit = 200;
        super.jump_limit = 2;
        super.swim_limit = 0;
    }
}
