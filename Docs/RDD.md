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

