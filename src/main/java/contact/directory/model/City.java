package contact.directory.model;

/**
 *
 * @author C.Mateo
 */
public class City {

    private int id;
    private String name;

    public City() {
        id = -1;
        name = "";
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid() {
        return !name.isEmpty();
    }

    @Override
    public String toString() {
        return getName();
    }

}
