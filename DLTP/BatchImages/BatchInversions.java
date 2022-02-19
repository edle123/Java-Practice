
/**
 * Write a description of BatchInversions here.
 * 
 * @Eric
 * @version 1, February 19th, 2022
 */
import edu.duke.ImageResource;
import edu.duke.FileResource;
import edu.duke.DirectoryResource;
import edu.duke.Pixel;
import java.io.File;

public class BatchInversions {
    public ImageResource makeInversion(ImageResource image){
        for (Pixel pixel : image.pixels()){
            pixel.setRed(255-pixel.getRed());
            pixel.setGreen(255-pixel.getGreen());
            pixel.setBlue(255-pixel.getBlue());
        }
        image.save();
        return image;
    }

    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            ImageResource copyImage = image;
            String imageName = image.getFileName();
            String newName = "inverted-"+imageName;
            makeInversion(copyImage);
            copyImage.setFileName(newName);
            copyImage.draw();
            copyImage.save();
        }

    }
}
