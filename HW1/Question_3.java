public class CorrectCode {
    //prints all prime factors of n in order
    public static void printFactors(int n){
        //find prime numbers from 2 to n
        int[] primes = new int[20];
        int primeCount = 0;
        for(int it = 2;it <= n;it += 1){
            //Check if n is divisible on it or not by if(n % it == 0) :
            if(n % it == 0) {
                boolean isPrime = true;
                //check if 'it' is prime
                for (int jt = 2; jt * jt <= it; jt += 1) {
                    if (it % jt == 0) {
                        isPrime = false;
                    }
                }

                if (isPrime == true) {
                    primes[primeCount++] = it;
                }
            }
        }
        //find prime factors of n
        for(int it = 0;it < primeCount;it += 1){
            if(n == 1){
                break;
            }
            System.out.print(primes[it] + " ");
            while (n % primes[it] == 0)
                n /= primes[it];
        }
        System.out.print("\n");
    }
    public static void main(String[] args){
        printFactors(91);
    }
}
