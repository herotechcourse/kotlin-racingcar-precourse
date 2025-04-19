🚀 Feature Requirements

❗️Implement a simple racing game where:
```angular2html
• During a given number of attempts, n cars can either move forward or stop.
• Each car can be given a name.
• When a car moves forward, its name should also be printed.
• Car names should be separated by commas, and names must not exceed 5 characters.
• The user should be able to input how many times the cars will move.
• The condition for a car to move forward is if a randomly generated number between 0 and 9 is 4 or greater.
• After completing the race, the winner(s) should be announced. There may be more than one winner.
• If there are multiple winners, they should be separated by commas.
• If the user inputs incorrect values, an IllegalArgumentException should be thrown, and the application should terminate.
```

Input/Output Requirements

Input
1.	Car names for the race (separated by commas):

pobi,woni,jun

2.	Number of attempts:

5

Output
•	Result for each round:

pobi : --
woni : ----
jun : ---


•	If there’s a single winner:

Final Winner: pobi


•	If there are multiple winners:

Final Winner: pobi, jun



Sample Execution

Enter the car names for the race (separate by commas):
pobi,woni,jun
How many attempts?
5

Execution Result
```angular2html

pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Final Winner: pobi, jun

```

🚗 Feature List


```angular2html
1.	Prompt the user with “Enter the car names for the race (separate by commas)”.

2.	Get input from the user.
•	If the input is empty, throw an IllegalArgumentException and terminate the application.

3.	Save the car names in a string list.
•	If any name has 0 characters or exceeds 5 characters, throw an IllegalArgumentException and terminate the application.
•	If there are duplicate names, throw an IllegalArgumentException and terminate the application.

4.	Prompt the user with “How many attempts?”.

5.	Get input for the number of attempts.
•	If the number is negative, throw an IllegalArgumentException and terminate the application.
•	If the input is not a number, throw an IllegalArgumentException and terminate the application.

6.	Create cars.
•	Assign names to cars.
•	Create a random distance generator for each car.
•	If a randomly generated number between 0 and 9 is 4 or greater, the car moves forward by 1.

7.	Create multiple cars.
•	Add cars to a list.
•	Move all cars according to the rules.

8.	Display the results after each round.

9.	Announce the winner(s).
•	If there is one winner, display it.
•	If there are multiple winners, display them separated by commas.

```
