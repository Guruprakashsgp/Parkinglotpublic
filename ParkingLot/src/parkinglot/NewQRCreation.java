package parkinglot;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PublicKey;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class NewQRCreation {
	String vehicle_no;
	public void NewQRCreation(String Vehicle_no)throws Exception{
		this.vehicle_no=Vehicle_no;
		String detailString="hi guru";
		ByteArrayOutputStream out=QRCode.from(vehicle_no).withSize(200, 200).to(ImageType.PNG).stream();
		File file=new File("./src/images/"+vehicle_no+ ".png");
		FileOutputStream fos;
		fos = new FileOutputStream(file);
		fos.write(out.toByteArray());
		fos.flush();
		
		
		
	}
	public static void main(String[] args) throws Exception
	{
		NewQRCreation newQRCreation=new NewQRCreation();
		newQRCreation.NewQRCreation("TN03BP3894");
	}
}

