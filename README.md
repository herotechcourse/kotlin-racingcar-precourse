# kotlin-racingcar-precourse

## Features to be implemented

### 1. User enters the car names as comma separated values.

#### The car names is a string which needs to be validated. The program will throw an IllegalArgumentException and terminate if

	1.1. The car string is null/empty

	1.2. If the length of any car name exceeds 5 characters 


### 2. User enters the number of rounds.
 
#### An IllegalArgumentException is thrown if

	2.1. The input is 0/null/empty

	2.2. The input entered is not an integer


### 3.  Each car moves forward or stays still based on a random number between 0 and 9. 

	3.1. If the random number generated is 4 or greater, the car moves forward

	3.2. Else, the car remains in the same position


### 4. The winners are displayed. If there are multiple winners, their names are displayed separated by commas. 

