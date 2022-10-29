package xyz.dinahworld.timemanager;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import xyz.dinahworld.timemanager.Clocks.Clocks;
import xyz.dinahworld.timemanager.Clocks.ClocksRepository;
import xyz.dinahworld.timemanager.Users.Users;
import xyz.dinahworld.timemanager.Users.UsersRepository;
import xyz.dinahworld.timemanager.WorkingTimes.WorkingTimes;
import xyz.dinahworld.timemanager.WorkingTimes.WorkingTimesRepository;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class TimeManagerApplication {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ClocksRepository clocksRepository;

	@Autowired
	private WorkingTimesRepository workingTimesRepository;

	public static void main(String[] args) {
		SpringApplication.run(TimeManagerApplication.class, args);
	}

	// Connect to Astra with creating DataStaxAstraProperties
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}

	@PostConstruct
	public void start() {
		Users user = new Users("DanteNiro", "danteniro@email.com");
		Clocks clock = new Clocks(LocalDateTime.now(), true,user.getId());
		WorkingTimes workingTimes = new WorkingTimes(user.getId(),LocalDateTime.of(2022,07,22,11,13),LocalDateTime.now());
		usersRepository.save(user);
		clocksRepository.save(clock);
		workingTimesRepository.save(workingTimes);
	}

}
