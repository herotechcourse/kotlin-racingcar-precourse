# kotlin-racingcar-precourse

Introduction: tbd

## Feature List

The features will be implemented in the following order:
- [x] Read the car names from the user's input.
- [ ] Read the number of rounds from the user's input.
- [ ] Race the cars for a single round.
- [ ] Race the cars for multiple rounds.
- [ ] Write the winners of the race to the console.

<details>
<summary>Whiteboard version</summary>

![Photo](assets/Image%202025-04-18%20at%2011.22.18.jpeg)
</details>

## Learnings

- One can declare utility classes as `object` instead of `class`. This allows the compiler to provide a single instance automatically, so one can call utility methods without creating an instance manually.
- `Console.readLine()` throws a `NoSuchElementException` if there is no input.
- The `isNullOrBlank()` method checks not only if a string is null or empty but also whether it contains only whitespace characters.

## Sources

- [Kotlin Tour: Collections](https://kotlinlang.org/docs/kotlin-tour-collections.html)
- [Difference Between a Class and Object in Kotlin](https://stackoverflow.com/questions/44255946/difference-between-a-class-and-object-in-kotlin)
- [Test-Driven Development with Kotlin](https://www.jetbrains.com/help/idea/tdd-with-kotlin.html)
