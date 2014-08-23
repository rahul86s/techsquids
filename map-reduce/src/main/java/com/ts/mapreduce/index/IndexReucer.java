package com.ts.mapreduce.index;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class IndexReucer extends Reducer<LongWritable, Text, NullWritable, Text>{
static enum Counter{COUNT}
static final char SEPARATOR=0x001;
	@Override
	protected void setup(
			Reducer<LongWritable, Text, NullWritable, Text>.Context context)
			throws IOException, InterruptedException {
		context.getCounter(Counter.COUNT).setValue(0);
		super.setup(context);
	}
@Override
protected void reduce(LongWritable key, Iterable<Text> value,Reducer<LongWritable, Text, NullWritable, Text>.Context context)
			throws IOException, InterruptedException {
		Long counter = context.getCounter(Counter.COUNT).getValue();
		context.write(NullWritable.get(), new Text(String.format("%d%c%s", counter,SEPARATOR,value.iterator().next())));
		context.getCounter(Counter.COUNT).increment(1);;
}
}
