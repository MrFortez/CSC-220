class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
        age = 18;
        name = "John Doe";

    }

    public void setAge(int val) {
        age = val;
    }

    public int getAge() {
        return age;
    }

    public void setName(String val) {
        name = val;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + "; Age: " + age;
    }

    // public static void main(String[] args) {
    //     Person guy = new Person();
    //     System.out.println(guy);
    // }
}
