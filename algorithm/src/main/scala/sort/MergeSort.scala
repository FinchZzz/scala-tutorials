package org.finch
package sort

import scala.annotation.tailrec

object MergeSort {

  def sort[A](list: List[A])(implicit e: A => Ordered[A]): List[A] = {


    def halfList(ll: List[A]): (List[A], List[A]) = {

      @tailrec
      def loop(allList: List[A], left: List[A], right: List[A]): (List[A], List[A]) = {
        allList match {
          case first :: second :: tail => loop(tail, first :: left, second :: right)
          case first :: Nil => (first :: left, right)
          case Nil => (left, right)
        }
      }

      loop(ll, Nil, Nil)

    }

    def merge(aList: List[A], bList: List[A]): List[A] = {
      @tailrec
      def loop(left: List[A], right: List[A], mergedList: List[A]): List[A] = {
        (left, right) match {
          case (leftHead :: leftTail, rightHead :: rightTail) =>
            if (leftHead > rightHead) loop(left, rightTail, rightHead :: mergedList)
            else loop(leftTail, right, leftHead :: mergedList)
          case (leftHead :: leftTail, Nil) => loop(leftTail, Nil, leftHead :: mergedList)
          case (Nil, rightHead :: rightTail) => loop(Nil, rightTail, rightHead :: mergedList)

        }
      }

      loop(aList, bList, Nil)
    }

    def sort(tuple: (List[A], List[A])): List[A] = {
      tuple match {
        case (Nil, Nil) => Nil
        case (Nil, right :: Nil) => right :: Nil
        case (left :: Nil, Nil) => left :: Nil
        case (left, right) => merge(halfAndSorted(left), halfAndSorted(right))
      }

    }


    def halfAndSorted(l: List[A]) = sort(halfList(l))

    halfAndSorted(list)

  }

}
