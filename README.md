# kotlin-racingcar-precourse

- [x] Car
    - [x] status
        - [x] name
        - [x] status
    - [x] behavior
        - [x] go
            - [x] check if fuel is enough
- [x] Fuel
    - [x] Random Number Generator
        - [x] make random number between 0~9
        - [x] fuel is enough when 4 or greater

- [x] input
    - [x] carNamesInput
        - [x] split car names input with (,)
        - [x] each slices must not be null, "", " "
    - [x] tryCountInput
        - [x] must not be null, "", " '
        - [x] must be number

- [x] CarNameDto
    - [x] names cannot exceed 5 characters
- [x] TryCountDto
    - [x] try count cannot exceed 1000

- [x] Round
    - [x] status
        - [x] round count
        - [x] participating cars
    - [x] behavior
        - [x] each car races


- [] Referee
    - [] status
        - [] winner Car status
        - [] winner Car List
    - [] behavior
        - [] judge winner

- [] output