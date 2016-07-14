package com.javalearn.test.level16.lesson13.bonus01;

import com.javalearn.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Admin on 24.11.2014.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imType){
        if (imType ==ImageTypes.BMP)
            return new BmpReader();
        else if(imType ==ImageTypes.PNG)
        return new PngReader();
        else if(imType ==ImageTypes.JPG)
        return new JpgReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки") ;

}
}
