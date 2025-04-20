# kotlin-racingcar-precourse

# TO-DO Features
Class Car
	Variable int movedRound, val String Name
	
	Contructor with String name

	Function void runRound - make move or not in this round based on random
	
	Function void printCarStatus - print name and Current movedRound

Class CarRacing
	Variable Car list cars, int totalRound, int currentRound

	Function getCarInput - get Car names input from user (comma-seperated). if user input invalid name, throw Exception (allow only alphabets and space)

	Function getRoundInput - get total round input from user. if user input invalid round, throw Exception (allow inputs within the Int range)

	Function init - display information, get user input using getCarInput, getRoundInput

	Function racing - process rounds

	Function printResult - display winners (max movedRounds cars)

	Function run - run carRacing. init - racing - printResult


# Structure With PseudoCode

Class CarRacing {
	Car list cars
	int totalRound
	int	currentRound = 0

	void getCarInput():
		String input = readLine()
		if input valid:
			String list names = split input
			for name in names:
				cars.append(new Car(name))
		else
			throw Exception

	void getRoundInput():
		int input = readLine()
		if input valid:
			totalRound = input
		else
			throw Exception

	void init():
		print Enter the names of the cars (comma-separated)
		getCarInput() Throw Exception
		print How many rounds will be played? (1 ~ proper Integer)
		getRoundInput() Throw Exception

	Car list Racing():
		for range in round:
			for car in cars:
				car.runRound()
				car.printStatus()

	void printResult(cars):
		var maxMovedRound
		for car in cars:
			check max movedRound of cars
		for car in cars:
			if car.movedRound == maxMovedRound:
				print(car.name) 	(comma print needed)

	void Run():
		init()
		Racing()
		printResult()
}

Class Car {
	String name;
	int movedRound = 0;

	Car(String name):
		this.name = name
		movedRound = 0

	static void runRound():
		if random() >= 4:
			movedRound++;

	void printCarStatus():
		print name: - (based on movedRound)
}

main () {
	var carRacing = new CarRacing()
	
	CarRacing.Run();
}