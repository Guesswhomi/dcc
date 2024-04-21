// Election algorithm
import java.util.*;  
  
class BullyAlgo{  
      
    static int numberOfProcess;  
    static int priorities[] = new int[100];  
    static int status[] = new int[100];  
    static int cord;  
    
    public static void main(String args[]){  
        System.out.println("Enter total number of processes:");  
        Scanner sc = new Scanner(System.in);  
        numberOfProcess = sc.nextInt();  
    
        int i;  
    
        for(i = 0; i<numberOfProcess; i++){  
            System.out.println("Status for process "+(i+1)+":");  
            status[i] = sc.nextInt();  
            System.out.println("Priority of process "+(i+1)+":");  
            priorities[i] = sc.nextInt();  
        }  
    
        System.out.println("Enter proces which will initiate election");  
        int ele = sc.nextInt();  
        
        sc.close();  

        electProcess(ele);  
        System.out.println("After electing process the final coordinator is "+cord);  
    }  
    
    static void electProcess(int ele){  
        ele = ele - 1;  
        cord = ele + 1;  
        
        for(int i = 0; i<numberOfProcess; i++){  
            if(priorities[ele]<priorities[i]){  
                System.out.println("Election message is sent from "+(ele+1)+" to "+(i+1));  
            if(status[i]==1)  
                electProcess(i+1);  
            }  
        }  
    }  
} 

//output
//Enter total number of processes:
//5
//Status for process 1:
//1
//Priority of process 1:
//3
//Status for process 2:
//1
//Priority of process 2:
//4
//Status for process 3:
//1
//Priority of process 3:
//2
//Status for process 4:
//1
//Priority of process 4:
//5
//Status for process 5:
//1
//Priority of process 5:
//1
//Enter proces which will initiate election
//3
//Election message is sent from 3 to 1
//Election message is sent from 1 to 2
//Election message is sent from 2 to 4
//Election message is sent from 1 to 4
//Election message is sent from 3 to 2
//Election message is sent from 2 to 4
//Election message is sent from 3 to 4
//After electing process the final coordinator is 4
