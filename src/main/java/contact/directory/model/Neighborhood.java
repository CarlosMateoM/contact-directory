package contact.directory.model;

/**
 *
 * @author C.Mateo
 */
public class Neighborhood {
    private int id;
    private String name;
    private Commune commune;

    public Neighborhood() {
        id = -1;
        name = "";
        commune = null;
    }

    public Neighborhood(int id, String name, Commune commune) {
        this.id = id;
        this.name = name;
        this.commune = commune;
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

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
    
    @Override
    public String toString() {
        return getName();
    }
   
}
