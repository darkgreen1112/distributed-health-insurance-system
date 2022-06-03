package com.darrylion.healthinsurancerestapi;

import com.darrylion.healthinsurancerestapi.entity.PatientPolicy;
import com.darrylion.healthinsurancerestapi.repository.PatientPolicyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.GregorianCalendar;

@SpringBootApplication
public class HealthInsuranceRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthInsuranceRestApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PatientPolicyRepository repository) {
		return (args) -> {
			repository.save(new PatientPolicy("Лебедева", "Луиза", "Ефимовна",
					new GregorianCalendar(2000, 9, 30).getTime(), new GregorianCalendar(2050, 9, 30).getTime()));
			repository.save(new PatientPolicy("Рыбакова", "Береслава", "Тихоновна",
					new GregorianCalendar(2000, 9, 30).getTime(), new GregorianCalendar(2050, 9, 30).getTime()));
			repository.save(new PatientPolicy("Морозова", "Хельга", "Ильяовна",
					new GregorianCalendar(2000, 9, 30).getTime(), new GregorianCalendar(2050, 9, 30).getTime()));
			repository.save(new PatientPolicy("Маркова", "Ольга", "Ильяовна",
					new GregorianCalendar(2000, 9, 30).getTime(), new GregorianCalendar(2050, 9, 30).getTime()));
			repository.save(new PatientPolicy("Орлова", "Виталина", "Владимировна",
					new GregorianCalendar(2000, 9, 30).getTime(), new GregorianCalendar(2050, 9, 30).getTime()));
			repository.save(new PatientPolicy("Ширяева", "Фия", "Владиславовна",
					new GregorianCalendar(2000, 9, 30).getTime(), new GregorianCalendar(2050, 9, 30).getTime()));
			repository.save(new PatientPolicy("Горбунова", "Сабрина", "Валерьяновна",
					new GregorianCalendar(2000, 9, 30).getTime(), new GregorianCalendar(2050, 9, 30).getTime()));
		};
	}

}
