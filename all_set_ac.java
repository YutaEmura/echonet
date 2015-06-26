import com.sonycsl.echo.Echo; 
import com.sonycsl.echo.EchoProperty; 
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject; 
import com.sonycsl.echo.eoj.profile.NodeProfile; 
import com.sonycsl.echo.eoj.device.airconditioner.HomeAirConditioner;
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

public class all_set_ac {

	public static void main(final String[] args) {
		try {
			Echo.start( new DefaultNodeProfile(),new DeviceObject[]{new DefaultController()});
//Echo.start isは3番20pで説明されてる，ex.3-a
			if(args[0] == null){
				System.err.println("Please type a command.");
				System.exit(-1);
			} else switch(args[0]){
				case "status":
					switch(args[1]){
					//ここ！！　だいじですね　ここさえやればOK　ex3-a
	  					case "ON":
							HomeAirConditioner.setG().reqSetOperationStatus( new byte[]{0x30}).send();
							break;
						case "OFF":
							HomeAirConditioner.setG().reqSetOperationStatus( new byte[]{0x31}).send();
							break;
						default:
							System.err.println("status error!");
							System.exit(-1);
					}
					break;
				case "mode":
					switch(args[1]){
						case "Automatic":
							HomeAirConditioner.setG().reqSetOperationModeSetting( new byte[]{0x41}).send();
							break;
						case "Cooling":
							HomeAirConditioner.setG().reqSetOperationModeSetting( new byte[]{0x42}).send();
							break;
						case "Heating":
							HomeAirConditioner.setG().reqSetOperationModeSetting( new byte[]{0x43}).send();
							break;
						case "Dehumidification":
							HomeAirConditioner.setG().reqSetOperationModeSetting( new byte[]{0x44}).send();
							break;
						case "Air_circulator":
							HomeAirConditioner.setG().reqSetOperationModeSetting( new byte[]{0x45}).send();
							break;
						default:
							System.err.println("mode error!");
							System.exit(-1);
					}
					break;
				case "temp":
					if(args[1] != null){
						byte[] bf = toStrHex(Integer.toHexString(Integer.parseInt(args[1])));
						HomeAirConditioner.setG().reqSetSetTemperatureValue(bf).send();
					}
					break;
				case "air":
					if(args[1] != null){
						switch(args[1]){
							case "Automatic":
								HomeAirConditioner.setG().reqSetAirFlowRateSetting( new byte[]{0x41}).send();
								break;
							default:
								byte[] bf = toStrHex(args[1]);
								HomeAirConditioner.setG().reqSetAirFlowRateSetting(bf).send();
						}
					}
					break;
				case "location":
					if(args[1] != null){
						byte[] bf = toStrHex(args[1]);
						HomeAirConditioner.setG().reqSetInstallationLocation(bf).send();
						System.out.println("location command was sent.");
					}
					break;
				default:
					System.err.println("Please type a correct command.");
					System.exit(-1);
			}
			//exit
			try{
				Thread.sleep(10000);
				//待つ
			} catch(Exception e){
				e.printStackTrace();

			}
			System.exit(0);
		} catch( IOException e){
			e.printStackTrace();
			System.err.println("Echonet lite error");
			//exit
			System.exit(-1);
		}
//		System.out.println("Started") ;
	}
	public static byte[] toStrHex(String hex) {
		byte[] bytes = new byte[hex.length() / 2];
		for (int index = 0; index < bytes.length; index++) {
			bytes[index] = (byte) Integer.parseInt(hex.substring(index * 2, (index + 1) * 2), 16);
		}
		return bytes;
	}
}
