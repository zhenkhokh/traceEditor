package ru.android.zheka.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

public class Config extends Model{

	@Column(name = "name")
	public String name;
	@Column(name = "optimization")
	public Boolean optimization;
	@Column(name = "travelmode")
	public String travelMode;
	@Column(name = "updatelocation")
	public Boolean uLocation;
	@Column(name = "updateTime")
	public String tenMSTime;
	@Column(name = "avoid")
	public String avoid;
	@Column(name = "reserved1")// do not modify name
	public String bellmanFord;//can be renamed
	@Column(name = "reserved2")
	public String address;
	@Column(name = "reserved3")
	public String rateLimit_ms;
	@Column(name = "reserved4")
	public String offline;
	//@Column(name = "reserved5")
	//public String reserved5;

	public String toString(){
		StringBuilder sb = new StringBuilder();
		return sb.append("name: "+name)
				.append(" optimization:"+optimization)
				.append(" travelMode:"+travelMode)
				.append(" show coordinate changing:"+uLocation)
				.append(" update location time:"+tenMSTime)
				.append(" avoid:"+avoid)
				.append(" bellmanFord:"+bellmanFord)
				.append(" address:"+address)
				.append(" rateLimit_ms:"+rateLimit_ms)
				.append(" offline:"+offline)
				.toString();
	}
}
