# Coding Challenge Description
## Problem: Look for the duplicates
Description: The purpose of this task is to transform a given string into a new string. In the new string, each character will be replaced by "{" if it occurs only once in the original string. If a character appears more than once in the original string, it will be replaced by "}". Please note that when checking for duplicates, capitalization should be ignored. Hint: class String has method toLowerCase().

Signature: `public static String encodeDuplicateCharacters(String theWord)`

Input: The input for this task would be a string, which is a sequence of characters.

Output:
The output of this task would be a new string that has the same length as the original string. Each character in the new string will be either "{" or "}", based on the occurrence of the corresponding character in the original string. If a character appears only once in the original string, it will be replaced with "{". If a character appears more than once, it will be replaced with "}". The capitalization of the characters in the original string should be ignored when determining duplicates.

Example: 
```
String text1 = "aabbccddaa"; 
String result1 = encodeDuplicateCharacters(text1); 
System.out.println(result1); // Output: }}}}}}}}}} 
String text2 = "Hello"; 
String result2 = encodeDuplicateCharacters(text2); 
System.out.println(result1); // Output: {{}}{ 
String text3 = "hi Hello"; 
String result3 = encodeDuplicateCharacters(text3); 
System.out.println(result1); // Output: }{{}{}}{ 
String text4 = "{json{name: Montran}"; 
String result4 = encodeDuplicateCharacters(text4); 
System.out.println(result4); // Output: }{{}}}}}}{{{}}}{{}}{

```
## Problem: Count Occurrences in Array and Sort by Digits
Description: You are given an array of integers. Write a Java method that counts the occurrences of each
unique number in the array and returns a two-dimensional array representing the result. The twodimensional
array should contain the unique numbers from the input array, sorted in ascending order
based on their digits, along with the corresponding number of occurrences.

Signature: `public static int[][] countOccurrences(int[] arr)`

Input:
An array of integers, arr, where the length of the array is n (0 <= n <= 10^5).
The integers in the array can be positive, negative, or zero.

Output:
A two-dimensional array, result, where the length of the array is m (0 <= m <= n).
Each row in the result array consists of two integers: the unique number from the input array and the
corresponding number of occurrences.

Constraints:
The output array should be sorted in ascending order based on the digits of the numbers.
If two or more numbers have the same digits, they should be sorted based on their original order in the
input array.

Example:
```
int[] arr = {4, 2, 9, 7, 5, 4, 9, 2};
int[][] occurrences = countOccurrences(arr);
Output:
The occurrences array should contain the following rows:
2: 2
4: 2
5: 1
7: 1 
9: 2
```
