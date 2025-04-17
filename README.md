# 🚗 Car Racing

## 📝 Overview

## ✅ Feature Checklist

## 📐 Requirement Analysis & Design

### 📓 Notes I wrote while reviewing the mission details

<image width="600" src="https://github.com/user-attachments/assets/b0bec2d4-1d2b-4188-8009-e1fb39b82e1a">

- The main keywords I took away are **Smaller Functions** and **Testing**.

- I decided to divide responsibilities into three main features:

|Feature|Description|
|--|--|
|**Input**|Read car names and number of rounds from `Console.readLine()` and validate the input. Throw `IllegalArgumentException` if the input is invalid.|
|**Game**|Move cars based on the game rules using `Randoms.pickNumberInRange()` to generate random numbers.|
|**Output**|Display the progress of each car and the final winners.|

> [!NOTE]  
> I chose to follow Test-Driven Development (TDD) because testing was strongly emphasized. I’m also focusing on keeping functions as small and focused as possible.

### 📊 Class Diagram & Flowchart

- Before starting the project, I wanted to design the overall flow and class structure of the program.

#### Flowchart

```mermaid
flowchart TD
    A[Enter Car Names]
    B[Enter Number of Rounds]
    C[Setup Game]
    D[Play Rounds]
    E[Show Progress]
    F[Show Winner]

    A --> B --> C
    E --> F
    
    subgraph Game
    C --> D --> E
    E --> |Repeat|D
    end
```

#### Class Diagram

- At first, I thought it made sense for both Car and Game to have their own state, so I designed them as normal classes.

```mermaid
classDiagram
    Game --> Car

    class Input {
        + readNamesOfTheCars() List~String~
        + readNumberOfRounds() Int
    }

    class Output {
        + displayProgress(cars: List~Car~)
        + displayWinners(cars: List~Car~)
    }

    class Game {
        - _cars: MutableList~Car~
        + cars: List~Car~
        + winners: List~Car~
        + setup(names: List~String~)
        + playOneRound()
    }

    class Car {
        + name: String
        - position: Int
        + moveForward()
        + toString() String
    }
```

- Later I realized that `Car` just holds simple values like `name` and `position`, and `Game` only updates `List<Car>`. So I decided to use an **immutable design** without storing state.
- But I did worry about flexibility. For example, if the game later supports different modes or special cars with boosters, it might be harder to extend.
- But instead, I decided to focus on **testability**, **separating each function clearly**, and **satisfying the requirements as given**.

```mermaid
classDiagram
    Game --> Car

    class Input {
        + readNamesOfTheCars() List~String~
        + readNumberOfRounds() Int
    }

    class Output {
        + displayProgress(cars: List~Car~)
        + displayWinners(cars: List~Car~)
    }

    class Game {
        + playOneRound(cars: List~Car~) List~Car~
        + getWinners(cars: List~Car~) List~Car~
    }

    class Car {
        + name: String
        - position: Int
        + movedForward() Car
        + toString() String
    }
```

## 🔧 Implementation Details
