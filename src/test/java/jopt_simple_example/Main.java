package jopt_simple_example;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by laurent.picquet on 22/06/2017.
 */
public class Main {

    @Test
    public void main() throws IOException {
        // test command line args, as they would be passed to a main method
        String[] args = new String[]{"-s", "--long", "aValueForLong", "-l", "anotherValueForLong"};

        // define the options parser
        OptionParser optionParser = new OptionParser();
        optionParser.acceptsAll(Arrays.asList("s", "short"),"short description").withOptionalArg().describedAs("a short argument");
        optionParser.acceptsAll(Arrays.asList("l", "long"), "something long").withOptionalArg().describedAs("a long argument").required();

        // parse the command line arguments
        OptionSet optionSet = optionParser.parse(args);

        // query if options were passed or not
        Assert.assertTrue(optionSet.has("s"));
        Assert.assertTrue(optionSet.has("long"));
        Assert.assertFalse(optionSet.has("something"));

        // retrieve the values
        Assert.assertEquals("", Arrays.asList("aValueForLong", "anotherValueForLong"), optionSet.valuesOf("long"));

        optionParser.printHelpOn(System.out);

    }




}

