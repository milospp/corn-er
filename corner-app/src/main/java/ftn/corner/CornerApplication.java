package ftn.corner;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CornerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CornerApplication.class, args);
		
	}

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks
				.newKieContainer(ks.newReleaseId("corner.kjar", "corner-drools", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(10_000);
		System.out.println("-----------Idemo-----------------------");

		 KieSession kSession = kContainer.newKieSession();
		System.out.println("Idemo");
		return kContainer;
	}

//	@Bean
//	public KieContainer kieContainer() {
//		KieServices ks = KieServices.Factory.get();
//		KieContainer kContainer = ks.getKieClasspathContainer();
////				 .newKieContainer(ks.newReleaseId("corner.kjar", "corner-drools", "0.0.1-SNAPSHOT"));
////		KieScanner kScanner = ks.newKieScanner(kContainer);
////		kScanner.start(10_000);
//		System.out.println("-----------Idemo-----------------------");
//
////		 KieSession kSession = kContainer.newKieSession();
//		System.out.println("Idemo");
//		return kContainer;
//	}


}

