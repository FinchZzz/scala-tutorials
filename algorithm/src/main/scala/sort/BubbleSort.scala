package org.finch
package sort

/**
 *  https://github.com/vkostyukov/scalacaster
 *
 */
object BubbleSort {

  def sort(arr: Array[Int]): Unit = {
    if (arr == null || arr.length < 2) return
    for (i <- 0 until arr.length - 1) {
      for (j <- 0 until arr.length - i - 1) {
        if (arr(j) >= arr(j + 1)) {
          arr(j) = arr(j) ^ arr(j + 1)
          arr(j + 1) = arr(j) ^ arr(j + 1)
          arr(j) = arr(j) ^ arr(j + 1)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 5, 2, 8, 5, 4, 3, 0, 7, 6)
    sort(arr)
    println(arr.mkString("Array(", ", ", ")"))

  }
}
