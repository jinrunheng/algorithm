var bulbSwitch = function(n) {
    if(n == 1){
        return 1
    }
    let res = 1
    while(res * res <= n){
        res++
    }
    return res - 1
};