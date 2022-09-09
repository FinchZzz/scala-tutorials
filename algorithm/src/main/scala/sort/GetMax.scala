package org.finch
package sort

object GetMax {


  def getMax(arr: Array[Int]): Int = {
    process(arr, 0, arr.length)
  }

  def process(arr: Array[Int], left: Int, right: Int): Int = {
    if (left == right) return arr(right)
    val middle = left + (right - left) >> 1
    val leftMax = process(arr, left, middle)
    val rightMax = process(arr, middle, right)
    Math.max(leftMax, rightMax)
  }
}
