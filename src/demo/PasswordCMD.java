package demo;

public class PasswordCMD {
	private static final String KEY="yaicwx";

	public String toGeneratePassword(String key) {
	
		return DataSafeUtil.decryptByBASE64(key.trim());
	}

	public String toSeePassword(String key) {
		
		return 	DataSafeUtil.encryptByBASE64(key.trim());
	}
}
