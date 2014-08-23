package com.ts.mapreduce.index;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.record.Index;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class IndexDriver extends Configured implements Tool{

	public int run(String[] arg0) throws Exception {
		Configuration conf =getConf();
		Job job = new Job(conf, "Indexing Job");
		job.setJarByClass(Index.class);
		return 0;
	}
	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
		ToolRunner.run(config,new IndexDriver(), args);
	}
}
