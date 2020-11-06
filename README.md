Great Circle Distance: Dublin Office
=====================

Description
-----------
The project is about finding the list of customers within 100km from the given Dublin Office location using the Spherical Law of Cosines formula.
For a given file containing a list of customers it reads the customer list and outputs the customers matching the criteria sorted by id.

Getting started
---------------

### Prerequisites

> Open JDK 11.x
>
> Maven 3.6.3
>
> Make sure to add Java 11 and Maven to the PATH variable

### Installation 
Navigate to the root directory of the project and run 
`maven package`
>
A jar file with name *great-circle-distance-1.0.0-jar-with-dependencies.jar* is generated in the 'target' directory

### How to start it

Navigate to the 'target' directory and run 
`java -jar great-circle-distance-1.0.0-jar-with-dependencies.jar`

The list of customers matching the criteria will be printed in the console

### Tests
To run the unit tests navigate to the root directory of the project and run `maven test`.
You can find the test coverage report in target/site/jacoco/index.html
