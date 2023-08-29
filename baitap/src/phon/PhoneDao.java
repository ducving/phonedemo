package phon;

import java.sql.*;

public class PhoneDao {
    public void getAllData() throws SQLException {
        Connect connect = new Connect();
        Connection connection = connect.connect();

        String query = "select * from Phone";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String information = resultSet.getString("information");

            System.out.println(" id : " + id + " - name : " + name + " - price :" + price + " - information : " + information);
        }
        connection.close();
    }

    public void isertDataBase(Phone newPhone) throws SQLException {
        Connect connect = new Connect();
        Connection connection = connect.connect();

        String query = "insert into Phone (name,price,information) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,newPhone.getName());
        preparedStatement.setDouble(2,newPhone.getPrice());
        preparedStatement.setString(3,newPhone.getInformation());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void searchDataWithName(String keyword) throws SQLException {
        Connect connect = new Connect();
        Connection connection = connect.connect();

        String query = "select * from Phone where name like '%" + keyword + "%'";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String information = resultSet.getString("information");

            System.out.println("id " + id + "- name " + name + "- price " + price + "- information " + information);
        }
        connection.close();

    }

    public void deleteDataID(String delete) throws SQLException {
        Connect connect = new Connect();
        Connection connection = connect.connect();

        String query = "delete from Phone where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,delete);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
