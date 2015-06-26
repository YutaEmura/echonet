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

public class indivisual_set_ac{
	public static void main(String[] args){
		final String number =  args[0];
		final String command =  args[1];
		final String value =  args[2];
		if (value == null){
			System.out.println("Please set InstallationLocation Command Value.");
			System.exit(-1);
		}
		Echo.addEventListener(new Echo.EventListener(){
		//2 Eventlistenerを登録している
			public void onNewHomeAirConditioner (HomeAirConditioner device){
				System.out.println( "HomeAirConditioner found.");
				device.setReceiver(new HomeAirConditioner.Receiver(){
					protected void onGetInstallationLocation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onGetInstallationLocation(eoj, tid, esv, property, success);
						String num = "";
						num = toHexStr(property.edt);
						System.out.print("InstallationLocation: ");
						System.out.println(num);
						if(!num.equals(number)){
							System.out.println("Different InstallationLocation");
							return;
						}
						try{
							((HomeAirConditioner)eoj).set().reqSetOperationStatus(new byte[]{0x30}).send();
							switch(command){
								case "status":
									switch(value){
										case "ON":
											((HomeAirConditioner)eoj).set().reqSetOperationStatus( new byte[]{0x30}).send();
											break;
										case "OFF":
											((HomeAirConditioner)eoj).set().reqSetOperationStatus( new byte[]{0x31}).send();
											break;
										default:
											System.err.println("status error!");
											System.exit(-1);
									}
									break;
								case "mode":
									switch(value){
										case "Automatic":
											((HomeAirConditioner)eoj).set().reqSetOperationModeSetting( new byte[]{0x41}).send();
											break;
										case "Cooling":
											((HomeAirConditioner)eoj).set().reqSetOperationModeSetting( new byte[]{0x42}).send();
											break;
										case "Heating":
											((HomeAirConditioner)eoj).set().reqSetOperationModeSetting( new byte[]{0x43}).send();
											break;
										case "Dehumidification":
											((HomeAirConditioner)eoj).set().reqSetOperationModeSetting( new byte[]{0x44}).send();
											break;
										case "Air_circulator":
											((HomeAirConditioner)eoj).set().reqSetOperationModeSetting( new byte[]{0x45}).send();
											break;
										default:
											System.err.println("mode error!");
											System.exit(-1);
									}
									break;
								case "temp":
									byte[] bf = toStrHex(Integer.toHexString(Integer.parseInt(value)));
									((HomeAirConditioner)eoj).set().reqSetSetTemperatureValue(bf).send();
									break;
								case "air":
									switch(value){
										case "Automatic":
											((HomeAirConditioner)eoj).set().reqSetAirFlowRateSetting( new byte[]{0x41}).send();
											break;
										default:
											bf = toStrHex(value);
											((HomeAirConditioner)eoj).set().reqSetAirFlowRateSetting(bf).send();
									}
									break;
								case "location":
									bf = toStrHex(value);
									((HomeAirConditioner)eoj).set().reqSetInstallationLocation(bf).send();
									break;
								default:
									System.err.println("Please type a correct command.");
									System.exit(-1);
							}
						}catch( IOException e) {
							e.printStackTrace();
						}
					}
					protected void onSetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onSetOperationStatus(eoj, tid, esv, property,success);
						System.out.println("Status command was sent.");
						System.exit(0);
					}
					protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onSetOperationModeSetting(eoj, tid, esv, property,success);
						System.out.println("Mode command was sent.");
						System.exit(0);
					}
					protected void onSetSetTemperatureValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onSetSetTemperatureValue(eoj, tid, esv, property,success);
						System.out.println("Temp command was sent.");
						System.exit(0);
					}
					protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
						super.onSetAirFlowRateSetting(eoj, tid, esv, property,success);
						System.out.println("Air command was sent.");
						System.exit(0);
					}
				});
				try{
					device.get().reqGetInstallationLocation().send() ;
				} 
				catch(IOException e){
					e.printStackTrace();
				};
			}
		});
		try{
			Echo.start( new DefaultNodeProfile(), new DeviceObject[] {new DefaultController()});
			NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
		}catch( IOException e){
			e.printStackTrace();
		}
		System.out.println("Started");
	}

	public static String toHexStr(byte[] arg){
		String ret = "";
		for ( int i=0;i<arg.length;++i ){
			ret = ret + Integer.toHexString(arg[i] & 0xff);
		}
		return ret;
	}

	public static byte[] toStrHex(String hex) {
		byte[] bytes = new byte[hex.length() / 2];
		for (int index = 0; index < bytes.length; index++) {
			bytes[index] = (byte) Integer.parseInt(hex.substring(index * 2, (index + 1) * 2), 16);
		}
		return bytes;
	}
}
