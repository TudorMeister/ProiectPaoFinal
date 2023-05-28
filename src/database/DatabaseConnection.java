package database;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.SortedSet;

import employee.*;
import tank.*;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private final Connection connection;

    private DatabaseConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/proiectpao?allowMultiQueries=true";
        String username = "root";
        String password = "1234";
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void createTables() throws SQLException, IOException {
        Path path = Path.of("src/dbcreation.txt");
        String query = Files.readString(path);

        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void dropTables() throws SQLException {
        String query = "DROP TABLE makers";
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = "DROP TABLE parts";
        statement.execute(query);

        query = "DROP TABLE cannons";
        statement.execute(query);

        query = "DROP TABLE engines";
        statement.execute(query);

        query = "DROP TABLE turrets";
        statement.execute(query);

        query = "DROP TABLE tanks";
        statement.execute(query);

        query = "DROP TABLE employees";
        statement.execute(query);

        query = "DROP TABLE mechanics";
        statement.execute(query);

    }

    public ArrayList<Mechanic> getMechanics() throws SQLException{
        String query = "SELECT * FROM mechanics INNER JOIN employees ON mechanics.employee_id = employees.employee_id";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ArrayList<Mechanic> mechanics = new ArrayList();
        Mechanic mech;
        while (rs.next()) {
            mech = new Mechanic(rs.getInt(1),rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(2));
            mechanics.add(mech);
        }
        return mechanics;
    }

    public ArrayList<Maker> getMakers() throws SQLException{
        String query = "SELECT * FROM makers";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ArrayList<Maker> makers = new ArrayList();
        Maker maker;
        while (rs.next()) {
            maker = new Maker(rs.getInt(1), rs.getString(2), rs.getString(3));
            makers.add(maker);
        }
        return makers;
    }

    public ArrayList<Cannon> getCannons() throws SQLException{
        String query = "SELECT * FROM cannons INNER JOIN parts ON cannons.part_id = parts.part_id";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ArrayList<Maker> makers = getMakers();

        ArrayList<Cannon> cannons = new ArrayList();
        Cannon cannon;
        while (rs.next()) {
            cannon = new Cannon(rs.getInt(1), makers.get(rs.getInt(8) - 1),rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(2), rs.getInt(3));
            cannons.add(cannon);
        }
        return cannons;
    }

    public ArrayList<Engine> getEngines() throws SQLException{
        String query = "SELECT * FROM engines INNER JOIN parts ON engines.part_id = parts.part_id";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ArrayList<Maker> makers = getMakers();

        ArrayList<Engine> engines = new ArrayList();
        Engine engine;
        while (rs.next()) {
            engine = new Engine(rs.getInt(1), makers.get(rs.getInt(9) - 1),rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(2), rs.getString(3), rs.getString(4));
            engines.add(engine);
        }
        return engines;
    }

    public ArrayList<Turret> getTurrets() throws SQLException{
        String query = "SELECT * FROM turrets INNER JOIN parts ON turrets.part_id = parts.part_id";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();

        ArrayList<Maker> makers = getMakers();

        ArrayList<Turret> turrets = new ArrayList();
        Turret turret;
        while (rs.next()) {
            turret = new Turret(rs.getInt(1), makers.get(rs.getInt(9) - 1),rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            turrets.add(turret);
        }
        return turrets;
    }

    public ArrayList<Tank> getTanks() throws SQLException{
        String query = "SELECT * FROM tanks";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ArrayList<Cannon> cannons = getCannons();
        ArrayList<Engine> engines = getEngines();
        ArrayList<Turret> turrets = getTurrets();

        ArrayList<Tank> tanks = new ArrayList();
        Tank tank;
        while (rs.next()) {
            System.out.println(rs.getInt(6) - 10);
            tank = new Tank(rs.getInt(1), rs.getString(3), rs.getInt(2), rs.getInt(4), engines.get(rs.getInt(6) - 10), cannons.get(rs.getInt(5) - 7), turrets.get(rs.getInt(7) - 4));
            tanks.add(tank);
        }
        return tanks;
    }

    public void addMechanic(Mechanic mechanic) throws SQLException{
        String query = String.format("INSERT INTO employees VALUES( %d, '%s', '%s', %d, '%s');\n", mechanic.getId(), mechanic.getFirstName(),
                mechanic.getLastName(), mechanic.getSalary(), mechanic.getAddress()); ;
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("INSERT INTO mechanics VALUES( %d, %d);", mechanic.getId(), mechanic.getExperience());
        statement.execute(query);
    }

    public void addTank(Tank tank) throws SQLException{
        String query = String.format("INSERT INTO tanks VALUES( %d, %d, '%s', %d, %d, %d, %d);", tank.getId(), tank.getPrice(), tank.getName(), tank.getWeight(), tank.getCannon().getId(), tank.getEngine().getId(), tank.getTurret().getId());
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void addCannon(Cannon cannon) throws SQLException{
        String query = String.format("INSERT INTO parts VALUES( %d, '%s', %d, %d, %d);", cannon.getId(), cannon.getName(), cannon.getPrice(), cannon.getWeight(), cannon.getMaker().getId());
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("INSERT INTO cannons VALUES( %d, %d, %d);", cannon.getId(), cannon.getCaliber(), cannon.getLength());
        statement.execute(query);
    }

    public void addEngine(Engine engine) throws SQLException{
        String query = String.format("INSERT INTO parts VALUES( %d, '%s', %d, %d, %d);", engine.getId(), engine.getName(), engine.getPrice(), engine.getWeight(), engine.getMaker().getId());
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("INSERT INTO engines VALUES( %d, %d, '%s', '%s');", engine.getId(), engine.getPower(), engine.getConfiguration(), engine.getFuelType());
        statement.execute(query);
    }

    public void addTurret(Turret turret) throws SQLException{
        String query = String.format("INSERT INTO parts VALUES( %d, '%s', %d, %d, %d);", turret.getId(), turret.getName(), turret.getPrice(), turret.getWeight(), turret.getMaker().getId());
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("INSERT INTO turrets VALUES( %d, %d, %d, %d);", turret.getId(), turret.getTotalCrew(), turret.getArmor(), turret.getRotationSpeed());
        statement.execute(query);
    }

    public void addMaker(Maker maker) throws SQLException{
        String query = String.format("INSERT INTO makers VALUES( %d, '%s', '%s');", maker.getId(), maker.getName(), maker.getHqLocation());
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void deleteMechanic(int id) throws SQLException{
        String query = String.format("DELETE FROM mechanics WHERE employee_id = %d;", id);
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("DELETE FROM employees WHERE employee_id = %d;", id);
        statement.execute(query);
    }

    public void deleteTank(int id) throws SQLException{
        String query = String.format("DELETE FROM tanks WHERE tank_id = %d;", id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void deleteCannon(int id) throws SQLException{
        String query = String.format("DELETE FROM cannons WHERE part_id = %d;", id);
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("DELETE FROM parts WHERE part_id = %d;", id);
        statement.execute(query);
    }

    public void deleteEngine(int id) throws SQLException{
        String query = String.format("DELETE FROM engines WHERE part_id = %d;", id);
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("DELETE FROM parts WHERE part_id = %d;", id);
        statement.execute(query);
    }

    public void deleteTurret(int id) throws SQLException{
        String query = String.format("DELETE FROM turrets WHERE part_id = %d;", id);
        Statement statement = connection.createStatement();
        statement.execute(query);

        query = String.format("DELETE FROM parts WHERE part_id = %d;", id);
        statement.execute(query);
    }

    public void deleteMaker(int id) throws SQLException{
        String query = String.format("DELETE FROM makers WHERE maker_id = %d;", id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void updateMechanicExperience(int id,int exp) throws SQLException{
        String query = String.format("UPDATE mechanics SET experience = %d WHERE employee_id = %d;", exp, id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void updateTankPrice(int id,int price) throws SQLException{
        String query = String.format("UPDATE tanks SET price = %d WHERE tank_id = %d;", price, id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void updateCannonPrice(int id,int price) throws SQLException{
        String query = String.format("UPDATE parts SET price = %d WHERE part_id = %d;", price, id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void updateEnginePrice(int id,int price) throws SQLException{
        String query = String.format("UPDATE parts SET price = %d WHERE part_id = %d;", price, id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void updateTurretPrice(int id,int price) throws SQLException{
        String query = String.format("UPDATE parts SET price = %d WHERE part_id = %d;", price, id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void updateMakerHqLocation(int id,String location) throws SQLException{
        String query = String.format("UPDATE makers SET hq_location = '%s' WHERE maker_id = %d;", location, id);
        Statement statement = connection.createStatement();
        statement.execute(query);
    }




}
