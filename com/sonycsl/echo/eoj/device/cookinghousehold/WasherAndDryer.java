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

public abstract class WasherAndDryer extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03D3;

	public static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_WASHER_AND_DRYER_SETTING = (byte)0xB2;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 = (byte)0xD0;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 = (byte)0xD1;
	public static final byte EPC_DRYING_CYCLE_SETTING_NOTE1 = (byte)0xD2;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 = (byte)0xD3;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 = (byte)0xD4;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 = (byte)0xD5;
	public static final byte EPC_WATER_FLOW_RATE_SETTING = (byte)0xD6;
	public static final byte EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING = (byte)0xD7;
	public static final byte EPC_GDEGREE_OF_DRYING_H_SETTING = (byte)0xD8;
	public static final byte EPC_REMAINING_WASHING_TIME = (byte)0xDB;
	public static final byte EPC_REMAINING_DRYING_TIME = (byte)0xDC;
	public static final byte EPC_ELAPSED_TIME_ON_THE_ON_TIMER = (byte)0xDF;
	public static final byte EPC_PRESOAKING_TIME_SETTING = (byte)0xE1;
	public static final byte EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE = (byte)0xE2;
	public static final byte EPC_WATER_VOLUME_SETTING1 = (byte)0xE3;
	public static final byte EPC_WATER_VOLUME_SETTING2 = (byte)0xE4;
	public static final byte EPC_WASHING_TIME_SETTING = (byte)0xE5;
	public static final byte EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING = (byte)0xE6;
	public static final byte EPC_RINSING_PROCESS_SETTING = (byte)0xE7;
	public static final byte EPC_SPIN_DRYING_TIME_SETTING = (byte)0xE8;
	public static final byte EPC_DRYING_TIME_SETTING = (byte)0xE9;
	public static final byte EPC_WARM_WATER_SETTING = (byte)0xEA;
	public static final byte EPC_BATHTUB_WATER_RECYCLE_SETTING = (byte)0xEB;
	public static final byte EPC_WRINKLING_MINIMIZATION_SETTING = (byte)0xEC;
	public static final byte EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE = (byte)0xED;
	public static final byte EPC_DOOR_COVER_LOCK_SETTING = (byte)0xEE;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE = (byte)0xEF;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING = (byte)0x92;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewWasherAndDryer(this);
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
	 * This property indicates the ON/OFF<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41<br>
	 * Door/cover closed = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	/**
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41<br>
	 * Door/cover closed = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDoorCoverOpenCloseStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart(ed) or in progress = 0x41<br>
	 * Suspend(ed) = 0x42<br>
	 * Stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWasherAndDryerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Washer and dryer setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart(ed) or in progress = 0x41<br>
	 * Suspend(ed) = 0x42<br>
	 * Stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerSetting() {return null;}
	/**
	 * Property name : Washer and dryer setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart(ed) or in progress = 0x41<br>
	 * Suspend(ed) = 0x42<br>
	 * Stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
	 * Washing and drying couse: 0x21 to<br>
	 * 0x3F<br>
	 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
	 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
	 * 0x80 to 0x8F<br>
	 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
	 * 0xC0 to 0xDF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Washing and drying cource><br>
	 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
	 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
	 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
	 * = 0x32<br>
	 * Washing cource / maker original cource<br>
	 * = 0x40 to 0x4F<br>
	 * <Washing cource><br>
	 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
	 * 0x68, clean rinsing = 0x69, disinfection<br>
	 * = 0x6A, oil stains = 0x6B, memory =<br>
	 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
	 * Washing cource / maker original cource<br>
	 * = 0x80 to 0x8F<br>
	 * <Drying cource><br>
	 * Standard = 0xA1, blankets = 0xA2, soft<br>
	 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
	 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
	 * 0xAB, user definition of drying time =<br>
	 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
	 * Drying cource / maker original cource<br>
	 * = 0xC0 to 0xCF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWasherAndDryerCycleSetting1Note1(byte[] edt) {return false;}
	/**
	 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
	 * Washing and drying couse: 0x21 to<br>
	 * 0x3F<br>
	 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
	 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
	 * 0x80 to 0x8F<br>
	 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
	 * 0xC0 to 0xDF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Washing and drying cource><br>
	 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
	 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
	 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
	 * = 0x32<br>
	 * Washing cource / maker original cource<br>
	 * = 0x40 to 0x4F<br>
	 * <Washing cource><br>
	 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
	 * 0x68, clean rinsing = 0x69, disinfection<br>
	 * = 0x6A, oil stains = 0x6B, memory =<br>
	 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
	 * Washing cource / maker original cource<br>
	 * = 0x80 to 0x8F<br>
	 * <Drying cource><br>
	 * Standard = 0xA1, blankets = 0xA2, soft<br>
	 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
	 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
	 * 0xAB, user definition of drying time =<br>
	 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
	 * Drying cource / maker original cource<br>
	 * = 0xC0 to 0xCF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleSetting1Note1() {return null;}
	/**
	 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
	 * Washing and drying couse: 0x21 to<br>
	 * 0x3F<br>
	 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
	 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
	 * 0x80 to 0x8F<br>
	 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
	 * 0xC0 to 0xDF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Washing and drying cource><br>
	 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
	 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
	 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
	 * = 0x32<br>
	 * Washing cource / maker original cource<br>
	 * = 0x40 to 0x4F<br>
	 * <Washing cource><br>
	 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
	 * 0x68, clean rinsing = 0x69, disinfection<br>
	 * = 0x6A, oil stains = 0x6B, memory =<br>
	 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
	 * Washing cource / maker original cource<br>
	 * = 0x80 to 0x8F<br>
	 * <Drying cource><br>
	 * Standard = 0xA1, blankets = 0xA2, soft<br>
	 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
	 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
	 * 0xAB, user definition of drying time =<br>
	 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
	 * Drying cource / maker original cource<br>
	 * = 0xC0 to 0xCF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleSetting1Note1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the<br>
	 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
	 * setting h property (EPC = 0xD2).<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No washing = 0x20, standard =<br>
	 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
	 * 0x28, clean rinsing = 0x29,<br>
	 * disinfection = 0x2D, oil stains =<br>
	 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
	 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
	 * 0x3F<br>
	 * Maker original cource = 0xE0 to<br>
	 * 0xEF<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWasherAndDryerCycleSetting2Note1(byte[] edt) {return false;}
	/**
	 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the<br>
	 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
	 * setting h property (EPC = 0xD2).<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No washing = 0x20, standard =<br>
	 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
	 * 0x28, clean rinsing = 0x29,<br>
	 * disinfection = 0x2D, oil stains =<br>
	 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
	 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
	 * 0x3F<br>
	 * Maker original cource = 0xE0 to<br>
	 * 0xEF<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleSetting2Note1() {return null;}
	/**
	 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the<br>
	 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
	 * setting h property (EPC = 0xD2).<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No washing = 0x20, standard =<br>
	 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
	 * 0x28, clean rinsing = 0x29,<br>
	 * disinfection = 0x2D, oil stains =<br>
	 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
	 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
	 * 0x3F<br>
	 * Maker original cource = 0xE0 to<br>
	 * 0xEF<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleSetting2Note1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Drying cycle setting (Note1)<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
	 * 0xD1) shall be used.<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
	 * 0xA4, ironing/business shirts =<br>
	 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
	 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
	 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
	 * Maker original cource = 0xE0 to<br>
	 * 0xEF<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDryingCycleSettingNote1(byte[] edt) {return false;}
	/**
	 * Property name : Drying cycle setting (Note1)<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
	 * 0xD1) shall be used.<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
	 * 0xA4, ironing/business shirts =<br>
	 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
	 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
	 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
	 * Maker original cource = 0xE0 to<br>
	 * 0xEF<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDryingCycleSettingNote1() {return null;}
	/**
	 * Property name : Drying cycle setting (Note1)<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
	 * 0xD1) shall be used.<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
	 * 0xA4, ironing/business shirts =<br>
	 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
	 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
	 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
	 * Maker original cource = 0xE0 to<br>
	 * 0xEF<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDryingCycleSettingNote1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle option list 1<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer<br>
	 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
	 * detailed explanation.<br>
	 * <br>
	 * Data type : unsign ed
char
 ~12,<br>
	 * <br>
	 * Data size : 12 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList1() {return null;}
	/**
	 * Property name : Washer and dryer cycle option list 1<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer<br>
	 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
	 * detailed explanation.<br>
	 * <br>
	 * Data type : unsign ed
char
 ~12,<br>
	 * <br>
	 * Data size : 12 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleOptionList1(byte[] edt) {
		if(edt == null || !(edt.length == 12)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle option list 2<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer<br>
	 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
	 * detailed explanation.<br>
	 * <br>
	 * Data type : unsign ed
char
 ~4,<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList2() {return null;}
	/**
	 * Property name : Washer and dryer cycle option list 2<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer<br>
	 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
	 * detailed explanation.<br>
	 * <br>
	 * Data type : unsign ed
char
 ~4,<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleOptionList2(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle option list 3<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsign ed
char
 ~4,<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList3() {return null;}
	/**
	 * Property name : Washer and dryer cycle option list 3<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsign ed
char
 ~4,<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleOptionList3(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Water flow rate setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * 0x31 to 0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWaterFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Water flow rate setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * 0x31 to 0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWaterFlowRateSetting() {return null;}
	/**
	 * Property name : Water flow rate setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * 0x31 to 0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWaterFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name :  gRotation speed for spin drying h
setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFFFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
	 * <br>
	 * Data type : unsign ed short<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGrotationSpeedForSpinDryingHSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gRotation speed for spin drying h
setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFFFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
	 * <br>
	 * Data type : unsign ed short<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGrotationSpeedForSpinDryingHSetting() {return null;}
	/**
	 * Property name :  gRotation speed for spin drying h
setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFFFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
	 * <br>
	 * Data type : unsign ed short<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGrotationSpeedForSpinDryingHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name :  gDegree of drying h setting<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31 to 0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGdegreeOfDryingHSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gDegree of drying h setting<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31 to 0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGdegreeOfDryingHSetting() {return null;}
	/**
	 * Property name :  gDegree of drying h setting<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31 to 0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsign ed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGdegreeOfDryingHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Remaining washing time<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining washing time<br>
	 * in .the . gHH:MM h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0xFE F0-0x3B<br>
	 * (=0-254) hours F(=0-59) minutes<br>
	 * Remaining time unknown=0xFF F<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsigne d
char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRemainingWashingTime() {return null;}
	/**
	 * Property name : Remaining washing time<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining washing time<br>
	 * in .the . gHH:MM h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0xFE F0-0x3B<br>
	 * (=0-254) hours F(=0-59) minutes<br>
	 * Remaining time unknown=0xFF F<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsigne d
char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRemainingWashingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Remaining drying time<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining drying<br>
	 * time .in .the . gHH:MM h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0xFE F0-0x3B<br>
	 * (=0-254) hours F(=0-59) minutes<br>
	 * Remaining time<br>
	 * unknown=0xFF F0xFF<br>
	 * <br>
	 * Data type : unsign ed<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRemainingDryingTime() {return null;}
	/**
	 * Property name : Remaining drying time<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining drying<br>
	 * time .in .the . gHH:MM h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0xFE F0-0x3B<br>
	 * (=0-254) hours F(=0-59) minutes<br>
	 * Remaining time<br>
	 * unknown=0xFF F0xFF<br>
	 * <br>
	 * Data type : unsign ed<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRemainingDryingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Elapsed time on the ON timer<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigne d
char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : Hour
minut es<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getElapsedTimeOnTheOnTimer() {return null;}
	/**
	 * Property name : Elapsed time on the ON timer<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigne d
char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : Hour
minut es<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidElapsedTimeOnTheOnTimer(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Presoaking time setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigne d char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setPresoakingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Presoaking time setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigne d char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getPresoakingTimeSetting() {return null;}
	/**
	 * Property name : Presoaking time setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting<br>
	 * 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigne d char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidPresoakingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Current stage of washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current stage of the washer and dryer cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Washing = 0x41<br>
	 * Rinsing = 0x42<br>
	 * Spin drying = 0x43<br>
	 * Suspended = 0x44<br>
	 * Washing completed = 0x45<br>
	 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
	 * Drying = 0x52<br>
	 * Wrinkling minimization = 0x53<br>
	 * Drying (with wrinkling minimization) completed = 0x54<br>
	 * Standing by to start = 0x61<br>
	 * 1st rinsing = 0x71<br>
	 * 2nd rinsing = 0x72<br>
	 * 3rd rinsing = 0x73<br>
	 * 4th rinsing = 0x74<br>
	 * 5th rinsing = 0x75<br>
	 * 6th rinsing = 0x76<br>
	 * 7th rinsing = 0x77<br>
	 * 8th rinsing = 0x78<br>
	 * 1st spin drying = 0x81<br>
	 * 2nd spin drying = 0x82<br>
	 * 3rd spin drying = 0x83<br>
	 * 4th spin drying = 0x84<br>
	 * 5th spin drying = 0x85<br>
	 * 6th spin drying = 0x86<br>
	 * 7th spin drying = 0x87<br>
	 * 8th spin drying = 0x88<br>
	 * Preheat spin drying = 0x91<br>
	 * Unique code defined by the manufature = 0xE0 to 0xEF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getCurrentStageOfWasherAndDryerCycle() {return null;}
	/**
	 * Property name : Current stage of washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current stage of the washer and dryer cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Washing = 0x41<br>
	 * Rinsing = 0x42<br>
	 * Spin drying = 0x43<br>
	 * Suspended = 0x44<br>
	 * Washing completed = 0x45<br>
	 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
	 * Drying = 0x52<br>
	 * Wrinkling minimization = 0x53<br>
	 * Drying (with wrinkling minimization) completed = 0x54<br>
	 * Standing by to start = 0x61<br>
	 * 1st rinsing = 0x71<br>
	 * 2nd rinsing = 0x72<br>
	 * 3rd rinsing = 0x73<br>
	 * 4th rinsing = 0x74<br>
	 * 5th rinsing = 0x75<br>
	 * 6th rinsing = 0x76<br>
	 * 7th rinsing = 0x77<br>
	 * 8th rinsing = 0x78<br>
	 * 1st spin drying = 0x81<br>
	 * 2nd spin drying = 0x82<br>
	 * 3rd spin drying = 0x83<br>
	 * 4th spin drying = 0x84<br>
	 * 5th spin drying = 0x85<br>
	 * 6th spin drying = 0x86<br>
	 * 7th spin drying = 0x87<br>
	 * 8th spin drying = 0x88<br>
	 * Preheat spin drying = 0x91<br>
	 * Unique code defined by the manufature = 0xE0 to 0xEF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCurrentStageOfWasherAndDryerCycle(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Water volume setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume in liters and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x7F (0 to 127 liters)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xBF: 1 to 32 liters<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xDF (1 to 32 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWaterVolumeSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Water volume setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume in liters and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x7F (0 to 127 liters)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xBF: 1 to 32 liters<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xDF (1 to 32 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWaterVolumeSetting1() {return null;}
	/**
	 * Property name : Water volume setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume in liters and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x7F (0 to 127 liters)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xBF: 1 to 32 liters<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xDF (1 to 32 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWaterVolumeSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Water volume setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31 to 0x40 (16 levels)<br>
	 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWaterVolumeSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Water volume setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31 to 0x40 (16 levels)<br>
	 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWaterVolumeSetting2() {return null;}
	/**
	 * Property name : Water volume setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31 to 0x40 (16 levels)<br>
	 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xA7: Levels 1 to 8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xC7: Levels 1 to 8<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWaterVolumeSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washing time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the washing process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * Relative setting in the negative direction<br>
	 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWashingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Washing time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the washing process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * Relative setting in the negative direction<br>
	 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWashingTimeSetting() {return null;}
	/**
	 * Property name : Washing time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the washing process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * Relative setting in the negative direction<br>
	 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWashingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name :  gNumber of times of rinsing h setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 8 times (0x00 to 0x08)<br>
	 * Automatic = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGnumberOfTimesOfRinsingHSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gNumber of times of rinsing h setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 8 times (0x00 to 0x08)<br>
	 * Automatic = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGnumberOfTimesOfRinsingHSetting() {return null;}
	/**
	 * Property name :  gNumber of times of rinsing h setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 8 times (0x00 to 0x08)<br>
	 * Automatic = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGnumberOfTimesOfRinsingHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rinsing process setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
	 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0000: Automatic mode<br>
	 * 0001: Rinsing without additional feeding of water from the tap<br>
	 * 0010: Rinsing with additional feeding of water from the tap<br>
	 * 0011: Shower rinsing<br>
	 * <br>
	 * Data type : unsigned char
 ~4<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRinsingProcessSetting(byte[] edt) {return false;}
	/**
	 * Property name : Rinsing process setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
	 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0000: Automatic mode<br>
	 * 0001: Rinsing without additional feeding of water from the tap<br>
	 * 0010: Rinsing with additional feeding of water from the tap<br>
	 * 0011: Shower rinsing<br>
	 * <br>
	 * Data type : unsigned char
 ~4<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRinsingProcessSetting() {return null;}
	/**
	 * Property name : Rinsing process setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
	 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0000: Automatic mode<br>
	 * 0001: Rinsing without additional feeding of water from the tap<br>
	 * 0010: Rinsing with additional feeding of water from the tap<br>
	 * 0011: Shower rinsing<br>
	 * <br>
	 * Data type : unsigned char
 ~4<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRinsingProcessSetting(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Spin drying time setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x3B (0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xBF: 1 to 32 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xDF: 1 to 32 minute<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSpinDryingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Spin drying time setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x3B (0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xBF: 1 to 32 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xDF: 1 to 32 minute<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSpinDryingTimeSetting() {return null;}
	/**
	 * Property name : Spin drying time setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x3B (0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0 to 0xBF: 1 to 32 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0 to 0xDF: 1 to 32 minute<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSpinDryingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Drying time setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the drying process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDryingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Drying time setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the drying process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDryingTimeSetting() {return null;}
	/**
	 * Property name : Drying time setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the drying process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00 to 0x17: 0x00 to 0x3B<br>
	 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting<br>
	 * 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDryingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Warm water setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 100  C (0x00 to 0x64)<br>
	 * Not to use warm water = 0xFE Automatic water temperature setting<br>
	 * = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWarmWaterSetting(byte[] edt) {return false;}
	/**
	 * Property name : Warm water setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 100  C (0x00 to 0x64)<br>
	 * Not to use warm water = 0xFE Automatic water temperature setting<br>
	 * = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWarmWaterSetting() {return null;}
	/**
	 * Property name : Warm water setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 100  C (0x00 to 0x64)<br>
	 * Not to use warm water = 0xFE Automatic water temperature setting<br>
	 * = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWarmWaterSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bathtub water recycle setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathtub water not used   : 0x40<br>
	 * Washing only                      : 0x41<br>
	 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
	 * All rinsing processes        : 0x43<br>
	 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
	 * Washing + all rinsing<br>
	 * processes                            : 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathtubWaterRecycleSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bathtub water recycle setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathtub water not used   : 0x40<br>
	 * Washing only                      : 0x41<br>
	 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
	 * All rinsing processes        : 0x43<br>
	 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
	 * Washing + all rinsing<br>
	 * processes                            : 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathtubWaterRecycleSetting() {return null;}
	/**
	 * Property name : Bathtub water recycle setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathtub water not used   : 0x40<br>
	 * Washing only                      : 0x41<br>
	 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
	 * All rinsing processes        : 0x43<br>
	 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
	 * Washing + all rinsing<br>
	 * processes                            : 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathtubWaterRecycleSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Wrinkling minimization setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Wrinkling minimization function<br>
	 * ON                  : 0x41<br>
	 * Wrinkling minimization function<br>
	 * OFF                : 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWrinklingMinimizationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Wrinkling minimization setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Wrinkling minimization function<br>
	 * ON                  : 0x41<br>
	 * Wrinkling minimization function<br>
	 * OFF                : 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWrinklingMinimizationSetting() {return null;}
	/**
	 * Property name : Wrinkling minimization setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Wrinkling minimization function<br>
	 * ON                  : 0x41<br>
	 * Wrinkling minimization function<br>
	 * OFF                : 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWrinklingMinimizationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Time remaining to complete washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time remaining to complete the current washer and<br>
	 * dryer .cycle .in .the . gHH: .MM h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFE: 0 to 0x3B<br>
	 * (= 0 to 254 hours): (= 0 to 59 minutes)<br>
	 * Remaining time unknown = 0xFF:<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getTimeRemainingToCompleteWasherAndDryerCycle() {return null;}
	/**
	 * Property name : Time remaining to complete washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time remaining to complete the current washer and<br>
	 * dryer .cycle .in .the . gHH: .MM h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFE: 0 to 0x3B<br>
	 * (= 0 to 254 hours): (= 0 to 59 minutes)<br>
	 * Remaining time unknown = 0xFF:<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTimeRemainingToCompleteWasherAndDryerCycle(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Door/cover lock    setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Locked: 0x41<br>
	 * Unlocked: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDoorCoverLockSetting(byte[] edt) {return false;}
	/**
	 * Property name : Door/cover lock    setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Locked: 0x41<br>
	 * Unlocked: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDoorCoverLockSetting() {return null;}
	/**
	 * Property name : Door/cover lock    setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Locked: 0x41<br>
	 * Unlocked: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDoorCoverLockSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current washer and dryer cycle setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bytes 1 and 2: This property indicates the available<br>
	 * items in a bitmap format.<br>
	 * Byte 3: Presoaking<br>
	 * With presoaking: 0x41<br>
	 * Without presoaking: 0x42<br>
	 * Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced.<br>
	 * Byte 6: Number of times of rinsing<br>
	 * The value of the  g fnumber of times of rinsing f setting h property shall be referenced.<br>
	 * Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced.<br>
	 * Byte 11: Spin drying time<br>
	 * The value of the  gspin drying time setting h property shall be referenced.<br>
	 * Bytes 12 and 13: Drying time<br>
	 * The value of the  hdrying time setting h<br>
	 * property shall be referenced.<br>
	 * Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced.<br>
	 * Byte 15: Water volume setting 1<br>
	 * The value of the  gwater volume setting 1 h property shall be referenced.<br>
	 * Byte 16: Water volume setting 2<br>
	 * The value of the  gwater volume setting 2 h property shall be referenced.<br>
	 * Byte 17: Bathtub water recycle setting<br>
	 * The value of the  gbathtub water recycle setting h property<br>
	 * shall be referenced.<br>
	 * Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced.<br>
	 * Bytes 19 and 20:  gRotation speed for spin drying h setting<br>
	 * The value of the  g frotation speed for spin drying f setting h property<br>
	 * shall be referenced.<br>
	 * Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
	 * The value of the  gpresoaking time setting h property shall be referenced.<br>
	 * Byte 24: Wrinkling minimization setting<br>
	 * The value of the  gwrinkling<br>
	 * minimization setting h property shall be referenced.<br>
	 * <br>
	 * Data type : unsigned
Char
 ~24<br>
	 * <br>
	 * Data size : 24 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycle() {return null;}
	/**
	 * Property name : Washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current washer and dryer cycle setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bytes 1 and 2: This property indicates the available<br>
	 * items in a bitmap format.<br>
	 * Byte 3: Presoaking<br>
	 * With presoaking: 0x41<br>
	 * Without presoaking: 0x42<br>
	 * Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced.<br>
	 * Byte 6: Number of times of rinsing<br>
	 * The value of the  g fnumber of times of rinsing f setting h property shall be referenced.<br>
	 * Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced.<br>
	 * Byte 11: Spin drying time<br>
	 * The value of the  gspin drying time setting h property shall be referenced.<br>
	 * Bytes 12 and 13: Drying time<br>
	 * The value of the  hdrying time setting h<br>
	 * property shall be referenced.<br>
	 * Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced.<br>
	 * Byte 15: Water volume setting 1<br>
	 * The value of the  gwater volume setting 1 h property shall be referenced.<br>
	 * Byte 16: Water volume setting 2<br>
	 * The value of the  gwater volume setting 2 h property shall be referenced.<br>
	 * Byte 17: Bathtub water recycle setting<br>
	 * The value of the  gbathtub water recycle setting h property<br>
	 * shall be referenced.<br>
	 * Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced.<br>
	 * Bytes 19 and 20:  gRotation speed for spin drying h setting<br>
	 * The value of the  g frotation speed for spin drying f setting h property<br>
	 * shall be referenced.<br>
	 * Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
	 * The value of the  gpresoaking time setting h property shall be referenced.<br>
	 * Byte 24: Wrinkling minimization setting<br>
	 * The value of the  gwrinkling<br>
	 * minimization setting h property shall be referenced.<br>
	 * <br>
	 * Data type : unsigned
Char
 ~24<br>
	 * <br>
	 * Data size : 24 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycle(byte[] edt) {
		if(edt == null || !(edt.length == 24)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation<br>
	 * OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation<br>
	 * OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation<br>
	 * OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Relative time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}
	/**
	 * Property name : Relative time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRelativeTimeBasedOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_WASHER_AND_DRYER_SETTING : return setWasherAndDryerSetting(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : return setWasherAndDryerCycleSetting1Note1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : return setWasherAndDryerCycleSetting2Note1(property.edt);
		case EPC_DRYING_CYCLE_SETTING_NOTE1 : return setDryingCycleSettingNote1(property.edt);
		case EPC_WATER_FLOW_RATE_SETTING : return setWaterFlowRateSetting(property.edt);
		case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING : return setGrotationSpeedForSpinDryingHSetting(property.edt);
		case EPC_GDEGREE_OF_DRYING_H_SETTING : return setGdegreeOfDryingHSetting(property.edt);
		case EPC_PRESOAKING_TIME_SETTING : return setPresoakingTimeSetting(property.edt);
		case EPC_WATER_VOLUME_SETTING1 : return setWaterVolumeSetting1(property.edt);
		case EPC_WATER_VOLUME_SETTING2 : return setWaterVolumeSetting2(property.edt);
		case EPC_WASHING_TIME_SETTING : return setWashingTimeSetting(property.edt);
		case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING : return setGnumberOfTimesOfRinsingHSetting(property.edt);
		case EPC_RINSING_PROCESS_SETTING : return setRinsingProcessSetting(property.edt);
		case EPC_SPIN_DRYING_TIME_SETTING : return setSpinDryingTimeSetting(property.edt);
		case EPC_DRYING_TIME_SETTING : return setDryingTimeSetting(property.edt);
		case EPC_WARM_WATER_SETTING : return setWarmWaterSetting(property.edt);
		case EPC_BATHTUB_WATER_RECYCLE_SETTING : return setBathtubWaterRecycleSetting(property.edt);
		case EPC_WRINKLING_MINIMIZATION_SETTING : return setWrinklingMinimizationSetting(property.edt);
		case EPC_DOOR_COVER_LOCK_SETTING : return setDoorCoverLockSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return setRelativeTimeBasedOnTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return getDoorCoverOpenCloseStatus();
		case EPC_WASHER_AND_DRYER_SETTING : return getWasherAndDryerSetting();
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : return getWasherAndDryerCycleSetting1Note1();
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : return getWasherAndDryerCycleSetting2Note1();
		case EPC_DRYING_CYCLE_SETTING_NOTE1 : return getDryingCycleSettingNote1();
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 : return getWasherAndDryerCycleOptionList1();
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 : return getWasherAndDryerCycleOptionList2();
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 : return getWasherAndDryerCycleOptionList3();
		case EPC_WATER_FLOW_RATE_SETTING : return getWaterFlowRateSetting();
		case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING : return getGrotationSpeedForSpinDryingHSetting();
		case EPC_GDEGREE_OF_DRYING_H_SETTING : return getGdegreeOfDryingHSetting();
		case EPC_REMAINING_WASHING_TIME : return getRemainingWashingTime();
		case EPC_REMAINING_DRYING_TIME : return getRemainingDryingTime();
		case EPC_ELAPSED_TIME_ON_THE_ON_TIMER : return getElapsedTimeOnTheOnTimer();
		case EPC_PRESOAKING_TIME_SETTING : return getPresoakingTimeSetting();
		case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE : return getCurrentStageOfWasherAndDryerCycle();
		case EPC_WATER_VOLUME_SETTING1 : return getWaterVolumeSetting1();
		case EPC_WATER_VOLUME_SETTING2 : return getWaterVolumeSetting2();
		case EPC_WASHING_TIME_SETTING : return getWashingTimeSetting();
		case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING : return getGnumberOfTimesOfRinsingHSetting();
		case EPC_RINSING_PROCESS_SETTING : return getRinsingProcessSetting();
		case EPC_SPIN_DRYING_TIME_SETTING : return getSpinDryingTimeSetting();
		case EPC_DRYING_TIME_SETTING : return getDryingTimeSetting();
		case EPC_WARM_WATER_SETTING : return getWarmWaterSetting();
		case EPC_BATHTUB_WATER_RECYCLE_SETTING : return getBathtubWaterRecycleSetting();
		case EPC_WRINKLING_MINIMIZATION_SETTING : return getWrinklingMinimizationSetting();
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE : return getTimeRemainingToCompleteWasherAndDryerCycle();
		case EPC_DOOR_COVER_LOCK_SETTING : return getDoorCoverLockSetting();
		case EPC_WASHER_AND_DRYER_CYCLE : return getWasherAndDryerCycle();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return getRelativeTimeBasedOnTimerSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return isValidDoorCoverOpenCloseStatus(property.edt);
		case EPC_WASHER_AND_DRYER_SETTING : return isValidWasherAndDryerSetting(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : return isValidWasherAndDryerCycleSetting1Note1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : return isValidWasherAndDryerCycleSetting2Note1(property.edt);
		case EPC_DRYING_CYCLE_SETTING_NOTE1 : return isValidDryingCycleSettingNote1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 : return isValidWasherAndDryerCycleOptionList1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 : return isValidWasherAndDryerCycleOptionList2(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 : return isValidWasherAndDryerCycleOptionList3(property.edt);
		case EPC_WATER_FLOW_RATE_SETTING : return isValidWaterFlowRateSetting(property.edt);
		case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING : return isValidGrotationSpeedForSpinDryingHSetting(property.edt);
		case EPC_GDEGREE_OF_DRYING_H_SETTING : return isValidGdegreeOfDryingHSetting(property.edt);
		case EPC_REMAINING_WASHING_TIME : return isValidRemainingWashingTime(property.edt);
		case EPC_REMAINING_DRYING_TIME : return isValidRemainingDryingTime(property.edt);
		case EPC_ELAPSED_TIME_ON_THE_ON_TIMER : return isValidElapsedTimeOnTheOnTimer(property.edt);
		case EPC_PRESOAKING_TIME_SETTING : return isValidPresoakingTimeSetting(property.edt);
		case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE : return isValidCurrentStageOfWasherAndDryerCycle(property.edt);
		case EPC_WATER_VOLUME_SETTING1 : return isValidWaterVolumeSetting1(property.edt);
		case EPC_WATER_VOLUME_SETTING2 : return isValidWaterVolumeSetting2(property.edt);
		case EPC_WASHING_TIME_SETTING : return isValidWashingTimeSetting(property.edt);
		case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING : return isValidGnumberOfTimesOfRinsingHSetting(property.edt);
		case EPC_RINSING_PROCESS_SETTING : return isValidRinsingProcessSetting(property.edt);
		case EPC_SPIN_DRYING_TIME_SETTING : return isValidSpinDryingTimeSetting(property.edt);
		case EPC_DRYING_TIME_SETTING : return isValidDryingTimeSetting(property.edt);
		case EPC_WARM_WATER_SETTING : return isValidWarmWaterSetting(property.edt);
		case EPC_BATHTUB_WATER_RECYCLE_SETTING : return isValidBathtubWaterRecycleSetting(property.edt);
		case EPC_WRINKLING_MINIMIZATION_SETTING : return isValidWrinklingMinimizationSetting(property.edt);
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE : return isValidTimeRemainingToCompleteWasherAndDryerCycle(property.edt);
		case EPC_DOOR_COVER_LOCK_SETTING : return isValidDoorCoverLockSetting(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE : return isValidWasherAndDryerCycle(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return isValidRelativeTimeBasedOnTimerSetting(property.edt);
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
			case EPC_WASHER_AND_DRYER_SETTING : 
				onSetWasherAndDryerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : 
				onSetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : 
				onSetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_CYCLE_SETTING_NOTE1 : 
				onSetDryingCycleSettingNote1(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_FLOW_RATE_SETTING : 
				onSetWaterFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING : 
				onSetGrotationSpeedForSpinDryingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GDEGREE_OF_DRYING_H_SETTING : 
				onSetGdegreeOfDryingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_PRESOAKING_TIME_SETTING : 
				onSetPresoakingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING1 : 
				onSetWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING2 : 
				onSetWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHING_TIME_SETTING : 
				onSetWashingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING : 
				onSetGnumberOfTimesOfRinsingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RINSING_PROCESS_SETTING : 
				onSetRinsingProcessSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPIN_DRYING_TIME_SETTING : 
				onSetSpinDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_TIME_SETTING : 
				onSetDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WARM_WATER_SETTING : 
				onSetWarmWaterSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING : 
				onSetBathtubWaterRecycleSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WRINKLING_MINIMIZATION_SETTING : 
				onSetWrinklingMinimizationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DOOR_COVER_LOCK_SETTING : 
				onSetDoorCoverLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
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
			case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : 
				onGetDoorCoverOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_SETTING : 
				onGetWasherAndDryerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : 
				onGetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : 
				onGetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_CYCLE_SETTING_NOTE1 : 
				onGetDryingCycleSettingNote1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 : 
				onGetWasherAndDryerCycleOptionList1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 : 
				onGetWasherAndDryerCycleOptionList2(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 : 
				onGetWasherAndDryerCycleOptionList3(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_FLOW_RATE_SETTING : 
				onGetWaterFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING : 
				onGetGrotationSpeedForSpinDryingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GDEGREE_OF_DRYING_H_SETTING : 
				onGetGdegreeOfDryingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_WASHING_TIME : 
				onGetRemainingWashingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_DRYING_TIME : 
				onGetRemainingDryingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ELAPSED_TIME_ON_THE_ON_TIMER : 
				onGetElapsedTimeOnTheOnTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_PRESOAKING_TIME_SETTING : 
				onGetPresoakingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE : 
				onGetCurrentStageOfWasherAndDryerCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING1 : 
				onGetWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING2 : 
				onGetWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHING_TIME_SETTING : 
				onGetWashingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING : 
				onGetGnumberOfTimesOfRinsingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RINSING_PROCESS_SETTING : 
				onGetRinsingProcessSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPIN_DRYING_TIME_SETTING : 
				onGetSpinDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_TIME_SETTING : 
				onGetDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WARM_WATER_SETTING : 
				onGetWarmWaterSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING : 
				onGetBathtubWaterRecycleSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WRINKLING_MINIMIZATION_SETTING : 
				onGetWrinklingMinimizationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE : 
				onGetTimeRemainingToCompleteWasherAndDryerCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_DOOR_COVER_LOCK_SETTING : 
				onGetDoorCoverLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE : 
				onGetWasherAndDryerCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onGetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41<br>
		 * Door/cover closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41<br>
		 * Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41<br>
		 * Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying couse: 0x21 to<br>
		 * 0x3F<br>
		 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
		 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
		 * 0x80 to 0x8F<br>
		 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
		 * 0xC0 to 0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying cource><br>
		 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
		 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing cource / maker original cource<br>
		 * = 0x40 to 0x4F<br>
		 * <Washing cource><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
		 * 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory =<br>
		 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing cource / maker original cource<br>
		 * = 0x80 to 0x8F<br>
		 * <Drying cource><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
		 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
		 * 0xAB, user definition of drying time =<br>
		 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
		 * Drying cource / maker original cource<br>
		 * = 0xC0 to 0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying couse: 0x21 to<br>
		 * 0x3F<br>
		 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
		 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
		 * 0x80 to 0x8F<br>
		 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
		 * 0xC0 to 0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying cource><br>
		 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
		 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing cource / maker original cource<br>
		 * = 0x40 to 0x4F<br>
		 * <Washing cource><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
		 * 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory =<br>
		 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing cource / maker original cource<br>
		 * = 0x80 to 0x8F<br>
		 * <Drying cource><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
		 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
		 * 0xAB, user definition of drying time =<br>
		 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
		 * Drying cource / maker original cource<br>
		 * = 0xC0 to 0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the<br>
		 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
		 * setting h property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard =<br>
		 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29,<br>
		 * disinfection = 0x2D, oil stains =<br>
		 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
		 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
		 * 0x3F<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the<br>
		 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
		 * setting h property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard =<br>
		 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29,<br>
		 * disinfection = 0x2D, oil stains =<br>
		 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
		 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
		 * 0x3F<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
		 * 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
		 * 0xA4, ironing/business shirts =<br>
		 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
		 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
		 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
		 * 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
		 * 0xA4, ironing/business shirts =<br>
		 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
		 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
		 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle option list 1<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer<br>
		 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
		 * detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~12,<br>
		 * <br>
		 * Data size : 12 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle option list 2<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer<br>
		 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
		 * detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~4,<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle option list 3<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~4,<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gRotation speed for spin drying h
setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
		 * <br>
		 * Data type : unsign ed short<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gRotation speed for spin drying h
setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
		 * <br>
		 * Data type : unsign ed short<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gDegree of drying h setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGdegreeOfDryingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gDegree of drying h setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGdegreeOfDryingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining washing time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining washing time<br>
		 * in .the . gHH:MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0xFE F0-0x3B<br>
		 * (=0-254) hours F(=0-59) minutes<br>
		 * Remaining time unknown=0xFF F<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigne d
char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRemainingWashingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining drying<br>
		 * time .in .the . gHH:MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0xFE F0-0x3B<br>
		 * (=0-254) hours F(=0-59) minutes<br>
		 * Remaining time<br>
		 * unknown=0xFF F0xFF<br>
		 * <br>
		 * Data type : unsign ed<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRemainingDryingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Elapsed time on the ON timer<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigne d
char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : Hour
minut es<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetElapsedTimeOnTheOnTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigne d char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigne d char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Current stage of washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current stage of the washer and dryer cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41<br>
		 * Rinsing = 0x42<br>
		 * Spin drying = 0x43<br>
		 * Suspended = 0x44<br>
		 * Washing completed = 0x45<br>
		 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
		 * Drying = 0x52<br>
		 * Wrinkling minimization = 0x53<br>
		 * Drying (with wrinkling minimization) completed = 0x54<br>
		 * Standing by to start = 0x61<br>
		 * 1st rinsing = 0x71<br>
		 * 2nd rinsing = 0x72<br>
		 * 3rd rinsing = 0x73<br>
		 * 4th rinsing = 0x74<br>
		 * 5th rinsing = 0x75<br>
		 * 6th rinsing = 0x76<br>
		 * 7th rinsing = 0x77<br>
		 * 8th rinsing = 0x78<br>
		 * 1st spin drying = 0x81<br>
		 * 2nd spin drying = 0x82<br>
		 * 3rd spin drying = 0x83<br>
		 * 4th spin drying = 0x84<br>
		 * 5th spin drying = 0x85<br>
		 * 6th spin drying = 0x86<br>
		 * 7th spin drying = 0x87<br>
		 * 8th spin drying = 0x88<br>
		 * Preheat spin drying = 0x91<br>
		 * Unique code defined by the manufature = 0xE0 to 0xEF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetCurrentStageOfWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x7F (0 to 127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF (1 to 32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x7F (0 to 127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF (1 to 32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWashingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWashingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gNumber of times of rinsing h setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 8 times (0x00 to 0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gNumber of times of rinsing h setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 8 times (0x00 to 0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
 ~4<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
 ~4<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x3B (0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF: 1 to 32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x3B (0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF: 1 to 32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 100  C (0x00 to 0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWarmWaterSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 100  C (0x00 to 0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWarmWaterSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40<br>
		 * Washing only                      : 0x41<br>
		 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43<br>
		 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40<br>
		 * Washing only                      : 0x41<br>
		 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43<br>
		 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function<br>
		 * ON                  : 0x41<br>
		 * Wrinkling minimization function<br>
		 * OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function<br>
		 * ON                  : 0x41<br>
		 * Wrinkling minimization function<br>
		 * OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Time remaining to complete washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time remaining to complete the current washer and<br>
		 * dryer .cycle .in .the . gHH: .MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: 0 to 0x3B<br>
		 * (= 0 to 254 hours): (= 0 to 59 minutes)<br>
		 * Remaining time unknown = 0xFF:<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetTimeRemainingToCompleteWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current washer and dryer cycle setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bytes 1 and 2: This property indicates the available<br>
		 * items in a bitmap format.<br>
		 * Byte 3: Presoaking<br>
		 * With presoaking: 0x41<br>
		 * Without presoaking: 0x42<br>
		 * Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced.<br>
		 * Byte 6: Number of times of rinsing<br>
		 * The value of the  g fnumber of times of rinsing f setting h property shall be referenced.<br>
		 * Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced.<br>
		 * Byte 11: Spin drying time<br>
		 * The value of the  gspin drying time setting h property shall be referenced.<br>
		 * Bytes 12 and 13: Drying time<br>
		 * The value of the  hdrying time setting h<br>
		 * property shall be referenced.<br>
		 * Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced.<br>
		 * Byte 15: Water volume setting 1<br>
		 * The value of the  gwater volume setting 1 h property shall be referenced.<br>
		 * Byte 16: Water volume setting 2<br>
		 * The value of the  gwater volume setting 2 h property shall be referenced.<br>
		 * Byte 17: Bathtub water recycle setting<br>
		 * The value of the  gbathtub water recycle setting h property<br>
		 * shall be referenced.<br>
		 * Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced.<br>
		 * Bytes 19 and 20:  gRotation speed for spin drying h setting<br>
		 * The value of the  g frotation speed for spin drying f setting h property<br>
		 * shall be referenced.<br>
		 * Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
		 * The value of the  gpresoaking time setting h property shall be referenced.<br>
		 * Byte 24: Wrinkling minimization setting<br>
		 * The value of the  gwrinkling<br>
		 * minimization setting h property shall be referenced.<br>
		 * <br>
		 * Data type : unsigned
Char
 ~24<br>
		 * <br>
		 * Data size : 24 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation<br>
		 * OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation<br>
		 * OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41<br>
		 * Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWasherAndDryerSetting(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying couse: 0x21 to<br>
		 * 0x3F<br>
		 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
		 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
		 * 0x80 to 0x8F<br>
		 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
		 * 0xC0 to 0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying cource><br>
		 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
		 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing cource / maker original cource<br>
		 * = 0x40 to 0x4F<br>
		 * <Washing cource><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
		 * 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory =<br>
		 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing cource / maker original cource<br>
		 * = 0x80 to 0x8F<br>
		 * <Drying cource><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
		 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
		 * 0xAB, user definition of drying time =<br>
		 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
		 * Drying cource / maker original cource<br>
		 * = 0xC0 to 0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWasherAndDryerCycleSetting1Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1, edt);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the<br>
		 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
		 * setting h property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard =<br>
		 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29,<br>
		 * disinfection = 0x2D, oil stains =<br>
		 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
		 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
		 * 0x3F<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWasherAndDryerCycleSetting2Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1, edt);
			return this;
		}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
		 * 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
		 * 0xA4, ironing/business shirts =<br>
		 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
		 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
		 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDryingCycleSettingNote1(byte[] edt) {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1, edt);
			return this;
		}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWaterFlowRateSetting(byte[] edt) {
			addProperty(EPC_WATER_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gRotation speed for spin drying h
setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
		 * <br>
		 * Data type : unsign ed short<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGrotationSpeedForSpinDryingHSetting(byte[] edt) {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gDegree of drying h setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGdegreeOfDryingHSetting(byte[] edt) {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigne d char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetPresoakingTimeSetting(byte[] edt) {
			addProperty(EPC_PRESOAKING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x7F (0 to 127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF (1 to 32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWashingTimeSetting(byte[] edt) {
			addProperty(EPC_WASHING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gNumber of times of rinsing h setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 8 times (0x00 to 0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGnumberOfTimesOfRinsingHSetting(byte[] edt) {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
 ~4<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRinsingProcessSetting(byte[] edt) {
			addProperty(EPC_RINSING_PROCESS_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x3B (0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF: 1 to 32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSpinDryingTimeSetting(byte[] edt) {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDryingTimeSetting(byte[] edt) {
			addProperty(EPC_DRYING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 100  C (0x00 to 0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWarmWaterSetting(byte[] edt) {
			addProperty(EPC_WARM_WATER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40<br>
		 * Washing only                      : 0x41<br>
		 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43<br>
		 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathtubWaterRecycleSetting(byte[] edt) {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function<br>
		 * ON                  : 0x41<br>
		 * Wrinkling minimization function<br>
		 * OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWrinklingMinimizationSetting(byte[] edt) {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDoorCoverLockSetting(byte[] edt) {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation<br>
		 * OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt);
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
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41<br>
		 * Door/cover closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41<br>
		 * Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerSetting() {
			addProperty(EPC_WASHER_AND_DRYER_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying couse: 0x21 to<br>
		 * 0x3F<br>
		 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
		 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
		 * 0x80 to 0x8F<br>
		 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
		 * 0xC0 to 0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying cource><br>
		 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
		 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing cource / maker original cource<br>
		 * = 0x40 to 0x4F<br>
		 * <Washing cource><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
		 * 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory =<br>
		 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing cource / maker original cource<br>
		 * = 0x80 to 0x8F<br>
		 * <Drying cource><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
		 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
		 * 0xAB, user definition of drying time =<br>
		 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
		 * Drying cource / maker original cource<br>
		 * = 0xC0 to 0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleSetting1Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the<br>
		 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
		 * setting h property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard =<br>
		 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29,<br>
		 * disinfection = 0x2D, oil stains =<br>
		 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
		 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
		 * 0x3F<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleSetting2Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1);
			return this;
		}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
		 * 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
		 * 0xA4, ironing/business shirts =<br>
		 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
		 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
		 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDryingCycleSettingNote1() {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 1<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer<br>
		 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
		 * detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~12,<br>
		 * <br>
		 * Data size : 12 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 2<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer<br>
		 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
		 * detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~4,<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList2() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 3<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~4,<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList3() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3);
			return this;
		}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWaterFlowRateSetting() {
			addProperty(EPC_WATER_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name :  gRotation speed for spin drying h
setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
		 * <br>
		 * Data type : unsign ed short<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGrotationSpeedForSpinDryingHSetting() {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING);
			return this;
		}
		/**
		 * Property name :  gDegree of drying h setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGdegreeOfDryingHSetting() {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining washing time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining washing time<br>
		 * in .the . gHH:MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0xFE F0-0x3B<br>
		 * (=0-254) hours F(=0-59) minutes<br>
		 * Remaining time unknown=0xFF F<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigne d
char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRemainingWashingTime() {
			addProperty(EPC_REMAINING_WASHING_TIME);
			return this;
		}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining drying<br>
		 * time .in .the . gHH:MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0xFE F0-0x3B<br>
		 * (=0-254) hours F(=0-59) minutes<br>
		 * Remaining time<br>
		 * unknown=0xFF F0xFF<br>
		 * <br>
		 * Data type : unsign ed<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		/**
		 * Property name : Elapsed time on the ON timer<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigne d
char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : Hour
minut es<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetElapsedTimeOnTheOnTimer() {
			addProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER);
			return this;
		}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigne d char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetPresoakingTimeSetting() {
			addProperty(EPC_PRESOAKING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Current stage of washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current stage of the washer and dryer cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41<br>
		 * Rinsing = 0x42<br>
		 * Spin drying = 0x43<br>
		 * Suspended = 0x44<br>
		 * Washing completed = 0x45<br>
		 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
		 * Drying = 0x52<br>
		 * Wrinkling minimization = 0x53<br>
		 * Drying (with wrinkling minimization) completed = 0x54<br>
		 * Standing by to start = 0x61<br>
		 * 1st rinsing = 0x71<br>
		 * 2nd rinsing = 0x72<br>
		 * 3rd rinsing = 0x73<br>
		 * 4th rinsing = 0x74<br>
		 * 5th rinsing = 0x75<br>
		 * 6th rinsing = 0x76<br>
		 * 7th rinsing = 0x77<br>
		 * 8th rinsing = 0x78<br>
		 * 1st spin drying = 0x81<br>
		 * 2nd spin drying = 0x82<br>
		 * 3rd spin drying = 0x83<br>
		 * 4th spin drying = 0x84<br>
		 * 5th spin drying = 0x85<br>
		 * 6th spin drying = 0x86<br>
		 * 7th spin drying = 0x87<br>
		 * 8th spin drying = 0x88<br>
		 * Preheat spin drying = 0x91<br>
		 * Unique code defined by the manufature = 0xE0 to 0xEF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCurrentStageOfWasherAndDryerCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x7F (0 to 127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF (1 to 32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWaterVolumeSetting1() {
			addProperty(EPC_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWaterVolumeSetting2() {
			addProperty(EPC_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWashingTimeSetting() {
			addProperty(EPC_WASHING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name :  gNumber of times of rinsing h setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 8 times (0x00 to 0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGnumberOfTimesOfRinsingHSetting() {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING);
			return this;
		}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
 ~4<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRinsingProcessSetting() {
			addProperty(EPC_RINSING_PROCESS_SETTING);
			return this;
		}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x3B (0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF: 1 to 32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSpinDryingTimeSetting() {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDryingTimeSetting() {
			addProperty(EPC_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 100  C (0x00 to 0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWarmWaterSetting() {
			addProperty(EPC_WARM_WATER_SETTING);
			return this;
		}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40<br>
		 * Washing only                      : 0x41<br>
		 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43<br>
		 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathtubWaterRecycleSetting() {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING);
			return this;
		}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function<br>
		 * ON                  : 0x41<br>
		 * Wrinkling minimization function<br>
		 * OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWrinklingMinimizationSetting() {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time remaining to complete washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time remaining to complete the current washer and<br>
		 * dryer .cycle .in .the . gHH: .MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: 0 to 0x3B<br>
		 * (= 0 to 254 hours): (= 0 to 59 minutes)<br>
		 * Remaining time unknown = 0xFF:<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTimeRemainingToCompleteWasherAndDryerCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDoorCoverLockSetting() {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current washer and dryer cycle setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bytes 1 and 2: This property indicates the available<br>
		 * items in a bitmap format.<br>
		 * Byte 3: Presoaking<br>
		 * With presoaking: 0x41<br>
		 * Without presoaking: 0x42<br>
		 * Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced.<br>
		 * Byte 6: Number of times of rinsing<br>
		 * The value of the  g fnumber of times of rinsing f setting h property shall be referenced.<br>
		 * Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced.<br>
		 * Byte 11: Spin drying time<br>
		 * The value of the  gspin drying time setting h property shall be referenced.<br>
		 * Bytes 12 and 13: Drying time<br>
		 * The value of the  hdrying time setting h<br>
		 * property shall be referenced.<br>
		 * Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced.<br>
		 * Byte 15: Water volume setting 1<br>
		 * The value of the  gwater volume setting 1 h property shall be referenced.<br>
		 * Byte 16: Water volume setting 2<br>
		 * The value of the  gwater volume setting 2 h property shall be referenced.<br>
		 * Byte 17: Bathtub water recycle setting<br>
		 * The value of the  gbathtub water recycle setting h property<br>
		 * shall be referenced.<br>
		 * Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced.<br>
		 * Bytes 19 and 20:  gRotation speed for spin drying h setting<br>
		 * The value of the  g frotation speed for spin drying f setting h property<br>
		 * shall be referenced.<br>
		 * Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
		 * The value of the  gpresoaking time setting h property shall be referenced.<br>
		 * Byte 24: Wrinkling minimization setting<br>
		 * The value of the  gwrinkling<br>
		 * minimization setting h property shall be referenced.<br>
		 * <br>
		 * Data type : unsigned
Char
 ~24<br>
		 * <br>
		 * Data size : 24 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycle() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation<br>
		 * OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
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
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41<br>
		 * Door/cover closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41<br>
		 * Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerSetting() {
			addProperty(EPC_WASHER_AND_DRYER_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying couse: 0x21 to<br>
		 * 0x3F<br>
		 * Washing and drying cource maker original code: 0x40 to 0x4F<br>
		 * Washing cource: 0x61 to 0x7F Washing cource maker original code:<br>
		 * 0x80 to 0x8F<br>
		 * Drying cource: 0xA1 to 0xBF Drying cource maker original code:<br>
		 * 0xC0 to 0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying cource><br>
		 * Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving =<br>
		 * 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing cource / maker original cource<br>
		 * = 0x40 to 0x4F<br>
		 * <Washing cource><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry =<br>
		 * 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory =<br>
		 * 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing cource / maker original cource<br>
		 * = 0x80 to 0x8F<br>
		 * <Drying cource><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection =<br>
		 * 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying =<br>
		 * 0xAB, user definition of drying time =<br>
		 * 0xAC, garment warming = 0xAD, tank drying = 0xBF<br>
		 * Drying cource / maker original cource<br>
		 * = 0xC0 to 0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleSetting1Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the<br>
		 *  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle<br>
		 * setting h property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard =<br>
		 * 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry =<br>
		 * 0x28, clean rinsing = 0x29,<br>
		 * disinfection = 0x2D, oil stains =<br>
		 * 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes<br>
		 * = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning =<br>
		 * 0x3F<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleSetting2Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1);
			return this;
		}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC =<br>
		 * 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry =<br>
		 * 0xA4, ironing/business shirts =<br>
		 * 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying<br>
		 * = 0xAB, user definition of drying time = 0xAC, garment warming =<br>
		 * 0xAD, heater current limit = 0xAE, tank drying = 0xBF<br>
		 * Maker original cource = 0xE0 to<br>
		 * 0xEF<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDryingCycleSettingNote1() {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 1<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer<br>
		 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
		 * detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~12,<br>
		 * <br>
		 * Data size : 12 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 2<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer<br>
		 * cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the<br>
		 * detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~4,<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList2() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 3<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsign ed
char
 ~4,<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList3() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3);
			return this;
		}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWaterFlowRateSetting() {
			addProperty(EPC_WATER_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name :  gRotation speed for spin drying h
setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000 to 0x0FFF (0 to 4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA7FF (1 to 2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC7FF (1 to 2048r/min.)<br>
		 * <br>
		 * Data type : unsign ed short<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGrotationSpeedForSpinDryingHSetting() {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING);
			return this;
		}
		/**
		 * Property name :  gDegree of drying h setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsign ed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGdegreeOfDryingHSetting() {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining washing time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining washing time<br>
		 * in .the . gHH:MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0xFE F0-0x3B<br>
		 * (=0-254) hours F(=0-59) minutes<br>
		 * Remaining time unknown=0xFF F<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigne d
char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRemainingWashingTime() {
			addProperty(EPC_REMAINING_WASHING_TIME);
			return this;
		}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining drying<br>
		 * time .in .the . gHH:MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0xFE F0-0x3B<br>
		 * (=0-254) hours F(=0-59) minutes<br>
		 * Remaining time<br>
		 * unknown=0xFF F0xFF<br>
		 * <br>
		 * Data type : unsign ed<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		/**
		 * Property name : Elapsed time on the ON timer<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigne d
char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : Hour
minut es<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformElapsedTimeOnTheOnTimer() {
			addProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER);
			return this;
		}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigne d char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformPresoakingTimeSetting() {
			addProperty(EPC_PRESOAKING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Current stage of washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current stage of the washer and dryer cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41<br>
		 * Rinsing = 0x42<br>
		 * Spin drying = 0x43<br>
		 * Suspended = 0x44<br>
		 * Washing completed = 0x45<br>
		 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
		 * Drying = 0x52<br>
		 * Wrinkling minimization = 0x53<br>
		 * Drying (with wrinkling minimization) completed = 0x54<br>
		 * Standing by to start = 0x61<br>
		 * 1st rinsing = 0x71<br>
		 * 2nd rinsing = 0x72<br>
		 * 3rd rinsing = 0x73<br>
		 * 4th rinsing = 0x74<br>
		 * 5th rinsing = 0x75<br>
		 * 6th rinsing = 0x76<br>
		 * 7th rinsing = 0x77<br>
		 * 8th rinsing = 0x78<br>
		 * 1st spin drying = 0x81<br>
		 * 2nd spin drying = 0x82<br>
		 * 3rd spin drying = 0x83<br>
		 * 4th spin drying = 0x84<br>
		 * 5th spin drying = 0x85<br>
		 * 6th spin drying = 0x86<br>
		 * 7th spin drying = 0x87<br>
		 * 8th spin drying = 0x88<br>
		 * Preheat spin drying = 0x91<br>
		 * Unique code defined by the manufature = 0xE0 to 0xEF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCurrentStageOfWasherAndDryerCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x7F (0 to 127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF (1 to 32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWaterVolumeSetting1() {
			addProperty(EPC_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31 to 0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xA7: Levels 1 to 8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xC7: Levels 1 to 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWaterVolumeSetting2() {
			addProperty(EPC_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWashingTimeSetting() {
			addProperty(EPC_WASHING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name :  gNumber of times of rinsing h setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 8 times (0x00 to 0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGnumberOfTimesOfRinsingHSetting() {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING);
			return this;
		}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
 ~4<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRinsingProcessSetting() {
			addProperty(EPC_RINSING_PROCESS_SETTING);
			return this;
		}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x3B (0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0 to 0xBF: 1 to 32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0 to 0xDF: 1 to 32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSpinDryingTimeSetting() {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00 to 0x17: 0x00 to 0x3B<br>
		 * (= 0 to 23 hours): (= 0 to 59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting<br>
		 * 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000 to 0xA03B: 1 to 60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000 to 0xC03B: 1 to 60 minutes<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDryingTimeSetting() {
			addProperty(EPC_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 100  C (0x00 to 0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWarmWaterSetting() {
			addProperty(EPC_WARM_WATER_SETTING);
			return this;
		}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40<br>
		 * Washing only                      : 0x41<br>
		 * Rinsing only (excluding the final rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43<br>
		 * Washing + rinsing (excluding the final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathtubWaterRecycleSetting() {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING);
			return this;
		}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function<br>
		 * ON                  : 0x41<br>
		 * Wrinkling minimization function<br>
		 * OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWrinklingMinimizationSetting() {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time remaining to complete washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time remaining to complete the current washer and<br>
		 * dryer .cycle .in .the . gHH: .MM h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: 0 to 0x3B<br>
		 * (= 0 to 254 hours): (= 0 to 59 minutes)<br>
		 * Remaining time unknown = 0xFF:<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTimeRemainingToCompleteWasherAndDryerCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDoorCoverLockSetting() {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current washer and dryer cycle setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bytes 1 and 2: This property indicates the available<br>
		 * items in a bitmap format.<br>
		 * Byte 3: Presoaking<br>
		 * With presoaking: 0x41<br>
		 * Without presoaking: 0x42<br>
		 * Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced.<br>
		 * Byte 6: Number of times of rinsing<br>
		 * The value of the  g fnumber of times of rinsing f setting h property shall be referenced.<br>
		 * Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced.<br>
		 * Byte 11: Spin drying time<br>
		 * The value of the  gspin drying time setting h property shall be referenced.<br>
		 * Bytes 12 and 13: Drying time<br>
		 * The value of the  hdrying time setting h<br>
		 * property shall be referenced.<br>
		 * Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced.<br>
		 * Byte 15: Water volume setting 1<br>
		 * The value of the  gwater volume setting 1 h property shall be referenced.<br>
		 * Byte 16: Water volume setting 2<br>
		 * The value of the  gwater volume setting 2 h property shall be referenced.<br>
		 * Byte 17: Bathtub water recycle setting<br>
		 * The value of the  gbathtub water recycle setting h property<br>
		 * shall be referenced.<br>
		 * Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced.<br>
		 * Bytes 19 and 20:  gRotation speed for spin drying h setting<br>
		 * The value of the  g frotation speed for spin drying f setting h property<br>
		 * shall be referenced.<br>
		 * Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
		 * The value of the  gpresoaking time setting h property shall be referenced.<br>
		 * Byte 24: Wrinkling minimization setting<br>
		 * The value of the  gwrinkling<br>
		 * minimization setting h property shall be referenced.<br>
		 * <br>
		 * Data type : unsigned
Char
 ~24<br>
		 * <br>
		 * Data size : 24 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycle() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation<br>
		 * OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRelativeTimeBasedOnTimerSetting() {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends WasherAndDryer {
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
