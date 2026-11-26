package q3;

import mpi.MPI;

public class PingPong {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        if (size == 2) {
            System.out.println("Rank " + rank + " is ready out of " + size + " processes.");
            int[] counter = {0};

            if (rank == 0) {
                MPI.COMM_WORLD.Send(counter, 0, 1, MPI.INT, 1, 0);
                System.out.println("Rank 0 sent " + counter[0]);
                
                MPI.COMM_WORLD.Recv(counter, 0, 1, MPI.INT, 1, 1);
                System.out.println("Rank 0 received back " + counter[0]);
            } else {
                MPI.COMM_WORLD.Recv(counter, 0, 1, MPI.INT, 0, 0);
                System.out.println("Rank 1 received " + counter[0]);
                
                counter[0]++;         
                MPI.COMM_WORLD.Send(counter, 0, 1, MPI.INT, 0, 1);
                System.out.println("Rank 1 sent back " + counter[0]);
            }
        } else if (rank == 0) {
            System.out.println("Ping-pong needs exactly 2 processes. Set np to 2.");
        }

        MPI.Finalize();
    }
}