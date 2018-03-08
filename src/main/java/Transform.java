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
    private static final int ARBITRARILY_HIGH = 245;
    /**
     *
     */
    private static final int TEN = 10;

    /**
     *
     */
    public static final int FULL_PIXEL = 225;

    /**
     *
     * @param originalImage Image to be shifted.
     * @param shiftx Amount to shift x by.
     * @param shifty Amount to shift y by.
     * @return an image array with the pixels shifted horizontally.
     */
    public static RGBAPixel[][] shift(final RGBAPixel[][] originalImage,
                                                final int shiftx,
                                      final int shifty) {
        RGBAPixel[][]newImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                newImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                if (i + shiftx < 0 || i + shiftx > originalImage.length - 1
                        || j + shifty < 0 || j + shifty > originalImage[i].length - 1) {
                    continue;
                } else {
                    newImage[i + shiftx][j + shifty] = originalImage[i][j];
                }
            }
        }
        return newImage;
    }

    /**
     *
     * @param originalImage the image to flip
     * @param upRight a decider int for flipping vertically or horizontally
     * @return a copy array
     */

    public static RGBAPixel[][]flip(final RGBAPixel[][] originalImage, final int upRight) {
        RGBAPixel[][] newImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i <= originalImage.length - 1; i++) {
            for (int j = 0; j <= originalImage[i].length - 1; j++) {
                if (upRight == 1) {
                    newImage[i][j] = originalImage[originalImage.length - 1 - i][j];
                }
                if (upRight == 2) {
                    newImage[i][j] = originalImage[i][originalImage[i].length - 1 - j];
                }
            }
        }
        return newImage;
    }

    /**
     *
     * @param originalImage The image to be rotated
     * @return a copy of the image rotated
     */
    public static RGBAPixel[][] rotate(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] newImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        double horicenter = (originalImage.length - 1) / 2.0;
        double verticenter = (originalImage[0].length - 1) / 2.0;
        double shiftX = 0.0;
        double shiftY = 0.0;
        for (int i = 0; i < newImage.length; i++) {
            for (int j = 0; j < newImage[i].length; j++) {
                newImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        for (int row = 0; row < originalImage.length; row++) {
            shiftX = row - horicenter;
            for (int col = 0; col < originalImage[row].length; col++) {
                shiftY = col - verticenter;
                int shiftValueY = (int) (shiftY + horicenter);
                int shiftValueX = (int) (-shiftX + verticenter);
                if (shiftValueY >= originalImage.length || shiftValueY < 0
                        || shiftValueX >= originalImage[row].length || shiftValueX < 0) {
                    continue;
                } else {
                    newImage[row][col] = originalImage[shiftValueY][shiftValueX];
                }
            }
        }
        for (int i = 0; i < newImage.length; i++) {
            for (int j = 0; j < newImage[i].length; j++) {
                if (newImage[i][j] == null) {
                    newImage[i][j].setRed(FULL_PIXEL);
                }
            }
        }
        return newImage;
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
        return Transform.shift(originalImage, -1 * amount, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.shift(originalImage, amount, 0);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.shift(originalImage, 0, -1 * amount);
    }
    /**
     *
     * @param originalImage the image to change
     * @param amount the amount by which it changes.
     * @return color shifted image
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        return Transform.shift(originalImage, 0, amount);
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
        return Transform.rotate(Transform.rotate(Transform.rotate(originalImage)));
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][]originalImage) {
        return Transform.rotate(originalImage);
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][]originalImage) {
        return Transform.flip(originalImage, 2);
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][]originalImage) {
        return Transform.flip(originalImage, 1);
    }
    /**
     *
     * @param originalImage the image to change
     * @return a thing
     */
    public static RGBAPixel[][] mystery(final RGBAPixel[][]originalImage) {
        return null;
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
                if (originalImage[i][j].getGreen() >= ARBITRARILY_HIGH
                        && originalImage[i][j].getRed() <= TEN
                        && originalImage[i][j].getBlue() <= TEN) {
                    newImage[i][j] = RGBAPixel.getFillValue();
                } else {
                    newImage[i][j] = originalImage[i][j];
                }
            }
        }
        return newImage;
    }
}
