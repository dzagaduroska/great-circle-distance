package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.geo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SphericalLawOfCosinesImplTest {

    GeoCoordinate startingCoordinate = new GeoCoordinate(new Latitude(23), new Longitude(2));
    GeoCoordinate destinationCoordinate = new GeoCoordinate(new Latitude(103), new Longitude(5));

    @Test
    void shouldGetDistanceToTheDestinationCoordinateWhenStartingCoordinateIsSet() {
        SphericalLawOfCosinesImpl sphericalLawOfCosines = new SphericalLawOfCosinesImpl();
        sphericalLawOfCosines.setStartingCoordinate(startingCoordinate);

        Double distance = sphericalLawOfCosines.getDistanceFromStartingCoordinateToDestinationCoordinate(destinationCoordinate);

        Assertions.assertNotNull(distance, "Distance between coordinates must not be null");
    }

    @Test
    void shouldThrowExceptionWhenGettingDistanceAndStartingCoordinateIsNotSet() {
        SphericalLawOfCosinesImpl sphericalLawOfCosines = new SphericalLawOfCosinesImpl();

        Assertions.assertThrows(
                StartingCoordinateNotSetException.class,
                () -> sphericalLawOfCosines.getDistanceFromStartingCoordinateToDestinationCoordinate(destinationCoordinate)
        );
    }
}
