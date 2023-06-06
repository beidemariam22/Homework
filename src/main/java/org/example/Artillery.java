package org.example;

import Enums.ArtilleryType;
import Enums.EquipmentCondition;
import Interface.Iattack;
import Interface.Icolorable;
import Interface.Ioperate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public final class Artillery extends MilitaryEquipments implements Ioperate, Icolorable, Iattack {

    private static final Logger LOGGER = LogManager.getLogger(Artillery.class);

    private List<Artillery> artillery = new ArrayList<>();

    public Artillery() {
    }

    public Artillery(int serialnum, String model, String condition, String location) {
        super(serialnum, model, condition, location);
    }

    public List<Artillery> getArtillery() {
        return artillery;
    }

    public void AddArtillery(Artillery artillery) {
        this.artillery.add(artillery);
    }

    @Override
    public void color() {
        LOGGER.info("Coloring the artillery");
        for (Artillery artillery : artillery) {
            LOGGER.info("Coloring artillery: " + artillery.getSerialNum());
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
        LOGGER.info("Number of artillery operators: " + artilleryoperator);
        if (artilleryoperator >= 4) {
            LOGGER.info("Sufficient artillery operators available. Preparing artillery operations.");
        } else {
            LOGGER.info("Insufficient artillery operators. Unable to perform artillery operations.");
        }
    }

    @Override
    public void attack() {
        for (ArtilleryType artilleryType : ArtilleryType.values()) {
            switch (artilleryType) {
                case HOWITZER:
                    LOGGER.info("Firing howitzer with range of " + artilleryType.range + " meters");
                    break;
                case MORTAR:
                    LOGGER.info("Launching mortar with range of " + artilleryType.range + " meters");
                    break;
                case ROCKET:
                    LOGGER.info("Firing rocket with range of " + artilleryType.range + " meters");
                    break;
                default:
                    LOGGER.info("Invalid artillery type");
                    break;
            }
        }
    }

    @Override
    public void navigate() {
        LOGGER.info("Navigating the artillery");
        for (Artillery artillery : artillery) {
            LOGGER.info("Navigating artillery: " + artillery.getSerialNum());
            if (artillery.getCondition().equals("Good")) {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " is in good condition. Proceeding with navigation.");
            } else {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " is not in good condition. Navigation aborted.");
            }
        }
    }

    @Override
    public void communicate() {
        LOGGER.info("Communicating with other units");
        for (Artillery artillery : artillery) {
            LOGGER.info("Communicating with artillery: " + artillery.getSerialNum());
            if (artillery.hasEnemy()) {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " has a target. Sending communication to other units.");
            } else {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " has no target. No communication required.");
            }
        }
    }

    @Override
    public void performMaintenance() {
        LOGGER.info("Performing maintenance on the artillery");
        for (Artillery artillery : artillery) {
            if (artillery.getCondition().equals("Maintenance Needed")) {
                LOGGER.info("Performing maintenance on artillery: " + artillery.getSerialNum());
                artillery.setCondition("No Maintenance Needed");
                LOGGER.info("Maintenance completed for artillery: " + artillery.getSerialNum());
            } else {
                LOGGER.info("No maintenance needed for artillery: " + artillery.getSerialNum());
            }
        }
    }

    @Override
    public void defend() {
        LOGGER.info("Defending the artillery");
        for (Artillery artillery : artillery) {
            LOGGER.info("Defending artillery: " + artillery.getSerialNum());
            if (artillery.hasEnemy()) {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " engaging enemy targets.");
            } else {
                LOGGER.info("No enemies detected. Artillery " + artillery.getSerialNum() + " in defensive position.");
            }
        }
    }

    @Override
    public void useSpecialAbility() {
        LOGGER.info("Using special ability of the artillery");
        for (Artillery artillery : artillery) {
            LOGGER.info("Using special ability of artillery: " + artillery.getSerialNum());
            if (artillery.isCommander()) {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " activating special ability: Command Mode.");
            } else {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " activating special ability: Defensive Shield.");
            }
        }
    }

    @Override
    public void retreat() {
        LOGGER.info("Retreating the artillery");
        for (Artillery artillery : artillery) {
            LOGGER.info("Retreating artillery: " + artillery.getSerialNum());
            if (artillery.hasEnemy()) {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " initiating tactical retreat.");
            } else {
                LOGGER.info("No enemies detected. Artillery " + artillery.getSerialNum() + " holding position.");
            }
        }
    }

    @Override
    public void operate() {
        LOGGER.info("Operating the artillery");
        for (Artillery artillery : artillery) {
            LOGGER.info("Operating artillery: " + artillery.getSerialNum());
            if (artillery.getCondition().equals("Good")) {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " is in good condition. Proceeding with operation.");
            } else {
                LOGGER.info("Artillery " + artillery.getSerialNum() + " is not in good condition. Maintenance is required before operation.");
            }
        }
    }
    @Override
    public void status() {
        LOGGER.info("Artillery Status:");
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
        return "Artillery {" +
                "Serialnumber " + getSerialNum() +
                ", Model " + getModel() +
                ", Condition " + getCondition() +
                ", Location " + getLocation() +
                "}";
    }
}
