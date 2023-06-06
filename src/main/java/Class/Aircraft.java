package Class;

import Enums.EquipmentCondition;
import Enums.JetType;
import Interface.Iattack;
import Interface.Ioperate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Aircraft<T> extends MilitaryEquipments implements Ioperate, Iattack {

    private static final Logger LOGGER= LogManager.getLogger(Aircraft.class);

    private List<Aircraft> aircrafts = new ArrayList<>();
    public T aircrafttype;

    public Aircraft(T aircrafttype, int serialnum, String model,
                    String condition, String location) {
        super(serialnum, model, condition, location);
        this.aircrafttype = aircrafttype;

    }

    public Aircraft() {
        this.aircrafttype = null;
    }

    public List<Aircraft> getAircraft() {
        return aircrafts;
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }
    public <T> void ThisLinkedList(Aircraft aircraft) {
        aircrafts.add(aircraft);
        //System.out.println(aircraft);
        //aircrafts.iterate();
    }
    @Override
    public void attack() {
        if (command && enemy) {
            for (JetType type : JetType.values())
                switch (type) {
                    case FIGHTER:
                        LOGGER.info("Fighter aircraft attacking enemy from " + type.hight + " meters");
                        break;
                    case BOMBER:
                        LOGGER.info("Bomber aircraft attacking enemy from " + type.hight + " meters");
                        break;
                    case TRANSPORT:
                        LOGGER.info("Transport wound soldier in  " + type.hight + " meters");
                        break;
                    default:
                        LOGGER.info("Invalid aircraft type");
                        break;
                }
        } else {
            LOGGER.info("Cannot attack without both command and enemy present");
        }
    }
    @Override
    public void operate() {
        LOGGER.info("Operating the aircraft");
        EquipmentCondition condition = getConditionEnum();
        if (condition == EquipmentCondition.GOOD || condition == EquipmentCondition.NO_MAINTENANCE_NEEDED) {
            LOGGER.info("Performing operations for aircraft in good condition");
        } else {
            LOGGER.info("Performing maintenance operations for the aircraft");
        }
    }

    @Override
    public void defend() {
        LOGGER.info("Defending against enemy attacks");
        if (aircrafts.size() > 1) {
            LOGGER.info("Calling for backup");
            for (Aircraft aircraft : aircrafts) {
                if (!aircraft.equals(this)) {
                    LOGGER.info("Assisting " + aircraft.aircrafttype + " aircraft");
                }
            }
        }
    }
    @Override
    public void useSpecialAbility() {
        LOGGER.info("Using special ability or skill");
        if (aircrafttype instanceof JetType) {
            JetType type = (JetType) aircrafttype;
            if (type == JetType.FIGHTER) {
                LOGGER.info("Activating fighter aircraft's afterburner");
            } else if (type == JetType.BOMBER) {
                LOGGER.info("Releasing bomb payload");
            } else if (type == JetType.TRANSPORT) {
                LOGGER.info("Deploying cargo drop system");
            } else {
                LOGGER.info("Invalid aircraft type");
            }
        } else {
            LOGGER.info("Unknown aircraft type");
        }
    }

    @Override
    public void retreat() {
        LOGGER.info("Retreating from the enemy");
        LOGGER.info("Notifying other aircraft for retreat");
        for (Aircraft aircraft : aircrafts) {
            if (!aircraft.equals(this)) {
                LOGGER.info("Retreating with " + aircraft.aircrafttype + " aircraft");
            }
        }
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
        LOGGER.info("Number of pilots: " + numpilot);
        // Additional conditions and looping
        if (numpilot > 1) {
            LOGGER.info("Multiple pilots detected. Coordinating operations.");
            for (int i = 1; i <= numpilot; i++) {
                LOGGER.info("Pilot " + i + " is ready.");
            }
        }
    }
    @Override
    public void navigate() {
        LOGGER.info("Navigating the aircraft");
        if (aircrafttype instanceof JetType) {
            JetType type = (JetType) aircrafttype;
            if (type == JetType.FIGHTER || type == JetType.BOMBER) {
                LOGGER.info("Performing fighter/bomber aircraft navigation procedures");
            } else if (type == JetType.TRANSPORT) {
                LOGGER.info("Performing transport aircraft navigation procedures");
            } else {
                LOGGER.info("Invalid aircraft type");
            }
        } else {
            LOGGER.info("Unknown aircraft type. Navigation procedures cannot be determined.");
        }
    }

    @Override
    public void communicate() {
        LOGGER.info("Communicating with other units");
        LOGGER.info("Establishing communication channels...");
        for (Aircraft aircraft : aircrafts) {
            if (!aircraft.equals(this)) {
                LOGGER.info("Communicating with " + aircraft.aircrafttype + " aircraft");
            }
        }
        LOGGER.info("Communication channels established.");
    }
    @Override
    public void performMaintenance() {
        LOGGER.info("Performing maintenance on the aircraft");
        if (getConditionEnum() == EquipmentCondition.MAINTENANCE_NEEDED) {
            LOGGER.info("Maintenance is required for the aircraft");
            LOGGER.info("Initiating maintenance procedures...");
            for (Aircraft aircraft : aircrafts) {
                if (!aircraft.equals(this)) {
                    LOGGER.info("Coordinating maintenance with " + aircraft.aircrafttype + " aircraft");
                }
            }
            LOGGER.info("Maintenance procedures completed.");
        } else {
            LOGGER.info("No maintenance required at the moment.");
        }
    }
    @Override
    public void status() {
        LOGGER.info("Aircraft Status:");
        EquipmentCondition condition = getConditionEnum();
        LOGGER.info(condition.getMessage());
    }
    private EquipmentCondition getConditionEnum() {
        String condition =getCondition();
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
        return "Aircraft {" +
                "Aircrafttype " + aircrafttype +
                ", Serialnumber " + getSerialNum() +
                ", Model " + getModel() +
                ", Condition " + getCondition() +
                ", Location " + getLocation() +
                "}";
    }
}
