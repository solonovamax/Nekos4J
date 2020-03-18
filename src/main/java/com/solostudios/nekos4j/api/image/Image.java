package com.solostudios.nekos4j.api.image;

import java.awt.image.BufferedImage;


public interface Image {
    /**
     * Gets the image that this object represents.
     *
     * @return
     */
    BufferedImage getImage();
    
    /**
     * Gets the type of the image.
     *
     * @return
     */
    String getType();
    
    /**
     * Gets the url for the image this object represents.
     *
     * @return
     */
    String getURL();
}
