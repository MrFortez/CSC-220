class PersonTest {
    public static void main(String[] args) {
        Person guy = new Person();
        System.out.println(guy);
        changeup(guy);
        System.out.println(guy);

        int x = 7; 
        System.out.println("x = " + x);
        changeup(x);
        System.out.println("x = " + x);
        


    }

    public static void changeup(Person x) {
        x.setAge(89);
        x.setName("Billy Bob");
    }

    public static void changeup(int x) {
        x = 10;
    }
}
