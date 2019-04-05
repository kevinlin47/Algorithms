/*
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
 

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
*/
import (
    "fmt"
    "math/big"
)


func minSteps(n int) int {
    var toReturn int
    var myInt = big.NewInt(int64(n))
    currentA := 1
    copyAll := 1
    
    if myInt.ProbablyPrime(n) {
        toReturn = n
    } else {
        for currentA != n {
            if (n % currentA == 0)  {
                copyAll = currentA
                currentA += copyAll
                toReturn += 2
            } else {
                currentA += copyAll
                toReturn += 1
            }
        }
    }
    return toReturn
}
