package com.dzagaduroska.great_circle_distance.geo;

import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLatitudeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LatitudeTest {
    
    @Test
    void shouldNotThrowAnExceptionWhenValidatingIfValueInRange() {
        double validLatitudeValue = 50;
       Latitude latitude = new Latitude(validLatitudeValue);
       latitude.validate();
    }

    @Test
    void shouldThrowAnExceptionWhenValidatingIfValueOutOfRange() {
        double invalidLatitudeValue = -95;
        Latitude latitude = new Latitude(invalidLatitudeValue);
        Assertions.assertThrows(
                OutOfRangeLatitudeException.class,
                latitude::validate
        );
    }
}
