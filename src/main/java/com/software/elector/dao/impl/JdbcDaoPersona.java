package com.software.elector.dao.impl;

import com.software.elector.dao.PersonaDao;
import com.software.elector.enums.ProcessErrorMessage;
import com.software.elector.exception.DatabaseAccessException;
import com.software.elector.model.Barrio;
import com.software.elector.model.Ciudad;
import com.software.elector.model.Comuna;
import com.software.elector.model.Direccion;
import com.software.elector.model.Persona;
import com.software.elector.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoPersona implements PersonaDao {

    private final DataSource dataSource;

    public JdbcDaoPersona(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Persona getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Persona> getAll() {
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
                List<Persona> personas = new ArrayList<>();
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

                    Ciudad ciudadPersona = new Ciudad(-1, ciudad);
                    Comuna comunaPersona = new Comuna(-1, comuna, ciudadPersona);
                    Barrio barrioPersona = new Barrio(-1, barrio, comunaPersona);
                    Direccion direccion = new Direccion(
                            -1,
                            calle,
                            carrera,
                            numero,
                            sobre,
                            barrioPersona
                    );

                    Persona persona = new Persona(
                            -1,
                            cedula,
                            primerNombre,
                            segundoNombre,
                            primerApellido,
                            segundoApellido,
                            telefono,
                            direccion
                    );

                    personas.add(persona);
                }
                return personas;
            }

        } catch (SQLException e) {
            throw new DatabaseAccessException("Error al intentar obtener los registros de votante: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Persona> getByKey(String key) {
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
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
                ) {

            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Persona> personas = new ArrayList<>();
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

                    Ciudad ciudadPersona = new Ciudad(-1, ciudad);
                    Comuna comunaPersona = new Comuna(-1, comuna, ciudadPersona);
                    Barrio barrioPersona = new Barrio(-1, barrio, comunaPersona);
                    Direccion direccion = new Direccion(
                            -1,
                            calle,
                            carrera,
                            numero,
                            sobre,
                            barrioPersona
                    );

                    Persona persona = new Persona(
                            -1,
                            cedula,
                            primerNombre,
                            segundoNombre,
                            primerApellido,
                            segundoApellido,
                            telefono,
                            direccion
                    );

                    personas.add(persona);
                }
                return personas;
            }

        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    String.format(
                            ProcessErrorMessage.ERROR_REGISTROS_FILTRADOS.getMessage(),
                             key
                    ) + e.getMessage(),
                    e);
        }
    }

    @Override
    public int save(Persona t) {

        String direccionSql = "INSERT INTO direccion (barrio_id, calle, carrera, numero, sobre) VALUES (?, ?, ?, ?, ?) RETURNING id";
        String personaSql = "INSERT INTO persona (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, cedula, telefono, direccion_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = dataSource.getConnection(); PreparedStatement preparedStatementPersona = connection.prepareStatement(personaSql); PreparedStatement preparedStatementDirection = connection.prepareStatement(direccionSql)) {

            connection.setAutoCommit(false);

            Direccion direccion = t.getDireccion();

            preparedStatementDirection.setInt(1, direccion.getBarrio().getId());
            preparedStatementDirection.setString(2, direccion.getCalle());
            preparedStatementDirection.setString(3, direccion.getCarrera());
            preparedStatementDirection.setString(4, direccion.getNumero());
            preparedStatementDirection.setString(5, direccion.getSobre());

            ResultSet resultSetDireccion = preparedStatementDirection.executeQuery();

            int idDireccion = DatabaseUtil.getLastInsertId(resultSetDireccion);

            preparedStatementPersona.setString(1, t.getPrimerNombre());
            preparedStatementPersona.setString(2, t.getSegundoNombre());
            preparedStatementPersona.setString(3, t.getPrimerApellido());
            preparedStatementPersona.setString(4, t.getSegundoApellido());
            preparedStatementPersona.setString(5, t.getCedula());
            preparedStatementPersona.setString(6, t.getTelefono());
            preparedStatementPersona.setInt(7, idDireccion);

            preparedStatementPersona.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            throw new DatabaseAccessException("Error al intentar guardar el nuevo votante: " + e.getMessage(), e);
        }

        return -1;
    }

    @Override
    public void update(Persona t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isCedulaInUse(String cedula) {
        String sql = "SELECT COUNT(*) FROM persona WHERE cedula = ?";
        try (
                Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cedula);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isTelefonoInUse(String telefono) {
        String sql = "SELECT COUNT(*) FROM persona WHERE telefono = ?";
        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, telefono);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
