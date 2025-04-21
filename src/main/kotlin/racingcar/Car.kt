
class Car(val name: String) {
  var position = 0

  fun moveIfPossible() {
    if ((0..9).random() >= 4) position++
  }
}