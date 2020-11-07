package com.dzagaduroska.great_circle_distance.geo;

import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLatitudeException;
import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLongitudeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LongitudeTest {

    @Test
    void shouldNotThrowAnExceptionWhenValidatingIfValueInRange() {
        double validLongitudeValue = 152;
        Longitude longitude = new Longitude(validLongitudeValue);
        longitude.validate();
    }

    @Test
    void shouldThrowAnExceptionWhenValidatingIfValueOutOfRange() {
        double invalidLongitudeValue = -195;
        Longitude longitude = new Longitude(invalidLongitudeValue);
        Assertions.assertThrows(
                OutOfRangeLongitudeException.class,
                longitude::validate
        );
    }
}
