package q3;

import mpi.MPI;

public class PingPong {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        if (size == 2) {
            System.out.println("Rank " + rank + " is ready out of " + size + " processes.");
        } else if (rank == 0) {
            System.out.println("Ping-pong needs exactly 2 processes. Set np to 2.");
        }

        MPI.Finalize();
    }
}