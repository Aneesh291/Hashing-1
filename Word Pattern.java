// Time Complexity :O(n*k)
// Space Complexity :O(n*k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// I will check does patterns length is equals to number of words in words, if not i return false.Either there would not have enough characters to map words or characters are insufficient to use words.
// For each character, i map the character in map and corresponding word in map. For each new entry before i put in map i check does the current word does already exists in map,if yes return false.
// If there is a ideal pattern and words exists it skips the above conditions comes out of the loop and returns true.
class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character,String> map=new HashMap<>();
        String[] arr=s.split(" ");
        if(pattern.length()!=arr.length)return false;
        boolean[] visited=new boolean[arr.length];
        for(int i=0;i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i))){
                for(String ss:map.values()){
                    if(ss.equals(arr[i])){
                        return false;
                    }
                }
                map.put(pattern.charAt(i),arr[i]);
                visited[i]=true;
            
            }
            else{
                if(!map.get(pattern.charAt(i)).equals(arr[i])){
                    return false;
                }
                visited[i]=true;
            }
        }
        
        return true;
        
    }
}
