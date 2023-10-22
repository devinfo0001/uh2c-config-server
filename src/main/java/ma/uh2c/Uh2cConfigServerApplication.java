package ma.uh2c;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
@EnableConfigServer
@RefreshScope
public class Uh2cConfigServerApplication {

	private static Logger logger = LoggerFactory.getLogger(Uh2cConfigServerApplication.class);

	public Uh2cConfigServerApplication() {
		super();
	}

	public static ConfigurableApplicationContext startMicroService(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Uh2cConfigServerApplication.class, args);
		ctx.addApplicationListener((ContextClosedEvent arg0) -> ctx.close());
		return ctx;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = Uh2cConfigServerApplication.startMicroService(args);
		if (ctx.isActive() && logger.isInfoEnabled()) {
			logger.info("Micro service [UH2C-CONFIG-SERVER] started correctly");
		}
	}
}