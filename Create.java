import java.io.File;
import java.io.IOException;

class Create{
	public static void main(String[] args){
		try{
		File file = new File("test.txt");
		System.out.println("jello World");
		if (file.createNewFile()){
			System.out.println("File created: " + file.getName());
		} else {
			System.out.println("File already exists.");
		}
		} catch (IOException e) {
			System.out.println("An Error Occurred.");
			e.printStackTrace();
		}

		}
}
