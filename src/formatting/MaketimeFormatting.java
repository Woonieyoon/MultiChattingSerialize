package formatting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MaketimeFormatting {
	
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("(yyyy-MM-dd HH:mm:ss)", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = simpleDateFormat.format(currentTime);
		return  mTime;
	}

}
