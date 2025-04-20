# Racing Car

Hero Tech Course 2025 Precourse Week 1 Mission

## Features

### Constraints

1. Design decisions
  * *Car name*<br>
    Q. If only a single name is given, shall the race still be proceeded?<br>
    A. No, at least two names should be given.<br>

    Q. How shall empty names be handled?<br>
    A. At least two names should be given.<br>

    Q. Shall duplicate names be accepted?<br>
    A. Dulicate names (after trimming) are not accepted.<br>
    
    Q. What if any two names differ only in leading and/or trailling spaces? (i.e., identical after trimming)<br>
    A. Dulicate names (after trimming) are not accepted.<br>
  
  * *Numnber of rounds*<br>
    Q. Is zero(0) acceptable as the number of rounds?<br>
    A. No, winners must have moved at least once (see below).<br>
    
    Q. Possible maximum is Int.MAX_VALUE (= 2,147,483,647) but is it reasonable to accept such a high number?<br>
    A. Number of rounds to be restricted to 0 < n <= 200<br>
  
  * *Race*<br>
    Q. If none of the cars has moved during the race, are all the cars still to be declared winners?<br>
    A. No, none shall be declared winners. A car must have moved at least once to be declared a winner.<br>

### [ ] Race configuration

1. Features
  * *Car names*
    - Size of names list must be at least 2.
    - 0 < length of name <= 5
    - Duplicate names are not accepted.
  * *Number of rounds*
    - 0 < number of rounds <= 200

2. Design decisions
  * Use factory function to instantiate (private primary constructor)
  * *Car name*
    - Ignore leading and trailing spaces
    - Validate right after input (before getting number of rounds)<br>
      &rarr; Put validation functions inside companion object rather than class body
  * *Number of rounds*
    - Throw `IllegalArgumentException` for errors during converting (e.g., `NumberFormatException`)

### [ ] Race

1. Features
  * *Lane*s
  * *Car*s

2. Design decisions
  * There are *lane*s in which cars can "move."
  * Each car is assigned its own lane.
  * Lane is responsible for decision whether the car assgined to it can move.
  * Race object is responsible for decision for winners.
  * Cars which have not moved at all during the race are excluded from winners.

### [ ] Lane

1. Design decisions
  * Each lane can accommodate *exactly* one car.
  * No lane is empty; every lane is occupied by a car.

### [ ] Car

1. Features
  * *Car name*
  * *position*

2. Design decisons
  * When a car attempts to move forward, it inquires its lane if it can move.
