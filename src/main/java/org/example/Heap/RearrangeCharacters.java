package org.example.Heap;

//Given a string S such that it may contain repeated lowercase alphabets.
//Rearrange the characters in the string such that no two adjacent characters are same.
import java.util.PriorityQueue;

class RearrangeCharacters {
    // Function to rearrange the characters in a string such that
    // no two adjacent characters are same.
    static class Node {
        char ch;
        int freq;
        Node(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    static String rearrangeCharacters(String s) {
        // Your code here
        int n=s.length();
        int[] freq=new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        PriorityQueue<Node> maxHeap=new PriorityQueue<>(
                (a,b)->b.freq-a.freq);
        for(int i=0;i<26;i++){
            if(freq[i]>0)
                maxHeap.add(new Node((char)(i+'a'),freq[i]));
        }
        StringBuilder result=new StringBuilder();
        Node prev=null;
        while(!maxHeap.isEmpty()){
            Node curr=maxHeap.poll();
            result.append(curr.ch);
            curr.freq--;

            if(prev!=null && prev.freq>0) maxHeap.add(prev);
            prev=curr;
        }
        if(result.length()!=n) return "";
        return result.toString();
    }
    // DRIVER FUNCTION
    public static void main(String[] args) {
        String input = "aaabc";

        System.out.println("Input: " + input);

        String output = rearrangeCharacters(input);

        if (output.isEmpty())
            System.out.println("Rearrangement not possible");
        else
            System.out.println("Output: " + output);
    }
}


