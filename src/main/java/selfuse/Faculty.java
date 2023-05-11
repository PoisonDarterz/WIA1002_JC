package selfuse;

import java.util.*;  

class C { 
    public static void main(String[] args) { 

                PriorityQueue<String> pQueue = new PriorityQueue<String>(); 
          
                pQueue.offer("C++"); 
                pQueue.offer("Python"); 
                pQueue.offer("Java"); 
                pQueue.offer("Fortran"); 
          
                System.out.println("peek() gives us: "+ pQueue.peek());     //(a) 
          
                System.out.println("The queue elements:");                         //(b) 
                Iterator itr = pQueue.iterator(); 
                while (itr.hasNext()) 
                    System.out.println(itr.next());                                           //(b) 
          
                pQueue.poll(); 
                System.out.println("After poll():");                                      //(c) 
                Iterator<String> itr2 = pQueue.iterator(); 
                while (itr2.hasNext()) 
                    System.out.println(itr2.next());                                         //(c) 
          
                pQueue.remove("Java"); 
                System.out.println("After remove():");                                 //(d) 
                Iterator<String> itr3 = pQueue.iterator(); 
                while (itr3.hasNext()) 
                    System.out.println(itr3.next());                                         //(d) 
          
                boolean b = pQueue.contains("Ruby"); 
                System.out.println ( "Priority queue contains Ruby or not?: " + b);          //(e) 
          
                Object[] arr = pQueue.toArray(); 
                System.out.println ( "Value in array: ");                                //(f) 
                for (int i = 0; i<arr.length; i++) 
                  System.out.println ( "Value: " + arr[i].toString()) ;             //(f)
     }   
 } 