package per.tmp.data.dataui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("per.tmp.data")
public class DataUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataUiApplication.class, args);
	}
}
