# MPJ Express 0.44 driver notes
Source: README-win.txt in the installed distribution.

| Device | Communication |
| --- | --- |
| niodev | Each rank runs in a JVM. Ranks communicate through Java NIO sockets. |
| hybdev | Ranks on the same node use shared memory. Communication across nodes uses a network device. |
| native | Java calls the installed native MPI implementation through JNI. The Windows distribution documents MS-MPI. |
