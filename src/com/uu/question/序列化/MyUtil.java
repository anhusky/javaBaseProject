package com.uu.question.序列化;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyUtil {
	private MyUtil() {
		throw new AssertionError();
	}

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) throws Exception {
		// ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String objName = obj.getClass().getName();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:/" + objName + ".serial"));
		oos.writeObject(obj);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:/" + objName + ".serial"));
		return (T) ois.readObject();
	}
}
