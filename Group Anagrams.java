//Time Complexity:O(n*m) :n->length of strs, m->length of each string
//Space Complexity:O(n*m) 
//Approach:
// We have strings which are of same character but formas different words.TO find out relation i find prime product of that string.
// If a primeproduct of that string exists in map i will add to the correspondng list else i will make a new entry to that map with the prime product.
// I have used BigInteger to avoid overflow, if are calculating pprime product for a large string primrproduct would be higher which can overflow.
// I will return all set of list in map each grouped by primeproduct.

import java.math.BigInteger;
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<BigInteger,List<String>> map=new HashMap<>();
        int[] arr=new int[26];
        int pos=0;
        int counter=2;
        while(pos<arr.length){
            int sum=0;
            for(int i=1;i<=counter;i++){
                if(counter%i==0){
                    sum++;
                }
            }
            if(sum==2){
                arr[pos]=counter;
                pos++;
            }
            counter++;
        }
        for(String s:strs){
            BigInteger pp=primeProduct(s,arr);
            if(!map.containsKey(pp)){
                map.put(pp,new ArrayList<>());
            }
            map.get(pp).add(s);
        }
        return new ArrayList<>(map.values());

    }
    public BigInteger primeProduct(String s,int[] arr){
        BigInteger total=BigInteger.ONE;
        for(char ch:s.toCharArray()){
            total=total.multiply(BigInteger.valueOf(arr[ch-'a']));
        }
        return total;
    }
}
