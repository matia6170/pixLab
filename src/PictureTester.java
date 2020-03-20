
/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods. Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Joshua Ciffer
 * @author Barbara Ericson
 */
public class PictureTester {

	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("../assets/beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test zeroRed */
	public static void testZeroRed() {
		Picture beach = new Picture("../assets/beach.jpg");
		beach.explore();
		beach.zeroRed();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("../assets/caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("../assets/temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("../assets/640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("../assets/swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}

	/** Converts to black and white */
	public static void convertToBlackAndWhite() {
		Picture pic = new Picture("../assets/femaleLionAndHall.jpg");
		pic.explore();
		Pixel[][] picPixels = pic.getPixels2D();
		for (Pixel[] pixelsRow : picPixels) {
			for (Pixel pixel : pixelsRow) {
				int averageColor = (int)pixel.getAverage();
				pixel.setRed(averageColor);
				pixel.setGreen(averageColor);
				pixel.setBlue(averageColor);
			}
		}
		pic.explore();
	}

	/** Adjusts the brightness of the picture */
	public static void adjustBrightness(double brightnessPercentage) {
		Picture pic = new Picture("../assets/koala.jpg");
		pic.explore();
		Pixel[][] picPixels = pic.getPixels2D();
		for (Pixel[] pixelsRow : picPixels) {
			for (Pixel pixel : pixelsRow) {
				if ((pixel.getRed() * brightnessPercentage) > 255) {
					brightnessPercentage -= .1;
				}
				pixel.setRed((int)(pixel.getRed() * brightnessPercentage));
				if ((pixel.getGreen() * brightnessPercentage) > 255) {
					brightnessPercentage -= .1;
				}
				pixel.setGreen((int)(pixel.getGreen() * brightnessPercentage));
				if ((pixel.getBlue() * brightnessPercentage) > 255) {
					brightnessPercentage -= .1;
				}
				pixel.setBlue((int)(pixel.getBlue() * brightnessPercentage));
			}
		}
		pic.explore();
	}

	/** Mirrors the image vertically. */
	public static void verticalMirror() {
		Picture pic = new Picture("../assets/redMotorcycle.jpg");
		pic.explore();
		Pixel[][] picPixels = pic.getPixels2D();
		Pixel leftPixel;
		Pixel rightPixel;
		for (int row = 0; row < picPixels.length; row++) {
			for (int col = 0; col < picPixels[row].length; col++) {
				leftPixel = picPixels[row][col];
				rightPixel = picPixels[row][picPixels[row].length - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		pic.explore();
	}

	/** Mirrors the image horizontally. */
	public static void horizontallyMirror() {
		Picture pic = new Picture("../assets/redMotorcycle.jpg");
		pic.explore();
		Pixel[][] picPixels = pic.getPixels2D();
		Pixel leftPixel;
		Pixel rightPixel;
		for (int row = 0; row < picPixels.length; row++) {
			for (int col = 0; col < picPixels[row].length; col++) {
				leftPixel = picPixels[row][col];
				rightPixel = picPixels[picPixels.length - 1 - row][col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		pic.explore();
	}

	/** Flip the image horizontally. */
	public static void flipHorizontally() {
		Picture pic1 = new Picture("../assets/butterfly1.jpg");
		pic1.explore();
		Picture pic2 = new Picture(pic1);
		Pixel[][] pixels1 = pic1.getPixels2D();
		Pixel[][] pixels2 = pic2.getPixels2D();
		for (int row = 0; row < pixels1.length; row++) {
			for (int col = 0; col < pixels1[row].length; col++) {
				pixels2[row][pixels2[row].length - col - 1].setColor(pixels1[row][col].getColor());
			}
		}
		pic2.explore();
	}

	/** Flip the image horizontally. */
	public static void flipVertically() {
		Picture pic1 = new Picture("../assets/butterfly1.jpg");
		pic1.explore();
		Picture pic2 = new Picture(pic1);
		Pixel[][] pixels1 = pic1.getPixels2D();
		Pixel[][] pixels2 = pic2.getPixels2D();
		for (int row = 0; row < pixels1.length; row++) {
			for (int col = 0; col < pixels1[row].length; col++) {
				pixels2[pixels2.length - 1 - row][col].setColor(pixels1[row][col].getColor());
			}
		}
		pic2.explore();
	}

	/** Combines the left half of the motorcycle with the right half of the butterfly. */
	public static void buttCycle() {
		Picture pic = new Picture("../assets/redMotorcycle.jpg");
		Picture pic2 = new Picture("../assets/butterfly1.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		Pixel[][] pixels2 = pic2.getPixels2D();

		Picture pic3 = new Picture(Math.min(pixels.length, pixels2.length), (pixels[0].length / 2) + (pixels2[0].length / 2));
		Pixel[][] pixelCombine = pic3.getPixels2D();
		for (int row = 0; row < pixelCombine.length; row++) {
			for (int col = 0; col < pixelCombine[row].length - (pixels2[0].length / 2); col++) {
				pixelCombine[row][col].setColor(pixels[row][col].getColor());
			}
		}
		for (int row = 0; row < Math.min(pixels.length, pixels2.length); row++) {
			for (int col = 0; col < pixels2[row].length / 2; col++) {
				pixelCombine[row][col + (pixels[0].length / 2)].setColor(pixels2[row][col + pixels2[0].length / 2].getColor());
			}
		}
		pic3.explore();
	}
	
	/** Repairs the Greek temple picture. */
	public static void repairTemple() {
		Picture pic1 = new Picture("../assets/temple.jpg");
		Picture pic2 = new Picture(pic1);
		pic1.explore();
		Pixel[][] pixels = pic2.getPixels2D();
		for (int row = 27; row <= 96; row++) {
			for (int col = 13; col <= 275; col++) {
				pixels[row][pixels[row].length - 1 - col].setColor(pixels[row][col].getColor());
			}
		}
		pic2.explore();
	}
	
	/**
	 * Main method for testing. Every class can have a main
	 * method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test and comment out the ones you don't want to run
		// testZeroBlue();
		// testZeroRed();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorVertical();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		// testCollage();
		// testCopy();
		// testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
		// convertToBlackAndWhite();
		// adjustBrightness(.8);
		// verticalMirror();
		// horizontallyMirror();
		// flipHorizontally();
		// flipVertically();
		// buttCycle();
		// repairTemple();
	}
}