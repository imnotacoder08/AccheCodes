class Solution {
   public boolean equationsPossible(String[] equations) {
        int[] groups = createGraph();

        for (String equation : equations) {
            int first = equation.charAt(0) - 'a', second = equation.charAt(3) - 'a';
            boolean isEqual = equation.charAt(1) == '=';
            if (isEqual)
                union(first, second, groups);
        }

        for (String equation : equations) {
            int first = equation.charAt(0) - 'a', second = equation.charAt(3) - 'a';
            boolean isEqual = equation.charAt(1) == '=';
            if (!isEqual && find(first, groups) == find(second, groups))
                    return false;
        }

        return true;
    }

    private int[] createGraph() {
        int[] equalGroups = new int[26];

        for (int i = 0; i < 26; ++i) {
            equalGroups[i] = i;
        }

        return equalGroups;
    }

    private void union(int firstVariable, int secondVariable, int[] groups) {
        int firstGroup = find(firstVariable, groups);
        int secondGroup = find(secondVariable, groups);

        if (firstGroup != secondGroup)
            groups[firstGroup] = secondGroup;
    }

    private int find(int variable, int[] groups) {
        if (groups[variable] == variable)
            return variable;

        return find(groups[variable], groups);
    }
}