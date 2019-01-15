package demo;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class DataSafeUtil {

	/**
	 * BASE64解密
	 * @param key
	 * @return String
	 */
	public static String decryptByBASE64(String key) {
		String value="";
		BASE64Decoder base64=new BASE64Decoder();
		try {
			value=new String(base64.decodeBuffer(key));
		} catch (Exception e) {
         e.printStackTrace();
		}
		return value;
	}

	public static String encryptByBASE64(String key) {
		BASE64Encoder base64=new BASE64Encoder();
		return base64.encodeBuffer(key.getBytes());
	}
	
	

}
