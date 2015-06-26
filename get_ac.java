import java.io.IOException; 
import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty; 
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.device.managementoperation.Controller;
import com.sonycsl.echo.eoj.device.airconditioner.HomeAirConditioner;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File; 
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class get_ac {

	public static void main(String[] args) {
		Echo.addEventListener(new Echo.EventListener() {
			public void onNewHomeAirConditioner(HomeAirConditioner device) {
				super.onNewHomeAirConditioner(device);
//				System.out.println("Home Air Conditioner found.") ;
      				Hoge.data_check = 1;
				device.setReceiver(new HomeAirConditioner.Receiver() {
					String mode;
//Location
					protected void onGetInstallationLocation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onGetInstallationLocation  (eoj, tid, esv, property, success) ;
//						System.out.println("Installation location : "+toHexStr(property.edt));
						System.out.print(toHexStr(property.edt) + ",");
					}
//Status
					protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onGetOperationStatus(eoj, tid, esv, property, success);
//						System.out.println("OperationStatus : "+toHexStr(property.edt));
						System.out.print(toHexStr(property.edt) + ",");
					}
//Mode
					protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onGetOperationModeSetting(eoj, tid, esv, property, success);
						mode = toHexStr(property.edt);
//						System.out.println("OperationMode : "+ mode);
						System.out.print(mode + ",");
					}
//Set temperature
					protected void onGetSetTemperatureValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onGetSetTemperatureValue(eoj, tid, esv, property, success);
						if(mode.equals( "41")  || mode.equals( "44")){
//							System.out.println("SetTemperatureValue : "+ toHexStr(property.edt));
							System.out.print("0,");
						} else {
							int fhex = Integer.parseInt(toHexStr(property.edt), 16);
//							System.out.println("SetTemperatureValue : "+ fhex + "degree");
							System.out.print(fhex + ",");
						}
					}
//Set Air flow
					protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onGetAirFlowRateSetting(eoj, tid, esv, property, success);
//						System.out.println("AirFlowRateSetting : "+ toHexStr(property.edt));
						System.out.print(toHexStr(property.edt) + ",");
					}
//Power consumption
					protected void onGetMeasuredCumulativePowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onGetMeasuredCumulativePowerConsumption(eoj, tid, esv, property, success) ;
						int fhex = Integer.parseInt(toHexStr(property.edt), 16);
//						System.out.println("MeasuredCumulativePowerConsumption : "+ fhex + "Wh");
						System.out.println(fhex);
					}
				});
			}
		});

//		while(Hoge.data_check!=1){
		for( int i = 0; i <5; i++){
			if(Hoge.data_check==1){
				break;
			}
			try {
				Echo.start( new DefaultNodeProfile(), new DeviceObject[] {
					new DefaultController()
				});
      				HomeAirConditioner.getG().reqGetInstallationLocation().reqGetOperationStatus().reqGetOperationModeSetting().reqGetSetTemperatureValue().reqGetAirFlowRateSetting().reqGetMeasuredCumulativePowerConsumption().send();
			}
			catch( IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//exit
		System.exit(0);
	}

	public static String toHexStr(byte[] arg) {
		String ret = "" ;
		for ( int i=0;i<arg.length;++i ) ret = ret + Integer.toHexString(arg[i] & 0xff) ;
		return ret ;
	}
}
