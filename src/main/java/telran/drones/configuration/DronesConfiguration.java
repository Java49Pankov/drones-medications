package telran.drones.configuration;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.*;

import telran.drones.dto.*;

@Configuration
public class DronesConfiguration {
	@Bean
	ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldAccessLevel(AccessLevel.PRIVATE)
				.setFieldMatchingEnabled(true);
		return modelMapper;
	}

	@Bean
	Map<State, State> getMovesMap() {
		Map<State, State> result = new HashMap<>();
		result.put(State.LOADING, State.LOADED);
		result.put(State.LOADED, State.DELIVERING);
		result.put(State.DELIVERING, State.DELIVERING1);
		result.put(State.DELIVERING1, State.DELIVERING2);
		result.put(State.DELIVERING2, State.DELIVERING3);
		result.put(State.DELIVERING3, State.RETURNING);
		result.put(State.RETURNING, State.RETURNING1);
		result.put(State.RETURNING1, State.RETURNING2);
		result.put(State.RETURNING2, State.RETURNING3);
		result.put(State.RETURNING3, State.IDLE);
		return result;
	}
}