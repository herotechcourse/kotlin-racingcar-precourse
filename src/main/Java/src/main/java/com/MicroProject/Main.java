package com.MicroProject;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        System.out.println("Enter the names of the cars (comma-separated):");
        String carNames = sc.next();
        while(checkLength(carNames)) {
            carNames = sc.next();
        }
        System.out.println("How many rounds will be played?");
        int rounds = sc.nextInt();
        CarRacingGame carRacingGame = new CarRacingGame(carNames, rounds);
        carRacingGame.startGame();
        pw.flush();
    }
    public static boolean checkLength(String carNames){
        String[] cars = carNames.split(",");
        for (String carName : cars) {
            if (carName.length() > 5) {
                System.out.println("Car name can not exceed 5 characters.");
                System.out.println("Enter the names of the cars (comma-separated):");
                return true;
            }
        }

        return false;
    }

    public static class CarRacingGame{
        private ArrayList<Car> cars;
        private int numberOfRounds;
        private int numberOfCars;
        private ArrayList<Car> winners = new ArrayList<>();

        public CarRacingGame(String names, int numberOfRounds){
            cars = new ArrayList<>();
            String[] carNames = names.split(",");
            for(String carName : carNames)
                cars.add(new Car(carName));
            this.numberOfCars = cars.size();
            this.numberOfRounds = numberOfRounds;
        }



        public void startGame(){
            pw.println("Race Results");
            int n = numberOfRounds;
            while(numberOfRounds --> 0){
                checkCars();
                checkEnd();
            }
        }
        private void checkCars(){
            for(Car car : cars){
                car.checkCar();
                pw.print(car.getName() + " : ");
                car.displayNumberOfMoves();
                pw.println();
            }
            pw.println();
        }

        public void checkEnd(){
            if(numberOfRounds == 0){
                int maxMoves = 0;
                for(Car car : cars)
                    maxMoves = Math.max(maxMoves, car.getNumberOfMoves());
                assignWinners(maxMoves);
                pw.print("Winners : ");
                printWinners();
            }
        }

        public void assignWinners(int maxMoves){
            for(Car car : cars)
                if(car.getNumberOfMoves() == maxMoves)
                    winners.add(car);
        }

        public void printWinners(){
            for(int i = 0; i < winners.size();i++)
                if(i != winners.size() - 1)
                    pw.print(winners.get(i) + ", ");
                else pw.print(winners.get(i));
        }


    }

    public static class Car{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
        private boolean isMoving;

        public int getNumberOfMoves() {
            return numberOfMoves;
        }

        private int numberOfMoves;

        public Car(String name){
            this.name = name;
        }

        public boolean checkCar(){
            int randomNumber = (int)(Math.random() * 10);
            if(randomNumber >= 4) {
                this.numberOfMoves++;
                return isMoving = true;
            }
            return false;
        }

        public void displayNumberOfMoves(){
            for(int i = 0;i < this.numberOfMoves;i++)
                pw.print("-");
        }

        public String toString(){
            return this.name;
        }

    }

}