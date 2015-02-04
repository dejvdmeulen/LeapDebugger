/**
 * Created by Bill Gates on 17/01/14.
 */
public class LeapMotionFilter {

    class FIR {
        private int length;
        private double[] delayLine;
        private double[] impulseResponse;
        private int count = 0;

        /**
         * This method always returns immediately, whether or not the
         * image exists. When this applet attempts to draw the image on
         * the screen, the data will be loaded. The graphics primitives
         * that draw the image will incrementally paint on the screen.
         *
         * @param  url  an absolute URL giving the base location of the image
         * @param  name the location of the image, relative to the url argument
         * @return      the image at the specified URL
         * @see
         */
        FIR(double[] coefs) {
            length = coefs.length;
            impulseResponse = coefs;
            delayLine = new double[length];
        }

        /**
         * This method always returns immediately, whether or not the
         * image exists. When this applet attempts to draw the image on
         * the screen, the data will be loaded. The graphics primitives
         * that draw the image will incrementally paint on the screen.
         *
         * @param  url  an absolute URL giving the base location of the image
         * @param  name the location of the image, relative to the url argument
         * @return      the image at the specified URL
         * @see
         */
        double getOutputSample(double inputSample) {
            delayLine[count] = inputSample;
            double result = 0.0;
            int index = count;
            for (int i=0; i<length; i++) {
                result += impulseResponse[i] * delayLine[index--];
                if (index < 0) index = length-1;
            }
            if (++count >= length) count = 0;
            return result;
        }
    }
}
