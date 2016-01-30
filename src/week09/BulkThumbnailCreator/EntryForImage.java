package week09.BulkThumbnailCreator;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class EntryForImage {
    private BufferedImage image;
    private String linkTo;
    private String nameTo;

    public String getNameTo() {
        return nameTo;
    }

    public BufferedImage getImage() {
        return image;
    }



    public String getLinkTo() {

        return linkTo;
    }

    private void setLinkTo(String linkTo) {
        Path path = Paths.get(linkTo);
        this.nameTo = path.getFileName().toString();
        this.linkTo = path.getParent().toString() + "//thumbnails";
    }

    public EntryForImage(BufferedImage image, String linkTo) {
        this.image = image;
        setLinkTo(linkTo);
    }
}
