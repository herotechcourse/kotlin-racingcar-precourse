/**
 * List extension functions
 */

package racingcar

/**
 * extension function to List<T>
 * Returns whether there are duplicates in the list.
 */
fun <T> List<T>.containsDuplicates() : Boolean {
    // source: https://stackoverflow.com/questions/47200440/kotlin-how-to-find-number-of-repeated-values-in-a-list#comment105915149_47200815
    return this.groupingBy { it }.eachCount().any { it.value > 1 }
}

/**
 * extension function to List<T>
 * Returns a pair of indices of the first duplicate elements in the list.
 * Returns Pair(-1, -1) if no duplicates exist in the list.
 */
fun <T> List<T>.firstDuplicatesIndices() : Pair<Int, Int> {
    for (i in this.indices.take(this.size - 1)) {
        val j = this.takeLast(this.size - i - 1).indexOfFirst { it == this[i] }
        if (j != -1) {
            return Pair(i, i + j + 1)
        }
    }
    return Pair(-1, -1)
}
