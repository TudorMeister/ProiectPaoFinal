import employee.*;
import service.TankService;
import tank.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;

import static util.Audit.initAudit;
import static util.Database.createTables;
import static util.Database.dropTables;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        HashMap<Tank, Integer> tanks = new HashMap<>();
        ArrayList<Mechanic> mechanics;
        ArrayList<Turret> turrets;
        ArrayList<Maker> makers;
        ArrayList<Cannon> cannons;
        ArrayList<Engine> engines;

        initAudit();
        createTables();


        TankService tankService = new TankService("Maaai", "Soseaua pisicesti");

        tankService.addMechanic(new Mechanic(1, "Andrei", "Popescu", 2000, "Strada 1", 100));
        tankService.addMechanic(new Mechanic(2, "Ion", "Ionescu", 2000, "Strada 2", 200));
        tankService.addMechanic(new Mechanic(3, "Vasile", "Vasilescu", 2000, "Strada 3", 300));

        mechanics = tankService.getMechanics();

        tankService.addMaker(new Maker(1, "Maker1", "Strada 1"));
        tankService.addMaker(new Maker(2, "Maker2", "Strada 2"));
        tankService.addMaker(new Maker(3, "Maker3", "Strada 3"));

        makers = tankService.getMakers();

        tankService.addTurret(new Turret(4, makers.get(0), "Turret1", 100, 100, 3, 100, 40));
        tankService.addTurret(new Turret(5, makers.get(1), "Turret2", 100, 100, 3, 100, 40));
        tankService.addTurret(new Turret(6, makers.get(2), "Turret3", 100, 100, 3, 100, 40));

        turrets = tankService.getTurrets();

        tankService.addCannon(new Cannon(7, makers.get(0), "Cannon1", 100, 100, 3, 100));
        tankService.addCannon(new Cannon(8, makers.get(1), "Cannon2", 100, 100, 3, 100));
        tankService.addCannon(new Cannon(9, makers.get(2), "Cannon3", 100, 100, 3, 100));

        cannons = tankService.getCannons();

        tankService.addEngine(new Engine(10, makers.get(0), "Engine1", 100, 100, 1200, "V12", "Diesel"));
        tankService.addEngine(new Engine(11, makers.get(1), "Engine2", 100, 100, 1400, "X12", "Diesel"));
        tankService.addEngine(new Engine(12, makers.get(2), "Engine3", 100, 100, 1600, "W16", "Diesel"));

        engines = tankService.getEngines();

        tankService.addTank(new Tank(1, "Tank1", 100, 50, engines.get(0), cannons.get(0), turrets.get(0)));
        tankService.addTank(new Tank(2, "Tank2", 100, 50, engines.get(1), cannons.get(1), turrets.get(1)));
        tankService.addTank(new Tank(3, "Tank3", 100, 50, engines.get(2), cannons.get(2), turrets.get(2)));

        for (Tank t :  tankService.getTanks())
        {
            tanks.put(t, 1000);
        }

        tankService.deleteMechanic(3);

        tankService.updateMechanicExperience(1, 1000);

        dropTables();


    }

}