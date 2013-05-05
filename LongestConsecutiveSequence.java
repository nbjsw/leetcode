/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
*/

// 由于平时不爱用hash table,导致一开始做这个题目毫无思路
// 一个小技巧：涉及到O(n)时间，并且还是unordered的东西，可以考虑一下Hash
// 两个hashtable那个思路我能理解，一个是start,length 另一个是end, length
// 但是一个hashtable的那个思路怎么做的，我还得思考一下
// 有了，其实是这样的，在一个hashtable里，有<点，长度>,这个长度可以向左，也可以向右
// 关键点在于你怎么用他。比如已经有了range [left, right],只有当left - 1，出现的时候，map.get(left)才会被用到
// 此时，肯定会被翻译成为向左的length，如果left + 1出现了，那么直接被忽略了，没有机会给你把length翻译为向右的length
// 当一个key处于range的中间时，这个key不会被用到了，所以对应的val对错都无所谓了

//hash <pos, len>

public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length == 1) return 0;
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int key : num) {
                if (!map.containsKey(key)) {
                        map.put(key, 1);
                        if (map.containsKey(key - 1))
                                max = Math.max(max, Solution.mergeRange(map, key - 1, key));
                        if (map.containsKey(key + 1))
                                max = Math.max(max, Solution.mergeRange(map, key, key + 1));
                }
        }
        return max;
    }
    
    private static int mergeRange(HashMap<Integer, Integer> map, int left, int right) {
        int leftBorder = left - map.get(left) + 1;
        int rightBorder = right + map.get(right) - 1;
        int len = rightBorder - leftBorder + 1;
        
        map.put(leftBorder, len);
        map.put(rightBorder, len);

        return len;
    }
}