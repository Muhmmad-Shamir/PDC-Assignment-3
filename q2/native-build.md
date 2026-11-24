# Visual Studio build notes for nativempjdev.dll
Create an empty C++ project named nativempjdev. Select Dynamic Library (.dll) and the platform matching the JVM and MS-MPI SDK.
Add the C files and associated headers listed in evidence/q2/jni-inputs.txt. For an empty project, leave precompiled headers disabled.

## Compile and link
Under C/C++ > General > Additional Include Directories, add the JDK include and include/win32 directories and the MS-MPI SDK Include directory.
Under Linker > General > Additional Library Directories, add the matching MS-MPI SDK library directory (for example Lib/x64).
Under Linker > Input > Additional Dependencies, add msmpi.lib.
Build the selected configuration. After a successful build copy nativempjdev.dll from the output folder to MPJ_HOME/lib.
