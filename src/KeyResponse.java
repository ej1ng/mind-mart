import java.awt.event.*;

public class KeyResponse implements KeyListener{

    Display display;
    public boolean displayed;
    public int pressedKey;
    public boolean checkedOut;
    public boolean nextPressed;
    public int checkoutItem;
    public int guess = 0;


    public KeyResponse(Display display) {
        this.display = display;
        displayed = false;
    }

    public void keyTyped(KeyEvent e) {



    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (display.gameState == display.intro) {

            if (code == KeyEvent.VK_ENTER) {
                nextPressed = true;

            }
        }
        if (display.gameState == display.shop) {
            if (code == KeyEvent.VK_1) {
                if (displayed == false) {
                    System.out.println(displayed);
                    displayed = true;
                    pressedKey = 0;
                    System.out.println(displayed);
                } else {
                    displayed = false;
                }
            } 
            if (code == KeyEvent.VK_2) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 1;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_3) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 2;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_4) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 3;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_5) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 4;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_6) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 5;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_7) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 6;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_8) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 7;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_9) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 8;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_0) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 9;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_Q) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 10;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_W) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 11;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_E) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 12;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_R) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 13;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_T) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 14;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_Y) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 15;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_A) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 16;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_S) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 17;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_D) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 18;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_F) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 19;
                } else {
                    displayed = false;
                }
            }
            if (code == KeyEvent.VK_G) {
                if (displayed == false) {
                    displayed = true;
                    pressedKey = 20;
                } else {
                    displayed = false;
                }
            }

            if (code == KeyEvent.VK_P) {
                checkoutItem = pressedKey;
                checkedOut = true;
            }
            if (code == KeyEvent.VK_ENTER) {
                nextPressed = true;
            }
        } 

        if (display.gameState == display.guess) {
            if (code == KeyEvent.VK_1) {
                guess = 1;
            }
            if (code == KeyEvent.VK_2) {
                guess = 2;
            }
            if (code == KeyEvent.VK_3) {
                guess = 3;
            }
            if (code == KeyEvent.VK_4) {
                guess = 4;
            }
            if (code == KeyEvent.VK_5) {
                guess = 5;
            }
            if (code == KeyEvent.VK_6) {
                guess = 6;
            }
            if (code == KeyEvent.VK_7) {
                guess = 7;
            }
            if (code == KeyEvent.VK_8) {
                guess = 8;
            }
            

        }
    }


    public int getCheckoutItem() {
        if (checkedOut == true) {
            checkedOut = false;
            return checkoutItem;
        }
        return -1;
    }


    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (display.gameState == display.intro) {
            if (code == KeyEvent.VK_ENTER) {
                nextPressed = false;
            }
            if (code == KeyEvent.VK_ENTER) {
                nextPressed = false;
            }
        }


        if (display.gameState == display.shop) {
            if (code == KeyEvent.VK_P) {
                checkedOut = false;
            }

        }


    }
}
