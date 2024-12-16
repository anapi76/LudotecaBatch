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

- Implementation of a Spring Batch job that reads a csv file of Categories and inserts the records into a database
    1. Reads the data from the csv file using a ItemReader
    2. Processes the data with an ItemProcessor.
    3. s the data into the database using an ItemWriter.
    4. Verify that the batch job has executed correctly and that the data has been inserted into the database using a
       Listener.

### Author

- Implementation of a Spring Batch job that reads a csv file of Authors and inserts the records into a txt file
    1. Reads the data from the csv file using a ItemReader
    2. Processes the data with an ItemProcessor.
    3. Writes the data into the txt file using an ItemWriter.

### Clean

- Implementation of a Spring Batch job that cleans files in a specified directory

### Game

- Implementation of a Spring Batch job that reads data from an H2 database of Games, checks the stock availability and
  write the results into a txt file.
    1. Reads the data from an H2 database table that contains game information (title, age, and stock).
    2. Processes each game entry to check if there is available stock.
    3. Writes the processed data (game title and stock availability) to a plain .txt file.
    4. Verifies that the batch job has executed correctly.
