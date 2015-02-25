package finchserve;


import java.io.*;
import java.util.*;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;



/**
 *
 * @author Peabody
 */
public class CommTool {

    static CommPortIdentifier portId;
    static Enumeration portList;
    InputStream inputStream;
    SerialPort serialPort;
    Thread readThread;

    public CommTool() {
        int count = 0;
        portList = CommPortIdentifier.getPortIdentifiers();
        System.out.println("Port List: ");
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            count++;
                System.out.println(count + ". " + portId.getName());
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                
//                if (portId.getName().equals("COM1")) {
//                    //                if (portId.getName().equals("/dev/term/a")) {
//                    //SimpleRead reader = new SimpleRead();
//                }
            }
        }
    }
}
