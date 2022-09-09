package org.finch
package sort

import scala.annotation.tailrec

object SelectSort {
  def sort(arr: Array[Int]): Unit = {
    if (arr == null || arr.length < 2) return
    for (i <- Range(0, arr.length - 1)) {
      var minIndex = i
      for (j <- Range(i + 1, arr.length)) {
        minIndex = if (arr(j) < arr(minIndex)) j else minIndex
      }
      swap(arr, i, minIndex)

    }
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def selectionSort[A](list: List[A])(implicit ev: A => Ordered[A]): List[A] = {
    def sort(as: List[A], bs: List[A]): List[A] = as match {
      case h :: t => select(h, t, Nil, bs)
      case Nil => bs
    }

    @tailrec
    def select(m: A, as: List[A], zs: List[A], bs: List[A]): List[A] = {
      as match {
        case h :: t =>
          if (m > h) select(m, t, h :: zs, bs)
          else select(h, t, m :: zs, bs)
        case Nil => sort(zs, m :: bs)
      }
    }

    sort(list, Nil)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 5, 2, 8, 5, 4, 3, 0, 7, 6)
    sort(arr)
    println(arr.mkString("Array(", ", ", ")"))

    selectionSort(List(1, 3, 5, 2, 8, 5, 4, 3, 0, 7, 6)).foreach(print)

  }
}
