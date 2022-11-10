import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person prs = null;
        if (this.name == null) {
            throw new IllegalArgumentException("You must specify the name!");
        }
        if (this.surname == null) {
            throw new IllegalArgumentException("You must specify the surname!");
        }
        if (this.age.getAsInt() < 0 || this.age.getAsInt() > 150) {
            throw new IllegalArgumentException("The age is incorrectly specified");
        }
        if(this.address == null){
            this.address = "unknown";
        }
        prs = new Person(this.name, this.surname, this.age.getAsInt(), this.address);

        return prs;
    }


}

