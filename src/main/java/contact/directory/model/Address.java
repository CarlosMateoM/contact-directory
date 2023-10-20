package contact.directory.model;

/**
 *
 * @author C.Mateo
 */
public class Address {
    private int id;
    private String street;
    private String avenue;
    private String number;
    private String on;
    private Neighborhood neighborhood;

    public Address() {
    }

    public Address(int id, String street, String avenue, String number, String on, Neighborhood neighborhood) {
        this.id = id;
        this.street = street;
        this.avenue = avenue;
        this.number = number;
        this.on = on;
        this.neighborhood = neighborhood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }
    
    public boolean isValid() {
        return neighborhood != null &&
               !street.isEmpty() &&
               !avenue.isEmpty() &&
               !number.isEmpty() &&
               !on.isEmpty();
    }
    
}
