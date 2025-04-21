# Car Racing Game

A concise, testable CLI racing car game in Kotlin. Designed to be modular, readable, and easy to test.

## Features

- **Clean architecture**:
    - `racingcar.domain` handles core entities (`Car`, `Race`) and validation
    - `racingcar.input` parses and validates raw user input with friendly error messages
    - `racingcar.service` (`Game`) runs rounds and determines winners
    - `racingcar.view` presents I/O (`InputView`, `ResultView`), keeping `main()` slim
- **Car name rules**: 1–5 characters, non-blank, unique across cars (humorous messages on violation)
- **Dependency injection** of randomness in `Car` for reliable unit testing
- **Customizable constants** instead of magic numbers (`MAX_NAME_LENGTH`, `RANDOM_MIN`, `RANDOM_MAX`, `ADVANCE_LIMIT`)
- **Comprehensive test suite**:
    - Unit tests for `Car` behavior and validation
    - Unit tests for `Race` rounds and winner logic
    - Unit tests for `RaceInputHandler` parsing and validation
    - Unit tests for `Game` orchestration and winner output
    - Integration tests via `ApplicationTest` using `NsTest` and `assertRandomNumberInRangeTest`


## How to Test

```bash
./gradlew clean test
```

All tests should pass successfully.

 

