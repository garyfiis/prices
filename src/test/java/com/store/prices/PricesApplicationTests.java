package com.store.prices;

import com.store.prices.business.dto.PriceRulesDto;
import com.store.prices.resources.PriceRulesController;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PricesApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	/** The headers. */
	private HttpHeaders headers;

	private String url;

	@BeforeAll
	public void setup() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		url = "http://localhost:" + this.port;
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	public void shouldReturnRulesPrices(String brandId, String productId, String applicationDate, String startDate, String endDate) {
		Map<String, String> params = new HashMap<>();
		params.put("brandId", brandId);
		params.put("productId", productId);

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).path(PriceRulesController.ROOT_RULES_PRICES)
				.queryParam("applicationDate",applicationDate).build();

		ResponseEntity<PriceRulesDto> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				new HttpEntity<String>(null, headers), PriceRulesDto.class, params);

		MatcherAssert.assertThat(response.getStatusCode(), CoreMatchers.equalTo(HttpStatus.OK));
		MatcherAssert.assertThat(response.getBody(), CoreMatchers.notNullValue());
		MatcherAssert.assertThat(response.getBody().getStartDate(), CoreMatchers.equalTo(startDate));
		MatcherAssert.assertThat(response.getBody().getEndDate(), CoreMatchers.equalTo(endDate));

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/errors.csv", numLinesToSkip = 1)
	public void shouldReturnError(String brandId, String productId, String applicationDate) {
		Map<String, String> params = new HashMap<>();
		params.put("brandId", brandId);
		params.put("productId", productId);

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).path(PriceRulesController.ROOT_RULES_PRICES)
				.queryParam("applicationDate",applicationDate).build();

		ResponseEntity<PriceRulesDto> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				new HttpEntity<String>(null, headers), PriceRulesDto.class, params);

		MatcherAssert.assertThat(response.getStatusCode(), CoreMatchers.equalTo(HttpStatus.NOT_FOUND));
	}

}
