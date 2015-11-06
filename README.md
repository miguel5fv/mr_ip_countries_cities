This Map Reduces works over a set of data where each column is separated by a **TAB** (\t).

We don't care if there are more than four, but at least must have four. And the fields we are going to process are the columns number 3 and 4. In our case we expect to use the ip and country code

```
2015 hostname1.com xx.xx.xx.xx Country_code_1
2014 hostname2.net yy.yy.yy.yy Country_code_2
```

To execute it you first needs to compile java class. We have to indicate the classpath of hadoop core classes and the external library we need, json. You could find it in this link: http://mvnrepository.com/artifact/org.json/json

`javac -classpath $HADOOP_HOME/hadoop-core.jar:lib/json.jar *.java`

Pack at them into a JAR file:

`jar cvf ipCountry.jar *.class`

And then add and execute the jar using Hadoop. In this case we use a command called -libsjar where indicate the external libs, like JSON:

`hadoop jar program_count.jar IpCountry libjars lib/json.jar  set-of-logs path-destination`
