package workshop.sc.cookieservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import workshop.sc.cookieservice.fallbacks.ActivityFallback;
import workshop.sc.model.Response;

@FeignClient(name = "ACTIVITY-SERVICE", fallback = ActivityFallback.class)
public interface ActivityClient {
	@GetMapping("/activity")
	Response getResponse();
}
