package workshop.sc.cookieservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import workshop.sc.cookieservice.fallbacks.ActivityFallback;
import workshop.sc.cookieservice.fallbacks.DecisionFallback;
import workshop.sc.model.Response;

@FeignClient(name = "DECISION-SERVICE", fallback = DecisionFallback.class)
public interface DecisionClient {
	@GetMapping("/decision")
	Response getResponse();
}
