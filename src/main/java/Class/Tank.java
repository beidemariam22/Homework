package Class;

import Enums.EquipmentCondition;
import Enums.TankType;
import Interface.Iattack;
import Interface.Ioperate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Tank extends MilitaryEquipments implements Ioperate, Iattack {
    private static final Logger LOGGER= LogManager.getLogger(MilitaryEquipments.class);

    private Queue<Tank> tanks = new LinkedList<>();
    private Map<TankType, Tank> mapping = new HashMap<>();

    public Tank() {
        this.tanks = null;
    }

    public Tank(int serialnum, String model,
                String condition, String location) {
        super(serialnum, model, condition, location);
    }

    public Queue<Tank> getTanks() {
        return tanks;
    }

    public void AddTank(Tank tank) {
        tanks.offer(tank);
    }

    public void HashingTank(TankType tanktype, Tank tank) {
        mapping.put(tanktype, tank);
    }
    @Override
    public boolean isCommander() {
        return command;
    }

    @Override
    public boolean hasEnemy() {
        return enemy;
    }

    @Override
    public void operators() {
        LOGGER.info("Number of tank operators: " + tankoperator);
        // Additional conditions and looping
        if (tankoperator >= 2) {
            LOGGER.info("Sufficient tank operators available. Preparing tank operations.");
        } else {
            LOGGER.info("Insufficient tank operators. Unable to perform tank operations.");
        }
    }

    @Override
    public void attack() {
        for (TankType type : TankType.values()) {
            switch (type) {
                case HEAVY:
                    LOGGER.info("The heavy tank can attack with a heavy-caliber gun by " + type.attackpower + " Power");
                    break;
                case MEDIUM:
                    LOGGER.info("The medium tank can attack with a high-velocity gun by " + type.attackpower + " Power");
                    break;
                case LIGHT:
                    LOGGER.info("The light tank can attack with a single cannon by " + type.attackpower + " Power");
                    break;
                default:
                    LOGGER.info("Invalid tank type!");
            }
            if (command && hasEnemy()) {
                LOGGER.info("Tank is attacking with power: " + type.attackpower + " Power");
            } else {
                LOGGER.info("Cannot attack without command or enemy.");
            }
        }
    }

    @Override
    public void navigate() {
        LOGGER.info("Navigating the tank");
        for (Tank tank : tanks) {
            LOGGER.info("Navigating tank: " + tank.getSerialNum());
            if (tank.getCondition().equals("Good")) {
                LOGGER.info("Tank " + tank.getSerialNum() + " is in good condition. Proceeding with navigation.");
            } else {
                LOGGER.info("Tank " + tank.getSerialNum() + " is not in good condition. Navigation aborted.");
            }
        }
    }

    @Override
    public void communicate() {
        LOGGER.info("Communicating with other units");
        for (Tank tank : tanks) {
            LOGGER.info("Communicating with tank: " + tank.getSerialNum());
            if (tank.hasEnemy()) {
                LOGGER.info("Tank " + tank.getSerialNum() + " has detected an enemy. Sending communication to other units.");
            } else {
                LOGGER.info("Tank " + tank.getSerialNum() + " has no enemy detected. No communication required.");
            }
        }
    }

    @Override
    public void performMaintenance() {
        LOGGER.info("Performing maintenance on the tank");
        for (Tank tank : tanks) {
            if (tank.getCondition().equals("Maintenance Needed")) {
                LOGGER.info("Performing maintenance on tank: " + tank.getSerialNum());
                tank.setCondition("No Maintenance Needed");
                LOGGER.info("Maintenance completed for tank: " + tank.getSerialNum());
            } else {
                LOGGER.info("No maintenance needed for tank: " + tank.getSerialNum());
            }
        }
    }
    @Override
    public void defend() {
        LOGGER.info("Defending the tank");
        for (Tank tank : tanks) {
            LOGGER.info("Defending tank: " + tank.getSerialNum());
            if (tank.hasEnemy()) {
                LOGGER.info("Tank " + tank.getSerialNum() + " engaging enemy targets.");
            } else {
                LOGGER.info("No enemies detected. Tank " + tank.getSerialNum() + " in defensive position.");
            }
        }
    }

    @Override
    public void useSpecialAbility() {
        LOGGER.info("Using special ability of the tank");
        for (Tank tank : tanks) {
            LOGGER.info("Using special ability of tank: " + tank.getSerialNum());
            if (tank.isCommander()) {
                LOGGER.info("Tank " + tank.getSerialNum() + " activating special ability: Command Mode.");
            } else {
                LOGGER.info("Tank " + tank.getSerialNum() + " activating special ability: Defensive Shield.");
            }
        }
    }

    @Override
    public void retreat() {
        LOGGER.info("Retreating the tank");
        for (Tank tank : tanks) {
            LOGGER.info("Retreating tank: " + tank.getSerialNum());
            if (tank.hasEnemy()) {
                LOGGER.info("Tank " + tank.getSerialNum() + " initiating tactical retreat.");
            } else {
                LOGGER.info("No enemies detected. Tank " + tank.getSerialNum() + " holding position.");
            }
        }
    }
    @Override
    public void operate() {
        LOGGER.info("Operating the tank");
        for (Tank tank : tanks) {
            LOGGER.info("Operating tank: " + tank.getSerialNum());
            if (tank.getCondition().equals("Good")) {
                LOGGER.info("Tank " + tank.getSerialNum() + " is in good condition. Proceeding with operation.");
            } else {
                LOGGER.info("Tank " + tank.getSerialNum() + " is not in good condition. Maintenance is required before operation.");
            }
        }
    }

    @Override
    public void status() {
        LOGGER.info("Tank Status:");
        EquipmentCondition condition = getConditionEnum();
        LOGGER.info(condition.getMessage());
    }

    private EquipmentCondition getConditionEnum() {
        String condition = getCondition();
        switch (condition) {
            case "Good":
                return EquipmentCondition.GOOD;
            case "Not Good":
                return EquipmentCondition.NOT_GOOD;
            case "Maintenance Needed":
                return EquipmentCondition.MAINTENANCE_NEEDED;
            case "No Maintenance Needed":
                return EquipmentCondition.NO_MAINTENANCE_NEEDED;
            case "Refueling Needed":
                return EquipmentCondition.REFUELING_NEEDED;
            default:
                return EquipmentCondition.UNKNOWN;
        }
    }

    @Override
    public String toString() {
        return "Tank {" +
                "Serialnumber " + getSerialNum() +
                ", Model " + getModel() +
                ", Condition " + getCondition() +
                ", Location " + getLocation() +
                "}";
    }
}
