### Overview
Information system for storing compulsory health insurance policies.

### Building
Before starting the system, you need to deploy PostgreSQL locally.
How to run with Docker:
```bash
docker run --name health_insurance_postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
```

Stopping a running container is also easy with a single command:
```bash
docker stop <containerId>
```

### Why Spring

Spring makes programming Java quicker, easier, and safer for everybody.
Spring’s focus on speed, simplicity, and productivity has made it the world's most popular Java framework.

### Tech Stack

- Spring boot
- Spring Web
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Lombok
- OpenApi