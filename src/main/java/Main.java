public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setName("John")
                .setSurname("Smith")
                .setAge(35)
                .setAddress("New York")
                .build();
        System.out.println(person);
        person.happyBirthday();
        person.setAddress("Casablanca");
        System.out.println(person);
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        try {
            // Возраст недопустимый
            new PersonBuilder().setName("TestIllegalAge").setSurname("TestIllegalAge").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
