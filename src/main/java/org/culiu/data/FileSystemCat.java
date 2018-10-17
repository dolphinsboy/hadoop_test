package org.culiu.data;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;

public class FileSystemCat {
    public static void main(String args[]) throws Exception{
        String uri = "hdfs://qbj3-op-hadoop-001:9000/user/hadoop/output/part-r-00000";

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        InputStream in = null;
        try{
            in = fs.open(new Path(uri));
            IOUtils.copyBytes(in, System.out, 4096, false);
        }finally {
            IOUtils.closeStream(in);
        }

    }
}
