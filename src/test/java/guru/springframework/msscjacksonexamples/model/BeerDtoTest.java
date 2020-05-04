package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest {
    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        var jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDesrializeDto() throws IOException {
        var jsonString = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":12121212,\"price\":\"12.99\",\"createdDate\":\"2020-05-04T15:44:25+0200\",\"lastUpdatedDate\":\"2020-05-04T15:44:25.786+02:00\",\"myLocalDate\":\"20200504\",\"beerId\":\"60924bcb-2824-4111-80f8-80b845fd31d3\"}\n";
        var beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.printf(String.valueOf(beerDto));
    }
}