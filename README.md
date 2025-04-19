# kotlin-racingcar-precourse

This is the submission for the first week's mission of the pre-course for the "Hero Tech Course: Berlin Edition" by [Deniz](https://github.com/deniz-oezdemir).

The project is a console-based Kotlin application that runs a simple car racing game. After the user enters car names and the number of rounds, the program simulates the race, shows the race progression, and prints the final results.

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

- We can declare utility classes as `object` instead of `class`. This allows the compiler to provide a single instance automatically, so we can call utility methods without creating an instance manually.
- `Console.readLine()` throws a `NoSuchElementException` if there is no input.
- The `isNullOrBlank()` method checks not only if a string is null or empty but also whether it contains only whitespace characters.
- Companion objects define class members that can be used without creating an instance of the class.
- The `assertRandomNumberInRangeTest` function controls random number generation during tests. It takes a test code block and a list of numbers. The function replaces random number calls with the specified values in order, making tests consistent and repeatable.
- Use `it` in lambdas to refer to the single parameter when the parameter is not explicitly named. For example, `cars.filter { it.position == maxPosition }` is concise and works well for simple cases. However, explicitly naming the parameter, like `cars.filter { car -> car.position == maxPosition }`, improves clarity in more complex cases or when lambdas are nested. Choose between `it` and explicit naming based on the complexity of the lambda and the need for readability.
- Single-expression functions in Kotlin let us define functions with one expression using the `=` symbol instead of curly braces. For example, `fun createCars(carNames: List<String>): List<Car> = carNames.map { Car(it) }` creates car objects from a list of names in one line.

## Sources

- [Kotlin Tour: Collections](https://kotlinlang.org/docs/kotlin-tour-collections.html)
- [Difference Between a Class and Object in Kotlin](https://stackoverflow.com/questions/44255946/difference-between-a-class-and-object-in-kotlin)
- [Test-Driven Development with Kotlin](https://www.jetbrains.com/help/idea/tdd-with-kotlin.html)
- [Companion Object in Kotlin](https://www.baeldung.com/kotlin/companion-object)
- [Lambda expressions and LINQ-style code in Kotlin](https://kotlinlang.org/docs/lambdas.html#underscore-for-unused-variables)
