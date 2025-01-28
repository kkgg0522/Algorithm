class Solution {
     public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while(!isPutWallet(wallet, bill)){
            bill = foldBill(bill);
            answer++;
        }
        return answer;
    }

    private boolean isPutWallet(int[] wallet, int[] bill){
        boolean width = false;
        boolean height = false;

        int widthNum = widthWalletPut(bill[0],wallet);
        if(widthNum != -1) {
            width = true;
            if (heightWalletPut(bill[1], wallet, widthNum)) {
                height = true;
            }
        }

        return (width&&height);
    }


    private int widthWalletPut(int width, int[] wallet){
        int val = -1;
        if(width<=wallet[0])
            val = 0;

        if(width<=wallet[1])
            val = 1;

        if(width<=wallet[0]&&width<=wallet[1])
            val = 2;

        return val;

    }

    private boolean heightWalletPut(int height, int[] wallet, int i){
        switch(i){
            case 0:
                return height <= wallet[1];
            case 1:
                return height <= wallet[0];
            case 2:
                return height <= wallet[0] || height <= wallet[1];
        }
        return false;
    }

    private int[] foldBill(int[] bill){
        if(bill[0]<=bill[1]){
            bill[1] = Math.floorDiv(bill[1] , 2);
        }
        else{
            bill[0] =Math.floorDiv(bill[0] , 2);
        }

        return bill;
    }
}