# Chapter Select

[Quickstart](#quickstart)

[Explanation](#explanation)

&emsp;[Step One](#step-one)

&emsp;[Step Two](#step-three)

&emsp;[Step Three](#step-three)

[Given More Time..](#given-more-time)

[HTTP DIAGRAM](#http Diagram)


# Quickstart

## Requirements:

- Oracle JDK11
- Gradle >= 7.7.3

## Steps

1. In a terminal, in a directory of your choosing, clone this repo with `git clone repo_url`
1. `cd` into the repo folder
1. Update the /src/main/resources/application.yaml with the appropriate credentials
```
spring:
  data:
    mongodb:
      uri: mongodb+srv://username:password@pyx-interview-cluster0.2zo55.mongodb.net/interview?ssl=true&retryWrites=true&w=majority&authMechanism=SCRAM-SHA-1
```
1. run `gradle bootRun` or `./gradlew bootRun` to get all of the necessary packages and run the server
    - backend server: http://localhost:8080/movies 
    - ***get params*** are title, year, cast_member, decade
    - ex: retrieve metadata with cast member 'Florance Lawrence' perform following get request `http://localhost:8080/movies?cast_member=Florence Lawrence`
    - You can make a ***post*** request on the same endpoint http://localhost:8080/movies
    - ex: post with the following schema   

    ```json
    {
      "type": "MovieMetadata",
      "properties": {
        "title": {
          "type": "string"
        },
        "year": {
          "type": "integer"
        },
        "cast": {
          "type": "array",
          "items": "string"
        },
        "genres": {
          "type": "array",
          "items": "string"
        },
      }
    }
    ```
1. run tests with `gradle bootRun` or `./gradlew bootRun`

# Explanation

Springboot is a magical wonderland of seemingly unlimited configuration options. Determining where to start was a bit of a challenge. You need to know a bit about maven and gradle to understand the configuration files and dependencies. In addition to this, I wanted to make sure that MongoDB Compass was working with atlas to have a nice GUI to visualize the database and the movies collection. 

## Step One

After all of the configuration part was squared away I wanted to try to follow solid principles and use the N-tiered architecture for this assignment. This requires isolating the different layers of the the application. I wanted to keep the classes as light as possible and isolate as much of the different functionality throughout. 

I isolate the Controller Layer, The Service Layer, and the Data Layer from one another(folders: controller, service, dao respectively). One of the goals I had was to try and use some validation annotations on the get request mappings to provide more information when an request is made incorrectly. 

The data class(MovieMetadata.java) was created based on the schema I observed from the movies.json/and from the mongoDB compass/atlas connection.

## Step Two

The two bonus/optional items for assignment I accomplished with the Query annotation in the MongoRespository and the two utility classes which made use of static methods.

## Step Three

***Title Case***
Title Case conversion is actually quite sophisticated and has various rules depending on the style being used(ie MLA, APA, Chicago etc). 
For time consideration and simplicity, will make an assumption on Title Case Rules(order of priority… those first on the list are higher priority): 
 - Capitalize First and Last words
 - Capitalize words four letters or longer
 - Lower case “a”, “an”, “the”, “and”, “but”, “for”, “at”, “by”, to”
 - Does not handle commas in front of words

## Given More Time
Given more time, I would...

1. Given more time to complete this assignment,  I would take a deep dive into grammar processing as certain words would be capitalized and other times they should be lower cased. For example, in certain times the words “in”, “on”, “by” should be lowercase(preposition) and other times they should be upper cased(adjective or adverb).   
**ex:**
 - out: Fresh out the Oven, but School’s Out Forever (adjective)
 - up: Crawling up a Hill, but Picking Up the Pieces (adverb)
 - Reference: https://titlecaseconverter.com/
2. I would also like to spend more time writing unit tests and mocking up the database. Testing is very important to me. Also taking time to think more about private methods and possibly coming up with indirect tests for them.
3. Add more commenting to the files especially the Convert to Title Case. 
4. Refractor the ConvertToTitleCase.java - the complex logic should be broken up to help with readability. 
5. Put more into the server validation of incomming requests.

## HTTP Diagram
![](./src/main/resources/http_diag.png)