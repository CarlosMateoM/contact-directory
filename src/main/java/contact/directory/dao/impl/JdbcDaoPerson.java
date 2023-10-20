package contact.directory.dao.impl;

import contact.directory.enums.ProcessErrorMessage;
import contact.directory.exception.DatabaseAccessException;
import contact.directory.model.Neighborhood;
import contact.directory.model.City;
import contact.directory.model.Commune;
import contact.directory.model.Address;
import contact.directory.model.Person;
import contact.directory.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import contact.directory.dao.PersonDao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoPerson implements PersonDao {

    private final DataSource dataSource;

    public JdbcDaoPerson(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Person getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> getAll() {
        String sql = "SELECT "
                + "p.primer_nombre as primerNombre, "
                + "p.segundo_nombre as segundoNombre, "
                + "p.primer_apellido as primerApellido, "
                + "p.segundo_apellido as segundoApellido, "
                + "p.cedula as cedula, "
                + "p.telefono as telefono, "
                + "d.calle as calle, "
                + "d.carrera as carrera, "
                + "d.numero as numero, "
                + "d.sobre as sobre, "
                + "b.nombre as Barrio, "
                + "c.nombre as comuna, "
                + "c2.nombre as ciudad "
                + "FROM "
                + "persona p "
                + "INNER JOIN direccion d ON p.direccion_id = d.id "
                + "INNER JOIN barrio b ON d.barrio_id = b.id "
                + "INNER JOIN comuna c ON b.comuna_id = c.id "
                + "INNER JOIN ciudad c2 ON c.ciudad_id = c2.id "
                + "ORDER BY p.primer_nombre";

        try (
                Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Person> people = new ArrayList<>();
                while (resultSet.next()) {

                    String primerNombre = resultSet.getString("primerNombre");
                    String segundoNombre = resultSet.getString("segundoNombre");
                    String primerApellido = resultSet.getString("primerApellido");
                    String segundoApellido = resultSet.getString("segundoApellido");
                    String cedula = resultSet.getString("cedula");
                    String telefono = resultSet.getString("telefono");
                    String calle = resultSet.getString("calle");
                    String carrera = resultSet.getString("carrera");
                    String numero = resultSet.getString("numero");
                    String sobre = resultSet.getString("sobre");
                    String barrio = resultSet.getString("Barrio");
                    String comuna = resultSet.getString("comuna");
                    String ciudad = resultSet.getString("ciudad");

                    City city = new City(-1, ciudad);
                    Commune commune = new Commune(-1, comuna, city);
                    Neighborhood neighborhood = new Neighborhood(-1, barrio, commune);

                    Address address = new Address(
                            -1,
                            calle,
                            carrera,
                            numero,
                            sobre,
                            neighborhood
                    );

                    Person person = new Person(
                            -1,
                            cedula,
                            primerNombre,
                            segundoNombre,
                            primerApellido,
                            segundoApellido,
                            telefono,
                            address
                    );

                    people.add(person);
                }
                return people;
            }

        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    ProcessErrorMessage.ERROR_OBTENER_REGISTROS.getMessage() + e.getMessage(),
                    e.getCause()
            );
        }
    }

    @Override
    public List<Person> getByKey(String key) {
        String sql = "SELECT "
                + "p.primer_nombre as primerNombre, "
                + "p.segundo_nombre as segundoNombre, "
                + "p.primer_apellido as primerApellido, "
                + "p.segundo_apellido as segundoApellido, "
                + "p.cedula as cedula, "
                + "p.telefono as telefono, "
                + "d.calle as calle, "
                + "d.carrera as carrera, "
                + "d.numero as numero, "
                + "d.sobre as sobre, "
                + "b.nombre as Barrio, "
                + "c.nombre as comuna, "
                + "c2.nombre as ciudad, "
                + "CONCAT(p.primer_nombre, ' ', p.segundo_nombre, ' ', p.primer_apellido, ' ', p.segundo_apellido) AS nombreCompleto "
                + "FROM "
                + "persona p "
                + "INNER JOIN direccion d ON p.direccion_id = d.id "
                + "INNER JOIN barrio b ON d.barrio_id = b.id "
                + "INNER JOIN comuna c ON b.comuna_id = c.id "
                + "INNER JOIN ciudad c2 ON c.ciudad_id = c2.id "
                + "WHERE CONCAT(p.primer_nombre, ' ', p.segundo_nombre, ' ', p.primer_apellido, ' ', p.segundo_apellido) ILIKE ? "
                + "OR cedula LIKE ? ORDER BY p.primer_nombre";

        try (
                Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                List<Person> people = new ArrayList<>();
                while (resultSet.next()) {

                    String primerNombre = resultSet.getString("primerNombre");
                    String segundoNombre = resultSet.getString("segundoNombre");
                    String primerApellido = resultSet.getString("primerApellido");
                    String segundoApellido = resultSet.getString("segundoApellido");
                    String cedula = resultSet.getString("cedula");
                    String telefono = resultSet.getString("telefono");
                    String calle = resultSet.getString("calle");
                    String carrera = resultSet.getString("carrera");
                    String numero = resultSet.getString("numero");
                    String sobre = resultSet.getString("sobre");
                    String barrio = resultSet.getString("Barrio");
                    String comuna = resultSet.getString("comuna");
                    String ciudad = resultSet.getString("ciudad");

                    City city = new City(-1, ciudad);
                    Commune commune = new Commune(-1, comuna, city);
                    Neighborhood neighborhood = new Neighborhood(-1, barrio, commune);
                    Address address = new Address(
                            -1,
                            calle,
                            carrera,
                            numero,
                            sobre,
                            neighborhood
                    );

                    Person person = new Person(
                            -1,
                            cedula,
                            primerNombre,
                            segundoNombre,
                            primerApellido,
                            segundoApellido,
                            telefono,
                            address
                    );

                    people.add(person);
                }
                return people;
            }

        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    String.format(
                            ProcessErrorMessage.ERROR_OBTENER_REGISTROS_FILTRADOS.getMessage(),
                            key
                    ) + e.getMessage(),
                    e);
        }
    }

    @Override
    public int save(Person t) {

        String direccionSql = "INSERT INTO direccion (barrio_id, calle, carrera, numero, sobre) VALUES (?, ?, ?, ?, ?) RETURNING id";
        String personaSql = "INSERT INTO persona (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, cedula, telefono, direccion_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(personaSql); PreparedStatement preparedStatementDirection = connection.prepareStatement(direccionSql)) {

            connection.setAutoCommit(false);

            Address address = t.getAddress();

            preparedStatementDirection.setInt(1, address.getNeighborhood().getId());
            preparedStatementDirection.setString(2, address.getStreet());
            preparedStatementDirection.setString(3, address.getAvenue());
            preparedStatementDirection.setString(4, address.getNumber());
            preparedStatementDirection.setString(5, address.getOn());

            ResultSet resultSetDireccion = preparedStatementDirection.executeQuery();

            int addressId = DatabaseUtil.getLastInsertId(resultSetDireccion);

            preparedStatement.setString(1, t.getFirstName());
            preparedStatement.setString(2, t.getMiddleName());
            preparedStatement.setString(3, t.getLastName());
            preparedStatement.setString(4, t.getSecondLastName());
            preparedStatement.setString(5, t.getIdentification());
            preparedStatement.setString(6, t.getPhone());
            preparedStatement.setInt(7, addressId);

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    ProcessErrorMessage.ERROR_GUARDAR_REGISTRO.getMessage() + e.getMessage(),
                    e.getCause()
            );
        }

        return -1;
    }

    @Override
    public void update(Person t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isIdentificationInUse(String identification) {
        String sql = "SELECT COUNT(*) FROM persona WHERE cedula = ?";
        try (
                Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, identification);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }

        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    ProcessErrorMessage.ERROR_VERIFICACION_CEDULA.getMessage() + e.getMessage(),
                    e.getCause());
        }
        return false;
    }

    @Override
    public boolean isPhoneInUse(String phone) {
        String sql = "SELECT COUNT(*) FROM persona WHERE telefono = ?";
        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, phone);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    ProcessErrorMessage.ERROR_VERIFICACION_TELEFONO.getMessage() + e.getMessage(),
                    e.getCause());
        }
        return false;
    }

}
