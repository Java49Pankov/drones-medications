package telran.drones;

public interface TestDisplayNames {
	String REGISTER_DRONE_NORMAL = "Registering drone normal flow";
	String REGISTER_DRONE_VALIDATION_VIOLATION = "Drone JSON with  wrong fields";
	String REGISTER_DRONE_MISSING_FIELDS = "Drone JSON with missing fields";
	String REGISTER_DRONE_ALREADY_EXISTS = "Registering Drone with existing number";
	String LOAD_DRONE_NORMAL = "Loading drone nornal flow";
	String LOAD_DRONE_NOT_FOUND = "Loading Drone Not Found";
	String LOAD_DRONE_MEDICATION_NOT_FOUND = "Loading Drone Medication Not Found";
	String LOAD_DRONE_LOW_BATTARY_CAPACITY = "Loading Drone Low Battary Capacity";
	String LOAD_DRONE_NOT_MATCHING_WEIGHT = "Loading Drone Not Matching Weight";
	String LOAD_DRONE_NOT_MATCHING_STATE = "Loading Drone State not IDLE";
}