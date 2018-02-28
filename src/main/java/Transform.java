/**
 *
 */
public class Transform {
    /**
     *
     */
    public static final int DEFAULT_COLOR_SHIFT = 32;
    /**
     *
     */
    public static final int DEFAULT_POSITION_SHIFT = 16;
    /**
     *
     */
    public static final int DEFAULT_RESIZE_AMOUNT = 2;
    /**
     *
     */
    public Transform() {
    }

    /**
     *
     */
    private static int arbitrarilyHigh = 245;
    /**
     *
     */
    private static int ten = 10;

    /**
     *
     */
    public static final int FULL_PIXEL = 225;

    /**
     *
     * @param originalImage Image to be shifted.
     * @param amount Amount to shift by.
     * @param direction The direction of the shift.
     * @return an image array with the pixels shifted horizontally.
     */
    public static RGBAPixel[][] shift(final RGBAPixel[][] originalImage,
                                                final int amount, final String direction) {
        return originalImage;
    }

    /**
     *
     * @param originalImage the image to be changed.
     * @param red red amount
     * @param blue blue amount
     * @param green green amount
     * @param alpha alpha amount
     * @return a colour shifted picture
     */
    public static RGBAPixel[][] colourShift(final RGBAPixel[][] originalImage, final int red,
                                            final int blue, final int green, final int alpha) {
        RGBAPixel[][]newImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                newImage[i][j] = RGBAPixel.getFillValue();
                if (originalImage[i][j].getRed() + red > FULL_PIXEL) {
                    newImage[i][j].setRed(FULL_PIXEL);
                } else {
                    newImage[i][j].setRed(originalImage[i][j].getRed() + red);
                }
                if (originalImage[i][j].getRed() + red < 0) {
                    newImage[i][j].setRed(0);
                } else {
                    newImage[i][j].setRed(originalImage[i][j].getRed() + red);
                }
                if (originalImage[i][j].getBlue() + blue > FULL_PIXEL) {
                    newImage[i][j].setBlue(FULL_PIXEL);
                } else {
                    newImage[i][j].setBlue(originalImage[i][j].getBlue() + blue);
                }
                if (originalImage[i][j].getBlue() + blue < 0) {
                    newImage[i][j].setBlue(0);
                } else {
                    newImage[i][j].setBlue(originalImage[i][j].getBlue() + blue);
                }
                if (originalImage[i][j].getGreen() + green > FULL_PIXEL) {
                    newImage[i][j].setGreen(FULL_PIXEL);
                } else {
                    newImage[i][j].setGreen(originalImage[i][j].getGreen() + green);
                }
                if (originalImage[i][j].getGreen() + green < 0) {
                    newImage[i][j].setGreen(0);
                } else {
                    newImage[i][j].setGreen(originalImage[i][j].getGreen() + green);
                }
                if (originalImage[i][j].getAlpha() + alpha > FULL_PIXEL) {
                    newImage[i][j].setAlpha(FULL_PIXEL);
                } else {
                    newImage[i][j].setAlpha(originalImage[i][j].getAlpha() + alpha);
                }
                if (originalImage[i][j].getAlpha() + alpha < 0) {
                    newImage[i][j].setAlpha(0);
                } else {
                    newImage[i][j].setAlpha(originalImage[i][j].getAlpha() + alpha);
                }
            }
        }
        return newImage;
    }
    /**
     *
     * @param originalImage the image to change.
     * @param amount the amount by which it changes.
     * @return an image array that has been modified.
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] moreRed(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, amount, 0, 0, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] lessRed(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, -1 * amount, 0, 0, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] moreGreen(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, 0, 0, amount, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] lessGreen(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, 0, 0, -1 * amount, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] moreBlue(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, 0, amount, 0, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] lessBlue(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, 0, -1 * amount, 0, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] moreAlpha(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, 0, 0, 0, amount);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] lessAlpha(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.colourShift(originalImage, 0, 0, 0, -1 * amount);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return a thing
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return a thing
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return a thing
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return a thing
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][]originalImage) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][]originalImage) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][]originalImage) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][]originalImage) {
        return originalImage;
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] mystery(final RGBAPixel[][]originalImage) {
        return originalImage;
    }
    /**
     *
     * @param originalImage The image to be green screened.
     * @return an image array that has no green values.
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] newImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                if (originalImage[i][j].getGreen() >= arbitrarilyHigh
                        && originalImage[i][j].getRed() <= ten && originalImage[i][j].getBlue() <= ten) {
                    newImage[i][j] = RGBAPixel.getFillValue();
                } else {
                    newImage[i][j] = originalImage[i][j];
                }
            }
        }
        return newImage;
    }
}
