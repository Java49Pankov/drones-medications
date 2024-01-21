package telran.drones.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import telran.drones.dto.*;
import telran.drones.entities.*;

import telran.drones.exceptions.*;
import telran.drones.repo.*;
import telran.drones.api.*;

@Service
@RequiredArgsConstructor
public class DronesServiceImpl implements DronesService {
	@Value("${" + PropertiesNames.CAPACITY_THRESHOLD + ":25}")
	byte capacityThreshold;

	final ModelMapper modelMapper;
	final DroneRepo droneRepo;
	final MedicationRepo medicationRepo;
	final LogRepo logRepo;

	@Override
	@Transactional
	public DroneDto registerDrone(DroneDto droneDto) {
		if (droneRepo.existsById(droneDto.getNumber())) {
			throw new DroneAlreadyExistException();
		}
		Drone drone = modelMapper.map(droneDto, Drone.class);
		drone.setState(State.IDLE);
		droneRepo.save(drone);
		return droneDto;
	}

	@Transactional(readOnly = false)
	@Override
	public LogDto loadDrone(String droneNumber, String medicationCode) {
		Drone drone = droneRepo.findById(droneNumber)
				.orElseThrow(() -> new DroneNotFoundException());
		Medication medication = medicationRepo.findById(medicationCode)
				.orElseThrow(() -> new MedicationNotFoundException());
		if (drone.getState() != State.IDLE) {
			throw new IllegalDroneStateException();
		}
		if (drone.getBatteryCapacity() < capacityThreshold) {
			throw new LowBatteryCapacityException();
		}
		if (drone.getWeightLimit() < medication.getWeight()) {
			throw new IllegalMedicationWeightException();
		}
		drone.setState(State.LOADING);
		EventLog log = new EventLog(drone, medication, LocalDateTime.now());
		logRepo.save(log);
		LogDto result = new LogDto(log.getTimestamp(), droneNumber, drone.getState(), drone.getBatteryCapacity(),
				medicationCode);
		return result;
	}

	@Override
	public List<MedicationDto> checkMedicationItems(String droneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
