package service;

import database.DatabaseConnection;
import employee.Employee;
import employee.Mechanic;
import tank.*;

import java.sql.SQLException;
import java.util.*;

import static util.Audit.printAction;

public class TankService {
    private String name;
    private String address;

    DatabaseConnection dbconn;



    public TankService(String name, String address) throws SQLException {
        this.name = name;
        this.address = address;
        dbconn = DatabaseConnection.getInstance();
    }


    public ArrayList<Maker> getMakers() throws SQLException {
        printAction("getMakers");
        return dbconn.getMakers();
    }

    public ArrayList<Tank> getTanks() throws SQLException {
        printAction("getTanks");
        return dbconn.getTanks();
    }


    public ArrayList<Mechanic> getMechanics() throws SQLException {
        printAction("getMechanics");
        return dbconn.getMechanics();
    }

    public ArrayList<Turret> getTurrets() throws SQLException {
        printAction("getTurrets");
        return dbconn.getTurrets();
    }

    public ArrayList<Cannon> getCannons() throws SQLException {
        printAction("getCannons");
        return dbconn.getCannons();
    }

    public ArrayList<Engine> getEngines() throws SQLException {
        printAction("getEngines");
        return dbconn.getEngines();
    }



    public void addMechanic(Mechanic mechanic) throws SQLException {
        printAction("addMechanic");
        dbconn.addMechanic(mechanic);
    }


    public void addMaker(Maker maker) throws SQLException {
        printAction("addMaker");
        dbconn.addMaker(maker);
    }

    public void addTank(Tank tank) throws SQLException {
        printAction("addTank");
        dbconn.addTank(tank);
    }


    public void addCannon(Cannon cannon) throws SQLException {
        printAction("addCannon");
        dbconn.addCannon(cannon);
    }

    public void addTurret(Turret turret) throws SQLException {
        printAction("addTurret");
        dbconn.addTurret(turret);
    }

    public void addEngine(Engine engine) throws SQLException {
        printAction("addEngine");
        dbconn.addEngine(engine);
    }

    public void deleteMechanic(int id) throws SQLException {
        printAction("deleteMechanic");
        dbconn.deleteMechanic(id);
    }


    public void deleteMaker(int id) throws SQLException {
        printAction("deleteMaker");
        dbconn.deleteMaker(id);
    }

    public void deleteTank(int id) throws SQLException {
        printAction("deleteTank");
        dbconn.deleteTank(id);
    }


    public void deleteCannon(int id) throws SQLException {
        printAction("deleteCannon");
        dbconn.deleteCannon(id);
    }

    public void deleteTurret(int id) throws SQLException {
        printAction("deleteTurret");
        dbconn.deleteTurret(id);
    }

    public void deleteEngine(int id) throws SQLException {
        printAction("deleteEngine");
        dbconn.deleteEngine(id);
    }

    public void updateMechanicExperience(int id, int experience) throws SQLException {
        printAction("updateMechanicExperience");
        dbconn.updateMechanicExperience(id, experience);
    }

    public void updateMakerHqLocation(int id, String hqLocation) throws SQLException {
        printAction("updateMakerHqLocation");
        dbconn.updateMakerHqLocation(id, hqLocation);
    }

    public void updateTankPrice(int id, int price) throws SQLException {
        printAction("updateTankPrice");
        dbconn.updateTankPrice(id, price);
    }

    public void updateCannonPrice(int id, int price) throws SQLException {
        printAction("updateCannonPrice");
        dbconn.updateCannonPrice(id, price);
    }

    public void updateTurretPrice(int id, int price) throws SQLException {
        printAction("updateTurretPrice");
        dbconn.updateTurretPrice(id, price);
    }

    public void updateEnginePrice(int id, int price) throws SQLException {
        printAction("updateEnginePrice");
        dbconn.updateEnginePrice(id, price);
    }

}
