package workshop.sc.cookieservice.fallbacks;

import org.springframework.stereotype.Component;
import workshop.sc.cookieservice.clients.ActivityClient;
import workshop.sc.cookieservice.clients.DecisionClient;
import workshop.sc.model.Response;

@Component
public class DecisionFallback implements DecisionClient {

	@Override
	public Response getResponse() {
		return new Response("fallback", "take a rest like the decision client!");
	}
}
