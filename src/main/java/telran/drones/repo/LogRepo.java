package telran.drones.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.drones.dto.DroneMedicationsAmount;
import telran.drones.dto.State;
import telran.drones.entities.*;

public interface LogRepo extends JpaRepository<EventLog, Long> {

	List<EventLog> findByDroneNumberAndState(String droneNumber, State state);

	List<EventLog> findByDroneNumberOrderByTimestampDesc(String droneNumber);

	@Query("SELECT d.number AS number, count(log.drone) AS amount "
			+ "FROM EventLog log "
			+ "RIGHT JOIN log.drone d "
			+ "WHERE log.state='LOADING' OR log.drone is null "
			+ "GROUP BY d.number "
			+ "ORDER BY count(log.drone) "
			+ "DESC")
	List<DroneMedicationsAmount> findDronesAmounts();

	EventLog findFirst1ByDroneNumberOrderByTimestampDesc(String number);

}
