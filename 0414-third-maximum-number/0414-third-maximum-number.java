class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        //set=odd(num);
        //}
    List<Integer> list = new ArrayList(set);
    Collections.sort(list);
    int n=list.size();
    if(n>=3){
        return list.get(n-3);
    }
    return list.get(n-1);
    }
}

        
    

        