import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(11)
                .setAddress(this.address);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    boolean hasAge() {
        return age.isPresent();
    }

    void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public OptionalInt getAge() {
        return age;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String city) {
        this.address = city;
    }

    @Override
    public String toString() {
        return " Name : " + name + ", Surname : " +
                surname + ", Age : " + age.getAsInt() + ", Address : " + address + ", ";
    }


}
