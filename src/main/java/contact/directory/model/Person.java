package contact.directory.model;

/**
 *
 * @author C.Mateo
 */
public class Person {

    private int id;
    private String identification;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String phone;
    private Address address;

    public Person() {
    }

    public Person(
            int id,
            String identification,
            String firstName,
            String middleName,
            String lastName,
            String secondLastName,
            String phone,
            Address address
    ) {
        this.id = id;
        this.identification = identification;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isValid() {
        return !firstName.isEmpty()
                && !lastName.isEmpty()
                && !identification.isEmpty()
                && !phone.isEmpty();
    }

}
