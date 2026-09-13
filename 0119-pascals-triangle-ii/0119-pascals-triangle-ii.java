class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        long value = 1;

        for (int i = 0; i <= rowIndex; i++) {

            // Current value add karo
            row.add((int) value);

            // Next value calculate karo
            value = value * (rowIndex - i) / (i + 1);
        }

        return row;
    }
}