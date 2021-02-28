class Leaderboard {
    private int[][] arr = new int[12000][];
    int idx = 0;

    public Leaderboard() {

    }
    
    public void addScore(int playerId, int score) {
        int[] arrT = new int[2];
        arrT[0] = playerId;
        arrT[1] = score;
        int pot = search(playerId);
        if(pot == -1)
            pot = idx;
        insert(arrT,pot);
    }

    private void insert(int[] arrT, int pot) {
        int i = pot;
        if(pot != idx){
            arrT[1] = arr[pot][1]+ arrT[1];
        }
        if(idx != 0){
            for (i = pot; i > 0 && arrT[1] > arr[i-1][1]; i--) {
                arr[i] = arr[i-1];
            }
        }
        arr[i] = arrT;
        if(pot == idx){
            idx++;
        }
    }
    
    public int top(int K) {
        int tempInd = K > idx?idx:K;
        int sum = 0;
        for(int i= 0;i < tempInd;i++){
            sum += arr[i][1];
        }

        return sum;
    }
    
    public void reset(int playerId) {
        int ret = search(playerId);
        int[] orign = arr[ret];
        orign[1] = 0;
        for(int i = ret+1;i<idx;i++){
            arr[i-1] = arr[i];
        }
        arr[idx-1] = orign;
    }

    public int search(int playerId) {
        for(int i = 0; i < idx;i++){
            if(arr[i][0] == playerId) return i;
        }
        return -1;
    }
}