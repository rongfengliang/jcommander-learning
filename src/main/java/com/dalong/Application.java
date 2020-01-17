package com.dalong;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class Application {
    @Parameter(names={"--length", "-l"},help = true,required =true ,description = "this is length info")
    int length;
    @Parameter(names={"--pattern", "-p"},help = true,required =true ,description = "this is pattern info")
    int pattern;
    @Parameter(names = "--help", help = true)
    private boolean help;
    public static void main(String[] args) {
        Application main = new Application();
        JCommander jct =  JCommander.newBuilder()
                .addObject(main)
                .build();
        jct.setProgramName("demo app");
        try {
            jct.parse(args);
            if (main.help) {
                jct.usage();
                return;
            }
            main.run();
        }
        catch (ParameterException parameterException ){
            System.out.printf(parameterException.toString());
           jct.usage();
        }

    }
    public void run() {
        System.out.printf("%d %d", length, pattern);
    }
}
