/*
 * Copyright 2012 Sony Computer Science Laboratories, Inc. <info@kadecot.net>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sonycsl.echo.eoj.device.cookinghousehold;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class CookingHeater extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03B9;

	public static final byte EPC_HEATING_STATUS = (byte)0xB1;
	public static final byte EPC_HEATING_SETTING = (byte)0xB2;
	public static final byte EPC_GALL_STOP_H_SETTING = (byte)0xB3;
	public static final byte EPC_HEATING_POWER_SETTING = (byte)0xE7;
	public static final byte EPC_HEATING_TEMPERATURE_SETTING = (byte)0xE3;
	public static final byte EPC_GHEATING_MODES_OF_STOVES_H_SETTING = (byte)0xE0;
	public static final byte EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS = (byte)0x96;
	public static final byte EPC_CHILD_LOCK_SETTING = (byte)0xA1;
	public static final byte EPC_RADIANT_HEATER_LOCK_SETTING = (byte)0xA2;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		removeStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_HEATING_STATUS);
		addSetProperty(EPC_GALL_STOP_H_SETTING);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewCookingHeater(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This  property  indicates  the  ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit :  �<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This  property  indicates  the  ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit :  �<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Heating status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Standing by: 0x40<br>
	 * Operating: 0x41<br>
	 * Temporarily stopped: 0x42<br>
	 * Heating prohibited: 0x50<br>
	 * Unknown: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 4<br>
	 * <br>
	 * Data size : 1 byte x 4<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getHeatingStatus();
	/**
	 * Property name : Heating status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Standing by: 0x40<br>
	 * Operating: 0x41<br>
	 * Temporarily stopped: 0x42<br>
	 * Heating prohibited: 0x50<br>
	 * Unknown: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 4<br>
	 * <br>
	 * Data size : 1 byte x 4<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidHeatingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Heating setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Left stove setting: right stove setting:<br>
	 * far-side stove setting: roaster setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Stop heating: 0x40<br>
	 * Start/resume heating: 0x41<br>
	 * Temporarily stop heating: 0x42<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHeatingSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heating setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Left stove setting: right stove setting:<br>
	 * far-side stove setting: roaster setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Stop heating: 0x40<br>
	 * Start/resume heating: 0x41<br>
	 * Temporarily stop heating: 0x42<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHeatingSetting() {return null;}
	/**
	 * Property name : Heating setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Left stove setting: right stove setting:<br>
	 * far-side stove setting: roaster setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Stop heating: 0x40<br>
	 * Start/resume heating: 0x41<br>
	 * Temporarily stop heating: 0x42<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHeatingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name :  gAll stop h setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Stop the heating on all of the left stove, right stove, far-side stove and roaster:<br>
	 * 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - undefined<br>
	 */
	protected abstract boolean setGallStopHSetting(byte[] edt);
	/**
	 * Property name :  gAll stop h setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Stop the heating on all of the left stove, right stove, far-side stove and roaster:<br>
	 * 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidGallStopHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Heating power setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of level (17<br>
	 * levels)                : 0x3000 to 0x3010<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of the state of flame:<br>
	 * Very low flame: 0x4002<br>
	 * Low flame: 0x4004<br>
	 * Medium flame: 0x4006<br>
	 * High flame: 0x4008<br>
	 * High power: 0x400a<br>
	 *  ENo setting: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char
x 4<br>
	 * <br>
	 * Data size : 2 byte x 4<br>
	 * <br>
	 * Unit : W Or Level Or
.<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHeatingPowerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heating power setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of level (17<br>
	 * levels)                : 0x3000 to 0x3010<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of the state of flame:<br>
	 * Very low flame: 0x4002<br>
	 * Low flame: 0x4004<br>
	 * Medium flame: 0x4006<br>
	 * High flame: 0x4008<br>
	 * High power: 0x400a<br>
	 *  ENo setting: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char
x 4<br>
	 * <br>
	 * Data size : 2 byte x 4<br>
	 * <br>
	 * Unit : W Or Level Or
.<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHeatingPowerSetting() {return null;}
	/**
	 * Property name : Heating power setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of level (17<br>
	 * levels)                : 0x3000 to 0x3010<br>
	 *  EWhen the heating powers are<br>
	 * specified in terms of the state of flame:<br>
	 * Very low flame: 0x4002<br>
	 * Low flame: 0x4004<br>
	 * Medium flame: 0x4006<br>
	 * High flame: 0x4008<br>
	 * High power: 0x400a<br>
	 *  ENo setting: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char
x 4<br>
	 * <br>
	 * Data size : 2 byte x 4<br>
	 * <br>
	 * Unit : W Or Level Or
.<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHeatingPowerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Heating temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Temperature setting: 0x32 to 0xFA (50<br>
	 * to 250  )<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 3<br>
	 * <br>
	 * Data size : 1 byte x 3<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHeatingTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heating temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Temperature setting: 0x32 to 0xFA (50<br>
	 * to 250  )<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 3<br>
	 * <br>
	 * Data size : 1 byte x 3<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHeatingTemperatureSetting() {return null;}
	/**
	 * Property name : Heating temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Temperature setting: 0x32 to 0xFA (50<br>
	 * to 250  )<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 3<br>
	 * <br>
	 * Data size : 1 byte x 3<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHeatingTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name :  gHeating modes of stoves h setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating power control mode: 0x41<br>
	 * Deep-frying mode (tempura, etc.):<br>
	 * 0x42<br>
	 * Water heating mode: 0x43<br>
	 * Rice boiling mode: 0x44<br>
	 * Stir-frying mode: 0x45<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 3<br>
	 * <br>
	 * Data size : 1 byte x 3<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGheatingModesOfStovesHSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gHeating modes of stoves h setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating power control mode: 0x41<br>
	 * Deep-frying mode (tempura, etc.):<br>
	 * 0x42<br>
	 * Water heating mode: 0x43<br>
	 * Rice boiling mode: 0x44<br>
	 * Stir-frying mode: 0x45<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 3<br>
	 * <br>
	 * Data size : 1 byte x 3<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGheatingModesOfStovesHSetting() {return null;}
	/**
	 * Property name :  gHeating modes of stoves h setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating power control mode: 0x41<br>
	 * Deep-frying mode (tempura, etc.):<br>
	 * 0x42<br>
	 * Water heating mode: 0x43<br>
	 * Rice boiling mode: 0x44<br>
	 * Stir-frying mode: 0x45<br>
	 * No setting: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
x 3<br>
	 * <br>
	 * Data size : 1 byte x 3<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGheatingModesOfStovesHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Relative time settings of OFF timers<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Used to set the relative time settings of<br>
	 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
	 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
	 * 4<br>
	 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
	 * No setting: 0xFFFFFF<br>
	 * <br>
	 * Data type : unsigned char
x 3 x 4<br>
	 * <br>
	 * Data size : 1 byte x 3
x 4<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRelativeTimeSettingsOfOffTimers(byte[] edt) {return false;}
	/**
	 * Property name : Relative time settings of OFF timers<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Used to set the relative time settings of<br>
	 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
	 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
	 * 4<br>
	 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
	 * No setting: 0xFFFFFF<br>
	 * <br>
	 * Data type : unsigned char
x 3 x 4<br>
	 * <br>
	 * Data size : 1 byte x 3
x 4<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRelativeTimeSettingsOfOffTimers() {return null;}
	/**
	 * Property name : Relative time settings of OFF timers<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Used to set the relative time settings of<br>
	 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
	 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
	 * 4<br>
	 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
	 * No setting: 0xFFFFFF<br>
	 * <br>
	 * Data type : unsigned char
x 3 x 4<br>
	 * <br>
	 * Data size : 1 byte x 3
x 4<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRelativeTimeSettingsOfOffTimers(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Child lock setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Child lock ON/OFF setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Child lock OFF: 0x40<br>
	 * Child lock ON: 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChildLockSetting(byte[] edt) {return false;}
	/**
	 * Property name : Child lock setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Child lock ON/OFF setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Child lock OFF: 0x40<br>
	 * Child lock ON: 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChildLockSetting() {return null;}
	/**
	 * Property name : Child lock setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Child lock ON/OFF setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Child lock OFF: 0x40<br>
	 * Child lock ON: 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChildLockSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Radiant heater lock setting<br>
	 * <br>
	 * EPC : 0xA2<br>
	 * <br>
	 * Contents of property :<br>
	 * Radiant heater lock ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Radiant heater lock OFF: 0x40<br>
	 * Radiant heater lock ON: 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRadiantHeaterLockSetting(byte[] edt) {return false;}
	/**
	 * Property name : Radiant heater lock setting<br>
	 * <br>
	 * EPC : 0xA2<br>
	 * <br>
	 * Contents of property :<br>
	 * Radiant heater lock ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Radiant heater lock OFF: 0x40<br>
	 * Radiant heater lock ON: 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRadiantHeaterLockSetting() {return null;}
	/**
	 * Property name : Radiant heater lock setting<br>
	 * <br>
	 * EPC : 0xA2<br>
	 * <br>
	 * Contents of property :<br>
	 * Radiant heater lock ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Radiant heater lock OFF: 0x40<br>
	 * Radiant heater lock ON: 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRadiantHeaterLockSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_HEATING_SETTING : return setHeatingSetting(property.edt);
		case EPC_GALL_STOP_H_SETTING : return setGallStopHSetting(property.edt);
		case EPC_HEATING_POWER_SETTING : return setHeatingPowerSetting(property.edt);
		case EPC_HEATING_TEMPERATURE_SETTING : return setHeatingTemperatureSetting(property.edt);
		case EPC_GHEATING_MODES_OF_STOVES_H_SETTING : return setGheatingModesOfStovesHSetting(property.edt);
		case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS : return setRelativeTimeSettingsOfOffTimers(property.edt);
		case EPC_CHILD_LOCK_SETTING : return setChildLockSetting(property.edt);
		case EPC_RADIANT_HEATER_LOCK_SETTING : return setRadiantHeaterLockSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_HEATING_STATUS : return getHeatingStatus();
		case EPC_HEATING_SETTING : return getHeatingSetting();
		case EPC_HEATING_POWER_SETTING : return getHeatingPowerSetting();
		case EPC_HEATING_TEMPERATURE_SETTING : return getHeatingTemperatureSetting();
		case EPC_GHEATING_MODES_OF_STOVES_H_SETTING : return getGheatingModesOfStovesHSetting();
		case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS : return getRelativeTimeSettingsOfOffTimers();
		case EPC_CHILD_LOCK_SETTING : return getChildLockSetting();
		case EPC_RADIANT_HEATER_LOCK_SETTING : return getRadiantHeaterLockSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_HEATING_STATUS : return isValidHeatingStatus(property.edt);
		case EPC_HEATING_SETTING : return isValidHeatingSetting(property.edt);
		case EPC_GALL_STOP_H_SETTING : return isValidGallStopHSetting(property.edt);
		case EPC_HEATING_POWER_SETTING : return isValidHeatingPowerSetting(property.edt);
		case EPC_HEATING_TEMPERATURE_SETTING : return isValidHeatingTemperatureSetting(property.edt);
		case EPC_GHEATING_MODES_OF_STOVES_H_SETTING : return isValidGheatingModesOfStovesHSetting(property.edt);
		case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS : return isValidRelativeTimeSettingsOfOffTimers(property.edt);
		case EPC_CHILD_LOCK_SETTING : return isValidChildLockSetting(property.edt);
		case EPC_RADIANT_HEATER_LOCK_SETTING : return isValidRadiantHeaterLockSetting(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return new Setter(this, true, false);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(this, responseRequired, false);
	}

	@Override
	public Getter get() {
		return new Getter(this, false);
	}

	@Override
	public Informer inform() {
		return new Informer(this, !isProxy());
	}
	
	@Override
	protected Informer inform(boolean multicast) {
		return new Informer(this, multicast);
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_HEATING_SETTING : 
				onSetHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GALL_STOP_H_SETTING : 
				onSetGallStopHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_POWER_SETTING : 
				onSetHeatingPowerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_TEMPERATURE_SETTING : 
				onSetHeatingTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GHEATING_MODES_OF_STOVES_H_SETTING : 
				onSetGheatingModesOfStovesHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS : 
				onSetRelativeTimeSettingsOfOffTimers(eoj, tid, esv, property, success);
				return true;
			case EPC_CHILD_LOCK_SETTING : 
				onSetChildLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RADIANT_HEATER_LOCK_SETTING : 
				onSetRadiantHeaterLockSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_HEATING_STATUS : 
				onGetHeatingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_SETTING : 
				onGetHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_POWER_SETTING : 
				onGetHeatingPowerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_TEMPERATURE_SETTING : 
				onGetHeatingTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GHEATING_MODES_OF_STOVES_H_SETTING : 
				onGetGheatingModesOfStovesHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS : 
				onGetRelativeTimeSettingsOfOffTimers(eoj, tid, esv, property, success);
				return true;
			case EPC_CHILD_LOCK_SETTING : 
				onGetChildLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RADIANT_HEATER_LOCK_SETTING : 
				onGetRadiantHeaterLockSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Standing by: 0x40<br>
		 * Operating: 0x41<br>
		 * Temporarily stopped: 0x42<br>
		 * Heating prohibited: 0x50<br>
		 * Unknown: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 1 byte x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove setting: right stove setting:<br>
		 * far-side stove setting: roaster setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop heating: 0x40<br>
		 * Start/resume heating: 0x41<br>
		 * Temporarily stop heating: 0x42<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove setting: right stove setting:<br>
		 * far-side stove setting: roaster setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop heating: 0x40<br>
		 * Start/resume heating: 0x41<br>
		 * Temporarily stop heating: 0x42<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gAll stop h setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop the heating on all of the left stove, right stove, far-side stove and roaster:<br>
		 * 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - undefined<br>
		 */
		protected void onSetGallStopHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of level (17<br>
		 * levels)                : 0x3000 to 0x3010<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of the state of flame:<br>
		 * Very low flame: 0x4002<br>
		 * Low flame: 0x4004<br>
		 * Medium flame: 0x4006<br>
		 * High flame: 0x4008<br>
		 * High power: 0x400a<br>
		 *  ENo setting: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 2 byte x 4<br>
		 * <br>
		 * Unit : W Or Level Or
.<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHeatingPowerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of level (17<br>
		 * levels)                : 0x3000 to 0x3010<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of the state of flame:<br>
		 * Very low flame: 0x4002<br>
		 * Low flame: 0x4004<br>
		 * Medium flame: 0x4006<br>
		 * High flame: 0x4008<br>
		 * High power: 0x400a<br>
		 *  ENo setting: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 2 byte x 4<br>
		 * <br>
		 * Unit : W Or Level Or
.<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHeatingPowerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Temperature setting: 0x32 to 0xFA (50<br>
		 * to 250  )<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Temperature setting: 0x32 to 0xFA (50<br>
		 * to 250  )<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gHeating modes of stoves h setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power control mode: 0x41<br>
		 * Deep-frying mode (tempura, etc.):<br>
		 * 0x42<br>
		 * Water heating mode: 0x43<br>
		 * Rice boiling mode: 0x44<br>
		 * Stir-frying mode: 0x45<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gHeating modes of stoves h setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power control mode: 0x41<br>
		 * Deep-frying mode (tempura, etc.):<br>
		 * 0x42<br>
		 * Water heating mode: 0x43<br>
		 * Rice boiling mode: 0x44<br>
		 * Stir-frying mode: 0x45<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time settings of OFF timers<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Used to set the relative time settings of<br>
		 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
		 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
		 * 4<br>
		 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
		 * No setting: 0xFFFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 3 x 4<br>
		 * <br>
		 * Data size : 1 byte x 3
x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time settings of OFF timers<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Used to set the relative time settings of<br>
		 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
		 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
		 * 4<br>
		 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
		 * No setting: 0xFFFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 3 x 4<br>
		 * <br>
		 * Data size : 1 byte x 3
x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Child lock setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Child lock ON/OFF setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Child lock OFF: 0x40<br>
		 * Child lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChildLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Child lock setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Child lock ON/OFF setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Child lock OFF: 0x40<br>
		 * Child lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChildLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Radiant heater lock setting<br>
		 * <br>
		 * EPC : 0xA2<br>
		 * <br>
		 * Contents of property :<br>
		 * Radiant heater lock ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Radiant heater lock OFF: 0x40<br>
		 * Radiant heater lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRadiantHeaterLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Radiant heater lock setting<br>
		 * <br>
		 * EPC : 0xA2<br>
		 * <br>
		 * Contents of property :<br>
		 * Radiant heater lock ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Radiant heater lock OFF: 0x40<br>
		 * Radiant heater lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRadiantHeaterLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(EchoObject eoj, boolean responseRequired, boolean multicast) {
			super(eoj, responseRequired, multicast);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
		}
		
		@Override
		public Setter reqSetOperationStatus(byte[] edt) {
			return (Setter)super.reqSetOperationStatus(edt);
		}
		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}
		@Override
		public Setter reqSetCurrentLimitSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimitSetting(edt);
		}
		@Override
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			return (Setter)super.reqSetPowerSavingOperationSetting(edt);
		}
		@Override
		public Setter reqSetPositionInformation(byte[] edt) {
			return (Setter)super.reqSetPositionInformation(edt);
		}
		@Override
		public Setter reqSetCurrentTimeSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentTimeSetting(edt);
		}
		@Override
		public Setter reqSetCurrentDateSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentDateSetting(edt);
		}
		@Override
		public Setter reqSetPowerLimitSetting(byte[] edt) {
			return (Setter)super.reqSetPowerLimitSetting(edt);
		}
		
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove setting: right stove setting:<br>
		 * far-side stove setting: roaster setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop heating: 0x40<br>
		 * Start/resume heating: 0x41<br>
		 * Temporarily stop heating: 0x42<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHeatingSetting(byte[] edt) {
			addProperty(EPC_HEATING_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gAll stop h setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop the heating on all of the left stove, right stove, far-side stove and roaster:<br>
		 * 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetGallStopHSetting(byte[] edt) {
			addProperty(EPC_GALL_STOP_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of level (17<br>
		 * levels)                : 0x3000 to 0x3010<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of the state of flame:<br>
		 * Very low flame: 0x4002<br>
		 * Low flame: 0x4004<br>
		 * Medium flame: 0x4006<br>
		 * High flame: 0x4008<br>
		 * High power: 0x400a<br>
		 *  ENo setting: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 2 byte x 4<br>
		 * <br>
		 * Unit : W Or Level Or
.<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHeatingPowerSetting(byte[] edt) {
			addProperty(EPC_HEATING_POWER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Heating temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Temperature setting: 0x32 to 0xFA (50<br>
		 * to 250  )<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gHeating modes of stoves h setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power control mode: 0x41<br>
		 * Deep-frying mode (tempura, etc.):<br>
		 * 0x42<br>
		 * Water heating mode: 0x43<br>
		 * Rice boiling mode: 0x44<br>
		 * Stir-frying mode: 0x45<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGheatingModesOfStovesHSetting(byte[] edt) {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Relative time settings of OFF timers<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Used to set the relative time settings of<br>
		 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
		 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
		 * 4<br>
		 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
		 * No setting: 0xFFFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 3 x 4<br>
		 * <br>
		 * Data size : 1 byte x 3
x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRelativeTimeSettingsOfOffTimers(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS, edt);
			return this;
		}
		/**
		 * Property name : Child lock setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Child lock ON/OFF setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Child lock OFF: 0x40<br>
		 * Child lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChildLockSetting(byte[] edt) {
			addProperty(EPC_CHILD_LOCK_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Radiant heater lock setting<br>
		 * <br>
		 * EPC : 0xA2<br>
		 * <br>
		 * Contents of property :<br>
		 * Radiant heater lock ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Radiant heater lock OFF: 0x40<br>
		 * Radiant heater lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRadiantHeaterLockSetting(byte[] edt) {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
		}
		
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		
		@Override
		public Getter reqGetOperationStatus() {
			return (Getter)super.reqGetOperationStatus();
		}
		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}
		@Override
		public Getter reqGetStandardVersionInformation() {
			return (Getter)super.reqGetStandardVersionInformation();
		}
		@Override
		public Getter reqGetIdentificationNumber() {
			return (Getter)super.reqGetIdentificationNumber();
		}
		@Override
		public Getter reqGetMeasuredInstantaneousPowerConsumption() {
			return (Getter)super.reqGetMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Getter reqGetMeasuredCumulativePowerConsumption() {
			return (Getter)super.reqGetMeasuredCumulativePowerConsumption();
		}
		@Override
		public Getter reqGetManufacturersFaultCode() {
			return (Getter)super.reqGetManufacturersFaultCode();
		}
		@Override
		public Getter reqGetCurrentLimitSetting() {
			return (Getter)super.reqGetCurrentLimitSetting();
		}
		@Override
		public Getter reqGetFaultStatus() {
			return (Getter)super.reqGetFaultStatus();
		}
		@Override
		public Getter reqGetFaultDescription() {
			return (Getter)super.reqGetFaultDescription();
		}
		@Override
		public Getter reqGetManufacturerCode() {
			return (Getter)super.reqGetManufacturerCode();
		}
		@Override
		public Getter reqGetBusinessFacilityCode() {
			return (Getter)super.reqGetBusinessFacilityCode();
		}
		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}
		@Override
		public Getter reqGetProductionNumber() {
			return (Getter)super.reqGetProductionNumber();
		}
		@Override
		public Getter reqGetProductionDate() {
			return (Getter)super.reqGetProductionDate();
		}
		@Override
		public Getter reqGetPowerSavingOperationSetting() {
			return (Getter)super.reqGetPowerSavingOperationSetting();
		}
		@Override
		public Getter reqGetPositionInformation() {
			return (Getter)super.reqGetPositionInformation();
		}
		@Override
		public Getter reqGetCurrentTimeSetting() {
			return (Getter)super.reqGetCurrentTimeSetting();
		}
		@Override
		public Getter reqGetCurrentDateSetting() {
			return (Getter)super.reqGetCurrentDateSetting();
		}
		@Override
		public Getter reqGetPowerLimitSetting() {
			return (Getter)super.reqGetPowerLimitSetting();
		}
		@Override
		public Getter reqGetCumulativeOperatingTime() {
			return (Getter)super.reqGetCumulativeOperatingTime();
		}
		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			return (Getter)super.reqGetStatusChangeAnnouncementPropertyMap();
		}
		@Override
		public Getter reqGetSetPropertyMap() {
			return (Getter)super.reqGetSetPropertyMap();
		}
		@Override
		public Getter reqGetGetPropertyMap() {
			return (Getter)super.reqGetGetPropertyMap();
		}
		
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Standing by: 0x40<br>
		 * Operating: 0x41<br>
		 * Temporarily stopped: 0x42<br>
		 * Heating prohibited: 0x50<br>
		 * Unknown: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 1 byte x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove setting: right stove setting:<br>
		 * far-side stove setting: roaster setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop heating: 0x40<br>
		 * Start/resume heating: 0x41<br>
		 * Temporarily stop heating: 0x42<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of level (17<br>
		 * levels)                : 0x3000 to 0x3010<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of the state of flame:<br>
		 * Very low flame: 0x4002<br>
		 * Low flame: 0x4004<br>
		 * Medium flame: 0x4006<br>
		 * High flame: 0x4008<br>
		 * High power: 0x400a<br>
		 *  ENo setting: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 2 byte x 4<br>
		 * <br>
		 * Unit : W Or Level Or
.<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHeatingPowerSetting() {
			addProperty(EPC_HEATING_POWER_SETTING);
			return this;
		}
		/**
		 * Property name : Heating temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Temperature setting: 0x32 to 0xFA (50<br>
		 * to 250  )<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHeatingTemperatureSetting() {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name :  gHeating modes of stoves h setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power control mode: 0x41<br>
		 * Deep-frying mode (tempura, etc.):<br>
		 * 0x42<br>
		 * Water heating mode: 0x43<br>
		 * Rice boiling mode: 0x44<br>
		 * Stir-frying mode: 0x45<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGheatingModesOfStovesHSetting() {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING);
			return this;
		}
		/**
		 * Property name : Relative time settings of OFF timers<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Used to set the relative time settings of<br>
		 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
		 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
		 * 4<br>
		 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
		 * No setting: 0xFFFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 3 x 4<br>
		 * <br>
		 * Data size : 1 byte x 3
x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRelativeTimeSettingsOfOffTimers() {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS);
			return this;
		}
		/**
		 * Property name : Child lock setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Child lock ON/OFF setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Child lock OFF: 0x40<br>
		 * Child lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChildLockSetting() {
			addProperty(EPC_CHILD_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Radiant heater lock setting<br>
		 * <br>
		 * EPC : 0xA2<br>
		 * <br>
		 * Contents of property :<br>
		 * Radiant heater lock ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Radiant heater lock OFF: 0x40<br>
		 * Radiant heater lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRadiantHeaterLockSetting() {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
		}
		
		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
		}
				@Override
		public Informer reqInformOperationStatus() {
			return (Informer)super.reqInformOperationStatus();
		}
		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}
		@Override
		public Informer reqInformStandardVersionInformation() {
			return (Informer)super.reqInformStandardVersionInformation();
		}
		@Override
		public Informer reqInformIdentificationNumber() {
			return (Informer)super.reqInformIdentificationNumber();
		}
		@Override
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			return (Informer)super.reqInformMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			return (Informer)super.reqInformMeasuredCumulativePowerConsumption();
		}
		@Override
		public Informer reqInformManufacturersFaultCode() {
			return (Informer)super.reqInformManufacturersFaultCode();
		}
		@Override
		public Informer reqInformCurrentLimitSetting() {
			return (Informer)super.reqInformCurrentLimitSetting();
		}
		@Override
		public Informer reqInformFaultStatus() {
			return (Informer)super.reqInformFaultStatus();
		}
		@Override
		public Informer reqInformFaultDescription() {
			return (Informer)super.reqInformFaultDescription();
		}
		@Override
		public Informer reqInformManufacturerCode() {
			return (Informer)super.reqInformManufacturerCode();
		}
		@Override
		public Informer reqInformBusinessFacilityCode() {
			return (Informer)super.reqInformBusinessFacilityCode();
		}
		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}
		@Override
		public Informer reqInformProductionNumber() {
			return (Informer)super.reqInformProductionNumber();
		}
		@Override
		public Informer reqInformProductionDate() {
			return (Informer)super.reqInformProductionDate();
		}
		@Override
		public Informer reqInformPowerSavingOperationSetting() {
			return (Informer)super.reqInformPowerSavingOperationSetting();
		}
		@Override
		public Informer reqInformPositionInformation() {
			return (Informer)super.reqInformPositionInformation();
		}
		@Override
		public Informer reqInformCurrentTimeSetting() {
			return (Informer)super.reqInformCurrentTimeSetting();
		}
		@Override
		public Informer reqInformCurrentDateSetting() {
			return (Informer)super.reqInformCurrentDateSetting();
		}
		@Override
		public Informer reqInformPowerLimitSetting() {
			return (Informer)super.reqInformPowerLimitSetting();
		}
		@Override
		public Informer reqInformCumulativeOperatingTime() {
			return (Informer)super.reqInformCumulativeOperatingTime();
		}
		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			return (Informer)super.reqInformStatusChangeAnnouncementPropertyMap();
		}
		@Override
		public Informer reqInformSetPropertyMap() {
			return (Informer)super.reqInformSetPropertyMap();
		}
		@Override
		public Informer reqInformGetPropertyMap() {
			return (Informer)super.reqInformGetPropertyMap();
		}
		
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Standing by: 0x40<br>
		 * Operating: 0x41<br>
		 * Temporarily stopped: 0x42<br>
		 * Heating prohibited: 0x50<br>
		 * Unknown: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 1 byte x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove setting: right stove setting:<br>
		 * far-side stove setting: roaster setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop heating: 0x40<br>
		 * Start/resume heating: 0x41<br>
		 * Temporarily stop heating: 0x42<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of level (17<br>
		 * levels)                : 0x3000 to 0x3010<br>
		 *  EWhen the heating powers are<br>
		 * specified in terms of the state of flame:<br>
		 * Very low flame: 0x4002<br>
		 * Low flame: 0x4004<br>
		 * Medium flame: 0x4006<br>
		 * High flame: 0x4008<br>
		 * High power: 0x400a<br>
		 *  ENo setting: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 4<br>
		 * <br>
		 * Data size : 2 byte x 4<br>
		 * <br>
		 * Unit : W Or Level Or
.<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHeatingPowerSetting() {
			addProperty(EPC_HEATING_POWER_SETTING);
			return this;
		}
		/**
		 * Property name : Heating temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Temperature setting: 0x32 to 0xFA (50<br>
		 * to 250  )<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHeatingTemperatureSetting() {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name :  gHeating modes of stoves h setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power control mode: 0x41<br>
		 * Deep-frying mode (tempura, etc.):<br>
		 * 0x42<br>
		 * Water heating mode: 0x43<br>
		 * Rice boiling mode: 0x44<br>
		 * Stir-frying mode: 0x45<br>
		 * No setting: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
x 3<br>
		 * <br>
		 * Data size : 1 byte x 3<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGheatingModesOfStovesHSetting() {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING);
			return this;
		}
		/**
		 * Property name : Relative time settings of OFF timers<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Used to set the relative time settings of<br>
		 * the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers.<br>
		 * (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~<br>
		 * 4<br>
		 * (= 0 to 23) : (= 0 to 59): (= 0 to 59)<br>
		 * No setting: 0xFFFFFF<br>
		 * <br>
		 * Data type : unsigned char
x 3 x 4<br>
		 * <br>
		 * Data size : 1 byte x 3
x 4<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRelativeTimeSettingsOfOffTimers() {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS);
			return this;
		}
		/**
		 * Property name : Child lock setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Child lock ON/OFF setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Child lock OFF: 0x40<br>
		 * Child lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChildLockSetting() {
			addProperty(EPC_CHILD_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Radiant heater lock setting<br>
		 * <br>
		 * EPC : 0xA2<br>
		 * <br>
		 * Contents of property :<br>
		 * Radiant heater lock ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Radiant heater lock OFF: 0x40<br>
		 * Radiant heater lock ON: 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRadiantHeaterLockSetting() {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING);
			return this;
		}
	}

	public static class Proxy extends CookingHeater {
		private byte mInstanceCode;
		public Proxy(byte instanceCode) {
			super();
			mInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mInstanceCode;
		}
		@Override
		protected byte[] getOperationStatus() {return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt) {return false;}
		@Override
		protected byte[] getInstallationLocation() {return null;}
		@Override
		protected byte[] getStandardVersionInformation() {return null;}
		@Override
		protected byte[] getFaultStatus() {return null;}
		@Override
		protected byte[] getManufacturerCode() {return null;}
		@Override
		protected byte[] getHeatingStatus() {return null;}
		@Override
		protected boolean setGallStopHSetting(byte[] edt) {return false;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return new Setter(new Proxy(instanceCode), true, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(new Proxy(instanceCode), responseRequired, true);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(new Proxy(instanceCode), true);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(new Proxy(instanceCode), true);
	}

}
