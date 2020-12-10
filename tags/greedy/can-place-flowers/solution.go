func canPlaceFlowers(flowerbed []int, n int) bool {
    if n == 0 {
        return true
    }
    if len(flowerbed) == 1 {
        return flowerbed[0] == 0 && n == 1
    }

    max := 0
    i := 0
    for i < len(flowerbed) {
        
        if i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 {
            flowerbed[i] = 1
            max += 1
            i += 1
            continue
        }

        if i - 1 >= 0 && i + 1 < len(flowerbed) && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0{
            flowerbed[i] = 1
            max += 1
            i += 1
            continue
        }
        
        if i == len(flowerbed) - 1 && flowerbed[len(flowerbed) - 1] == 0 && flowerbed[len(flowerbed) - 2] == 0{
            flowerbed[i] = 1
            max += 1
            i += 1
            continue
        }

        if max >= n {
            return true
        }
        i += 1
    }
    return max >= n
}