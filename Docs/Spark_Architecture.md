### Spark uses a master/worker architecture.

**_There is a driver that talks to a single coordinator called master that manages workers in which executors run._**

![Architecture - Simple](Pics/Spark-architecture-spark-website.png)

#### A Spark driver (aka an application’s driver process):
  * hosts SparkContext for a Spark application
  * control point of jobs and tasks executions
  * hosts web UI
  * splits a Spark application into tasks and schedules them to run on executors
  * is alive still end of the spark application or vice-versa

#### Executor is a distributed agent that is responsible for executing tasks.

 * Executor typically runs for the entire lifetime of a Spark application which is called static allocation of executors,
     but you could also opt in for [dynamic allocation]
 * Executors reports heartbeat and partial metrics for active tasks to HeartbeatReceiver RPC Endpoint on the driver.
 * Executors provide in-memory storage for RDDs that are cached in Spark applications (via Block Manager).


#### Cluster Managers : Spark currently supports three cluster managers

1. Standalone – a simple cluster manager included with Spark that makes it easy to set up a cluster.
2. Apache Mesos – a general cluster manager that can also run Hadoop MapReduce and service applications.
3. Hadoop YARN – the resource manager in Hadoop 2.



[dynamic allocation]: _Unlike the "traditional" static allocation where a Spark application reserves CPU and memory 
      resources upfront (irrespective of how much it may eventually use), in dynamic allocation you get as much as 
      needed and no more. It scales the number of executors up and down based on workload, i.e. idle executors are 
      removed, and when there are pending tasks waiting for executors to be launched on, dynamic allocation requests them._
