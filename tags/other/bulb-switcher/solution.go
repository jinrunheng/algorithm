func bulbSwitch(n int) int {
    if n == 1{
        return 1 
    }
    res := 1
    for res * res <= n {
        res++
    }
    return res - 1
}