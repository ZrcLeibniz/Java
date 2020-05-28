package client;

import sheep.DeepCloneableTarget;
import sheep.DeepProtoType;

public class DeepClient {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		DeepProtoType deepProtoType = new DeepProtoType();
		deepProtoType.name = "Ф��";
		deepProtoType.deepCloneableTarget = new DeepCloneableTarget("Ф����ë", "ë");
		DeepProtoType clone = (DeepProtoType)deepProtoType.deepClone();
		System.out.println(clone == deepProtoType);
		System.out.println(deepProtoType.deepCloneableTarget == clone.deepCloneableTarget);
	}

}
