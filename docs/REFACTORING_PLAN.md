### Additional Test
- [ ] Car name contains whitespace
- [ ] Multiple winner scenario
- [ ] Invalid round count
  - [ ] zero
  - [ ] negative
  - [ ] non numeric
  - [ ] blank
- [ ] Invalid character in car name (Let's use `Regex("[^a-zA-Z0-9, ]")`)
- [ ] Duplicate car names like "pobi, pobi"
- [ ] Test for round count exceeding upper limit. (Let max 500 round)
- [ ] Test for exceeding maximum number of cars. (Let max 100 cars)

### Seperate Rules.kt from model
- [ ] RANDOM_MIN=0, RANDOM_MAX=9
- [ ] MOVE_THRESHOLD=4
- [ ] MAX_CAR_NAME_LEN=5
- [ ] MAX_ROUND=500
- [ ] MAX_CAR_COUNT=100
- [ ] NAME_DELIMETER=','
- [ ] MOVE_SYM='-'