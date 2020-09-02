package workshops.sc.activityservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import workshop.sc.model.Response;

import java.util.Random;

@RestController
public class ActivityController {

	@Value("${activities}")
	private String[] activities;

	@Value("${spring.application.name}")
	private String serviceName;

	@GetMapping("/activity")
	public Response getDecision() {
		return getResponseWithRandomDecision();
	}

	private Response getResponseWithRandomDecision() {
		String msg = activities[new Random().nextInt(activities.length)];
		return new Response(serviceName.toUpperCase(), msg);
	}
}
