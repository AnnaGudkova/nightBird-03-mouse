import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Actuator {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		File file=new File("world.txt");
		InputStream instream=new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		PrintableWoodLoader W=new PrintableWoodLoader();
		PrintableWood wood=W.PrintableWoodLoad(instream,System.out);
		MyMouse mouse = new MyMouse();
		int xStart, yStart, xFinish, yFinish;
		Point start, finish;
		Action currentAction;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Woodman's name:" + System.lineSeparator());
		String name = scanner.nextLine();
		
		System.out.println("Woodman's xStartCoordinate:" + System.lineSeparator());
		xStart = scanner.nextInt();
		System.out.println("Woodman's yStartCoordinate:" + System.lineSeparator());
		yStart = scanner.nextInt();		
		start = new Point(xStart,yStart);
		
		System.out.println("Woodman's xFinishCoordinate:" + System.lineSeparator());
		xFinish = scanner.nextInt();
		System.out.println("Woodman's yFinishCoordinate:" + System.lineSeparator());
		yFinish = scanner.nextInt();	
		finish = new Point(xFinish,yFinish);
		
		currentAction = Action.Ok;		
		wood.createWoodman(name, start, finish);
		System.out.println("Your result: ");
		if ((currentAction == Action.WoodmanNotFound)) {
			throw new CodeException("Woodman not found");
		} 
		while (currentAction != Action.Finish) {
			currentAction = wood.move(name, mouse.NextMove(currentAction));	
		} 	
		if (currentAction == Action.Finish) {
			System.out.println("Congratulations! Woodman reached the finish!");
		}
		else {
			System.out.println("Unfortunately, woodman didn't reach the finish");
		}
	}
		
}
