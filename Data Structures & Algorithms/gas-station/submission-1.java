class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            gas[i] = gas[i] - cost[i];
        }

        if (totalGas < totalCost) return -1;

        int total = 0;
        int res = 0;
        int i = 0;
        while (i < n - 1) {
            
            total += gas[i];
            if (total < 0) {
                res = i + 1;
                total = 0;
            } 
            i++;
        }
        return res;

        // for (int i = 0; i < n; i++) {
            
        //     if (i == n-1) {
        //         return res;
        //     }
        //     res = i;
        //     if (total < 0) {
        //         total = 0;
        //         continue;
        //     } 
            
        //     total += gas[i];
            
        // }
        // return -1;
    }
}
