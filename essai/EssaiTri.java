package essai;


import java.util.*; 
  
public class EssaiTri { 
    public static void main(String[] args) { 
        LinkedList<String> al = new LinkedList<String>(); 
        al.add("Geeks For Geeks"); 
        al.add("Friends"); 
        al.add("Dear"); 
        al.add("Is"); 
        al.add("Superb"); 
  
        Collections.sort(al); 
  
        System.out.println("List after the use of" + 
                           " Collection.sort() :\n" + al); 
    } 
} 