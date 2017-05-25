### RDD

**A Resilient Distributed Dataset (RDD), the basic abstraction in Spark.**

Represents an immutable, partitioned collection of elements that can be operated on in parallel. 

All operations are automatically available on any RDD of the right type (e.g. RDD[(Int, Int)] through implicit.

Internally, each RDD is characterized by ***five*** main properties:

1. A list of partitions 
2. A function for computing each split 
3. A list of dependencies on other RDDs 
4. Optionally, a Partitioner for key-value RDDs (e.g. to say that the RDD is hash-partitioned) 
5. Optionally, a list of preferred locations to compute each split on (e.g. block locations for an HDFS file)

Some other behaviours / features of RDDS

1. Lazyly evaluated
2. Immutable
3. Compile time type-safe


and some crazier properties of :

1. Cannot be Optimized by Spark, the lambda is opaque 

    ```
     parsedRDD.reduceByKey( _ + _ )
        .filter {case (project, numRequet) => == "en"  }
        .take(100)
        .foreach(println)
        
        
     /* the filter if done before the reduce would have saved 
         a whole lot of network trasfer and 
         unnecessary data getting processed */
    ```
2. Slow on Non-JVM languages like Python
3. Lower Level API
  