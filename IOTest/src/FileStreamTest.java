import java.io.*;
public class FileStreamTest {

	public static void main(String[] args)
	{
		/*byte[] bw= {65,66,67,68};
		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("test.txt");
			/*for(byte b:bw)
			{
				fos.write(b);
			}*/
			/*fos.write(bw);
		fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis=new FileInputStream("test.txt");
			int sz=fis.available();
			
			for(int i=0;i<sz;i++)
			{
				System.out.println((char)fis.read());
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*int width = 10;
		Drawable d = () -> System.out.println("Drawing " + width);
		d.draw();*/
		
		SomeFunc<String> revrs = (str) -> {
			String result="";
			for(int i=str.length()-1;i>=0;i--)
			{
				result += str.charAt(i);
			}
			return result;
		};
		System.out.println("Reversed String is : " + revrs.func("Lambda"));
		}
	}

