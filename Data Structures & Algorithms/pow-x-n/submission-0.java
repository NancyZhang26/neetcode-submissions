class Solution {
    
    public double myPow(double x, int n) {
        return pow(x, x, n);
    }

    public double pow(double x, double cur, int n) {
        if (n<0) {
            x = 1/x;
            cur = 1/cur;
            n = -n;
        }

        if (n==1) return x;

        double res = cur*pow(x, cur, n-1);
        
        return res;
    }
}
