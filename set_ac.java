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

public class set_ac {

	public static void main(final String[] args) {
		Echo.addEventListener(new Echo.EventListener() {
			public void onNewHomeAirConditioner (HomeAirConditioner device){
				super.onNewHomeAirConditioner (device);
				System.out.println( "HomeAirConditioner found.");
				try {
					if(args[0] == null){
						System.out.println("Please type a command.");
					} else switch(args[0]){
						case "on":
	      						device.set().reqSetOperationStatus( new byte[]{0x30}).send();
							break;
						case "off":
							device.set().reqSetOperationStatus( new byte[]{0x31}).send();
							break;
						case "mode":
							device.set().reqSetOperationModeSetting( new byte[]{0x41}).send();
							break;
						case "temp":
							if(args[1] != null){
								device.set().reqSetSetTemperatureValue(new byte[]{0x1C}).send();
							}
							break;
						case "air":
							if(args[1] != null){
								byte [] sb = args[1].getBytes();
								device.set().reqSetAirFlowRateSetting( new byte[]{0x35}).send();
							}
							break;
						default:
							System.out.println("Please type a correct command.");
					}
				} catch(IOException e){
					e.printStackTrace();
				}
				System.out.println("Set command was sent.");
				//exit
				System.exit(0);
			}
		});
	
		try {
			Echo.start( new DefaultNodeProfile(),new DeviceObject[]{new DefaultController()});
			NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
		} catch( IOException e){
			e.printStackTrace();
		}
		System.out.println("Started") ;
	}
}
