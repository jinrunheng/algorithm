/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * func guess(num int) int;
 */

func guessNumber(n int) int {
    l := 1
    r := n
    for l <= r {
        mid := l + ((r - l) >> 1)
        if guess(mid) == -1 {
            r = mid - 1
        }else if guess(mid) == 1{
            l = mid + 1
        }else {
            return mid
        }
    }
    return -1
}