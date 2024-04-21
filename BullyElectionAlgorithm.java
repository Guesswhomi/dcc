import java.util.Scanner;

public class BullyElectionAlgorithm {
    
    static int numberOfProcesses;
    static int[] priorities;
    static int[] status;
    static int coordinator;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the total number of processes
        System.out.println("Enter total number of processes:");
        numberOfProcesses = scanner.nextInt();
        
        // Initialize arrays for priorities and status
        priorities = new int[numberOfProcesses];
        status = new int[numberOfProcesses];
        
        // Input status and priority for each process
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter status for process " + (i + 1) + ":");
            status[i] = scanner.nextInt();
            
            System.out.println("Enter priority for process " + (i + 1) + ":");
            priorities[i] = scanner.nextInt();
        }
        
        // Input the process that will initiate the election
        System.out.println("Enter process which will initiate election:");
        int initiatingProcess = scanner.nextInt();
        
        scanner.close();

        // Execute the Bully Election Algorithm
        electCoordinator(initiatingProcess);
        
        // Print the final coordinator
        System.out.println("After electing process, the final coordinator is Process " + coordinator);
    }

    static void electCoordinator(int initiator) {
        initiator--; // Adjust to array index
        
        coordinator = initiator + 1; // Assume the initiating process is the coordinator
        
        // Check for processes with higher priority and higher IDs
        for (int i = initiator + 1; i < numberOfProcesses; i++) {
            if (status[i] == 1 && priorities[i] > priorities[initiator]) {
                //System.out.println("Election message is sent from Process " + (initiator + 1) + " to Process " + (i + 1));
                System.out.println("Election message is sent from Process " + (initiator + 1) + " to Process " + (i + 1));
                coordinator = i + 1; // Update coordinator
                if (i + 1 != numberOfProcesses) { // If there are higher priority processes
                    electCoordinator(i + 1); // Start election recursively from higher priority process
                }
            }
        }
    }
}
