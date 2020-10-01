package com.zipper.aline;

import com.zipper.aline.util.Complex;
import com.zipper.aline.util.FFT;
import org.junit.Test;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/22.
 */
public class Util {


    @Test
    public void getFFT() {
        Complex[] signals = new Complex[1000];
        for (int i = 0; i < 1000000; i++) {
            Math.sin(i / 0.01);
        }

        FFT fft = new FFT();
        System.out.println(signals);
        Complex[] out = fft.fft(signals);
        System.out.println(out);

    }
}
