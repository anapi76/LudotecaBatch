# Tutorial Ludoteca Spring Batch Project

This project was generated with Spring Boot using Spring Initializr and is based on Java.

## Description

Configure and use Spring Batch to perform batch processing tasks in a ludoteca (board game library), where users can
manage games, categories, authors, customers and loans

https://github.com/anapi76/LudotecaBatch.git

## Requirements

- IntelliJ IDEA
- Spring Boot version 3.3.5
- Java 17.0.13 or higher.
- Maven
- H2 Database
- Spring Batch

### Category

- Implementation of a Spring Batch job that reads a file of Categories and inserts the records into a database
    1. Read the data from the csv file using a ItemReader
    2. Process the data with an ItemProcessor.
    3. Write the data into the database using an ItemWriter.
    4. Verify that the batch job has executed correctly and that the data has been inserted into the database using a
       Listener.
