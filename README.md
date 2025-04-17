# Racing Car

Hero Tech Course 2025 Precourse Week 1 Mission

## Features

### Constraints

1. Design decisions
  * *Car name*<br>
    Q. If only a single name is given, is the race still to be proceeded?<br>
    A. No, at least two names should be given.
  
  * *Numnber of rounds*<br>
    Q. Is zero(0) acceptable as the number of rounds?<br>
    A. No, winners must have moved at least once (see below).<br>
    
    Q. Possible maximum is Int.MAX_VALUE (= 2,147,483,647) but is it reasonable to accept such a high number?<br>
    A. Number of rounds to be restricted to 0 < n <= 200
  
  * *Race*<br>
    Q. If none of the cars has moved during the race, are all the cars still to be declared winners?<br>
    A. No, a car must have moved at least once to be declared a winner.

### [ ] Race configurations

1. Properties
  * *Car names*
    - Size of names array must be at least 2.
    - 0 < length of name <= 5
  * *Number of rounds*
    - 0 < number of rounds <= 200

2. Design decisions
  * Use factory function to instantiate (private primary constructor)
  * *Car name*
    - Ignore leading and trailing spaces
    - Validate right after input (before getting number of rounds)
      -> Put validation functions inside companion object rather than class body
  * *Number of rounds*
    - Throw `IllegalArgumentException` for errors during converting (e.g., `NumberFormatException`)

### [ ] Race

1. Properties
  * *configurations*
  * *Lanes*

2. Design decisions
  * Race consists of *Lane*s in which cars can "move."
  * Race object is responsible for car moves.
  * Race object is responsible for decision for winners.
  * Cars which have not moved at all during the race are excluded from winners.

### [ ] Lane

1. Design decisions
  * Each lane can accommodate *exactly* one car.
  * No lane is empty; every lane is occupied by a car.

### [ ] Car

1. Properties
  * *Car name*
  * *position*
2. Design decisons
