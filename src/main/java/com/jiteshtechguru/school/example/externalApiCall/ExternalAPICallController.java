package com.jiteshtechguru.school.example.externalApiCall;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class ExternalAPICallController {
	
	private final WebClient webClient;

	public ExternalAPICallController(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://countriesnow.space").build();
	}
	
	
	@GetMapping("/CountriesByWebClient")
	public Mono<Root> someRestCall() {
		
		return this.webClient.get().uri("/api/v0.1/countries/capital")
						.retrieve().bodyToMono(Root.class);
	}	
	
	@GetMapping("/CountriesByRestTemplate")
	ResponseEntity<Root> all() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Root> response  = restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/capital", Root.class);
		return response;
	}

}
