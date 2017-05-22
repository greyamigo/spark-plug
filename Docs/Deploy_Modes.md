### Deploy Mode

#### Deploy mode specifies the location of where driver executes in the deployment environment.

Deploy mode can be one of the following options:

1. ***Client (default)*** - the driver runs on the machine that the Spark application was launched.
2. ***Cluster*** - the driver runs on a random node in a cluster.


What are the practical differences between Spark Standalone client deploy mode and cluster deploy mode? What are the pro's and con's of using each one?
Let's try to look at the differences between client and cluster mode.

#### Client:

* Driver runs on a dedicated server (Master node) inside a dedicated process. This means it has all available resources at it's disposal to execute work.
* Driver opens up a dedicated Netty HTTP server and distributes the JAR files specified to all Worker nodes (big advantage).
* Because the Master node has dedicated resources of it's own, you don't need to "spend" worker resources for the Driver program.
* If the driver process dies, you need an external monitoring system to reset it's execution.

#### Cluster:

* Driver runs on one of the cluster's Worker nodes. The worker is chosen by the Master leader
* Driver runs as a dedicated, standalone process inside the Worker.
* Driver programs takes up at least 1 core and a dedicated amount of memory from one of the workers (this can be configured).
* Driver program can be monitored from the Master node using the --supervise flag and be reset in case it if it fails with non-zero exit code. ( with Spark Standalone Cluster)
* When working in Cluster mode, all JARs related to the execution of your application need to be publicly available to all the workers. This means you can either manually place them in a shared place or in a folder for each of the workers.
