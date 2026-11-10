class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackCount = attacks.length;
        int lastAttack = attacks[attackCount - 1][0];
        
        int currentHealth = health;
        int continuousTime = 0;
        int index = 0;
        
        for(int i = 0; i <= lastAttack; i++) {
            if(attacks[index][0] == i) {
                currentHealth -= attacks[index][1];
                continuousTime = 0;
                index += 1;
                if(currentHealth <= 0) {
                    return -1;
                }
                continue;
            }
            if(currentHealth < health) {
                if(currentHealth + bandage[1] <= health) {
                    currentHealth += bandage[1];
                } else {
                    currentHealth = health;
                }
                continuousTime += 1;
                if(continuousTime == bandage[0]) {
                    continuousTime = 0;
                    if(currentHealth + bandage[2] <= health) {
                        currentHealth += bandage[2];
                    } else {
                        currentHealth = health;
                    }
                }
            }
        }
        
        return currentHealth;
    }
}