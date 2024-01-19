package com.mn.springbootsampler.bdd.steps;

import com.mn.springbootsampler.web.resource.PaymentResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest

public class RestSteps {

    @Autowired
    @SuppressWarnings("unused")
    private TestRestTemplate restTemplate;

    @When("I send a payment:")
    public void postPayment(DataTable payments) {
        var maps = payments.asMaps(String.class, Object.class);
        maps.forEach(this::send);
    }

    private void send(Map<String, Object> m) {
       var payment = new PaymentResource(m.get("bic").toString(), m.get("iban").toString(), m.get("currency").toString(),  Integer.parseInt(m.get("amount").toString()));
        var paymentHttpEntity = new HttpEntity<>(payment, getHeaders());

        var result = restTemplate.exchange("/api/payment", HttpMethod.POST, paymentHttpEntity, String.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private MultiValueMap<String, String> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
