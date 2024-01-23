# 🏏 Live Cricket Score API - Spring Boot Backend 🚀

## 📋 Requirement

The Live Cricket Score API is a Spring Boot backend project designed to fulfill the need for real-time updates on cricket matches. The system provides information such as live scores, point tables for the CWC 2023, and details about all ongoing matches.

## Demo

![LiveCricScore](Demo.gif)

## 🎨 Design

### Controllers

The primary controller, `CricketController`, handles various endpoints for fetching live match scores, CWC 2023 point tables, and a list of all matches.

```java
@RestController
@RequestMapping("/cricket")
@CrossOrigin("*")
public class CricketController {
    // ... (controller methods)
}
```

### Entity

The `Match` entity encapsulates the details of a cricket match, including team information, scores, live text, match link, and status.

```java
@Entity
@Table(name = "cricket_match")
public class Match {
    // ... (fields)

    @Enumerated
    private MatchStatus status;

    private Date date = new Date();

    // ... (methods)
}
```

### Enum

The `MatchStatus` enum defines the possible statuses of a cricket match - either completed or live.

```java
public enum MatchStatus {
    COMPLETED, LIVE
}
```

### Repositories

The `MatchRepo` interface, extending `JpaRepository`, provides CRUD operations for the `Match` entity.

```java
public interface MatchRepo extends JpaRepository<Match, Integer> {
    Optional<Match> findByTeamHeading(String teamHeading);
}
```

### Services

The `CricketService` interface outlines methods to retrieve live match scores, CWC 2023 point tables, and details of all matches.

```java
public interface CricketService {
    List<Match> getLiveMatchScores();
    List<List<String>> getCWC2023PointTable();
    List<Match> getAllMatches();
}
```

## 🚀 Implementation

### Get Live Match Scores 📊

```java
@GetMapping("/live")
public ResponseEntity<?> getLiveMatchScores() throws InterruptedException {
    System.out.println("Getting live match");
    return new ResponseEntity<>(this.cricketService.getLiveMatchScores(), HttpStatus.OK);
}
```

### Get CWC 2023 Point Table 🏆

```java
@GetMapping("/point-table")
public ResponseEntity<?> getCWC2023PointTable() {
    return new ResponseEntity<>(this.cricketService.getCWC2023PointTable(), HttpStatus.OK);
}
```

### Get All Matches 📅

```java
@GetMapping
public ResponseEntity<List<Match>> getAllMatches() {
    return new ResponseEntity<>(this.cricketService.getAllMatches(), HttpStatus.OK);
}
```

## 🌐 Cross-Origin Resource Sharing

The `@CrossOrigin("*")` annotation in the `CricketController` allows for cross-origin resource sharing.

Feel free to explore and integrate this API to meet the requirements of fetching live cricket scores and tournament statistics. Stay updated with real-time cricket action! 🏏✨