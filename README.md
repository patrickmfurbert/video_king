# Chapter Select

[Quickstart](#quickstart)

[Explanation](#explanation)

&emsp;[Step One](#step-one)

&emsp;[Step Two](#step-three)

&emsp;[Step Three](#step-three)

[Given More Time..](#given-more-time)

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

lorem

## Step One

lorem

## Step Two

lorem

## Step Three

lorem

## Given More Time
Given more time, I would...

- lorem