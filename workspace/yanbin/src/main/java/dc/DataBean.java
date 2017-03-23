package dc;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


import org.apache.hadoop.io.Writable;

public class DataBean implements Writable{
	private String telNo;
	private long upPayLoad;
	private long downPayLoad;
	private long totalPayLoad;
	
	public DataBean(){}
	public DataBean(String telNo, long upPayLoad, long downPayLoad) {
		super();
		this.telNo = telNo;
		this.upPayLoad = upPayLoad;
		this.downPayLoad = downPayLoad;
		this.totalPayLoad = upPayLoad +downPayLoad;
	}

	
	//序列化
	//注意：１类型２顺序
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(telNo);
		out.writeLong(upPayLoad);
		out.writeLong(downPayLoad);
		out.writeLong(upPayLoad);
	}

	
	//反序列化　
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.telNo = in.readUTF();
		this.upPayLoad = in.readLong();
		this.downPayLoad = in.readLong();
		this.totalPayLoad = in.readLong();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.upPayLoad+"\t"+this.downPayLoad + "\t" +totalPayLoad;
	}
	public void setTel(String tel) {
		this.telNo = tel;
	}

	public long getUpPayLoad() {
		return upPayLoad;
	}

	public void setUpPayLoad(long upPayLoad) {
		this.upPayLoad = upPayLoad;
	}

	public long getDownPayLoad() {
		return downPayLoad;
	}

	public void setDownPayLoad(long downPayLoad) {
		this.downPayLoad = downPayLoad;
	}

	public long getTotalPayLoad() {
		return totalPayLoad;
	}

	public void setTotalPayLoad(long totalPayLoad) {
		this.totalPayLoad = totalPayLoad;
	}
	
}
