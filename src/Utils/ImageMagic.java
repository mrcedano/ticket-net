
package Utils;

import java.awt.Image;
import javax.swing.ImageIcon;


public class ImageMagic {
    public static ImageIcon resizeImage(ImageIcon imageIcon, int newWidth, int newHeight) {
        return new ImageIcon(imageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));
    }
}
