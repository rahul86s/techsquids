package com.ts.mapreduce.index;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class IndexMapper extends Mapper<Object , Text, LongWritable, Text>{
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, LongWritable, Text>.Context context)
			throws IOException, InterruptedException {
		System.out.println(key.toString());
		context.write(new LongWritable(Long.parseLong(key.toString())), value);
	}

}
