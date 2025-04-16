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

- [] input
    - [] carNamesInput
        - [] split car names input with (,)
        - [] each slices must not be null, "", " "
    - [] tryCountInput
        - [] must not be null, "", " '
        - [] must be number

- [] CarNameDto
    - [] names cannot exceed 5 characters
- [] TryCountDto
    - [] try count cannot exceed 1000