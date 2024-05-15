// ChatGpt
    class Gun {
    private int bulletCount;

    public Gun() {
        bulletCount = 0;
    }

    public void fillBullet() {
        bulletCount++;
    }

    public void shoot() {
        if (bulletCount > 0) {
            bulletCount--;
        }
    }

    public boolean canShootRocketLauncher() {
        return bulletCount >= 5;
    }

    public void shootRocketLauncher() {
        if (bulletCount >= 5) {
            bulletCount -= 5;
        }
    }

    public int getBulletCount() {
        return bulletCount;
    }
}

class Player {
    private String name;
    private Gun gun;
    private boolean shield;

    public Player(String name) {
        this.name = name;
        gun = new Gun();
        shield = false;
    }

    public void say(String action) {
        if (action.equalsIgnoreCase("bullet")) {
            gun.fillBullet();
        } else if (action.equalsIgnoreCase("shield")) {
            shield = true;
        } else if (action.equalsIgnoreCase("shoot")) {
            if (shield) {
                shield = false;
            } else {
                gun.shoot();
            }
        } else if (action.equalsIgnoreCase("rocket launcher")) {
            if (gun.canShootRocketLauncher()) {
                gun.shootRocketLauncher();
            }
        }
    }

    public int getBulletCount() {
        return gun.getBulletCount();
    }

    public boolean isDeadlyShot() {
        return gun.getBulletCount() >= 5;
    }

    public String getName() {
        return name;
    }
}

class DuelGame {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Game game = new Game(player1, player2);
        game.startGame();
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}

class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame() {
        while (!isGameOver()) {
            playTurn(player1, player2);
            if (isGameOver()) {
                break;
            }
            playTurn(player2, player1);
        }
    }

    private void playTurn(Player currentPlayer, Player opponent) {
        System.out.println(currentPlayer.getName() + "'s turn. Current bullet count: " + currentPlayer.getBulletCount());
        // Simulate player's input here, e.g., using a scanner
        // For brevity, you can hardcode the actions.
        String action = "bullet"; // Replace with player input
        currentPlayer.say(action);
        if (currentPlayer.isDeadlyShot()) {
            System.out.println(currentPlayer.getName() + " shoots with a deadly shot!");
        }
    }

    public boolean isGameOver() {
        return player1.isDeadlyShot() || player2.isDeadlyShot();
    }

    public Player getWinner() {
        if (player1.isDeadlyShot()) {
            return player1;
        } else if (player2.isDeadlyShot()) {
            return player2;
        }
        return null;
    }
}

    
    

