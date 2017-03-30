package rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;
public class RPCServer implements Bizable{ //定义了一个接口叫Bizable
	
	//RPC里面应该有一个方法，我的客户端【不同进程】可以调用我这里的方法，于是我写一个方法
	public String sayHi(String name){
		return "HI~ " + name;
	}
	public static void main(String[] args) throws Exception {
		//我现在要使用Hadoop提供的工具类来完成RPC通信，【如果不用工具类，自己写底层很麻烦】
		Configuration conf = new Configuration();
	Server server=	new RPC.Builder(conf).setProtocol(Bizable.class).setInstance(new RPCServer()).setBindAddress("192.168.1.100").setPort(9527).build();   //每个都set一下，暂时还没有完全看懂。待2刷
		server.start();
	}
}