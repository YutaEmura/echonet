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
package com.sonycsl.echo.eoj.device.audiovisual;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class Display extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0601;

	public static final byte EPC_DISPLAY_CONTROL_SETTING = (byte)0xB0;
	public static final byte EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS = (byte)0xB1;
	public static final byte EPC_SUPPORTED_CHARACTER_CODES = (byte)0xB2;
	public static final byte EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER = (byte)0xB3;
	public static final byte EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED = (byte)0xB4;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS);
		addGetProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS);
		addGetProperty(EPC_SUPPORTED_CHARACTER_CODES);
		addSetProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER);
		addGetProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewDisplay(this);
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
	 * This property indicates the ON/OFF status of the weighing machine operation<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationStatus(byte[] edt);
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status of the weighing machine operation<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Display control setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Displaying enabled: 0x30<br>
	 * Displaying disabled: 0x31<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDisplayControlSetting(byte[] edt) {return false;}
	/**
	 * Property name : Display control setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Displaying enabled: 0x30<br>
	 * Displaying disabled: 0x31<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDisplayControlSetting() {return null;}
	/**
	 * Property name : Display control setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Displaying enabled: 0x30<br>
	 * Displaying disabled: 0x31<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDisplayControlSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Character string setting acceptance status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ready: 0x30        Busy: 0x31<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getCharacterStringSettingAcceptanceStatus();
	/**
	 * Property name : Character string setting acceptance status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ready: 0x30        Busy: 0x31<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCharacterStringSettingAcceptanceStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Supported character codes<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0   ANSI X3.4<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 1   Shift-JIS Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 2   JIS Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 3   Japanese EUC Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 4   UCS-4<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 5   UCS-2<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 6   Latin-1<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 7   UTF-8<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 8 and succeeding bits:<br>
	 * for future reserved    0<br>
	 * <br>
	 * Data type : unsigne d char ~
2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getSupportedCharacterCodes();
	/**
	 * Property name : Supported character codes<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0   ANSI X3.4<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 1   Shift-JIS Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 2   JIS Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 3   Japanese EUC Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 4   UCS-4<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 5   UCS-2<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 6   Latin-1<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 7   UTF-8<br>
	 * Implemented: 1<br>
	 * Not implemented: 0<br>
	 * Bit 8 and succeeding bits:<br>
	 * for future reserved    0<br>
	 * <br>
	 * Data type : unsigne d char ~
2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidSupportedCharacterCodes(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Character string to present to the user<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
	 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
	 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
	 * string to present to the user.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
	 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
	 * code sequence of the character string to present to the user (max.<br>
	 * 244 bytes)<br>
	 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
	 * ANSI X3.4=0x01<br>
	 * Shift .JIS=0x02<br>
	 * JIS =0x03<br>
	 * Japanese EUC=0x04<br>
	 * UCS-4 =0x05<br>
	 * UCS-2 =0x06<br>
	 * Latin -1=0x07<br>
	 * UTF-8=0x08<br>
	 * 0x09 and succeeding values = for future reserved<br>
	 * <br>
	 * Data type : unsigne d    char
 ~
Max
247<br>
	 * <br>
	 * Data size : Max247
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - optional<br>
	 */
	protected abstract boolean setCharacterStringToPresentToTheUser(byte[] edt);
	/**
	 * Property name : Character string to present to the user<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
	 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
	 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
	 * string to present to the user.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
	 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
	 * code sequence of the character string to present to the user (max.<br>
	 * 244 bytes)<br>
	 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
	 * ANSI X3.4=0x01<br>
	 * Shift .JIS=0x02<br>
	 * JIS =0x03<br>
	 * Japanese EUC=0x04<br>
	 * UCS-4 =0x05<br>
	 * UCS-2 =0x06<br>
	 * Latin -1=0x07<br>
	 * UTF-8=0x08<br>
	 * 0x09 and succeeding values = for future reserved<br>
	 * <br>
	 * Data type : unsigne d    char
 ~
Max
247<br>
	 * <br>
	 * Data size : Max247
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - optional<br>
	 */
	protected byte[] getCharacterStringToPresentToTheUser() {return null;}
	/**
	 * Property name : Character string to present to the user<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
	 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
	 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
	 * string to present to the user.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
	 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
	 * code sequence of the character string to present to the user (max.<br>
	 * 244 bytes)<br>
	 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
	 * ANSI X3.4=0x01<br>
	 * Shift .JIS=0x02<br>
	 * JIS =0x03<br>
	 * Japanese EUC=0x04<br>
	 * UCS-4 =0x05<br>
	 * UCS-2 =0x06<br>
	 * Latin -1=0x07<br>
	 * UTF-8=0x08<br>
	 * 0x09 and succeeding values = for future reserved<br>
	 * <br>
	 * Data type : unsigne d    char
 ~
Max
247<br>
	 * <br>
	 * Data size : Max247
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCharacterStringToPresentToTheUser(byte[] edt) {
		if(edt == null || !(edt.length <= 247)) return false;
		return true;
	}
	/**
	 * Property name : Length of character
string accepted<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the total number of bytes of the newest character string to present to the<br>
	 * user which has been set and is being held.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: 0x00 to 0xF4<br>
	 * Second byte: 0x00 (for future reserved)<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getLengthOfCharacterStringAccepted();
	/**
	 * Property name : Length of character
string accepted<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the total number of bytes of the newest character string to present to the<br>
	 * user which has been set and is being held.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: 0x00 to 0xF4<br>
	 * Second byte: 0x00 (for future reserved)<br>
	 * <br>
	 * Data type : unsigne d char<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidLengthOfCharacterStringAccepted(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_DISPLAY_CONTROL_SETTING : return setDisplayControlSetting(property.edt);
		case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER : return setCharacterStringToPresentToTheUser(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DISPLAY_CONTROL_SETTING : return getDisplayControlSetting();
		case EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS : return getCharacterStringSettingAcceptanceStatus();
		case EPC_SUPPORTED_CHARACTER_CODES : return getSupportedCharacterCodes();
		case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER : return getCharacterStringToPresentToTheUser();
		case EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED : return getLengthOfCharacterStringAccepted();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DISPLAY_CONTROL_SETTING : return isValidDisplayControlSetting(property.edt);
		case EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS : return isValidCharacterStringSettingAcceptanceStatus(property.edt);
		case EPC_SUPPORTED_CHARACTER_CODES : return isValidSupportedCharacterCodes(property.edt);
		case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER : return isValidCharacterStringToPresentToTheUser(property.edt);
		case EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED : return isValidLengthOfCharacterStringAccepted(property.edt);
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
			case EPC_DISPLAY_CONTROL_SETTING : 
				onSetDisplayControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER : 
				onSetCharacterStringToPresentToTheUser(eoj, tid, esv, property, success);
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
			case EPC_DISPLAY_CONTROL_SETTING : 
				onGetDisplayControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS : 
				onGetCharacterStringSettingAcceptanceStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_SUPPORTED_CHARACTER_CODES : 
				onGetSupportedCharacterCodes(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER : 
				onGetCharacterStringToPresentToTheUser(eoj, tid, esv, property, success);
				return true;
			case EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED : 
				onGetLengthOfCharacterStringAccepted(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Display control setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Displaying enabled: 0x30<br>
		 * Displaying disabled: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDisplayControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Display control setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Displaying enabled: 0x30<br>
		 * Displaying disabled: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDisplayControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Character string setting acceptance status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ready: 0x30        Busy: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCharacterStringSettingAcceptanceStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Supported character codes<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0   ANSI X3.4<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 1   Shift-JIS Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 2   JIS Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 3   Japanese EUC Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 4   UCS-4<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 5   UCS-2<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 6   Latin-1<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 7   UTF-8<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 8 and succeeding bits:<br>
		 * for future reserved    0<br>
		 * <br>
		 * Data type : unsigne d char ~
2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetSupportedCharacterCodes(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Character string to present to the user<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
		 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
		 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
		 * string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
		 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
		 * code sequence of the character string to present to the user (max.<br>
		 * 244 bytes)<br>
		 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
		 * ANSI X3.4=0x01<br>
		 * Shift .JIS=0x02<br>
		 * JIS =0x03<br>
		 * Japanese EUC=0x04<br>
		 * UCS-4 =0x05<br>
		 * UCS-2 =0x06<br>
		 * Latin -1=0x07<br>
		 * UTF-8=0x08<br>
		 * 0x09 and succeeding values = for future reserved<br>
		 * <br>
		 * Data type : unsigne d    char
 ~
Max
247<br>
		 * <br>
		 * Data size : Max247
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - optional<br>
		 */
		protected void onSetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Character string to present to the user<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
		 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
		 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
		 * string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
		 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
		 * code sequence of the character string to present to the user (max.<br>
		 * 244 bytes)<br>
		 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
		 * ANSI X3.4=0x01<br>
		 * Shift .JIS=0x02<br>
		 * JIS =0x03<br>
		 * Japanese EUC=0x04<br>
		 * UCS-4 =0x05<br>
		 * UCS-2 =0x06<br>
		 * Latin -1=0x07<br>
		 * UTF-8=0x08<br>
		 * 0x09 and succeeding values = for future reserved<br>
		 * <br>
		 * Data type : unsigne d    char
 ~
Max
247<br>
		 * <br>
		 * Data size : Max247
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - optional<br>
		 */
		protected void onGetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Length of character
string accepted<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the total number of bytes of the newest character string to present to the<br>
		 * user which has been set and is being held.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: 0x00 to 0xF4<br>
		 * Second byte: 0x00 (for future reserved)<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetLengthOfCharacterStringAccepted(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Display control setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Displaying enabled: 0x30<br>
		 * Displaying disabled: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDisplayControlSetting(byte[] edt) {
			addProperty(EPC_DISPLAY_CONTROL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Character string to present to the user<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
		 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
		 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
		 * string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
		 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
		 * code sequence of the character string to present to the user (max.<br>
		 * 244 bytes)<br>
		 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
		 * ANSI X3.4=0x01<br>
		 * Shift .JIS=0x02<br>
		 * JIS =0x03<br>
		 * Japanese EUC=0x04<br>
		 * UCS-4 =0x05<br>
		 * UCS-2 =0x06<br>
		 * Latin -1=0x07<br>
		 * UTF-8=0x08<br>
		 * 0x09 and succeeding values = for future reserved<br>
		 * <br>
		 * Data type : unsigne d    char
 ~
Max
247<br>
		 * <br>
		 * Data size : Max247
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - optional<br>
		 */
		public Setter reqSetCharacterStringToPresentToTheUser(byte[] edt) {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER, edt);
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
		 * Property name : Display control setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Displaying enabled: 0x30<br>
		 * Displaying disabled: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDisplayControlSetting() {
			addProperty(EPC_DISPLAY_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Character string setting acceptance status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ready: 0x30        Busy: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCharacterStringSettingAcceptanceStatus() {
			addProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS);
			return this;
		}
		/**
		 * Property name : Supported character codes<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0   ANSI X3.4<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 1   Shift-JIS Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 2   JIS Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 3   Japanese EUC Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 4   UCS-4<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 5   UCS-2<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 6   Latin-1<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 7   UTF-8<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 8 and succeeding bits:<br>
		 * for future reserved    0<br>
		 * <br>
		 * Data type : unsigne d char ~
2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetSupportedCharacterCodes() {
			addProperty(EPC_SUPPORTED_CHARACTER_CODES);
			return this;
		}
		/**
		 * Property name : Character string to present to the user<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
		 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
		 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
		 * string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
		 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
		 * code sequence of the character string to present to the user (max.<br>
		 * 244 bytes)<br>
		 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
		 * ANSI X3.4=0x01<br>
		 * Shift .JIS=0x02<br>
		 * JIS =0x03<br>
		 * Japanese EUC=0x04<br>
		 * UCS-4 =0x05<br>
		 * UCS-2 =0x06<br>
		 * Latin -1=0x07<br>
		 * UTF-8=0x08<br>
		 * 0x09 and succeeding values = for future reserved<br>
		 * <br>
		 * Data type : unsigne d    char
 ~
Max
247<br>
		 * <br>
		 * Data size : Max247
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCharacterStringToPresentToTheUser() {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER);
			return this;
		}
		/**
		 * Property name : Length of character
string accepted<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the total number of bytes of the newest character string to present to the<br>
		 * user which has been set and is being held.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: 0x00 to 0xF4<br>
		 * Second byte: 0x00 (for future reserved)<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetLengthOfCharacterStringAccepted() {
			addProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED);
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
		 * Property name : Display control setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Displaying enabled: 0x30<br>
		 * Displaying disabled: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDisplayControlSetting() {
			addProperty(EPC_DISPLAY_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Character string setting acceptance status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ready: 0x30        Busy: 0x31<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCharacterStringSettingAcceptanceStatus() {
			addProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS);
			return this;
		}
		/**
		 * Property name : Supported character codes<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0   ANSI X3.4<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 1   Shift-JIS Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 2   JIS Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 3   Japanese EUC Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 4   UCS-4<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 5   UCS-2<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 6   Latin-1<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 7   UTF-8<br>
		 * Implemented: 1<br>
		 * Not implemented: 0<br>
		 * Bit 8 and succeeding bits:<br>
		 * for future reserved    0<br>
		 * <br>
		 * Data type : unsigne d char ~
2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformSupportedCharacterCodes() {
			addProperty(EPC_SUPPORTED_CHARACTER_CODES);
			return this;
		}
		/**
		 * Property name : Character string to present to the user<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting.<br>
		 * The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall<br>
		 * indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character<br>
		 * string to present to the user.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format<br>
		 * Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte<br>
		 * code sequence of the character string to present to the user (max.<br>
		 * 244 bytes)<br>
		 * Each of the character codes listed below shall be assigned with the indicated code value.<br>
		 * ANSI X3.4=0x01<br>
		 * Shift .JIS=0x02<br>
		 * JIS =0x03<br>
		 * Japanese EUC=0x04<br>
		 * UCS-4 =0x05<br>
		 * UCS-2 =0x06<br>
		 * Latin -1=0x07<br>
		 * UTF-8=0x08<br>
		 * 0x09 and succeeding values = for future reserved<br>
		 * <br>
		 * Data type : unsigne d    char
 ~
Max
247<br>
		 * <br>
		 * Data size : Max247
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCharacterStringToPresentToTheUser() {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER);
			return this;
		}
		/**
		 * Property name : Length of character
string accepted<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the total number of bytes of the newest character string to present to the<br>
		 * user which has been set and is being held.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: 0x00 to 0xF4<br>
		 * Second byte: 0x00 (for future reserved)<br>
		 * <br>
		 * Data type : unsigne d char<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformLengthOfCharacterStringAccepted() {
			addProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED);
			return this;
		}
	}

	public static class Proxy extends Display {
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
		protected boolean setOperationStatus(byte[] edt) {return false;}
		@Override
		protected byte[] getCharacterStringSettingAcceptanceStatus() {return null;}
		@Override
		protected byte[] getSupportedCharacterCodes() {return null;}
		@Override
		protected boolean setCharacterStringToPresentToTheUser(byte[] edt) {return false;}
		@Override
		protected byte[] getLengthOfCharacterStringAccepted() {return null;}
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
