class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            list.add(A[i]);
        }
        for(int i = 0; i < B.length; i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) > B[i]){
                    res[i] = list.get(j);
                    list.remove(j);
                    break;
                }else {
                    if(j == list.size() - 1){
                        res[i] = list.get(0);
                        list.remove(0);
                        break;
                    }
                }
            }
        }
        return res;
    }
}