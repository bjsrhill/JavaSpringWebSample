JavaSpringWebSample
===================

This is a sample web application built using:

- the Spring Framework
- Hibernate
- HSQLDB
- log4j
- JUnit
- Ant build script

To start the HSQLDB data server enter the following at the project root:

ant -f sampleshsqldb.xml starthsql

To recreate the test data run the following at the project root:

ant -f sampleshsqldb.xml execddl 

To build, run the following at the project root:

ant build

To deploy, run the following at the project root:

ant deploy

To rebuild run the following at the project root:

ant rebuild
