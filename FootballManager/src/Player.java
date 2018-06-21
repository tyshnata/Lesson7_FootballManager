import java.util.Objects;
/** Class Player defines an object with the fields name, age, rating and command.
 * The class contains a constructor, methods for obtaining the name, age, rating and command of the object,
 * and overridden methods equals() and hashCode() */
public class Player {

    private String name;
    private Integer age;
    private Double rating;
    private String command;

    public Player(String name, Integer age, Double rating, String command) {
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getRating() {
        return rating;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(age, player.age) &&
                Objects.equals(rating, player.rating) &&
                Objects.equals(command, player.command);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, rating, command);
    }
}
