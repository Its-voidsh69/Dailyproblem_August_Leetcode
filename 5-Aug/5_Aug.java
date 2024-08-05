// Problem Name: Kth Distinct String in an Array

// Problem Statement
// A distinct string is a string that is present only once in an array.

//     Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

//     Note that the strings are considered in the order in which they appear in the array.</p>


//Brute Force Solution

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = arr.length;
        String res[] = new String[n];
        int resIndex = 0;

        for(int i = 0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int i  = 0;  i<n; i++){
            if(map.get(arr[i]) == 1){
                res[resIndex++] = arr[i];
            }
        }

        if(resIndex>=k){
            return res[k-1];
        }

        return "";
    }
}

// Space and Time Complexity
// Brute Force Solution: Time Complexity - O(n), Space Complexity - O(n)

//Optimal Solution

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = arr.length;
        int count = 0;
        int resIndex = 0;

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (String s : arr) {
            if (map.get(s) == 1) {
                count++;

                if (count == k) {
                    return s;
                }
            }
        }
        return "";
    }
}

// Space and Time Complexity
// optimal Solution: Time Complexity - O(n), Space Complexity(1)
