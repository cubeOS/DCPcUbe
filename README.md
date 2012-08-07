#DCPcUbe

##About
DCPcUbe is a Java-based emulator for DCPU-16 that is currently in development.

##Arguments
```bash
--disk path/to/file
  alias: -d path/to/file
--emulate path/to/file
  alias: -e path/to/file
--help
  alias: -h
```

##Running DCPcUbe
Running DCPcUbe is easy. You can use any of the arguments above. For example:
```bash
java -jar DCPcUbe.jar --e path/to/file
```
You can also emulate multiple files!
```bash
java -jar DCPcUbe.jar -e path/to/first/file -e path/to/second/file
```
Let's say you want to add more disks. You can do that!
```bash
java -jar DCPcUbe.jar -e path/to/file -d path/to/file
```
You can have multiple disks for each emulation you specify to run. The possibilities are *endless*!