import java.io.*;
import java.util.*;

public class App {

    /*A class Node is created with 3 elements - 
    Childs : Array of the nodes. 
    Str : To check if the word is a complete word or not.  
    found : A boolean value to check if the word is already found or not. */
    public static class Node{
        Node childs[] = new Node[26];
        String string; 
        boolean found;                     
    }

    public static void insert(Node current, String s){
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(current.childs[ch-'a'] == null){
                current.childs[ch-'a']=new Node();
            }
            current = current.childs[ch-'a'];
        }
        current.string = s;
    }

    public static void search(Node current, Node new_word){

        if(current.string != null && new_word.string != null){
            if(current.found == false){
                ans.add(current.string);
            }
            current.found = true;
        }
        if(new_word.string != null){
            search(current, root);
        }

        for(int i=0; i<26; i++){
            if(current.childs[i] != null && new_word.childs[i] != null){                           
                search(current.childs[i], new_word.childs[i]);
            }              
        }
    }

    public static void search1(Node current){
        if(current.string != null){
            search(current,root);
        }
        
        for(Node child: current.childs){
            if(child != null){
                search1(child);
            }
        }
    }

    static Node root;
    static ArrayList<String> ans = new ArrayList<>();
    
    //wordCompositionProblem Function calls 2 functions and returns the answer.
    public static List<String> wordCompositionProblem(String[] words){
        root = new Node();
        for(int s=0; s<words.length; s++){
            //1. insert - To insert the words in the trie. 
            insert(root, words[s]);

    }
    //2. search1 - To search for the words.
    search1(root);
    
    return ans;
    }

    public static void main(String[] args) throws Exception { 
        

        List<String> string = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("D:/Impledge Coding Question/input_02.txt"));
        String str;
        while (sc.hasNext()) {
            str = sc.next();
            // adding each string to arraylist
            string.add(str);
        }       
        // convert any arraylist to array
        String[] words = string.toArray(new String[0]);
        
        long start = System.currentTimeMillis();
        List<String> result = wordCompositionProblem(words);
        //Sorting the result in descending order.
        Collections.sort(result, Comparator.comparingInt(String::length).reversed());
        long end = System.currentTimeMillis();

        System.out.println("Longest Compound Word: " + result.get(0));
        System.out.println("Second Longest Compound Word: " + result.get(1));
        System.out.println("Time Taken : " + (end - start) + "ms");

  }
}
