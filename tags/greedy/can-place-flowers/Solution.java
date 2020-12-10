class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        int i = 0;
        if(n == 0){
            return true;
        }
        if(flowerbed.length == 1){
            return flowerbed[0] == 0 && n == 1;
        }
        while(i < flowerbed.length){
            if(i == 0 && flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                max++;
                i += 1;
                continue;
            }

            if(i - 1 >= 0 && i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                max++;
                flowerbed[i] = 1;
                i++;
                continue;
            }

            if(i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0){
                max++;
                flowerbed[i] = 1;
                i++;
                continue;
            }

            if(max >= n){
                return true;
            }
            
            i++;
        }
        return max >= n;
    }
}