package zrc.classadapter;

public class VoltageCAdapter extends Voltage220V implements IVoltage5V{

	@Override
	public int output5V() {
		// TODO Auto-generated method stub
		int srcV = 220;
		int dstV = srcV / 44;
		return dstV;
	}
	
}
