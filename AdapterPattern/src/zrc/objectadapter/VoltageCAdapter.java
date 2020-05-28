package zrc.objectadapter;

public class VoltageCAdapter implements IVoltage5V{

	
	private Voltage220V voltage220V;
	
	public VoltageCAdapter(Voltage220V voltage220v) {
		this.voltage220V = voltage220v;
	}

	@Override
	public int output5V() {
		// TODO Auto-generated method stub
		int dst = 0;
		if(null != voltage220V) {
			int src = voltage220V.output220V();
			dst = src / 44;
		}
		return dst;
	}
	
}
