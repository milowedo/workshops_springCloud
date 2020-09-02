package workshop.sc.cookieservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import workshop.sc.cookieservice.clients.ActivityClient;
import workshop.sc.cookieservice.clients.DecisionClient;
import workshop.sc.model.Response;

@RestController
public class CookieController {

	private final ActivityClient activityClient;
	private final DecisionClient decisionClient;

	@Value("${spring.application.name}")
	private String serviceName;

	public CookieController(ActivityClient activityClient, DecisionClient decisionClient) {
		this.activityClient = activityClient;
		this.decisionClient = decisionClient;
	}


	@GetMapping("/fortune")
	public Response fortune() {
		return getResponse();
	}

	private Response getResponse() {
		return getFortune();
	}

	private Response getFortune() {
		return new Response(serviceName.toUpperCase(),
				decisionClient.getResponse().getMessage() + " " + activityClient.getResponse().getMessage()
		);
	}
}
