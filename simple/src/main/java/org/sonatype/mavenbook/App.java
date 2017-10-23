package org.sonatype.mavenbook;

import java.net.*; 
import org.springframework.cloud.commons.util.*;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* import org.json.*; */
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
 
/**
 * Hello world!
 *
 */
public class App 
{
/*    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception  // UnknownHostException 
    {
		InetAddress Address = InetAddress.getLocalHost(); 
		System.out.println(Address); 
		
		// try (InetUtils utils = new InetUtils(new InetUtilsProperties())) {
			InetUtils utils = new InetUtils(new InetUtilsProperties());
			System.out.println("new InetUtils");
			InetUtils.HostInfo hostInfo = utils.findFirstNonLoopbackHostInfo();
			System.out.println("HostInfo");
			String hostName = hostInfo.getHostname();
			String ipAddress = hostInfo.getIpAddress();
			System.out.println("hostname = " + hostName + "; IP Addr = \n" + ipAddress); 
		// }
		
        /*if (args.length != 3)
        {
            System.err.println("give command as follows : ");
            System.err.println("XSLTTest data.xml converted.xsl converted.html");
            return;
        }
        String dataXML = args[0];
        String inputXSL = args[1];
        String outputHTML = args[2];
 
        App st = new App();
        try
        {
            st.transform(dataXML, inputXSL, outputHTML);
        }
        catch (TransformerConfigurationException e)
        {
            System.err.println("TransformerConfigurationException");
            System.err.println(e);
        }
        catch (TransformerException e)
        {
            System.err.println("TransformerException");
            System.err.println(e);
        }*/
    }
 
    public void transform(String dataXML, String inputXSL, String outputHTML)
            throws TransformerConfigurationException,
            TransformerException
    {
 
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(inputXSL);
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in = new StreamSource(dataXML);
        StreamResult out = new StreamResult(outputHTML);
        transformer.transform(in, out);
        System.out.println("The generated HTML file is:" + outputHTML);

		String str = "{'name':'JSON','integer':1,'double':2.0,'boolean':true,'nested':{'id':'知我者谓我心忧，不知我者谓我何求？'},'array':[1,2,3]}";
		JSONObject json = new JSONObject(str);
		String xml = XML.toString(json);
		System.out.println(xml); 
		
		int PRETTY_PRINT_INDENT_FACTOR = 4;
		String TEST_XML_STRING = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON 中文</test>";

		JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
        String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        System.out.println(jsonPrettyPrintString);
    }

}
