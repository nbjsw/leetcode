/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
*/

// ����ƽʱ������hash table,����һ��ʼ�������Ŀ����˼·
// һ��С���ɣ��漰��O(n)ʱ�䣬���һ���unordered�Ķ��������Կ���һ��Hash
// ����hashtable�Ǹ�˼·������⣬һ����start,length ��һ����end, length
// ����һ��hashtable���Ǹ�˼·��ô���ģ��һ���˼��һ��
// ���ˣ���ʵ�������ģ���һ��hashtable���<�㣬����>,������ȿ�������Ҳ��������
// �ؼ�����������ô�����������Ѿ�����range [left, right],ֻ�е�left - 1�����ֵ�ʱ��map.get(left)�Żᱻ�õ�
// ��ʱ���϶��ᱻ�����Ϊ�����length�����left + 1�����ˣ���ôֱ�ӱ������ˣ�û�л�������length����Ϊ���ҵ�length
// ��һ��key����range���м�ʱ�����key���ᱻ�õ��ˣ����Զ�Ӧ��val�Դ�����ν��

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