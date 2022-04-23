package ru.geekbrains.JavaCore;

 import java.sql.*;


public class SqliteExamples {
    public static  void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db");

            Statement statement = connection.createStatement();

            statement.executeUpdate( "update faculties set name = 'Test1' where id = 1");

            ResultSet resultSet = statement.executeQuery( "select * from students");

            while( resultSet.next()){
                System.out.print ( resultSet.getInt ("id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getString( "faculty_id") + "\n");
            }

            Long time = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++){
                statement.executeUpdate(String.format("insert into students (name, score,faculty_id) values %s, %d, %d)",
                        "student"+i, i, i));
            }
            System.out.println(("Time of insert 10000 line ="));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
