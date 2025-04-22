# kotlin-racingcar-precourse

## 🏗  Project Structure

```
[Application]
       │
       ▼
[RaceController]
       │
       ├────────────────┬─────────────────┐
       ▼                ▼                 ▼
   [Model]           [View]          [DTOs]
    │                 │                │
    ├── Car          ├── InputView    ├── CarNameDto
    ├── Round        ├── OutputView   ├── TryCountDto
    ├── Referee                       ├── RoundResultDto
    ├── Fuel                          └── WinnersDto
    └── RandomNumberGenerator
```

I designed Model-View-Controller architecture.

<br>

## 🎯 Key Components


<img width="400" alt="image" src="https://github.com/user-attachments/assets/ad45bdad-abdf-4c84-b463-138ca3a2ef6c" />

### 🚘 Car

```kotlin
class Car(val name: String, private var status: Int = 0, private val fuel: Fuel)
```
- Represents a car in the racing game
- Maintains the car's name and current position (status)
- Uses dependency injection for fuel strategy
- Responsible for moving forward based on fuel condition

### ⛳️ Round

```kotlin
class Round(val count: Int, private val participants: List<Car>)
```
- Represents a single round of the race
- Manages the race execution for all participating cars
- Keeps track of each car's position in the current round

### 🧑‍⚖️ Referee

```kotlin
class Referee(private val participants: List<Car>, private val winners: MutableList<Car>)
```

- Acts as a judge for the race
- Determines the winner(s) based on cars' final positions

### 🧈 Fuel Interface

```kotlin
interface Fuel { fun isEnough(): Boolean }
```

- Defines the contract for movement condition
- Allows different implementations of movement strategies
- Enables easy testing through strategy pattern

### 🔢 RandomNumberGenerator

```kotlin
class RandomNumberGenerator : Fuel
```

- Implements the Fuel interface
- Generates random numbers to determine car movement
- Uses numbers 0-9 with threshold of 4 for movement decision

<br>


## ✅ Functional Requirements

- [x] Car
    - [x] status
        - [x] name
        - [x] status
    - [x] behavior
        - [x] go
            - [x] check if fuel is enough
- [x] Fuel
    - [x] Random Number Generator
        - [x] make random number between 0~9
        - [x] fuel is enough when 4 or greater

- [x] input
    - [x] carNamesInput
        - [x] split car names input with (,)
        - [x] each slices must not be null, "", " "
    - [x] tryCountInput
        - [x] must not be null, "", " '
        - [x] must be number

- [x] CarNameDto
    - [x] names cannot exceed 5 characters
- [x] TryCountDto
    - [x] try count cannot exceed 1000

- [x] Round
    - [x] status
        - [x] round count
        - [x] participating cars
    - [x] behavior
        - [x] each car races


- [x] Referee
    - [x] status
        - [x] participants
        - [x] winners
    - [x] behavior
        - [x] judge winner

- [x] output
    - [x] print round result
        - [] print participants in order to input order 
    - [x] print winners
    - [x] RaceResultDto

- [x] race controller

<br>

## ✨ What I focused On

### 1. Clean Architecture & Design Patterns

- Implemented MVC (Model-View-Controller) pattern for clear separation of concerns
- Applied Single Responsibility Principle (SRP) to ensure each class has one primary responsibility
- Used `Strategy Pattern` with Fuel interface to make movement logic easily changeable and testable

### 2. Immutability

- Designed immutable DTOs (CarNameDto, TryCountDto, RoundResultDto, WinnersDto) for safe data transfer
- Each class returns Immutable state of objects

<br>

## 🎓 Lessons Learned

### 1. Kotlin Language Specifics

#### Property Handling

- Discovered Kotlin's automatic getter/setter generation for properties
- Learned the distinction between using val vs var in data classes
- Understood that data class properties should preferably be immutable (val)


#### String Operations

- Learned the crucial difference between `isNotEmpty()` and `isNotBlank()`:
- `isNotEmpty()`: Returns false for `""`, but true for `" "`
- `isNotBlank()`: Returns false for both `""` and `" "`

#### Syntax Differences from Java

- Using colon (:) syntax instead of Java's implements/extends

### 2. Mutable Collections
- Understood the implications of using `MutableList` vs `immutable List`

### 3. Static Factory Methods
- Learned Kotlin's approach to static factory methods using `companion object`

### 4. Order Preservation in Collections
- Discovered that `HashMap` doesn't preserve insertion order
- Learned to use `LinkedHashMap` for maintaining insertion order



