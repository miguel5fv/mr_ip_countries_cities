import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class CountryMapper extends MapReduceBase implements
    Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value,
      OutputCollector<Text, IntWritable> output, Reporter reporter)
      throws IOException {
    String s = value.toString();
        String[] fields = s.split("\\t+");

        // Ip is the column 3.
        String ip               = fields[3];
        IpDecoder decoder       = new IpDecoder();
        String city;

        try {
                city    = decoder.getCity(ip);
        } catch (Exception e) {
                city    = "unknown";
        }

        // Country code is the column 4
        output.collect(new Text(fields[4] + "\t" + city), new IntWritable(1));
  }
}
