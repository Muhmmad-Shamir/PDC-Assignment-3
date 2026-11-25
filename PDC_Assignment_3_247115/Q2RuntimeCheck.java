import mpi.MPI;
import java.util.Arrays;

public class Q2RuntimeCheck {
    public static void main(String[] args) throws Exception {
        String[] userArgs = MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        long heapMiB = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        System.out.println("rank=" + rank + " args=" + Arrays.toString(userArgs) + " maxHeapMiB=" + heapMiB);
        MPI.Finalize();
    }
}