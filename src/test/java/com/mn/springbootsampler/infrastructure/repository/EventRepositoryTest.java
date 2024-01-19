package com.mn.springbootsampler.infrastructure.repository;

import com.mn.springbootsampler.model.Event;
import com.mn.springbootsampler.model.repositories.GenericRepository;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mn.springbootsampler.TestHelpers.provideEvent;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureEmbeddedDatabase( refresh = AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_EACH_TEST_METHOD)
class EventRepositoryTest {
    public static final String TEST_BODY = """
            {
            	"bic"  : "DE0000001",
            	"iban" : "DE123456789023",
            	"currency" : "EUR",
            	"amount": 9
            }
            """;
    @Autowired
    GenericRepository<Event, Integer> genericRepository;

    @Test
    void shouldSavePayment() {
        var e = provideEvent();
        var result = genericRepository.save(e);
        assertThat(result.getId()).isGreaterThanOrEqualTo(1);
        assertThat(result.toString()).containsIgnoringWhitespaces(TEST_BODY);
    }

    @Test
    void shouldReadBackPaymentById() {
        var save = genericRepository.save(provideEvent());
        var byId = genericRepository.findById(save.getId());
        assertThat(byId).isPresent();
        assertThat(byId).hasValueSatisfying(s -> {
            assertThat(s.toString()).contains("Event");
        });
    }

    @Test
    void shouldReadBackAllPayment() {
        genericRepository.save(provideEvent());
        genericRepository.save(provideEvent());
        var result = genericRepository.findAll();
        assertThat(result).hasSize(2);

    }
}