class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int c : candyType){
            if(!set.contains(c)){
                set.add(c);
            }
        }
        return Math.min(candyType.length / 2,set.size());
    }
}