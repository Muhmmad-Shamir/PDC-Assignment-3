# Q3 viva notes

## Trace one round

Both processes call `MPI.Init(args)` and use `COMM_WORLD.Size()` to check for two participants. Each calls `COMM_WORLD.Rank()` to select its role. Rank 0 sends one integer to rank 1 with tag 0. Rank 1 receives it, increments its local buffer, and sends the reply with tag 1. Rank 0 receives that reply into its own buffer. On the last round rank 0 sends 9 and receives 10. Both ranks then leave the loop and call `MPI.Finalize()`.

## Point-to-point and collective communication

Each ping-pong message has a specific sender and receiver. `Send()` and `Recv()` are point-to-point calls. A collective such as `Scatter()` requires every member of the communicator to call the corresponding operation, including the root.

## Which communicator?

- `MPI.COMM_WORLD` includes both processes in this run. Their ranks are 0 and 1.
- `MPI.COMM_SELF` includes just the caller. Its rank in that communicator is always 0.
- `MPI.COMM_NULL` represents an invalid communicator handle and cannot carry a message.
