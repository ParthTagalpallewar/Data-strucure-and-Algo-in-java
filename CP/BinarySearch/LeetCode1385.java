package CP.BinarySearch;

// Given two integer arrays arr1 and arr2, and the integer d,
// return the distance value between the two arrays.

// The distance value is defined as the number of elements arr1[i]
//  such that there is not any element arr2[j] where|arr1[i]-arr2[j]|<=d.

//Example 1
// arr1 = [4, 5, 8] arr2 = [10, 9, 1, 8] d = 2
// Answer = 2

// Explain
// For arr1[0]=4 we have: 
// |4-10|=6 > d=2 
// |4-9|=5 > d=2 
// |4-1|=3 > d=2 
// |4-8|=4 > d=2 
// For arr1[1]=5 we have: 
// |5-10|=5 > d=2 
// |5-9|=4 > d=2 
// |5-1|=4 > d=2 
// |5-8|=3 > d=2
// For arr1[2]=8 we have:
// |8-10|=2 <= d=2
// |8-9|=1 <= d=2
// |8-1|=7 > d=2
// |8-8|=0 <= d=2

// Approach 1 - Brute force approach
// Approach 2 - sort array and find closest number in arr2

// Finding Closest Number
// Approach 1 -> 
// if d == 2
// find mid and if mid < d then s = mid + 1 else e = mid - 1 
// so that we get two index s and e compare them and find number

// Approach 2
// if num is 4 and d = 2
// get range ie from num-d to num+d
// binary search for num checking in that range 

public class LeetCode1385 {

}
