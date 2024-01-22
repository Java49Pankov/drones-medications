DELETE FROM logs;
DELETE FROM drones;
DELETE FROM medications;

INSERT INTO drones (number, model, weight_limit, battery_capacity, state) 
	VALUES
		('Drone-1', 'Middleweight', 300, 100, 'IDLE'),
		('Drone-2', 'Middleweight', 300, 100, 'IDLE'),
		('Drone-3', 'Middleweight', 300, 100, 'IDLE');
INSERT INTO medications	(code, name, weight)
	VALUES
		('MED_1', 'Medication-1', 200),
		('MED_2', 'Medication-2', 200);	