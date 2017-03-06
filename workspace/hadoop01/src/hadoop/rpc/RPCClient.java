package hadoop.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RPCClient {
	public static void main (String [ ] args) throws IOException{
		Bizable proxy = RPC.getProxy(Bizable.class, 10010, new InetSocketAddress("192.168.1.100",9527),new Configuration());
		String result = proxy.sayHi("tomcat");
		System.out.println(result);
		RPC.stopProxy(proxy);
	}
}
