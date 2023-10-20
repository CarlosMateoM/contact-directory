package contact.directory.model;

/**
 *
 * @author C.Mateo
 */
public class Commune {
    
    private int id;
    private String name;
    private City city;

    public Commune() {
    }

    public Commune(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public boolean isValid(){
        return !name.isEmpty();
    }
    
    @Override
    public String toString() {
        return getName();
    }

}
