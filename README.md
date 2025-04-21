# kotlin-racingcar-precourse

This is the submission for the first week's mission of the pre-course for the "Hero Tech Course: Berlin Edition" by [Deniz](https://github.com/deniz-oezdemir).

The project is a console-based Kotlin application that runs a simple car racing game.
After the user enters car names and the number of rounds, the program simulates the race,
shows the race progression, and prints the final results.

Below you can find a quick demonstration of the program:

https://github.com/user-attachments/assets/2a4823e9-5e73-47f2-a8fc-e4b13b62d8a7

## Table of Contents
- [Feature List](#feature-list)
- [Learnings](#learnings)
- [Considerations](#considerations)
- [Reflections and Future Work](#reflections-and-future-work)
- [Sources](#sources)

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

After learning the basics through the [Kotlin Tour](https://kotlinlang.org/docs/kotlin-tour-welcome.html), I started the project and noted the following key takeaways:

- We can declare utility classes as `object` instead of `class`. This allows the compiler to provide a single instance automatically, so we can call utility methods without creating an instance manually.
- The provided `Console.readLine()` throws a `NoSuchElementException` if there is no input.
- The `isNullOrBlank()` method checks not only if a string is null or empty but also whether it contains only whitespace characters.
- Companion objects define class members that can be used without creating an instance of the class.
- The `assertRandomNumberInRangeTest` function controls random number generation during tests. It takes a test code block and a list of numbers. The function replaces random number calls with the specified values in order, making tests consistent and repeatable.
- Use `it` in lambdas to refer to the single parameter when the parameter is not explicitly named. For example, `cars.filter { it.position == maxPosition }` is concise and works well for simple cases. However, explicitly naming the parameter, like `cars.filter { car -> car.position == maxPosition }`, improves clarity in more complex cases or when lambdas are nested. Choose between `it` and explicit naming based on the complexity of the lambda and the need for readability.
- Single-expression functions in Kotlin let us define functions with one expression using the `=` symbol instead of curly braces. For example, `fun createCars(carNames: List<String>): List<Car> = carNames.map { Car(it) }` creates car objects from a list of names in one line.

## Considerations

Restrictions I considered but chose not to implement:

- Not allowing races with only one car: Solo races happen in reality, so the program supports them.
- Not allowing duplicate car names: In reality, competitors with the same name can compete in a race.

## Reflections and Future Work

If I were to expand this project or start it again with a larger scope, I would make the following changes:

- Break functions into smaller, single-purpose units from the get go. For example, separate input reading from validation to make the code more reusable, reduce duplication, and improve readability.
- Separate the logic for simulating the race from printing the output. This would make the program easier to test and adapt for different interfaces, such as a web or graphical application.

## Sources

- [Kotlin Tour: Collections](https://kotlinlang.org/docs/kotlin-tour-collections.html)
- [Difference Between a Class and Object in Kotlin](https://stackoverflow.com/questions/44255946/difference-between-a-class-and-object-in-kotlin)
- [Test-Driven Development with Kotlin](https://www.jetbrains.com/help/idea/tdd-with-kotlin.html)
- [Companion Object in Kotlin](https://www.baeldung.com/kotlin/companion-object)
- [Lambda expressions and LINQ-style code in Kotlin](https://kotlinlang.org/docs/lambdas.html#underscore-for-unused-variables)
- [Kotlin Coding Conventions: Documentation Comments](https://kotlinlang.org/docs/coding-conventions.html#documentation-comments)
