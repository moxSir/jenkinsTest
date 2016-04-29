package com.protobuftest.protobuf;

import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;
import com.protobuftest.protobuf.PersonProbuf.Person;
import com.protobuftest.protobuf.PersonProbuf.Person.PhoneNumber;

public class Test {
	public static void main(String[] args) {
		PersonProbuf.Person.Builder builder = PersonProbuf.Person.newBuilder();
		builder.setEmail("ys0798@163.com");
		builder.setId(1);
		builder.setName("TestName");
		
		builder.addPhone(PersonProbuf.Person.PhoneNumber.newBuilder()
				.setNumber("131111111")
				.setType(PersonProbuf.Person.PhoneType.MOBILE));
		builder.addPhone(PersonProbuf.Person.PhoneNumber.newBuilder()
				.setNumber("011111")
				.setType(PersonProbuf.Person.PhoneType.HOME));
		Person person = builder.build();
		Person.PhoneNumber number = person.getPhone(1);
		System.out.println(number.getNumber()+"******");
		byte[] buf = person.toByteArray();

		try {
			Person person2 = PersonProbuf.Person.parseFrom(buf);
			System.out.println(person2.getName() + ", " + person2.getEmail());
			List<PhoneNumber> lstPhones = person2.getPhoneList();
			for (PhoneNumber phoneNumber : lstPhones) {
				System.out.println(phoneNumber.getNumber());
			}
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(buf.toString());
	}
}
