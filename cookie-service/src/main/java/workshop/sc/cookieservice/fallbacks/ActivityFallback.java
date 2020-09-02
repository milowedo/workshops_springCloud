package workshop.sc.cookieservice.fallbacks;

import org.springframework.stereotype.Component;
import workshop.sc.cookieservice.clients.ActivityClient;
import workshop.sc.model.Response;

@Component
public class ActivityFallback implements ActivityClient {

	@Override
	public Response getResponse() {
		return new Response("fallback", "take a rest like activity client!");
	}
}
