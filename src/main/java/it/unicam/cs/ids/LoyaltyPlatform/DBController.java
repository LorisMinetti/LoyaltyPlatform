package it.unicam.cs.ids.LoyaltyPlatform;

import it.unicam.cs.ids.LoyaltyPlatform.model.ClienteModel;

import java.sql.*;
import java.util.*;


public class DBController {

    private static DBController instance;

    private String dbUrl = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private String dbUser = "postgres";

    private String dbPassword = "postgres";

    private Connection connection = null;

    private DBController() {

    }

    /* Singleton pattern */
    public static DBController getInstance() {
        if(instance == null) {
            instance = new DBController();
        }
        return instance;
    }

    public void setDBController(String url, String user, String password) {
        this.dbUrl = url;
        this.dbUser = user;
        this.dbPassword = password;
    }

    public void connect() {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Database connected, ready to go!");
        } catch(SQLException e){
            System.out.println("Problems in opening a connection to the DB");
            e.printStackTrace();
        }
    }

    private void close(){
        try{
            connection.close();
        } catch(SQLException e){
            System.out.println("Problems in closing the connection to the DB");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public boolean DBtest(){
        boolean result = true;
        try{
            if(connection == null || connection.isClosed()){
                connect();
                result = false;
            }
            DatabaseMetaData data = connection.getMetaData();
            System.out.println("Details on DBMS - " + data.getDatabaseProductName() + "\n" + "  version:  "
                    + data.getDriverMajorVersion() + "\n" + "  catalogs: " + data.getCatalogs().getCursorName() + "\n"
                    + "  schemas:  " + data.getSchemas().getRow() + "\n");
            close();
        } catch (SQLException e){
            System.out.println("Problems in testing the connection to the DB");
            e.printStackTrace();
        }
        return result;
    }

    //TODO: inserire qui le query necessarie per la propria applicazione
    public List<ClienteModel> getAllClienti(String tabella) throws SQLException {
        List<ClienteModel> listaClienti = new ArrayList<>();
        String query = "SELECT * FROM clienti";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                ClienteModel cliente = extractClienteFromResultSet(rs);
                listaClienti.add(cliente);
            }
        }

        return listaClienti;
    }

    private ClienteModel extractClienteFromResultSet(ResultSet rs) throws SQLException {
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(rs.getString("nome"));
        cliente.setId(UUID.fromString(rs.getString("id")));

        // Popolare le altre mappe e campi desiderati

        return cliente;
    }
}
