Steps to execute spark-plug in a centos image
=============================================

 * ``docker pull centos``
 * ``docker run -it centos:latest bash``
 * ``yum install git``
 * ``git clone https://github.com/greyamigo/spark-plug.git``
 * ``cd spark-plug/``
 * ``curl https://bintray.com/sbt/rpm/rpm | tee /etc/yum.repos.d/bintray-sbt-rpm.repo``
 * ``yum install sbt``
 * ``yum install java``
 * ``sbt compile``
 * ``sbt package``
 * ``yum install wget``
 * ``wget http://d3kbcqa49mib13.cloudfront.net/spark-2.0.0-bin-hadoop2.7.tgz``
 * ``tar xf spark-2.0.0-bin-hadoop2.7.tgz``
 * ``mkdir /usr/local/spark``
 * ``mv -r spark-2.0.0-bin-hadoop2.7/* /usr/local/spark``
 * ``mv  spark-2.0.0-bin-hadoop2.7/* /usr/local/spark``
 * ``PATH=$PATH:$HOME/bin:/usr/local/spark/bin``
 * ``source ~/.bash_profile``
 * ``spark-submit target/scala-2.11/spark-plug_2.11-1.0.jar --local README.md``
