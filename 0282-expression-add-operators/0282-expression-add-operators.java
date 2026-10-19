
import java.util.*;

class Solution {

    List<String> result = new ArrayList<>();

    public void backtrack(String num, int target, int idx,
                          long value, long prev, String expr) {

        // Saare digits use ho gaye
        if (idx == num.length()) {
            if (value == target) {
                result.add(expr);
            }
            return;
        }

        // Next operand banane ke liye digits choose karo
        for (int i = idx; i < num.length(); i++) {

            // Leading zero allowed nahi hai, e.g. "05"
            if (i > idx && num.charAt(idx) == '0') {
                break;
            }

            String part = num.substring(idx, i + 1);
            long curr = Long.parseLong(part);

            // First number: abhi koi operator nahi lagega
            if (idx == 0) {
                backtrack(num, target, i + 1,
                          curr, curr, part);
            } else {

                // Addition
                backtrack(num, target, i + 1,
                          value + curr, curr,
                          expr + "+" + part);

                // Subtraction
                backtrack(num, target, i + 1,
                          value - curr, -curr,
                          expr + "-" + part);

                // Multiplication: precedence handle karo
                backtrack(num, target, i + 1,
                          value - prev + prev * curr,
                          prev * curr,
                          expr + "*" + part);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        result.clear();

        backtrack(num, target, 0, 0, 0, "");

        return result;
    }
}
