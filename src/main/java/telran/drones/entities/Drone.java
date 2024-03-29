package telran.drones.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import telran.drones.dto.*;

@Entity
@Table(name = "drones")
@NoArgsConstructor
@Getter
@ToString
public class Drone {
	@Id
	@Column(length = 100)
	String number;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, updatable = false)
	ModelType model;

	@Column(nullable = false, updatable = false, name = "weight_limit")
	int weightLimit;

	@Setter
	@Column(nullable = false, updatable = true, name = "battery_capacity")
	byte batteryCapacity;

	@Enumerated(EnumType.STRING)
	@Setter
	@Column(nullable = false, updatable = true)
	State state;

//	public void setBatteryCapacity(byte batteryCapacity) {
//		this.batteryCapacity = batteryCapacity;
//	}

//	public void setState(State state) {
//		this.state = state;
//	}

}