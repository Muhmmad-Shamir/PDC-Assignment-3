# Machines file
Use one hostname or IP address per line. The supplied machines file lists only this laptop.
For a two-node lab, replace its contents with the two actual reachable hostnames, one per line.
Launch from the directory containing machines when using the default machines file.

## Windows daemon lifecycle
On each Windows compute node, use mpjdaemon.bat -boot, then mpjdaemon.bat -status.
After the job has finished, use mpjdaemon.bat -halt on each node.
The installed batch file queries localhost for status. These commands are reference notes.

## Cleaning processes
The installed Windows batch wrapper supports boot, status and halt.
On supported Unix hosts the separate mpjclean machines wrapper passes the machines file to the daemon manager with -clean.
Cleanup can affect other Java workloads. Check node ownership and running jobs first.
