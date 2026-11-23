package q1;

import mpi.MPI;

public class RankDemo {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        System.out.println("My rank is " + rank + " out of " + size);

    }
}
