package manager;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShot {
    public static void main(String[] args) {
        System.out.println(createFileNameScreenShot());
    }
    public static void takeScreenShot(TakesScreenshot screenShot){
        String fileName = createFileNameScreenShot();
        File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scrFile, new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String createFileNameScreenShot(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        String currentDate = formatter.format(date);
        System.out.println(currentDate);
        String filePath = "src/main/resources/screenshots/screnshot_"+currentDate+".png";
        return filePath;
    }
}
