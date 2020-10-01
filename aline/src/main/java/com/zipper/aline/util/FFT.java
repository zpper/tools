package com.zipper.aline.util;

public class FFT {
    /**
     * 快速傅里叶逆变换
     *
     * @param x
     * @return
     */
    public Complex[] fft(Complex[] x) {
        int n = x.length;

        // 因为exp(-2i*n*PI)=1，n=1时递归原点
        if (n == 1) {
            return x;
        }

        // 如果信号数为奇数，使用dft计算
        if (n % 2 != 0) {
            return dft(x);
        }

        // 提取下标为偶数的原始信号值进行递归fft计算
        Complex[] even = new Complex[n / 2];
        for (int k = 0; k < n / 2; k++) {
            even[k] = x[2 * k];
        }
        Complex[] evenValue = fft(even);

        // 提取下标为奇数的原始信号值进行fft计算
        // 节约内存
        Complex[] odd = even;
        for (int k = 0; k < n / 2; k++) {
            odd[k] = x[2 * k + 1];
        }
        Complex[] oddValue = fft(odd);

        // 偶数+奇数
        Complex[] result = new Complex[n];
        for (int k = 0; k < n / 2; k++) {
            // 使用欧拉公式e^(-i*2pi*k/N) = cos(-2pi*k/N) + i*sin(-2pi*k/N)
            double p = -2 * k * Math.PI / n;
            Complex m = new Complex(Math.cos(p), Math.sin(p));
            result[k] = evenValue[k].add(m.mul(oddValue[k]));
            // exp(-2*(k+n/2)*PI/n) 相当于 -exp(-2*k*PI/n)，其中exp(-n*PI)=-1(欧拉公式);
            result[k + n / 2] = evenValue[k].sub(m.mul(oddValue[k]));
        }
        return result;
    }

    /**
     * 傅里叶变换 ,效率低
     *
     * @param x
     * @return
     */
    public Complex[] dft(Complex[] x) {
        int n = x.length;

        // 1个信号exp(-2i*n*PI)=1
        if (n == 1)
            return x;

        Complex[] result = new Complex[n];
        for (int i = 0; i < n; i++) {
            result[i] = new Complex(0, 0);
            for (int k = 0; k < n; k++) {
                //使用欧拉公式e^(-i*2pi*k/N) = cos(-2pi*k/N) + i*sin(-2pi*k/N)
                double p = -2 * k * Math.PI / n;
                Complex m = new Complex(Math.cos(p), Math.sin(p));
                result[i].add(x[k].mul(m));
            }
        }
        return result;
    }


}
