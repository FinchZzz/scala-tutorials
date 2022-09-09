package org.finch
package sort

object InsertSort {

  def sort(arr: Array[Int]): Unit = {
    if (arr == null || arr.length < 2) return

    for (i <- 1 until arr.length) {
      for (j <- 0 until i) {
        if (arr(i) < arr(j)) {
          arr(j) = arr(j) ^ arr(i)
          arr(i) = arr(j) ^ arr(i)
          arr(j) = arr(j) ^ arr(i)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 5, 2, 8, 5, 4, 3, 0, 7, 6)
    sort(arr)
    arr.foreach(print)
  }
}
