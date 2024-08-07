class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder str = new StringBuilder(String.valueOf(num));
        int n = str.length();
        
        // Insert commas after every three digits
        int index = n - 3;
        while (index > 0) {
            str.insert(index, ',');
            index -= 3;
        }

        // Define the magnitudes
        String[] track = {"", "Thousand", "Million", "Billion"};

        // Split the string by commas
        String[] parts = str.toString().split(",");

        // Convert each part to words and append the corresponding magnitude
        StringBuilder result = new StringBuilder();
        int partCount = parts.length;

        for (int i = 0; i < partCount; i++) {
            String part = parts[i];
            if (!part.equals("000")) {
                result.append(convertGroup(part)).append(" ").append(track[partCount - 1 - i]).append(" ");
            }
        }

        return result.toString().trim();
    }

    private String convertGroup(String str) {
        int num = Integer.parseInt(str);
        String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        StringBuilder words = new StringBuilder();
        
        if (num >= 100) {
            words.append(lessThan20[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            words.append(tens[num / 10]).append(" ");
            num %= 10;
        }
        if (num > 0) {
            words.append(lessThan20[num]).append(" ");
        }

        return words.toString().trim();
    }
}


// Time and Space Complexity

// Time --> O(logbase10(n) *n)
// Space --> O(logbase10 n)