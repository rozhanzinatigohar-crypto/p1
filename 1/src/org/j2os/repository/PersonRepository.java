package org.j2os.repository;

import org.j2os.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "amirsam", "myjava123");
    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person (id,name,family,salary) values (?,?,?,?)");
        preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setDouble(4, person.getSalary());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update person set name=?,family=?,salary=? where id=?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setInt(3, person.getSalary());
        preparedStatement.setInt(4, person.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("delete person where id=?");
        preparedStatement.setInt(1, person.getId());
        preparedStatement.executeUpdate();
    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> list = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person()
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setFamily(resultSet.getString("family"))
                    .setSalary(resultSet.getInt("salary"));
            list.add(person);
        }
        return list;
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
