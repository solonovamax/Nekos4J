package com.solostudios.nekos4j.internal.image;

import com.solostudios.nekos4j.api.image.Image;
import org.json.JSONObject;

import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ImageImpl implements Image {
    static final String  blackMagicRegex = "(?:http?s:\\/\\/cdn.nekos.life\\/)(?<type>.*)(?:\\/.*\\..*)";
    static final Pattern pattern         = Pattern.compile(blackMagicRegex);
    
    private final BufferedImage im;
    private final String        url;
    private final String        type;
    
    
    public ImageImpl(BufferedImage im, JSONObject jobj) {
        this.im = im;
        this.url = jobj.getString("url");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            type = matcher.group(1);
        } else {
            throw new IllegalStateException("Must have resolvable type");
        }
    }
    
    @Override
    public BufferedImage getImage() {
        return im;
    }
    
    @Override
    public String getType() {
        return type;
    }
    
    @Override
    public String getURL() {
        return url;
    }
}