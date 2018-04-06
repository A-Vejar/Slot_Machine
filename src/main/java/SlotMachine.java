public class SlotMachine {

    // Attributes
    private  int nSlots = 3;
    private int balance;
    private Roll[] slots;
    String change = "";

    // Constructor
    public SlotMachine (){
        // Initial balance
        this.balance = 1000;
        this.slots = new Roll[nSlots];
        for (int i = 0 ; i < nSlots; i++){
            slots[i]= new Roll();
        }
    }

    // Gets
    /**
     * It shows the random numbers in the slot machine
     * @param bet, Your own initial bets
     */
    public void Bets(int bet){
        // Balance updating
        this.balance -= bet;
        // End of game pressing "0"
        if(bet == 0){
            return;
        }
        // Game start ...
        System.out.println("| ¡¡ Slot Machine !! |");
        for(int i = 0; i< nSlots; i++){
            // Change value from "0" to "*"
            change = Integer.toString(slots[i].getValue());
            if (change.equals("0")) {
                change = "*";
            }
            // Shows the random numbers, and its change a possible value of "0" to "*"
            System.out.print("|" + change + "|");
        } // End for
        System.out.println();

        // Winnings Cases
        // 1. Case of three "*" appears
        if(slots[0].getValue() == 0 && slots[1].getValue() == 0 && slots[2].getValue() == 0){
            this.balance += 500;
            System.out.println("You earn $" + 500);
        }else{
            // 2. Case of two "*" appears
            if((slots[0].getValue() == 0 && slots[1].getValue() == 0) ||
                    (slots[1].getValue() == 0 && slots[2].getValue() == 0) ||
                    (slots[0].getValue() == 0 && slots[2].getValue() == 0)){
                this.balance += 300;
                System.out.println("You earn $" + 300);
            }else{
                // 3. Case of one "*" appears
                if(slots[0].getValue() == 0 || slots[1].getValue() == 0 || slots[2].getValue() == 0){
                    this.balance += 50;
                    System.out.println("You earn $" + 50);
                }else{
                    // 4. Case of a three random numbers are the same
                    if(slots[0].getValue() == slots[1].getValue() && slots[1].getValue() == slots[2].getValue()){
                        this.balance += (slots[0].getValue() * bet);
                        System.out.println("You earn $" + (slots[0].getValue() * bet));
                    }
                }
            }
        }
        // Update the random numbers
        slots[0].setValue();
        slots[1].setValue();
        slots[2].setValue();
    }

    // Return our balance
    public int getBalance(){
        return balance;
    }
}
