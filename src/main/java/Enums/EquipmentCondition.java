package Enums;

public enum EquipmentCondition{
        GOOD("Aircraft is currently in a mission."),
        NOT_GOOD("Aircraft is not currently in a mission."),
        MAINTENANCE_NEEDED("Maintenance is needed for this aircraft."),
        NO_MAINTENANCE_NEEDED("Maintenance is not needed for this aircraft."),
        REFUELING_NEEDED("Refueling is needed for this aircraft."),
        UNKNOWN("Unknown condition for this aircraft.");

        private final String message;

        EquipmentCondition(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }


