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

public class advanced {
	public static void main(String[] args) {
  Echo.addEventListener(new Echo.EventListener() {
    public void onNewHomeAirConditioner(HomeAirConditioner device) {
      super.onNewHomeAirConditioner(device);
      Hoge.data_check = 1;
    System.out.println("check_data2:" + Hoge.data_check);
      device.setReceiver(new HomeAirConditioner.Receiver() {
        String mode;
        //Location
        protected void onGetInstallationLocation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
          super.onGetInstallationLocation  (eoj, tid, esv, property, success) ;
          System.out.print(toHexStr(property.edt) + ",");
        }
        //Status
        protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
          super.onGetOperationStatus(eoj, tid, esv, property, success);
          System.out.print(toHexStr(property.edt) + ",");
        }
        //Mode
        protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
          super.onGetOperationModeSetting(eoj, tid, esv, property, success);
          mode = toHexStr(property.edt);
          System.out.print(mode + ",");
        }
        //Set temperature
        protected void onGetSetTemperatureValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
          super.onGetSetTemperatureValue(eoj, tid, esv, property, success);
          if (mode.equals( "41")  || mode.equals( "44")) {
            System.out.print("0,");
          } 
          else {
            int fhex = Integer.parseInt(toHexStr(property.edt), 16);
            System.out.print(fhex + ",");
          }
        }
        //Set Air flow
        protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
          super.onGetAirFlowRateSetting(eoj, tid, esv, property, success);
          System.out.println(toHexStr(property.edt) + ".");
        }
      }
      );
    }
  }
  );

  while (Hoge.data_check!=1) {
    try {
      Echo.start( new DefaultNodeProfile(), new DeviceObject[] {
        new DefaultController()
      }
      );

      HomeAirConditioner.getG().reqGetInstallationLocation().reqGetOperationStatus().reqGetOperationModeSetting().reqGetSetTemperatureValue().reqGetAirFlowRateSetting().send();
    } 
    catch( IOException e) { 
      e.printStackTrace();
    }
    System.out.println("Started") ;
    System.out.println("check_data:" + Hoge.data_check);

    // 10秒待つ
    try { 
      Thread.sleep(10000);
    } 
    catch (InterruptedException e) { 
      e.printStackTrace();
    }
  }
      System.out.println("Good Job!");

}

public static String toHexStr(byte[] arg) {
  String ret = "" ;
  for ( int i=0;i<arg.length;++i ) ret = ret + Integer.toHexString(arg[i] & 0xff) ;
  return ret ;
}
}

