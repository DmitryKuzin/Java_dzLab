package file;


import com.sun.xml.internal.bind.v2.runtime.output.XMLStreamWriterOutput;
import com.thoughtworks.xstream.XStream;
import core.Library;

import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.Date;

/**
 * Created by kuzin on 9/30/2015.
 */
public class Writer {
    static int count=0;
    public static void writeLib(Library lib) throws IOException {
        try (FileOutputStream fout = new FileOutputStream("./lib"+count+".dat");
             ObjectOutputStream out = new ObjectOutputStream(fout)) {        // ????? ??? ?????? (????????????) ????????
            out.writeObject(lib);
        }
        count++;
    }
    public static void writeLibXml(Library lib) throws IOException{
        XStream xstream=new XStream();
        testTextIO(xstream.toXML(lib));
    }
    private static void testTextIO(String s) throws IOException {
        try (FileOutputStream fin = new FileOutputStream("./testXML.txt");
             PrintWriter pw = new PrintWriter(fin)) {                // ????? ?????? ??? ????????? ??????
            pw.write(s);
        }
    }
}
