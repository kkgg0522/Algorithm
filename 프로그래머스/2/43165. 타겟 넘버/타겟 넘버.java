class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0, numbers, target);
        return answer;
    }

    void dfs(int n, int sum, int[] numbers, int target){
        if(n == numbers.length){
            if(target==sum){
                answer++;
            }
            return;
        }
        
        dfs(n+1, sum + numbers[n], numbers, target);
        dfs(n+1, sum - numbers[n], numbers, target);
    }
}