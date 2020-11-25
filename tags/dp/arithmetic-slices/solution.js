/**
 * @param {number[]} A
 * @return {number}
 */
var numberOfArithmeticSlices = function(A) {
    let dp = new Array()
    let sum = 0
    dp[0] = 0
    dp[1] = 0
    for(let i = 2; i < A.length; i++){
        if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
            dp[i] = dp[i - 1] + 1
            sum += dp[i]
        }else{
            dp[i] = 0
        }
    }
    return sum
};