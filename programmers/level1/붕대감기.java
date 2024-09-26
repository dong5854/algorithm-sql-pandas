class Solution {

    static class Player {

        int castTime;
        int recover;
        int finalRecover;
        int health;
        int curHealth;
        int curCastTime;

        Player(int castTime, int recover, int finalRecover, int health) {
            this.castTime = castTime;
            this.recover = recover;
            this.finalRecover = finalRecover;
            this.health = health;
            this.curHealth = health;
            this.curCastTime = 0;
        }

        public void heal(int time) {
            if (this.curHealth < 0) return;
            this.curCastTime += time;
            this.curHealth += this.recover * time;
            this.curHealth += (this.curCastTime / this.castTime) * this.finalRecover;
            this.curCastTime %= this.castTime;
            this.curHealth = Math.min(this.health, this.curHealth);
        }

        public void attacked(int damage) {
            this.curCastTime = 0;
            this.curHealth -= damage;
        }

        public int getHP() {
            if (this.curHealth <= 0) return -1;
            return this.curHealth;
        }

    }

    public int 붕대감기(int[] bandage, int health, int[][] attacks) {
        Player player = new Player(bandage[0], bandage[1], bandage[2], health);
        int lastAttacked = 0;
        for (int[] attack : attacks) {
            player.heal(attack[0] - 1 - lastAttacked);
            player.attacked(attack[1]);
            lastAttacked = attack[0];
        }
        return player.getHP();
    }
}