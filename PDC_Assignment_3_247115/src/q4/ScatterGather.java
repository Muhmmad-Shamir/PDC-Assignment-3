package q4;

import java.util.Arrays;
import mpi.MPI;

public class ScatterGather {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        if (size == 4) {
            int[] input = new int[16];
            int[] local = new int[4];
            int[] result = new int[16];

            // Rank 0 fills the input array with 1 through 16.
            if (rank == 0) {
                for (int i = 0; i < input.length; i++) {
                    input[i] = i + 1;
                }
            }

            // Each rank receives four consecutive integers.
            MPI.COMM_WORLD.Scatter(input, 0, 4, MPI.INT,
                                   local, 0, 4, MPI.INT, 0);

            System.out.println("Rank " + rank + " received "
                    + Arrays.toString(local));

            // Each rank doubles its own four integers.
            for (int i = 0; i < local.length; i++) {
                local[i] *= 2;
            }

            // Rank 0 collects the four blocks in rank order.
            MPI.COMM_WORLD.Gather(local, 0, 4, MPI.INT,
                                  result, 0, 4, MPI.INT, 0);

            if (rank == 0) {
                System.out.println("Final result: " + Arrays.toString(result));
            }
        } else if (rank == 0) {
            System.out.println("This program needs exactly 4 processes.");
        }

        MPI.Finalize();
    }
}