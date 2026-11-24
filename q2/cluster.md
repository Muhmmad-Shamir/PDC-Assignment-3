# Machines file
Use one hostname or IP address per line. The supplied machines file lists only this laptop.
For a two-node lab, replace its contents with the two actual reachable hostnames, one per line.
Launch from the directory containing machines when using the default machines file.

## Windows daemon lifecycle
On each Windows compute node, use mpjdaemon.bat -boot, then mpjdaemon.bat -status.
After the job has finished, use mpjdaemon.bat -halt on each node.
The installed batch file queries localhost for status. These commands are reference notes.
