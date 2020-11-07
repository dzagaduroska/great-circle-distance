package com.dzagaduroska.great_circle_distance.geo;

import com.dzagaduroska.great_circle_distance.geo.exception.StartingCoordinateNotSetException;

import static java.lang.Math.acos;
import static java.lang.Math.sin;
import static java.lang.Math.cos;

/**
 * Implementation of the Spherical Law of Cosines formula.
 * It can be used to compute distances between two points on the surface of the Earth.
 * @see <a href="https://en.wikipedia.org/wiki/Spherical_law_of_cosines">Spherical Law of cosines</a>
 */
public class SphericalLawOfCosinesImpl {

    private GeoCoordinate startingCoordinate = null;

    /** The radius of the Earth in km. */
    static final Long radiusOfTheEarth = 6371L;

    public void setStartingCoordinate(GeoCoordinate startingCoordinate) {
        this.startingCoordinate = startingCoordinate;
    }

    /**
     * Calculate the distance between given starting coordinate and the destination coordinate using
     * the Spherical Law of Cosines formula.
     * The starting coordinate must be set before using this method.
     *
     * @param destinationCoordinate the destination coordinate
     * @return the distance between the coordinates
     */
    public Double getDistanceFromStartingCoordinateToDestinationCoordinate(GeoCoordinate destinationCoordinate)
            throws StartingCoordinateNotSetException {
        if (startingCoordinate == null) {
            throw new StartingCoordinateNotSetException();
        }
        double latitudeOfStartCoordinateInRadians = startingCoordinate.latitude.toRadians();
        double latitudeOfDestinationCoordinateInRadians = destinationCoordinate.latitude.toRadians();

        double deltaLambda = Math.abs(destinationCoordinate.longitude.toRadians() - startingCoordinate.longitude.toRadians());

        Double angle = acos(
                sin(latitudeOfStartCoordinateInRadians) * sin(latitudeOfDestinationCoordinateInRadians) +
                        cos(latitudeOfStartCoordinateInRadians) * cos(latitudeOfDestinationCoordinateInRadians) * cos(deltaLambda)
        );

        return radiusOfTheEarth * angle;
    }
}
