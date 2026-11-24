# Reproduce the three runtime checks
Run from the repository root in PowerShell with MPJ_HOME set and a JDK on PATH.

~~~powershell
javac -cp "$env:MPJ_HOME/lib/mpj.jar" -d "$env:TEMP" q2/Q2RuntimeCheck.java
java -jar "$env:MPJ_HOME/lib/starter.jar" -np 2 -dev multicore -cp "$env:TEMP" Q2RuntimeCheck
java -jar "$env:MPJ_HOME/lib/starter.jar" -np 2 -dev multicore -cp "$env:TEMP" Q2RuntimeCheck alpha "two words"
java -jar "$env:MPJ_HOME/lib/starter.jar" -np 2 -dev multicore -cp "$env:TEMP" -Xmx128m Q2RuntimeCheck alpha "two words"
~~~

MPI.Init returns the application arguments following the class name. Both ranks share the multicore JVM and its heap limit.
