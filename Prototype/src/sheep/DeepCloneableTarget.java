package sheep;

import java.io.Serializable;

public class DeepCloneableTarget implements Cloneable, Serializable {

	private String cloneName;
	private String cloneClass;

	public DeepCloneableTarget(String cloneName, String cloneClass) {
		super();
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();

	}

}
