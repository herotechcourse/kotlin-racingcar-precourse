package racingcar.storage

import racingcar.storage.exception.CarNotFoundException
import racingcar.storage.exception.DuplicateCarException

private val storage = mutableMapOf<String, Int>();
private const val DEFAULT_POSITION = 0;

class CarStorage {

    fun addCar(name: String){
        if(storage[name] != null)
            throw DuplicateCarException(name);
        storage[name] = DEFAULT_POSITION;
    }

    fun moveCar(name: String){
        var current = storage[name];
        if(current == null)
            throw CarNotFoundException(name);
        storage[name] = current + 1;
    }
}
