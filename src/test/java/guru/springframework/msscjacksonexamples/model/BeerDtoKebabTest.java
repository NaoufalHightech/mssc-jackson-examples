package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@ActiveProfiles("kebab")
@JsonTest
class BeerDtoKebabTest extends BaseTest {

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        var jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDesrializeDto() throws IOException {
        var jsonString = "{\"beerId\":\"8edd1c90-1b6d-40f4-9829-b22442bbd60f\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":12121212,\"price\":12.99,\"createdDate\":\"2020-05-04T14:34:51.817+02:00\",\"lastUpdatedDate\":\"2020-05-04T14:34:51.818+02:00\"}\n";
        var beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.printf(String.valueOf(beerDto));
    }
}