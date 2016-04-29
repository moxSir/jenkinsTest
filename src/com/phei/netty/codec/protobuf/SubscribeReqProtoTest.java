package com.phei.netty.codec.protobuf;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;

public class SubscribeReqProtoTest {
	private static byte[] encode(SubscribeReqProto.SubecribeReq req){
		return req.toByteArray();
	}
	private static SubscribeReqProto.SubecribeReq decode(byte[] body) throws InvalidProtocolBufferException{
		return SubscribeReqProto.SubecribeReq.parseFrom(body);
	}
	
	private static SubscribeReqProto.SubecribeReq createSubscribeReq(){
		SubscribeReqProto.SubecribeReq.Builder builder = SubscribeReqProto.SubecribeReq.newBuilder();
		builder.setSubReqID(1);
		builder.setUserName("tom");
		builder.setProductName("Netty Book");
		List<String> address  = new ArrayList<>();
		address.add("NanJing YuHuaTai");
		address.add("BeiJing LiuLiChang");
		address.add("ShenZhen HongShuLin");
		builder.addAllAddres(address);
		return builder.build();
	}
	public static void main(String[] args) throws InvalidProtocolBufferException {
		SubscribeReqProto.SubecribeReq subecribeReq = createSubscribeReq();
		System.out.println("Before encode :"+subecribeReq.toString());
		SubscribeReqProto.SubecribeReq subecribeReq2 = decode(encode(subecribeReq));
		System.out.println("After decode :"+subecribeReq.toString());
		System.out.println("Assert equal:"+subecribeReq.equals(subecribeReq2));
	}
}
