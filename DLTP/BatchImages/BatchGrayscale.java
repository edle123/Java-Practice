/**
 * Prompts the user to select at least one image file, then returns a copy
 * of the selected image file in grayscale.
 * 
 * @Eric
 * @version 1, February 19th, 2022
 */

import edu.duke.ImageResource;
import edu.duke.DirectoryResource;
import edu.duke.Pixel;
import java.io.File;

public class BatchGrayscale {
    public void grayscale(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            ImageResource copyImage = image;
            String imageName = image.getFileName();
            String newName = "gray-"+imageName;            
            for(Pixel pixel : copyImage.pixels()){
                int average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                pixel.setRed(average);
                pixel.setGreen(average);
                pixel.setBlue(average);
            }
            copyImage.draw();
            copyImage.setFileName(newName);
            copyImage.save();
        }
    }
}
