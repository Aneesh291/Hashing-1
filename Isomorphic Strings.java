// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
//I iterate through each Character in string check it exists in mapif not i makea new entry with that charcter in s string value as corresponding character in t string.
// If a key already exists i will check wheather the value of that key is not same as current t character if not returns false, esle if finds for next ket key.
// I also make sure that no single value shares multiple keys , so maintains a 2nd map which stores t characters as keys and s characters as values
// I will perfom Step-1,Step-2 for 2nd map too so that it return true only if there exists perfect key value pairs. 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),t.charAt(i));
            }
            else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            if(!map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i),s.charAt(i));
            }
            else{
                if(map2.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
