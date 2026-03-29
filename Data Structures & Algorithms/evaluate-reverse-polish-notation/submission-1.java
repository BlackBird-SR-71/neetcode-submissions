class Solution {
    public int evalRPN(String[] tokens) {
        List<String> math = Arrays.asList("+", "-", "*", "/");

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
            if (math.contains(tokens[i])) {
                int first = st.pop();
                int second = st.pop();

                if (tokens[i].equals("+")) {
                    st.push(first + second);
                }
                else if (tokens[i].equals("-")) {
                    st.push(second - first);
                }
                else if (tokens[i].equals("*")) {
                    st.push(first * second);
                }
                else if (tokens[i].equals("/")) {
                    st.push(second / first);
                }
            }
            else {
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.pop();
    }
}
