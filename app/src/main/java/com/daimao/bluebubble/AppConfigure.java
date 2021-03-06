package com.daimao.bluebubble;

import android.os.Environment;

import java.io.File;

/**
 * Created by baige on 2018/3/24.
 */

public class AppConfigure {


    public final static String KEY_GESTURE_PASSWORD = "key_gesture_password";
    public final static String LOG_TAG ="BlueBubble";
    public final static String mainServerIp = "120.78.148.180";
    public final static String secondaryServerIp = "120.79.203.153";
    public final static String tcp_default_port = "12056";
    public final static String udp_default_port = "12059";
    public final static String cmd_default_port = "12058";


    public final static String APP_HOME = Environment.getExternalStorageDirectory() + File.separator + "imchat";
    public final static String HEAD_IMG_PATH = APP_HOME + File.separator + "head";
    public final static String LOG_PATH = APP_HOME + File.separator + "log";


    public final static String KEY_IS_LOGIN = "is_login";
    public final static String KEY_USER_ID = "user_id";
    public final static String KEY_USER_NAME = "user_name";
    public final static String KEY_USER_ALIAS = "user_alias";
    public final static String KEY_PASSWORD = "user_password";
    public final static String KEY_VERIFICATION = "user_verification";
    public final static String KEY_USER_IMG = "user_img";

    public final static String KEY_SERVER_IP = "server_ip";
    public final static String KEY_SERVER_PORT = "server_port";
    public final static String KEY_DEVICE_ID = "device_id";

    public final static String IS_LOGIN = "is_login";

    /*设置*/
    public static final String KEY_PHONE_SILENCE = "key_phone_silence";
    public static final String KEY_PHONE_RING = "key_phone_ring";
    public static final String KEY_PHONE_VIBRATE = "key_phone_vibrate";

    public static final String KEY_ALERT = "key_alert";
    public static final String KEY_ALERT_VIBRATE = "key_alert_vibrate";

    public static final String KEY_PHONE_SERVER_IP_ARRAY = "key_server_ip_array";
    public static final String KEY_PHONE_SERVER_IP = "key_phone_server_ip";
    public static final String KEY_PHONE_SERVER_TCP_PORT = "key_phone_server_tcp_port";
    public static final String KEY_PHONE_SERVER_UDP_PORT = "key_phone_server_udp_port";

    public static final String DEFAULT_PHONE_SERVER_IP = "120.78.148.180";
    public static final String DEFAULT_TCP_PORT = "12056";
    public static final String DEFAULT_UDP_PORT = "12059";

    public static final String KEY_SLIP_WINDOW_COUNT = "key_slip_window_count";
    public static final String KEY_FILE_SHARE = "key_file_share";

}
