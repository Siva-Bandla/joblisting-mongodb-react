# Job Listing Application
A Spring Boot application that allows jobseekers to view posted jobs and recruiters to post new job listings. Uses MongoDB for data storage.

## Features
- Jobseekers can browse all posted jobs.
- Recruiters can post new job listings.
- RESTful APIs built using Spring Boot.
- Data persistence using MongoDB.

  ## Tech Stack
- Java 21
- Spring Boot
- MongoDB
- Maven
- RESTful APIs

## Setup
```bash
git clone https://github.com/username/joblistingMongoDBReact.git
cd joblistingMongoDBReact
mvn spring-boot:run

##API end points
- GET /allPosts → List all jobs
- GET /posts/{text} → Search jobs by text
- POST /post → Add a new job (for recruiters)
  
