# kotlin-racingcar-precourse

Introduction: tbd

## Feature List

The features will be implemented in the following order:
- [x] Read the car names from the user's input.
- [x] Read the number of rounds from the user's input.
- [x] Race the cars for a single round.
- [x] Race the cars for multiple rounds.
- [x] Write the winners of the race to the console.

<details>
<summary>Whiteboard version</summary>

![Photo](assets/Image%202025-04-18%20at%2011.22.18.jpeg)
</details>

## Learnings

- One can declare utility classes as `object` instead of `class`. This allows the compiler to provide a single instance automatically, so one can call utility methods without creating an instance manually.
- `Console.readLine()` throws a `NoSuchElementException` if there is no input.
- The `isNullOrBlank()` method checks not only if a string is null or empty but also whether it contains only whitespace characters.
- Companion objects define class members that can be used without creating an instance of the class.
- The `assertRandomNumberInRangeTest` function controls random number generation during tests. It takes a test code block and a list of numbers. The function replaces random number calls with the specified values in order, making tests consistent and repeatable.

## Sources

- [Kotlin Tour: Collections](https://kotlinlang.org/docs/kotlin-tour-collections.html)
- [Difference Between a Class and Object in Kotlin](https://stackoverflow.com/questions/44255946/difference-between-a-class-and-object-in-kotlin)
- [Test-Driven Development with Kotlin](https://www.jetbrains.com/help/idea/tdd-with-kotlin.html)
- [Companion Object in Kotlin](https://www.baeldung.com/kotlin/companion-object)
