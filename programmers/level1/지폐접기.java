import java.util.*;

class 지폐접기 {

    class Bill {

        int folded;
        int[] size;

        Bill(int[] size) {
            this.folded = 0;
            this.size = size;
            Arrays.sort(this.size);
        }

        boolean needToFold(int[] wallet) {
            if (this.size[0] <= wallet[0] && this.size[1] <= wallet[1]) {
                return true;
            }
            this.size[1] = this.size[1] / 2;
            Arrays.sort(this.size);
            this.folded += 1;
            return false;
        }
    }

    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        Bill b = new Bill(bill);
        while (!b.needToFold(wallet)) {}
        return b.folded;
    }
}