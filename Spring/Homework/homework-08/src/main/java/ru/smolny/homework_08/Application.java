package ru.smolny.homework_08;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		TestBean bean = context.getBean(TestBean.class);

		bean.sumWithForLoop(202312000);
		bean.noLogMethod();
		bean.sumWithForLoop(2023120000);
		bean.sleep(1000);
		log.info("{}", bean.throwRuntimeException(1, 2));
		log.info("{}", bean.throwNullPointerException());
		log.info("{}", bean.throwIllegalArgumentException());
		log.info("{}", bean.throwIndexOutOfBoundsException());
	}

}
