// IN2011 Computer Networks
// Coursework 2023/2024
//
// Submission by
// YOUR_NAME_GOES_HERE
// YOUR_STUDENT_ID_NUMBER_GOES_HERE
// YOUR_EMAIL_GOES_HERE


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

// DO NOT EDIT starts
interface TemporaryNodeInterface {
    public boolean start(String startingNodeName, String startingNodeAddress);
    public boolean store(String key, String value);
    public String get(String key);
}
// DO NOT EDIT ends


public class TemporaryNode implements TemporaryNodeInterface {

    public boolean start(String startingNodeName, String startingNodeAddress) {
        try {
            // Split the startingNodeAddress into host and port
            String[] addressParts = startingNodeAddress.split(":");
            String host = addressParts[0];
            int port = Integer.parseInt(addressParts[1]);

            // Create a socket to connect to the starting node
            Socket socket = new Socket(host, port);

            // Example of sending a START message, adjust based on the actual protocol
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("START <protocol_version> " + startingNodeName + "\n");
            writer.flush();

            // Assume connection is successful if no exception is thrown
            // You might want to read the response from the server to confirm connection
            // Close the resources after use or keep them open if you plan to reuse the socket
            socket.close();

            return true;
        } catch (IOException e) {
            // Handle exceptions, such as unknown host or no server listening on the given port
            return false;
        }
    }

    public boolean store(String key, String value) {
	// Implement this!
	// Return true if the store worked
	// Return false if the store failed
	return true;
    }

    public String get(String key) {
	// Implement this!
	// Return the string if the get worked
	// Return null if it didn't
	return "Not implemented";
    }
}
