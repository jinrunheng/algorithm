func numPairsDivisibleBy60(time []int) int {
    var res int
    seconds := make([]int, 60)
    for _,v := range time {
        seconds[v % 60]++
    }
    res += seconds[0] * (seconds[0] - 1) / 2
    res += seconds[30] * (seconds[30] - 1) / 2
    i := 1
    j := 59
    for i < j {
        res += seconds[i] * seconds[j]
        i++
        j--
    }
    return res

}
